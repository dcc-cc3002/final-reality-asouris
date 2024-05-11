package character.players

class PaladinTest extends munit.FunSuite{
  var Paladin1: Paladin = _
  var Paladin2: Paladin = _

  override def beforeEach(context: BeforeEach): Unit = {
    Paladin1 = new Paladin("Paladin1", 20, 5, 10)
    Paladin2 = new Paladin("Paladin2", 20, 10, 5)
  }

  test("equals"){
    assertEquals(Paladin1, Paladin1)
    assertEquals(Paladin1, new Paladin("Paladin1", 20, 5, 10))
    assert(!Paladin1.equals(Paladin2))
  }
}
