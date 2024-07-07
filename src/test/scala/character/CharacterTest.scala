package character
import character.players.Warrior
import effects.PoisonEffect
import exceptions.{BadBehaviourException, NoneException}
import spells.Poison

import scala.collection.mutable.ArrayBuffer

class CharacterTest extends munit.FunSuite{


  test("isDefeated should return true if the life of the character has reached 0, false otherwise") {
    var enemy = Enemy("enemy", 10, 10, 5, 30, 20)
    assert(!enemy.isDefeated)
    
    enemy.setLife(- enemy.getLife)
    assert(enemy.isDefeated)
    
  }

  test("A character cannot be created with an empty name") {
    var warriorGood = Warrior("warriorGood", 10, 10, 10, 10)
    intercept[IllegalArgumentException] {
      var warriorBad = Warrior("", 10, 10, 10, 10)
    }
  }
  test("A character cannot be created with negative defense") {
    var enemy0 = Enemy("enemy0", 10, 10, 10, 10, 10)
    var enemy1 = Enemy("enemy1", 10, 10, 10, 0, 10)

    intercept[IllegalArgumentException] {
      var enemyBad = Enemy("enemyBad", 10, 10, 10, -10, 10)
    }
  }

  test("A character cannot be created with neither maxLife nor weight lesser than 1") {
    var enemy0 = Enemy("enemy0", 1, 1, 10, 10, 10)
    var warrior = Warrior("enemy1", 10, 10, 10, 1)

    intercept[IllegalArgumentException] {
      var warriorBad = Warrior("warriorBad", 0, 0, 10, 10)
    }
    intercept[IllegalArgumentException] {
      var warriorBad = Warrior("warriorBad", 10, 10, 10, 0)
    }
  }

  test("receiveAttack should decrease the current life of the character by the amount attacked minus defense") {
    var character1 = Enemy("character1", 15, 15, 5, 2, 20)

    assert(character1.getLife == 15)
    character1.receiveAttack(10)
    assert(character1.getLife == 7)
  }
  test("receiveAttack should do nothing if the attack is less than defense") {
    var character1 = Warrior("character1", 15, 15, 10, 20)

    assert(character1.getLife == 15)
    character1.receiveAttack(5)
    assert(character1.getLife == 15)
  }
  test("receiveAttack should leave the life at 0 even when the damage is greater than current life") {
    var character1 = Warrior("character1", 15, 15, 10, 20)

    assert(character1.getLife == 15)
    character1.receiveAttack(30)
    assert(character1.getLife == 0)
  }

  test("Team attribute testing"){
    val enemy = Enemy("warrior", 15, 15, 10, 20, 25)

    val enemies = new ArrayBuffer[Character]()
    enemies += new Enemy("Darkshade", 130, 110, 50, 45, 70)
    enemies += new Enemy("Bloofang", 120, 100, 45, 40, 65)
    enemies += new Enemy("Grimscale", 140, 120, 55, 50, 75)
    
    intercept[NoneException]{
      enemy.getTeam
    }

    enemy.setTeam(enemies)

    val expected = enemies
    assert(enemy.getTeam == expected)
  }
  
  test("Effects Testing"){
    val warrior = new Warrior("warrior", 15, 15, 20, 20)
    
    assert(!warrior.hasEffects)
    
    warrior.addEffect(new PoisonEffect(18))

    val expectedRes = warrior.getLife - 18/3

    warrior.applyEffects()

    assert(warrior.getLife == expectedRes)
  }
  
  test("Paralyzed test"){
    val warrior = new Warrior("warrior", 15, 15, 20, 20)
    assert(!warrior.isParalyzed)
    
    warrior.setParalyzed(true)
    assert(warrior.isParalyzed)
  }
  
  test("getMage test"){
    val warrior = new Warrior("warrior", 15, 15, 20, 20)
    intercept[BadBehaviourException]{
      warrior.getMage
    }
  }

}
