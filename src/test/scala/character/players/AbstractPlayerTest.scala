package character.players

import character.Enemy
import exceptions.BadBehaviourException
import weapon.{Axe, Weapon}

class AbstractPlayerTest extends munit.FunSuite{

  test("attackEnemy should throw an exception if a player without a weapon tries to attack"){
    var warrior = Warrior("warrior", 20, 10, 5)
    var enemy = Enemy("enemy", 25, 10, 5, 5)

    intercept[BadBehaviourException]{
      warrior.attackEnemy(enemy)
    }
  }

  test("attackCharacter should attack the character by exactly the weapons attack damage") {
    var warrior = Warrior("warrior", 20, 10, 5)
    var enemy = Enemy("enemy", 25, 10, 5, 5)

    warrior.equip(new Axe("axe", 10, 5))

    warrior.attackEnemy(enemy)
    assert(enemy.getLife == 20)

  }
  test("attackCharacter should not make an effect on the character if the defense more o equal to the attack"){
    var warrior = Warrior("warrior", 20, 10, 5)
    var enemy = Enemy("enemy", 25, 10, 15, 5)

    warrior.equip(new Axe("axe", 10, 5))

    assert(enemy.getLife == 25)
    warrior.attackEnemy(enemy)
    assert(enemy.getLife == 25)
  }

  test("attackPlayer throws an exception since an enemy cannot attack another enemy") {
    var warrior0 = Warrior("warrior0", 10, 12, 5)
    var warrior1 = Warrior("warrior1", 15, 4, 2)

    intercept[BadBehaviourException] {
      warrior0.attackPlayer(warrior1)
    }
  }


}
