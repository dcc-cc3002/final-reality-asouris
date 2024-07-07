package effects

import character.players.Warrior

class PoisonEffectTest extends munit.FunSuite{

  test("toString test"){
    val poison = new PoisonEffect(18)
    assert(poison.toString == "Poison(4)")
  }

  test("apply test"){
    val poison = new PoisonEffect(18)
    val warrior = new Warrior("warrior", 27, 27, 15, 20)

    assert(poison.apply(warrior))
    assert(poison.duration == 3 && warrior.getLife == 21)
    assert(poison.apply(warrior))
    assert(poison.apply(warrior))
    assert(!poison.apply(warrior))
    assert(poison.duration == 1 && warrior.getLife == 3)
  }

}
