import character.{Character, Enemy}
import character.players.{Ninja, Paladin, WhiteMage}
import controller.GameBattle
import party.Party
import weapon.{Axe, Bow, Staff, Sword, Wand, Weapon}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * Main program
 * defines and runs a test game
 */

@main def main(): Unit = {
  val c1 = new Paladin("Sir Valiant", 150, 120, 50, 80)
  val c2 = new Ninja("Shadowblade", 120, 100, 40, 60)
  val c3 = new WhiteMage("Aria", 100, 80, 30, 60, 150, 120)

  val party = new Party()
  party.addCharacter(c1)
  party.addCharacter(c2)
  party.addCharacter(c3)

  val enemies = new ArrayBuffer[Character]()
  enemies += new Enemy("Darkshade", 130, 110, 50, 45, 70)
  enemies += new Enemy("Bloofang", 120, 100, 45, 40, 65)
  enemies += new Enemy("Grimscale", 140, 120, 55, 50, 75)

  val weapons = mutable.Map[Character, ArrayBuffer[Weapon]]()
  val w11 = new Axe("Double-Edged Axe", 55, 8)
  val w12 = new Sword("Broadsword", 42, 6)
  val w13 = new Axe("War Axe", 48, 7)
  val w14 = new Sword("Katana", 37, 4)

  val w1 : ArrayBuffer[Weapon] = ArrayBuffer(
    w11, w12, w13, w14
  )
  weapons(c1) = w1

  val w21 = new Bow("Crossbow", 45, 5)
  val w22 = new Wand("Wierd Wand", 20, 2, 30)
  val w23 = new Sword("Sabre", 36, 5)
  val w24 = new Bow("Hunting Bow", 30, 3)

  val w2 : ArrayBuffer[Weapon] = ArrayBuffer(
    w21, w22, w23, w24
  )
  weapons(c2) = w2

  val w31 = new Staff("Wizards Staff", 50, 7, 15)
  val w32 = new Bow("Short Bow", 35, 3)
  val w33 = new Bow("Composite Bow", 35, 3)
  val w34 = new Wand("Mystic Wand", 20, 2, 30)

  val w3 : ArrayBuffer[Weapon] = ArrayBuffer(
    w31, w32, w33, w34
  )
  weapons(c3) = w3

  c1.equip(w11)
  c2.equip(w21)
  c3.equip(w31)

  val game = new GameBattle(party, enemies, weapons)

  game.run()

}


