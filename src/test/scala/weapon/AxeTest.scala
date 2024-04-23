package weapon
import weapon.Axe

class AxeTest extends munit.FunSuite{
  var Axe1: Axe = _
  var Axe2: Axe = _

  override def beforeEach(context: BeforeEach): Unit = {
    Axe1 = new Axe("destroyer", 5, 10)
    Axe2 = new Axe("supreme", 4, 15)
  }

  test("equals"){
    assertEquals(Axe1, Axe1)
    assertEquals(Axe1, new Axe("destroyer", 5, 10))
    assert(!Axe1.equals(Axe2))
  }

}
