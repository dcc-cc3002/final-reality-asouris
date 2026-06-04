package turnSheduler

import turnScheduler.TurnScheduler
import character.players.Warrior

class TurnSchedulerTest extends munit.FunSuite {

  test("Adding and Removing Players") {
    val scheduler = new TurnScheduler
    val warrior1 = new Warrior("warrior1", 100, 10, 15)
    val warrior2 = new Warrior("warrior2", 120, 20, 4)

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

  test("Increasing Action Bar") {
    val scheduler = new TurnScheduler
    val warrior = new Warrior("warrior", 100, 10, 15)

    scheduler.addCharacter(warrior)
    scheduler.increaseActionBar(50)
    scheduler.characters.get(warrior) match {
      case Some(value) => assert(value == 50)
      case None => false
    }

  }

  test("Checking Readiness") {
    val scheduler = new TurnScheduler
    val warrior = new Warrior("warrior", 100, 10, 15)

    scheduler.addCharacter(warrior)
    scheduler.increaseActionBar(1)
    assert(scheduler.isReady(warrior) == false)

    scheduler.increaseActionBar(100)
    assert(scheduler.isReady(warrior) == true)

  }

  test("Getting Next Character") {
    val scheduler = new TurnScheduler
    val warrior1 = new Warrior("warrior1", 100, 10, 1)
    val warrior2 = new Warrior("warrior2", 100, 10, 15)

    scheduler.addCharacter(warrior1)
    scheduler.addCharacter(warrior2)
    scheduler.increaseActionBar(5)

    val nextCharacter = scheduler.nextCharacter
    assert(nextCharacter == warrior1)

  }
}