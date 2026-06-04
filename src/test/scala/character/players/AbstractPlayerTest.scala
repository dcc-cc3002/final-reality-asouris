package character.players

import character.Enemy
import exceptions.BadBehaviourException
import weapon.{Axe, Weapon}

class AbstractPlayerTest extends munit.FunSuite{

  test("attackCharacter should throw an exception if a player without a weapon tries to attack"){
    var warrior = Warrior("warrior", 20, 10, 5)
    var enemy = Enemy("enemy", 25, 10, 5, 5)

    intercept[BadBehaviourException]{
      warrior.attackCharacter(enemy)
    }
  }

  test("attackCharacter should attack the character by exactly the weapons attack damage") {
    var warrior = Warrior("warrior", 20, 10, 5)
    var enemy = Enemy("enemy", 25, 10, 5, 5)

    warrior.equip(new Axe("axe", 10, 5))

    warrior.attackCharacter(enemy)
    assert(enemy.getLife == 20)

  }
  test("attackCharacter should not make an effect on the character if the defense more o equal to the attack"){
    var warrior = Warrior("warrior", 20, 10, 5)
    var enemy = Enemy("enemy", 25, 10, 15, 5)

    warrior.equip(new Axe("axe", 10, 5))

    assert(enemy.getLife == 25)
    warrior.attackCharacter(enemy)
    assert(enemy.getLife == 25)
  }
  
 



}
