package character
import character.players.Warrior

class CharacterTest extends munit.FunSuite{


  test("isDefeated should return true if the life of the character has reached 0, false otherwise") {
    var enemy = Enemy("enemy", 10, 5, 30, 20)
    assert(!enemy.isDefeated)
    
    enemy.setLife(0)
    assert(enemy.isDefeated)
    
  }
}
