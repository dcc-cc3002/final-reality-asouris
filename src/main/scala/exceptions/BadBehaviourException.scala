package exceptions

/**
 * An exception indicating that it was attempted bad or invalid behaviour in the program.
 *
 * @param details A message providing more details about the exception.
 */
class BadBehaviourException(details: String) extends Exception (details){

}
