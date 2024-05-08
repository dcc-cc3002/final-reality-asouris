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

  test("An enemy cannot be created with the attack attribute lesser than 1"){
    var enemy0 = Enemy("enemy0", 10, 1, 10, 10)
    var enemy1 = Enemy("enemy1", 10, 100, 10, 10)

    intercept[IllegalArgumentException]{
      var enemyBad = Enemy("enemyBad", 10, 0, 10, 10)
    }
  }

  test("attackCharacter should make a character receive an attack of the magnitude of the attackers attack points if attack is too little nothing happens"){
    var enemy0 = Enemy("enemy0", 10, 12, 5, 40)
    var enemy1 = Enemy("enemy1", 15, 4, 2, 20)

    assert(enemy1.life == 15)
    enemy0.attackCharacter(enemy1)
    assert(enemy1.life == 5)

    assert(enemy0.life == 10)
    enemy1.attackCharacter(enemy0)
    assert(enemy0.life == 10)
  }
}
