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
    val retList: List[Int] = List()
     if (min>max ) {
       println("parameter not valid")
       return retList
     }
    
    val rangeList = (min to max).toList
    
    //val newList =  rangeList.map((curval: Int) => if(curval % 2 !=0) curval )
    
    val newList =  rangeList.filter(curval => (curval % 2 !=0) ).map(curval => curval)
    
    
     return newList.asInstanceOf[List[(Int)]]
  }

  /**
    * Implement a function which reverses a String
    * @param s Input string
    * @return new String which is the reversed version of input
    */
  def stringReverser(s: String): String = {
    val stringRev = {s:String => (for(i<-s.length-1 to 0 by -1) yield s(i)).mkString}
    return stringRev(s)
  }

  /**
    * Generate a Map which contains the the frequency counts of all the words
    * specified in the input Sequence. It should ignore case
    * @param input
    * @return Map of Word => Count
    */
  def wordFrequency(input: Seq[Seq[String]]): Map[String, Int] = {
    
     //println (input)
     
    val newMap = input.flatten.map(words=> (words,1)).groupBy(f=>f._1.toLowerCase()).mapValues(_.size)
    
     //println(newMap)
     return newMap
  }

  /**
    * Collapse a list of Options into a concrete list of values
    * @param l
    * @return
    */
  def optionCollapse[T](l: Seq[Option[T]])(f: T => Boolean): Seq[T] = {
    
    //val seqOpt:
//    println(l)
    val ret:List[Int]  = l.flatten.filter(p => p.isInstanceOf[Integer] ).asInstanceOf[List[(Int)]]
    
    val retEvens:Seq[T] = ret.filter(curval => (curval % 2 ==0) ).map(curval => curval).asInstanceOf[Seq[(T)]]
//    println(ret)
    return retEvens
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
              ("generateOdds", generateOddsTest _),
              ("stringReverser", stringReverserTest _),
               ("wordFrequency", wordFrequencyTest _),
    ("OptionCollapseTest", optionCollapseTest _)
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
  def generateOddsTest():Boolean = {
    
    val expected = List(3,5,7,9)
    return CodeFun.generateOdds(2, 9) == expected
    
  }
  
   def stringReverserTest():Boolean = {
    val expected = "DOG YM HO"
    return CodeFun.stringReverser("OH MY GOD") == expected
    
  }
   
  /**
    * Add the logic to execute all of the tests.
    * This function should print the name of the test and whether it passed or failed.
    */
  def runAllTests(){
    println(TestSuite.testsToRun)
    //testsToRun.foreach { s <- println s. }
    for ( onetest <- testsToRun){
        val ret = onetest._2.apply();
        val status = (if(ret) "SUCCEEDED" else "FAILED!!")
        println("Unit Test for ->" + onetest._1 + ":"+ status )
    }
  }
}
