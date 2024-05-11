package character.players

class AbstractMagicPlayerTest extends munit.FunSuite{
  
  test("getMagicPoints should give you value for the attribute magic points of the character"){
    val mage : WhiteMage = new WhiteMage("destroyerOfWorlds", 10, 5, 10, 7)
    
    val expected = 7
    
    assert(mage.getMagicPoints == expected)
  }
  
  test("toString should give you a String with the following structure Magic Character(name, life, defense, weight, magic points)"){
    val mage : WhiteMage = new WhiteMage("destroyerOfWorlds", 10, 5, 10, 7)
    
    val expected = "Magic Character(destroyerOfWorlds, 10, 5, 10, 7)"
    
    assert(mage.toString == expected)
    
  }

}
