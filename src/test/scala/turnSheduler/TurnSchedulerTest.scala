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

    assert(scheduler.characters.size == 2)
    assert(scheduler.characters.contains(warrior1))
    assert(scheduler.characters.contains(warrior2))

    scheduler.removeCharacter(warrior1)
    assert(scheduler.characters.size == 1)
    assert(!scheduler.characters.contains(warrior1))
    assert(scheduler.characters.contains(warrior2))
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

  test("Increasing Action Bar") {
    val sword1 = Sword("sword1", 5, 10)
    warrior1.equip(sword1)

    scheduler.addCharacter(warrior1)
    scheduler.increaseActionBar(50)
    scheduler.characters.get(warrior1) match {
      case Some(value) => assert(value == 50)
      case None => throw NoneException("Value is none")
    }

  }

  test("The player with the most advantage in the action bar gets in the queue first"){
    val sword1 = Sword("sword1", 5, 10)
    val sword2 = Sword("sword2", 5, 10)
    warrior1.equip(sword1)
    warrior3.equip(sword2)

    scheduler.addCharacter(warrior1)
    scheduler.addCharacter(warrior3)

    scheduler.increaseActionBar(100)

    scheduler.nextCharacter match {
      case Some(character) =>
        print(character)
        assert(character == warrior3)
      case None => throw NoneException("Queue is empty")
    }

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



    scheduler.nextCharacter match {
      case Some(value) => print(value);assert(value == warrior3)
      case None => throw NoneException("Queue is empty")
    }
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
    print(expected)
    assert(scheduler.getReady == expected)

  }
}