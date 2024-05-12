package weapon


class SwordTest extends munit.FunSuite{
  var Sword1: Sword = _
  var Sword2: Sword = _
  var Axe : Axe = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sword1 = new Sword("destroyer", 5, 10)
    Sword2 = new Sword("supreme", 4, 15)
    Axe = new Axe("axe", 10, 20)
  }

  test("equals"){
    assertEquals(Sword1, Sword1)
    assertEquals(Sword1, new Sword("destroyer", 5, 10))
    assert(!Sword1.equals(Sword2))
    assert(!Sword1.equals(Axe))
  }

  test("Test toString"){
    val expected = "Sword(destroyer, 5, 10)"
    assert(Sword1.toString == expected)
  }

}
