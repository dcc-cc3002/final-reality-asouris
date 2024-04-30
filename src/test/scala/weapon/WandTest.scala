package weapon

class WandTest extends munit.FunSuite{
  var Wand1: Wand = _
  var Wand2: Wand = _

  override def beforeEach(context: BeforeEach): Unit = {
    Wand1 = new Wand("destroyer", 5, 10, 15)
    Wand2 = new Wand("supreme", 4, 15, 10)
  }

  test("equals"){
    assertEquals(Wand1, Wand1)
    assertEquals(Wand1, new Wand("destroyer", 5, 10, 15))
    assert(!Wand1.equals(Wand2))
  }

}
