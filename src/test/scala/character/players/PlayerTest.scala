package character.players

import character.players.Warrior
import character.players.Ninja

class PlayerTest extends munit.FunSuite {

  test("A Player should be defeated when its life points reach zero") {
    val player = new Warrior("Sapo", 10, 5, 2) // Creating a player with 10 life points
    assert(!player.isDefeated) // Player should not be defeated initially

    // Inflict damage until the player's life points reach zero
    (1 to 10).foreach(_ => player.life -= 1)

    assert(player.isDefeated) // Player should be defeated when life points reach zero
  }

  test("A Player should not be defeated when its life points are positive") {
    val player = new Ninja("Sepo", 20, 8, 3) // Creating a player with 20 life points
    assert(!player.isDefeated) // Player should not be defeated initially

    // Inflict damage but ensure life points remain positive
    (1 to 10).foreach(_ => player.life -= 1)

    assert(!player.isDefeated) // Player should not be defeated when life points are positive
  }
}
