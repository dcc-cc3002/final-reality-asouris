package character.players

class NinjaTest extends munit.FunSuite{
  var Ninja1: Ninja = _
  var Ninja2: Ninja = _

  override def beforeEach(context: BeforeEach): Unit = {
    Ninja1 = new Ninja("Ninja1", 20, 5, 10)
    Ninja2 = new Ninja("Ninja2", 20, 10, 5)
  }

  test("equals"){
    assertEquals(Ninja1, Ninja1)
    assertEquals(Ninja1, new Ninja("Ninja1", 20, 5, 10))
    assert(!Ninja1.equals(Ninja2))
  }
}