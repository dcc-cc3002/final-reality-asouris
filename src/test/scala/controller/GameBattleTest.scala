package controller

import character.{Enemy, Character}
import character.players.WhiteMage
import party.Party
import weapon.{Bow, Staff, Wand, Weapon}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class GameBattleTest extends munit.FunSuite {

  test("run test"){
    val c3 = new WhiteMage("Aria", 100, 80, 30, 60, 150, 120)

    val party = new Party()
    party.addCharacter(c3)

    val enemies = new ArrayBuffer[Character]()
    val enemy = new Enemy("Darkshade", 130, 110, 1000, 45, 1)
    enemies += enemy

    val weapons = mutable.Map[Character, ArrayBuffer[Weapon]]()
    val w31 = new Staff("Wizards Staff", 50, 7, 15)
    val w32 = new Bow("Short Bow", 35, 3)
    val w33 = new Bow("Composite Bow", 35, 3)
    val w34 = new Wand("Mystic Wand", 20, 2, 30)

    val w3 : ArrayBuffer[Weapon] = ArrayBuffer(
      w31, w32, w33, w34
    )
    weapons(c3) = w3

    c3.equip(w31)


    val game = new GameBattle(party, enemies, weapons)
    game.run()

  }

}
