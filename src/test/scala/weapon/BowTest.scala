package weapon

class BowTest extends munit.FunSuite{
  var Bow1: Bow = _
  var Bow2: Bow = _

  override def beforeEach(context: BeforeEach): Unit = {
    Bow1 = new Bow("destroyer", 5, 10)
    Bow2 = new Bow("supreme", 4, 15)
  }

  test("equals"){
    assertEquals(Bow1, Bow1)
    assertEquals(Bow1, new Bow("destroyer", 5, 10))
    assert(!Bow1.equals(Bow2))
  }

}
