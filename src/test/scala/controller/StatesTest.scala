package controller

import character.{Character, Enemy}
import character.players.{Ninja, Paladin, Warrior, WhiteMage}
import controller.states.{AttackState, BeginningTurn, CastState, ChoosingAction, ChoosingWeapon, EndingTurn, SettingTurns}
import effects.{ParalyzeEffect, PoisonEffect}
import exceptions.NoneException
import party.Party
import spells.{Fire, Paralysis, Poison, Thunder}
import weapon.{Axe, Bow, Staff, Sword, Wand, Weapon}

import java.io.ByteArrayInputStream
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class StatesTest extends munit.FunSuite{

  var controller : GameController = _
  var c3 : WhiteMage = _
  var enemies : ArrayBuffer[Character] = _
  var enemy : Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    c3 = new WhiteMage("Aria", 100, 80, 30, 60, 150, 120)

    val party = new Party()
    party.addCharacter(c3)

    enemies = new ArrayBuffer[Character]()
    enemy = new Enemy("Darkshade", 130, 110, 50, 45, 70)
    enemies += enemy

    val weapons = mutable.Map[Character, ArrayBuffer[Weapon]]()
    val w31 = new Staff("Wizards Staff", 50, 7, 15)
    val w32 = new Bow("Short Bow", 35, 3)
    val w33 = new Bow("Composite Bow", 35, 3)
    val w34 = new Wand("Mystic Wand", 20, 2, 30)

    val w3 : ArrayBuffer[Weapon] = ArrayBuffer(
      w31, w32, w33, w34
    )
    weapons(c3) = w3

    c3.equip(w31)

    controller = new GameController(party, enemies, weapons)
  }
  //scheduler initialized
  //state = SettingTurns
  test("SettingTurns update test"){
    controller.update()
    assert(!controller.areTurns())
    controller.update()
    controller.update()
    controller.update()
    assert(controller.areTurns())
    assert(controller.getState.isInstanceOf[BeginningTurn])
  }

  test("EndingTurn update test"){
    //if there arent any turns sets the state to SettingTurns
    controller.setState(new EndingTurn)
    controller.update()
    assert(controller.getState.isInstanceOf[SettingTurns])

    //if there are turns sets the state to begginingTurn
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.setState(new EndingTurn)
    controller.update()
    assert(controller.getState.isInstanceOf[BeginningTurn])
  }

  test("ChoosingWeapon update test"){
    controller.setState(new ChoosingWeapon)
    intercept[NoneException]{
      controller.update()
    }
    //current character is an enemy update passes to attackState
    controller.currentTurn = Some(new Enemy("enemy", 15, 15, 15, 20, 20))

    controller.update()

    assert(controller.getState.isInstanceOf[AttackState])

    controller.currentTurn = Some(c3)

    controller.setState(new ChoosingWeapon)
    val input = new java.io.ByteArrayInputStream("1\n0\n".getBytes)
    Console.withIn(input) {
      controller.update()
    }

    assert(controller.getState.isInstanceOf[ChoosingAction])

  }

  test("ChoosingAction update test"){
    controller.setState(new ChoosingAction)
    intercept[NoneException]{
      controller.update()
    }
    //if current character is not a mage, passes to AttackState
    controller.currentTurn = Some(new Warrior("warrior", 15, 15, 20, 20))

    controller.update()

    assert(controller.getState.isInstanceOf[AttackState])
  }

  test("BeginningTurn paralyze test"){
    //if character is paralyzed, sets state to endingTurn
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    enemy.setParalyzed(true)
    c3.setParalyzed(true)

    controller.setState(new BeginningTurn)
    controller.update()
    assert(controller.getState.isInstanceOf[EndingTurn])
  }
  test("beginningTurn defeated test"){
    //if character is dead, sets state to endingTurn
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    enemy.setLife(-enemy.getLife)
    c3.setLife(-c3.getLife)

    controller.setState(new BeginningTurn)
    controller.update()
    assert(controller.getState.isInstanceOf[EndingTurn])
  }

  test("beginningTurn has effects and is paralyzed test"){
    //if character has effects
    //if is paralyzed from them states passes to EndingTurn
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    c3.addEffect(new ParalyzeEffect(10))
    controller.setState(new BeginningTurn)

    controller.update()
    assert(controller.getState.isInstanceOf[EndingTurn])
  }

  test("beginningTurn has effects and dies test") {
    //if character has effects
    //if dies from them, states passes to EndingTurn
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    c3.addEffect(new PoisonEffect(1000))
    controller.setState(new BeginningTurn)

    controller.update()
    assert(controller.getState.isInstanceOf[EndingTurn])
  }

  test("beginningTurn doesnt have effects or doesnt die test") {
    //if character do not have effects or effect didnt kill
    // passes to ChoosingWeapon
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    c3.addEffect(new PoisonEffect(3))
    controller.setState(new BeginningTurn)

    controller.update()
    assert(controller.getState.isInstanceOf[ChoosingWeapon])
  }

  test("beginningTurn doesnt have effects test") {
    //if character do not have effects
    // passes to ChoosingWeapon
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.increaseActionBar()
    controller.setState(new BeginningTurn)

    controller.update()
    assert(controller.getState.isInstanceOf[ChoosingWeapon])
  }

  test("AttackState test"){
    controller.setState(new AttackState())
    intercept[NoneException]{
      controller.update()
    }
    //sets state to EndingTurn after
    controller.currentTurn = Some(enemy)

    controller.update()

    assert(controller.getState.isInstanceOf[EndingTurn])

  }

  test("CastState test") {
    controller.setState(new CastState())
    intercept[NoneException] {
      controller.update()
    }

    controller.currentTurn = Some(c3)


    val input = new java.io.ByteArrayInputStream("3\n1\n".getBytes)
    Console.withIn(input) {
      controller.update()
    }

    assert(controller.getState.isInstanceOf[EndingTurn])
  }

  test("Spells targets"){
    val thunder = new Thunder
    assert(thunder.getTargets(controller, enemy) == enemies)

    val poison = new Poison
    assert(poison.getTargets(controller, enemy) == enemies)

    val paralysis = new Paralysis
    assert(paralysis.getTargets(controller, enemy) == enemies)

    val fire = new Fire
    assert(fire.getTargets(controller, enemy) == enemies)
  }



}
