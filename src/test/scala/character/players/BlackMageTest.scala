package character.players

class BlackMageTest extends munit.FunSuite{
  var BlackMage1: BlackMage = _
  var BlackMage2: BlackMage = _

  override def beforeEach(context: BeforeEach): Unit = {
    BlackMage1 = new BlackMage("BlackMage1", 20, 5, 10, 10)
    BlackMage2 = new BlackMage("BlackMage2", 20, 10, 5, 6)
  }

  test("equals"){
    assertEquals(BlackMage1, BlackMage1)
    assertEquals(BlackMage1, new BlackMage("BlackMage1", 20, 5, 10, 10))
    assert(!BlackMage1.equals(BlackMage2))
  }
}