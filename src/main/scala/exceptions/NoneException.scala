package exceptions

/**
 * An exception indicating that a particular value is "None" when it was expected to have a value.
 *
 * @param details A message providing more details about the exception.
 */
class NoneException(details: String) extends Exception (details){

}
