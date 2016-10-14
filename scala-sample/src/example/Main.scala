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
  
  println("#sqrt(2)")
  println(sqrt(2))
  println()
  
  // Greatest common divisor
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
  
  println("#GCD(14, 21)")
  println(gcd(14, 21))
  println()

  // Factorial - tail recursive version
  def factorial(n: Int): Int = {
    def loop(acc:Int, n: Int): Int = 
      if(n == 0) acc
      else loop(acc*n, n-1)
    loop(1, n)
  }
  
  println("#Factorial(5)")
  println(factorial(5))
  println()
  
  def pascal(c: Int, r: Int): Int = {
    if(c==0 || r==c) 1
    else if(c<=r/2) pascal(c-1,r-1) + pascal(c,r-1)
    else if(c>r/2) pascal(r-c-1,r) + pascal(r-c,r-1)
    else 0
  }
  
  println("#Pascal's Triangle")
  for (row <- 0 to 10) {
    for (col <- 0 to row)
      print(pascal(col, row) + " ")
      println()
  }
  
}
