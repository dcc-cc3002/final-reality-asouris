package exceptions

/**
 * An exception indicating that a weapon with an owner is trying to set another one.
 *
 * @param details A message providing more details about the exception.
 */
class OwnerException(details: String) extends Exception (details){

}
