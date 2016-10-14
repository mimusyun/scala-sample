package example

object Main extends App {
   
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
  
  println(sqrt(2))
  
  // Greatest common divisor
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
  
  println(gcd(14, 21))

  // Factorial - tail recursive version
  def factorial(n: Int): Int = {
    def loop(acc:Int, n: Int): Int = 
      if(n == 0) acc
      else loop(acc*n, n-1)
    loop(1, n)
  }
  
  println(factorial(5))
  
}
