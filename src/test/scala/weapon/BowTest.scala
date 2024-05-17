package weapon

class BowTest extends munit.FunSuite{
  var Bow1: Bow = _
  var Bow2: Bow = _
  var Sword: Sword = _

  override def beforeEach(context: BeforeEach): Unit = {
    Bow1 = new Bow("destroyer", 5, 10)
    Bow2 = new Bow("supreme", 4, 15)
    Sword = new Sword("destroyer", 5, 10)
  }

  test("equals"){
    assertEquals(Bow1, Bow1)
    assertEquals(Bow1, new Bow("destroyer", 5, 10))
    assert(!Bow1.equals(Bow2))
    assert(!Bow1.equals(Sword))
  }

  test("Test toString") {
    val expected = "Bow(destroyer, 5, 10)"
    assert(Bow1.toString == expected)
  }

}
