package controller


import character.{Character, Enemy}
import character.players.{Ninja, Paladin, Warrior, WhiteMage}
import controller.states.{AttackState, BeginningTurn, ChoosingAction, ChoosingWeapon, EndingTurn, SettingTurns}
import effects.{ParalyzeEffect, PoisonEffect}
import party.Party
import weapon.{Axe, Bow, Staff, Sword, Wand, Weapon}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class controllerTests extends munit.FunSuite {
  var controller: GameController = _
  var c3: WhiteMage = _
  var enemies : ArrayBuffer[Character] = _
  var enemy: Enemy = _

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

    val w3: ArrayBuffer[Weapon] = ArrayBuffer(
      w31, w32, w33, w34
    )
    weapons(c3) = w3

    c3.equip(w31)

    controller = new GameController(party, enemies, weapons)
  }
  
  test("getEnemies test"){
    assert(controller.getEnemies == enemies)
  }
  test("checkFinished test"){
    assert(!controller.checkFinished())
    
    enemy.setLife(-enemy.getLife)
    
    assert(controller.checkFinished())
  }
  test("party defeated"){
    assert(!controller.partyDefeated)
    
    c3.setLife(-c3.getLife)
    
    assert(controller.partyDefeated)
  }
  test("enemies defeated"){
    assert(!controller.enemiesDefeated)

    enemy.setLife(-enemy.getLife)

    assert(controller.enemiesDefeated)
  }
  test("all alies dead test"){
    enemy.setTeam(enemies)
    assert(!controller.allAlliesDead(enemy))

    enemy.setLife(-enemy.getLife)

    assert(controller.allAlliesDead(enemy))
  }
  
  test("diplay massage no error test"){
    controller.displayEndMessage()
    enemy.setLife(-enemy.getLife)
    controller.displayEndMessage()
  }
  test("win test"){
    assert(!controller.win())
    enemy.setLife(-enemy.getLife)
    assert(controller.win())
  }
}
