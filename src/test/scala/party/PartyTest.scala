package party

import character.players.Warrior
import character.players.Ninja


class PartyTest extends munit.FunSuite {

  test("A Party should not be defeated when at least one member is not defeated") {
    val party = new Party()
    party.addCharacter(new Warrior("Sapo", 10, 5, 2))
    party.addCharacter(new Ninja("Sepo", 15, 8, 3))
    assert(!party.isDefeated) // Party should not be defeated when at least one member is not defeated
  }

  test("A Party should be defeated when all members are defeated") {
    val party = new Party()
    party.addCharacter(new Warrior("Sapo", 0, 5, 2))
    party.addCharacter(new Ninja("Sepo", 0, 8, 3))
    assert(party.isDefeated) // Party should be defeated when all members are defeated
  }

  test("A Party should be defeated when it has no members") {
    val party = new Party()
    assert(party.isDefeated) // Party should be defeated when it has no members
  }
}
