package weapon


class SwordTest extends munit.FunSuite{
  var Sword1: Sword = _
  var Sword2: Sword = _

  override def beforeEach(context: BeforeEach): Unit = {
    Sword1 = new Sword("destroyer", 5, 10)
    Sword2 = new Sword("supreme", 4, 15)
  }

  test("equals"){
    assertEquals(Sword1, Sword1)
    assertEquals(Sword1, new Sword("destroyer", 5, 10))
    assert(!Sword1.equals(Sword2))
  }

}
