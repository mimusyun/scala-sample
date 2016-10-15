package example

object TypicalAlgorithms {
  
  /*
   * Typical Algorithms' implementation
   * 
   * abs(x: Double)
   * sumInts(a: Int, b: Int)
   * factorial(n: Int)
   * sumFactorials(a: Int, b: Int)
   * sqrt(x: Double)
   * gcd(x: Int, y: Int)
   * pascal(c: Int, r: Int)
   * balance(chars: List[Char])
   * 
   * */
  
  def abs(x: Double) = if (x > 0) x else -x
    
  def factorial(n: Int): Int = {
    
    def loop(acc:Int, n: Int): Int = 
      if(n == 0) acc
      else loop(acc * n, n - 1)
    
    loop(1, n)
  }
  
  def sqrt(x: Double) = { 
      
    def sqrtIter(guess: Double): Double = 
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    
    def isGoodEnough (guess: Double) = 
      abs(guess * guess - x) < 1.0e-3
    
    def improve(guess: Double) =
      (guess + x / guess) / 2
      
    sqrtIter(1.0)
  }
  
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
  
  def pascal(c: Int, r: Int): Int = {
    if(c == 0 || r == c) 1
    else if(c <= r/2) pascal(c - 1, r - 1) + pascal(c, r - 1)
    else if(c >r /2) pascal(r - c - 1, r - 1) + pascal(r - c, r - 1)
    else 0
  }
  
  def balance(chars: List[Char]): Boolean = {
    def isBalanced(chars: List[Char], cnt: Int): Boolean = {
      if (cnt<0) false
      else if(chars.isEmpty) cnt == 0
      else if(chars.head == '(') isBalanced(chars.tail, cnt + 1)
      else if(chars.head == ')') isBalanced(chars.tail, cnt - 1)
      else isBalanced(chars.tail, cnt) 
    }
    
    isBalanced(chars, 0)
  }
  
  def execute() = {
    println("#Newton's method - sqrt")
    println("sqrt(2) = " + TypicalAlgorithms.sqrt(2))
    println()
    
    println("#Greatest Common Divisor - gcd")
    println("gcd(14, 21) = " + TypicalAlgorithms.gcd(14, 21))
    println()
    
    println("#Factorial - factorial")
    println("factorial(5) = " + TypicalAlgorithms.factorial(5))
    println()
    
    println("#Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(TypicalAlgorithms.pascal(col, row) + " ")
        println()
    }
    println()
    
    println("#Parenthese balance check")
    println("Is () balanced? = " + TypicalAlgorithms.balance("()".toList).toString())
    println("Is )( balanced? = " + TypicalAlgorithms.balance(")(".toList))
    println("Is (()()) balanced? = " + TypicalAlgorithms.balance("(()())".toList))
    println("Is ((A)(A)(Test)) balanced? = " + TypicalAlgorithms.balance("((A)(A)(Test))".toList))
    println()
  }
  
}