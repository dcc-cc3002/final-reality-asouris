package party

import character.Enemy
import character.players.{Ninja, Paladin, Warrior}


class PartyTest extends munit.FunSuite {

  test("Test equals"){
    val party0 = new Party()
    val party1 = new Party()
    val enemy = new Enemy("enemy", 10, 5, 10, 5)

    party0.addCharacter(new Warrior("Sapo", 10, 5, 2))
    party0.addCharacter(new Ninja("Sepo", 15, 8, 3))

    party1.addCharacter(new Warrior("Sapo", 10, 5, 2))
    party1.addCharacter(new Paladin("Sepo", 15, 8, 3))

    assertEquals(party0, party0)
    assert(!party0.equals(party1))
    
    assert(!party0.equals(enemy))
  }

  test("Test toString"){
    val party0 = new Party()
    party0.addCharacter(new Warrior("Sapo", 10, 5, 2))
    party0.addCharacter(new Ninja("Sepo", 15, 8, 3))

    val expected = "Party(Warrior(Sapo, 10, 5, 2), Ninja(Sepo, 15, 8, 3))"

    assert(party0.toString == expected)
  }

  test("A Party should not be defeated when at least one member is not defeated") {
    val party = new Party()
    party.addCharacter(new Warrior("Sapo", 10, 5, 2))
    party.addCharacter(new Ninja("Sepo", 15, 8, 3))
    assert(!party.isDefeated) // Party should not be defeated when at least one member is not defeated
  }

  test("A Party should be defeated when all members are defeated") {
    val party = new Party()
    var warrior = Warrior("Sapo", 1, 5, 2)
    var ninja = Ninja("Sepo", 1, 8, 3)
    party.addCharacter(warrior)
    party.addCharacter(ninja)

    warrior.setLife(0)
    ninja.setLife(0)

    assert(party.isDefeated) // Party should be defeated when all members are defeated
  }

  test("A Party should be defeated when it has no members") {
    val party = new Party()
    assert(party.isDefeated) // Party should be defeated when it has no members
  }
}
