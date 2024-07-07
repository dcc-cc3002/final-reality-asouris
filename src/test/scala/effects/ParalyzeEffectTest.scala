package effects

import character.players.Warrior

class ParalyzeEffectTest extends munit.FunSuite{

  test("toString test"){
    val paralyze = new ParalyzeEffect(18)
    assert(paralyze.toString == "Paralyze(1)")
  }

  test("apply test") {
    val paralyze = new ParalyzeEffect(18)
    val warrior = new Warrior("warrior", 27, 27, 15, 20)

    assert(!paralyze.apply(warrior))

    assert(paralyze.duration == 0 && warrior.isParalyzed)
  }
}
