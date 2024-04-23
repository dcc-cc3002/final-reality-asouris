package character

import character.Enemy

class EnemyTest extends munit.FunSuite {

  test("An Enemy should be defeated when its life points reach zero") {
    val enemy = new Enemy("Goblin", 10, 5, 2, 50) // Creating an enemy with 10 life points
    assert(!enemy.isDefeated) // Enemy should not be defeated initially

    // Inflict damage until the enemy's life points reach zero
    (1 to 10).foreach(_ => enemy.life -= 1)

    assert(enemy.isDefeated) // Enemy should be defeated when life points reach zero
  }

  test("An Enemy should not be defeated when its life points are positive") {
    val enemy = new Enemy("Orc", 20, 8, 3, 80) // Creating an enemy with 20 life points
    assert(!enemy.isDefeated) // Enemy should not be defeated initially

    // Inflict damage but ensure life points remain positive
    (1 to 10).foreach(_ => enemy.life -= 1)

    assert(!enemy.isDefeated) // Enemy should not be defeated when life points are positive
  }
}
