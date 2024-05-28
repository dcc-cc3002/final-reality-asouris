package character.players

class AbstractMagicPlayerTest extends munit.FunSuite{
  
  test("getMagicPoints should give you value for the attribute magic points of the character"){
    val mage : WhiteMage = new WhiteMage("destroyerOfWorlds", 10, 5, 5, 10, 7, 7)
    
    val expected = 7
    
    assert(mage.getMana == expected)
  }

}
