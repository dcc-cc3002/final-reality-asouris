package character.players

class PaladinTest extends munit.FunSuite{
  var Paladin1: Paladin = _
  var Paladin2: Paladin = _
  var Warrior: Warrior = _

  override def beforeEach(context: BeforeEach): Unit = {
    Paladin1 = new Paladin("Paladin1", 20, 20, 5, 10)
    Paladin2 = new Paladin("Paladin2", 20, 20, 10, 5)
    Warrior = new Warrior("BestWarrior", 20, 20, 20, 5)
  }

  test("equals"){
    assertEquals(Paladin1, Paladin1)
    assertEquals(Paladin1, new Paladin("Paladin1", 20, 20, 5, 10))
    assert(!Paladin1.equals(Paladin2))
    
    assert(!Paladin1.equals(Warrior))
  }
  test("Test toString") {
    val expected = "Paladin(Paladin1, 20, 20, 5, 10)"
    assert(expected == Paladin1.toString)
  }
}
