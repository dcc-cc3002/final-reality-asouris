package character.players

import character.Enemy
import exceptions.SpellException
import weapon.Wand

class MagicPlayerBehaviourTest extends munit.FunSuite{
  
  test("getMagicPoints should give you value for the attribute magic points of the character"){
    val mage : WhiteMage = new WhiteMage("destroyerOfWorlds", 10, 5, 5, 10, 7, 7)
    
    val expected = 7
    
    assert(mage.getMana == expected)
  }

  test("castFire should throw an exception if fire cant affect the target or if its being casted by a white mage"){
    val mage1 = new BlackMage("black", 30, 30, 20, 20, 40, 40)
    val mage2 = new WhiteMage("white", 30, 30, 20, 20, 40, 40)
    val enemy = new Enemy("enemy", 20, 20, 20, 29, 29)
    val wand1 = new Wand("wand", 10, 10, 10)
    val wand2 = new Wand("wand", 10, 10, 10)

    mage1.equip(wand1)
    mage2.equip(wand2)

    intercept[SpellException]{
      mage1.castFire(mage2)
    }

    intercept[SpellException]{
      mage2.castFire(enemy)
    }
  }

  test("castHealing should throw an exception if healing cant affect the target or if its being casted by a black mage") {
    val black = new BlackMage("black", 30, 30, 20, 20, 40, 40)
    val white = new WhiteMage("white", 30, 30, 20, 20, 40, 40)
    val enemy = new Enemy("enemy", 20, 20, 20, 29, 29)
    val wand1 = new Wand("wand", 10, 10, 10)
    val wand2 = new Wand("wand", 10, 10, 10)

    black.equip(wand1)
    white.equip(wand2)

    intercept[SpellException] {
      white.castHealing(enemy)
    }

    intercept[SpellException] {
      black.castHealing(white)
    }
  }

  test("castParalysis should throw an exception if paralysis cant affect the target or if its being casted by a black mage") {
    val black = new BlackMage("black", 30, 30, 20, 20, 40, 40)
    val white = new WhiteMage("white", 30, 30, 20, 20, 40, 40)
    val enemy = new Enemy("enemy", 20, 20, 20, 29, 29)
    val wand1 = new Wand("wand", 10, 10, 10)
    val wand2 = new Wand("wand", 10, 10, 10)

    black.equip(wand1)
    white.equip(wand2)

    intercept[SpellException] {
      white.castParalysis(black)
    }

    intercept[SpellException] {
      black.castParalysis(enemy)
    }
  }

  test("castPoison should throw an exception if poison cant affect the target or if its being casted by a black mage") {
    val black = new BlackMage("black", 30, 30, 20, 20, 40, 40)
    val white = new WhiteMage("white", 30, 30, 20, 20, 40, 40)
    val enemy = new Enemy("enemy", 20, 20, 20, 29, 29)
    val wand1 = new Wand("wand", 10, 10, 10)
    val wand2 = new Wand("wand", 10, 10, 10)

    black.equip(wand1)
    white.equip(wand2)

    intercept[SpellException] {
      white.castPoison(black)
    }

    intercept[SpellException] {
      black.castPoison(enemy)
    }
  }

  test("castThunder should throw an exception if thunder cant affect the target or if its being casted by a white mage") {
    val black = new BlackMage("black", 30, 30, 20, 20, 40, 40)
    val white = new WhiteMage("white", 30, 30, 20, 20, 40, 40)
    val enemy = new Enemy("enemy", 20, 20, 20, 29, 29)
    val wand1 = new Wand("wand", 10, 10, 10)
    val wand2 = new Wand("wand", 10, 10, 10)

    black.equip(wand1)
    white.equip(wand2)

    intercept[SpellException] {
      black.castThunder(white)
    }

    intercept[SpellException] {
      white.castFire(enemy)
    }
  }

  test("A SpellException should be throw if tried to cast spell on a dead character") {
    val black = new BlackMage("black", 30, 30, 20, 20, 40, 40)
    val white = new WhiteMage("white", 30, 30, 20, 20, 40, 40)
    val enemy = new Enemy("enemy", 20, 20, 20, 29, 29)
    val warrior = new Warrior("warrior", 20, 20, 20, 20)
    val wand1 = new Wand("wand", 10, 10, 10)
    val wand2 = new Wand("wand", 10, 10, 10)

    black.equip(wand1)
    white.equip(wand2)

    enemy.setLife(-enemy.getLife)
    warrior.setLife(-warrior.getLife)

    intercept[SpellException] {
      black.castFire(enemy)
    }
    intercept[SpellException] {
      black.castThunder(enemy)
    }
    intercept[SpellException] {
      white.castHealing(warrior)
    }
    intercept[SpellException] {
      white.castPoison(enemy)
    }
    intercept[SpellException] {
      white.castParalysis(enemy)
    }
  }

  test("An exception should be trow if a mage with no weapon tries to cast a spell"){
    val black = new BlackMage("black", 30, 30, 20, 20, 40, 40)
    val white = new WhiteMage("white", 30, 30, 20, 20, 40, 40)
    val enemy = new Enemy("enemy", 20, 20, 20, 29, 29)

    intercept[SpellException]{
      black.castFire(enemy)
    }
    intercept[SpellException]{
      black.castThunder(enemy)
    }
    intercept[SpellException]{
      white.castHealing(black)
    }
    intercept[SpellException]{
      white.castParalysis(enemy)
    }
    intercept[SpellException]{
      white.castPoison(enemy)
    }
  }

}
