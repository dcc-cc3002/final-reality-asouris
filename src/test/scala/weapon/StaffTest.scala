package weapon

class StaffTest extends munit.FunSuite{
  var Staff1: Staff = _
  var Staff2: Staff = _
  var Sword: Sword = _

  override def beforeEach(context: BeforeEach): Unit = {
    Staff1 = new Staff("destroyer", 5, 10, 15)
    Staff2 = new Staff("supreme", 4, 15, 10)
    Sword = new Sword("destroyer", 5, 10)
  }

  test("equals"){
    assertEquals(Staff1, Staff1)
    assertEquals(Staff1, new Staff("destroyer", 5, 10, 15))
    assert(!Staff1.equals(Staff2))
    assert(!Staff1.equals(Sword))
  }

  test("Test toString") {
    val expected = "Staff(destroyer, 5, 10, 15)"
    assert(Staff1.toString == expected)
  }

}
