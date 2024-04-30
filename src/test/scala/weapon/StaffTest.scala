package weapon

class StaffTest extends munit.FunSuite{
  var Staff1: Staff = _
  var Staff2: Staff = _

  override def beforeEach(context: BeforeEach): Unit = {
    Staff1 = new Staff("destroyer", 5, 10, 15)
    Staff2 = new Staff("supreme", 4, 15, 10)
  }

  test("equals"){
    assertEquals(Staff1, Staff1)
    assertEquals(Staff1, new Staff("destroyer", 5, 10, 15))
    assert(!Staff1.equals(Staff2))
  }

}
