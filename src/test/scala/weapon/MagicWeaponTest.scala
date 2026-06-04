package weapon

class MagicWeaponTest extends munit.FunSuite{

  test("A magic weapon cannot be created with the attribute magicAttack lesser than 1"){
    var wandGood = Wand("wandGood", 10, 10, 1)
    var wandBetter = Wand("wandBetter", 10, 10, 100)

    intercept[IllegalArgumentException]{
      var wandBad = Wand("wandBad", 10, 10, 0)
    }
    intercept[IllegalArgumentException] {
      var wandWorse = Wand("wandWorse", 10, 10, -100)
    }
  }

}
