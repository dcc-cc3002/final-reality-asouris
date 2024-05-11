package character.players


class WhiteMageTest extends munit.FunSuite{
  var WhiteMage1: WhiteMage = _
  var WhiteMage2: WhiteMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    WhiteMage1 = new WhiteMage("whiteMage1", 20, 5, 10, 5)
    WhiteMage2 = new WhiteMage("whiteMage2", 20, 10, 5, 15)
  }

  test("equals"){
    assertEquals(WhiteMage1, WhiteMage1)
    assertEquals(WhiteMage1, new WhiteMage("whiteMage1", 20, 5, 10, 5))
    assert(!WhiteMage1.equals(WhiteMage2))
  }

}
