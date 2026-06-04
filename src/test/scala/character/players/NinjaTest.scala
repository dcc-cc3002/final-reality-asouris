package character.players

class NinjaTest extends munit.FunSuite{
  var Ninja1: Ninja = _
  var Ninja2: Ninja = _
  var Warrior: Warrior = _

  override def beforeEach(context: BeforeEach): Unit = {
    Ninja1 = new Ninja("Ninja1", 20, 5, 10)
    Ninja2 = new Ninja("Ninja2", 20, 10, 5)
    Warrior = new Warrior("BestWarrior", 20, 20, 5)
  }

  test("equals"){
    assertEquals(Ninja1, Ninja1)
    assertEquals(Ninja1, new Ninja("Ninja1", 20, 5, 10))
    assert(!Ninja1.equals(Ninja2))
    
    assert(!Ninja1.equals(Warrior))
  }

  test("Test toString") {
    val expected = "Ninja(Ninja1, 20, 5, 10)"
    assert(expected == Ninja1.toString)
  }
}