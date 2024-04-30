package character

import character.Enemy
import weapon.Sword

class EnemyTest extends munit.FunSuite {

  test("equals"){
    var enemy0 = Enemy("enemy0", 10, 20, 30, 40)
    var enemy1 = Enemy("enemy1", 10, 15, 30, 2)

    assertEquals(enemy1, enemy1)
    assertEquals(enemy1, new Enemy("enemy1", 10, 15, 30, 2))
    assert(!enemy1.equals(enemy0))
  }
}
