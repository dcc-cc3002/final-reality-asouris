package character.players

class WarriorTest extends munit.FunSuite{
  var Warrior1: Warrior = _
  var Warrior2: Warrior = _

  override def beforeEach(context: BeforeEach): Unit = {
    Warrior1 = new Warrior("warrior1", 20, 5, 10)
    Warrior2 = new Warrior("warrior2", 20, 10, 5)
  }

  test("equals"){
    assertEquals(Warrior1, Warrior1)
    assertEquals(Warrior1, new Warrior("Warrior", 20, 5, 10))
    assert(!Warrior1.equals(Warrior2))
  }

}
