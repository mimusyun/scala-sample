package example

object HigherOrderFunction {
  
  /*
   * Higher Order Functions Examples
   * */
  
  // Normal Functions
  def id(x: Int): Int = x
  def cube(x: Int): Int = x * x * x
  def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)  

  // Sum functions - normal recursive implementation
  def sumInts_1(a: Int, b: Int): Int = 
    if (a > b) 0 else a + sumInts_1(a + 1, b)
  
  def sumCubes_1(a: Int, b: Int): Int = 
    if (a > b) 0 else cube(a) + sumCubes_1(a + 1, b)
    
  def sumFactorials_1(a: Int, b: Int): Int =
    if (a > b) 0 else fact(a) + sumFactorials_1(a + 1, b)
   
  // Sum functions - implementation with Higher Order Function
  def sum_1(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum_1(f, a + 1, b)
    
  def sumInts_2(a: Int, b: Int): Int = sum_1(id, a, b)   
  def sumCubes_2(a: Int, b: Int): Int = sum_1(cube, a, b) 
  def sumFactorials_2(a: Int, b: Int): Int = sum_1(fact, a, b)   
  
  // Anonymous Functions Examples
  (x: Int) => x * x * x
  (x: Int, y: Int) => x + y
  
  // Implementations with anonymous functions
  def sumInts_3(a: Int, b: Int) = sum_1(x => x, a, b)
  def sumCubes_3(a: Int, b: Int) = sum_1(x => x * x * x, a, b)
  
  // Sum functions - implementation with Higher Order Function optimized by tail recursion
  def sum_2(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }
  
  def sumInts_4(a: Int, b: Int): Int = sum_2(id, a, b) 
  def sumCubes_4(a: Int, b: Int): Int = sum_2(cube, a, b)
  def sumFactorials_4(a: Int, b: Int): Int = sum_2(fact, a, b)
  
  // Example - find fixed point (fixed point -> (x,y) = (1,1),(2,2) ... (n,n))

  val tolerance = 0.0001
  def isCloseEnough(x: Double, y: Double) = 
    math.abs((x - y) / x) / x < tolerance
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }
    
}