package effects

import character.players.Warrior

class BurntEffectTest extends munit.FunSuite{

  test("toString test"){
    val burnt = new BurntEffect(18)
    assert(burnt.toString == "Burnt(3)")
  }

  test("apply test"){
    val burnt = new BurntEffect(18)
    val warrior = new Warrior("warrior", 27, 27, 15, 20)

    assert(burnt.apply(warrior))
    assert(burnt.duration == 2 && warrior.getLife == 18)
    assert(burnt.apply(warrior))
    assert(burnt.duration == 1 && warrior.getLife == 9)
    assert(!burnt.apply(warrior))
  }

}
