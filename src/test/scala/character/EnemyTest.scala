package character

import character.players.Warrior
import exceptions.BadBehaviourException


class EnemyTest extends munit.FunSuite {

  test("equals"){
    var enemy0 = Enemy("enemy0", 10, 20, 30, 40)
    var enemy1 = Enemy("enemy1", 10, 15, 30, 2)
    var Warrior = new Warrior("BestWarrior", 20, 20, 5)

    assertEquals(enemy1, enemy1)
    assertEquals(enemy1, new Enemy("enemy1", 10, 15, 30, 2))
    assert(!enemy1.equals(enemy0))
    assert(!enemy0.equals(Warrior))
  }
  test("getAttack returns the attack attribute of an enemy"){
    val attack = 20

    val enemy = Enemy("enemy", 10, attack, 30, 40)

    assert(enemy.getAttack == attack)
  }

  test("Test toString"){
    val enemy = Enemy("enemy", 10, 20, 30, 40)

    val expected = "Enemy(enemy, 10, 20, 30, 40)"
    
    assert(enemy.toString == expected)
  }

  test("An enemy cannot be created with the attack attribute lesser than 1"){
    var enemy0 = Enemy("enemy0", 10, 1, 10, 10)
    var enemy1 = Enemy("enemy1", 10, 100, 10, 10)

    intercept[IllegalArgumentException]{
      var enemyBad = Enemy("enemyBad", 10, 0, 10, 10)
    }
  }

  test("attackPlayer should make a player receive an attack of the magnitude of the attackers attack points if attack is too little nothing happens"){
    var enemy = Enemy("enemy", 10, 12, 5, 40)
    var warrior = Warrior("warrior", 15, 4, 2)

    assert(warrior.getLife == 15)
    enemy.attackPlayer(warrior)
    assert(warrior.getLife == 7)
  }

  test("attackEnemy throws an exception since an enemy cannot attack another enemy"){
    var enemy0 = Enemy("enemy0", 10, 12, 5, 40)
    var enemy1 = Enemy("enemy1", 15, 4, 2, 20)

    intercept[BadBehaviourException]{
      enemy0.attackEnemy(enemy1)
    }
  }

}
