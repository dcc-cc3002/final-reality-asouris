package exceptions

/**
 * An exception indicating that a weapon could not be equipped.
 *
 * @param details A message providing more details about the exception.
 */
class WeaponException(details: String) extends Exception (details){

}
