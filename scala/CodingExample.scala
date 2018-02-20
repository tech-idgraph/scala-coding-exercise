/**
* TODO: Implement each function where you see a `throw new NotImplementedError()` or a TODO
* Try to follow functional programming paradigms and avoid directly using mutable structures
* Once you have implemented your solutions move on to implementing Unit tests for these solutions.
* All the tests should return True and function properly.
**/

object CodeFunRunner extends App {
  TestSuite.runAllTests
}

object CodeFun {
  /**
    * Implement a function which prints only odd numbers between [min, max]
    * @param min Inclusive start of numbers
    * @param max Inclusive end of numbers
    * @return List of all numbers which are odd between [min,max]
    */
  def generateOdds(min: Int, max: Int): List[Int] = {
    throw new NotImplementedError()
  }

  /**
    * Implement a function which reverses a String
    * @param s Input string
    * @return new String which is the reversed version of input
    */
  def stringReverser(s: String): String = {
    throw new NotImplementedError()
  }

  /**
    * Generate a Map which contains the the frequency counts of all the words
    * specified in the input Sequence. It should ignore case
    * @param input
    * @return Map of Word => Count
    */
  def wordFrequency(input: Seq[Seq[String]]): Map[String, Int] = {
    throw new NotImplementedError()
  }

  /**
    * Collapse a list of Options into a concrete list of values
    * @param l
    * @return
    */
  def optionCollapse[T](l: Seq[Option[T]])(f: T => Boolean): Seq[T] = {
    throw new NotImplementedError()
  }
}

/**
* Test Suite Object which contains a list of tests to run for Unit testing
*/
object TestSuite {

  /****
    * We now need to test our CodeFun functions.
    * Write proper unit tests to make sure our functions do what we are expecting
    * Once you write all of your tests, add them to the testsToRun!
    *****/
  val testsToRun = Seq(
    ("OptionCollapseTest", optionCollapseTest _),
    ("WordFrequencyTest", wordFrequencyTest _)
  )

  // BEGIN Tests
  // here are some examples
  def optionCollapseTest(): Boolean = {
    val input: Seq[Option[Int]] =
      Seq(Option(1), Option(2), None, Option(3), None, Option(4))

    val expected = Seq(2,4)

    // running option collapse should only yield even numbers
    CodeFun.optionCollapse(input)(_ % 2 == 0) == expected
  }

  def wordFrequencyTest(): Boolean = {
    val input = Seq(Seq("This", "is", "test"),
                Seq("This", "has", "something"),
                Seq("Something", "which", "is", "something"))

    val expected = Map("this" -> 2, "is" -> 2, "test" -> 1, "has" -> 1, "something" -> 3, "which" -> 1)

    CodeFun.wordFrequency(input) == expected
  }

  /* TODO: Implement more tests, for testing each functions behavior! */

  /**
    * Add the logic to execute all of the tests.
    * This function should print the name of the test and whether it passed or failed.
    */
  def runAllTests(): Unit = {
    throw new NotImplementedError()
  }
}
