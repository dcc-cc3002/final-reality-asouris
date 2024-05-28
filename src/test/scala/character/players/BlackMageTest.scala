package character.players

class BlackMageTest extends munit.FunSuite{
  var BlackMage1: BlackMage = _
  var BlackMage2: BlackMage = _
  var Warrior: Warrior = _

  override def beforeEach(context: BeforeEach): Unit = {
    BlackMage1 = new BlackMage("BlackMage1", 20, 20, 5, 10, 10, 10)
    BlackMage2 = new BlackMage("BlackMage2", 20, 20, 10, 5, 6, 6)
    Warrior = new Warrior("BestWarrior", 20, 20, 20, 5)
  }

  test("equals"){
    assertEquals(BlackMage1, BlackMage1)
    assertEquals(BlackMage1, new BlackMage("BlackMage1", 20, 20, 5, 10, 10, 10))
    assert(!BlackMage1.equals(BlackMage2))
    
    assert(!BlackMage1.equals(Warrior))
  }
  test("Test toString"){
    val expected = "BlackMage(BlackMage1, 20, 20, 5, 10, 10, 10)"
    assert(expected == BlackMage1.toString)
  }
}