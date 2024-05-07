package character

import character.players.Warrior;


class AbstractCharacterTest extends munit.FunSuite {

    test("receiveAttack should decrease the current life of the character by the amount attacked minus defense") {
        var character1 = Enemy("character1", 15, 5, 2, 20)

        assert (character1.life == 15)
        character1.receiveAttack(10)
        assert (character1.life == 7)
    }
    test("receiveAttack should do nothing if the attack is less than defense"){
        var character1 = Warrior("character1", 15, 10, 20)

        assert(character1.life == 15)
        character1.receiveAttack(5)
        assert(character1.life == 15)
    }
    test("receiveAttack should leave the life at 0 even when the damage is greater than current life") {
        var character1 = Warrior("character1", 15, 10, 20)

        assert(character1.life == 15)
        character1.receiveAttack(30)
        assert(character1.life == 0)
    }

}
