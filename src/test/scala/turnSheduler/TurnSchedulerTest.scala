package turnSheduler

import turnScheduler.TurnScheduler
import character.players.{Player, Warrior}
import exceptions.NoneException
import weapon.Sword

import scala.collection.mutable.ArrayBuffer

class TurnSchedulerTest extends munit.FunSuite {

  var scheduler: TurnScheduler = _
  var warrior1: Warrior = _
  var warrior2: Warrior = _
  var warrior3: Warrior = _

  override def beforeEach(context: BeforeEach): Unit = {
    scheduler = new TurnScheduler
    warrior1 = new Warrior("warrior1", 100, 10, 15)
    warrior2 = new Warrior("warrior2", 120, 20, 4)
    warrior3 = new Warrior("warrior1", 100, 10, 1)
  }

  test("Adding and Removing Players") {
    scheduler.addCharacter(warrior1)
    scheduler.addCharacter(warrior2)

    assert(scheduler.getCharacters.size == 2)
    assert(scheduler.getCharacters.contains(warrior1))
    assert(scheduler.getCharacters.contains(warrior2))

    scheduler.removeCharacter(warrior1)
    assert(scheduler.getCharacters.size == 1)
    assert(!scheduler.getCharacters.contains(warrior1))
    assert(scheduler.getCharacters.contains(warrior2))
  }

  test("Getting maximum value"){
    val sword1 = Sword("sword1", 5, 10)
    val sword2 = Sword("sword2", 5, 10)
    warrior1.equip(sword1)
    warrior3.equip(sword2)

    scheduler.addCharacter(warrior1)
    scheduler.increaseActionBar(10)

    scheduler.addCharacter(warrior3)

    scheduler.getMaximum match {
      case Some(value) => assert(value == 10)
      case None => throw NoneException("Map is empty")
    }
  }

  test("Resetting action bar"){
    val sword1 = Sword("sword1", 5, 10)
    val sword2 = Sword("sword2", 5, 10)
    warrior1.equip(sword1)
    warrior3.equip(sword2)

    scheduler.addCharacter(warrior1)
    scheduler.addCharacter(warrior3)
    scheduler.increaseActionBar(10)
    scheduler.getMaximum match {
      case Some(value) => assert(value == 10)
      case None => throw NoneException("Map is empty")
    }

    scheduler.resetActionBar()
    scheduler.getMaximum match {
      case Some(value) => assert(value == 0)
      case None => throw NoneException("Map is empty")
    }

  }

  test("Increasing Action Bar up to maximum actionBar value") {
    val sword1 = Sword("sword1", 5, 10)
    warrior1.equip(sword1) //15  15 + 5 = 20

    scheduler.addCharacter(warrior1)
    scheduler.increaseActionBar(50)
    scheduler.getCharacters.get(warrior1) match {
      case Some(value) => assert(value == 20)
      case None => throw NoneException("Value is none")
    }

  }

  test("The player with the most advantage in the action bar gets in the queue first"){
    print("testing begin")
    val sword1 = Sword("sword1", 5, 10) //15
    val sword2 = Sword("sword2", 5, 10) //1
    warrior1.equip(sword1) //15  15 + 5 = 20
    warrior3.equip(sword2) //1   1  + 5 = 6

    scheduler.addCharacter(warrior1)
    scheduler.addCharacter(warrior3)

    scheduler.increaseActionBar(100)

    val value = scheduler.nextCharacter
    print(value)
    assert(value == warrior3)
    print("testing end")
  }

  test("Checking Readiness") {
    val sword1 = Sword("sword1", 5, 10)
    warrior1.equip(sword1)

    scheduler.addCharacter(warrior1)
    scheduler.increaseActionBar(1)
    assert(!scheduler.isReady(warrior1))

    scheduler.increaseActionBar(100)
    assert(scheduler.isReady(warrior1))

  }

  test("Getting Next Character") {
    val sword1 = Sword("sword1", 5, 10)
    val sword2 = Sword("sword2", 5, 10)
    warrior1.equip(sword1)
    warrior3.equip(sword2)

    scheduler.addCharacter(warrior1)
    scheduler.addCharacter(warrior3)

    scheduler.increaseActionBar(10)

    assert(scheduler.nextCharacter == warrior3)

  }

  test("Getting all the ready characters"){

    val sword1 = Sword("sword1", 5, 10)
    val sword2 = Sword("sword2", 5, 10)
    warrior1.equip(sword1)
    warrior3.equip(sword2)

    scheduler.addCharacter(warrior1)
    scheduler.addCharacter(warrior3)

    scheduler.increaseActionBar(100)

    val expected = ArrayBuffer(warrior3, warrior1)
    val value = scheduler.getReady
    print(value)
    assert(value == expected)

  }
}