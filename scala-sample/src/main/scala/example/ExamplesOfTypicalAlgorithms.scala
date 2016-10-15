package example

object ExamplesOfTypicalAlgorithms {
  def abs(x: Double) = 
      if (x > 0) x else -x
  
  // Newton's method
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
  
  // Greatest common divisor
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)

  // Factorial - tail recursive version
  def factorial(n: Int): Int = {
    def loop(acc:Int, n: Int): Int = 
      if(n == 0) acc
      else loop(acc*n, n-1)
    loop(1, n)
  }
  
  // Pascal's Triangle
  def pascal(c: Int, r: Int): Int = {
    if(c==0 || r==c) 1
    else if(c<=r/2) pascal(c-1,r-1) + pascal(c,r-1)
    else if(c>r/2) pascal(r-c-1,r-1) + pascal(r-c,r-1)
    else 0
  }
  
  // Parentheses balance check
  def balance(chars: List[Char]): Boolean = {
    def isBalanced(chars: List[Char], cnt: Int): Boolean = {
      if (cnt<0) false
      else if(chars.isEmpty) cnt == 0
      else if(chars.head == '(') isBalanced(chars.tail, cnt+1)
      else if(chars.head == ')') isBalanced(chars.tail, cnt-1)
      else isBalanced(chars.tail, cnt) 
    }
    
    isBalanced(chars, 0)
  }
  
}