

package example

object Main extends App {
  
  println("#Newton's method - sqrt")
  println("sqrt(2) = " + ExamplesOfTypicalAlgorithms.sqrt(2))
  println()
  
  println("#Greatest Common Divisor - gcd")
  println("gcd(14, 21) = " + ExamplesOfTypicalAlgorithms.gcd(14, 21))
  println()
  
  println("#Factorial - factorial")
  println("factorial(5) = " + ExamplesOfTypicalAlgorithms.factorial(5))
  println()
  
  println("#Pascal's Triangle")
  for (row <- 0 to 10) {
    for (col <- 0 to row)
      print(ExamplesOfTypicalAlgorithms.pascal(col, row) + " ")
      println()
  }
  println()
  
  println("#Parenthese balance check")
  println("Is () balanced? = " + ExamplesOfTypicalAlgorithms.balance("()".toList).toString())
  println("Is )( balanced? = " + ExamplesOfTypicalAlgorithms.balance(")(".toList))
  println("Is (()()) balanced? = " + ExamplesOfTypicalAlgorithms.balance("(()())".toList))
  println("Is ((A)(A)(Test)) balanced? = " + ExamplesOfTypicalAlgorithms.balance("((A)(A)(Test))".toList))
  println()
  
}
