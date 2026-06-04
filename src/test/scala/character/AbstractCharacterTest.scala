package character

import character.players.Warrior;


class AbstractCharacterTest extends munit.FunSuite {

    test("A character cannot be created with an empty name"){
        var warriorGood = Warrior("warriorGood", 10, 10, 10)
        intercept[IllegalArgumentException]{
            var warriorBad = Warrior("", 10, 10, 10)
        }
    }
    test("A character cannot be created with negative defense"){
        var enemy0 = Enemy("enemy0", 10, 10, 10, 10)
        var enemy1 = Enemy("enemy1", 10, 10, 0, 10)

        intercept[IllegalArgumentException]{
            var enemyBad = Enemy("enemyBad", 10, 10, -10, 10)
        }
    }

    test("A character cannot be created with neither life nor weight lesser than 1") {
        var enemy0 = Enemy("enemy0", 1, 10, 10, 10)
        var warrior = Warrior("enemy1", 10, 10, 1)

        intercept[IllegalArgumentException] {
            var warriorBad = Warrior("warriorBad", 0, 10, 10)
        }
        intercept[IllegalArgumentException] {
            var warriorBad = Warrior("warriorBad", 10, 10, 0)
        }
    }

    test("receiveAttack should decrease the current life of the character by the amount attacked minus defense") {
        var character1 = Enemy("character1", 15, 5, 2, 20)

        assert (character1.getLife == 15)
        character1.receiveAttack(10)
        assert (character1.getLife == 7)
    }
    test("receiveAttack should do nothing if the attack is less than defense"){
        var character1 = Warrior("character1", 15, 10, 20)

        assert(character1.getLife == 15)
        character1.receiveAttack(5)
        assert(character1.getLife == 15)
    }
    test("receiveAttack should leave the life at 0 even when the damage is greater than current life") {
        var character1 = Warrior("character1", 15, 10, 20)

        assert(character1.getLife == 15)
        character1.receiveAttack(30)
        assert(character1.getLife == 0)
    }

}
