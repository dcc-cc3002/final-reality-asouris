package character
import character.players.Warrior

class CharacterTest extends munit.FunSuite{


  test("isDefeated should return true if the life od a character has reached 0, false otherwise") {
    var enemy = Enemy("enemy", 10, 5, 30, 20)
    var warrior = Warrior("warrior", 0, 20, 50)

    assert(warrior.isDefeated)
    assert(!enemy.isDefeated)
  }
}
