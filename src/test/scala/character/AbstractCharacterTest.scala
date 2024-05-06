package character;
import character.AbstractCharacter


class AbstractCharacterTest extends munit.FunSuite {

    test("receiveAttack should decrease the current life of the character by the amount attacked minus defense") {
        var character0 = AbstractCharacter("character0", 10, 12, 5, 40)
        var character1 = AbstractCharacter("character1", 15, 4, 2, 20)

        assert (character1.life == 15)
        character1.receiveAttack(10)
        assert (character1.life == 5)
    }
    test("receiveAttack shoud do nothing if the attack is less than defense"){
        var character0 = Character("character0", 10, 12, 5, 40)
        var character1 = Character("character1", 15, 4, 2, 20)
                
    }
    
}
