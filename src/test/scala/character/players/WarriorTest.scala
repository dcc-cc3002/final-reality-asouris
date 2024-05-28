package character.players

class WarriorTest extends munit.FunSuite{
  var Warrior1: Warrior = _
  var Warrior2: Warrior = _
  var Paladin: Paladin = _

  override def beforeEach(context: BeforeEach): Unit = {
    Warrior1 = new Warrior("warrior1", 20, 20, 5, 10)
    Warrior2 = new Warrior("warrior2", 20, 20, 10, 5)
    Paladin = new Paladin("BestPaladin", 20, 20, 20, 5)
  }

  test("equals"){
    assertEquals(Warrior1, Warrior1)
    assertEquals(Warrior1, new Warrior("warrior1", 20, 20, 5, 10))
    assert(!Warrior1.equals(Warrior2))
    
    assert(!Warrior1.equals(Paladin))
  }

  test("Test toString") {
    val expected = "Warrior(warrior1, 20, 20, 5, 10)"
    assert(expected == Warrior1.toString)
  }

}
