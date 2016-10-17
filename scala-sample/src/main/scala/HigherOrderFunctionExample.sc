object HigherOrderFunctionExample {
  
  // Normal Functions
  def id(x: Int): Int = x                         //> id: (x: Int)Int
  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int
  def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)
                                                  //> fact: (x: Int)Int

  // Sum functions - normal recursive implementation
  def sumInts_1(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts_1(a + 1, b)     //> sumInts_1: (a: Int, b: Int)Int
  
  def sumCubes_1(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + sumCubes_1(a + 1, b)
                                                  //> sumCubes_1: (a: Int, b: Int)Int
    
  def sumFactorials_1(a: Int, b: Int): Int =
    if (a > b) 0 else fact(a) + sumFactorials_1(a + 1, b)
                                                  //> sumFactorials_1: (a: Int, b: Int)Int
   
  // Sum functions - implementation with Higher Order Function
  def sum_1(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum_1(f, a + 1, b)                //> sum_1: (f: Int => Int, a: Int, b: Int)Int
    
  def sumInts_2(a: Int, b: Int): Int = sum_1(id, a, b)
                                                  //> sumInts_2: (a: Int, b: Int)Int
  def sumCubes_2(a: Int, b: Int): Int = sum_1(cube, a, b)
                                                  //> sumCubes_2: (a: Int, b: Int)Int
  def sumFactorials_2(a: Int, b: Int): Int = sum_1(fact, a, b)
                                                  //> sumFactorials_2: (a: Int, b: Int)Int
  
  // Anonymous Functions Examples
  (x: Int) => x * x * x                           //> res0: Int => Int = <function1>
  (x: Int, y: Int) => x + y                       //> res1: (Int, Int) => Int = <function2>
  
  // Implementations with anonymous functions
  def sumInts_3(a: Int, b: Int) = sum_1(x => x, a, b)
                                                  //> sumInts_3: (a: Int, b: Int)Int
  def sumCubes_3(a: Int, b: Int) = sum_1(x => x * x * x, a, b)
                                                  //> sumCubes_3: (a: Int, b: Int)Int
  
  // Sum functions - implementation with Higher Order Function optimized by tail recursion
  def sum_2(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
  }                                               //> sum_2: (f: Int => Int, a: Int, b: Int)Int
  
  def sumInts_4(a: Int, b: Int): Int = sum_2(id, a, b)
                                                  //> sumInts_4: (a: Int, b: Int)Int
  def sumCubes_4(a: Int, b: Int): Int = sum_2(cube, a, b)
                                                  //> sumCubes_4: (a: Int, b: Int)Int
  def sumFactorials_4(a: Int, b: Int): Int = sum_2(fact, a, b)
                                                  //> sumFactorials_4: (a: Int, b: Int)Int
  
  // Example - find fixed point (fixed point -> (x,y) = (1,1),(2,2) ... (n,n))

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    math.abs((x - y) / x) / x < tolerance         //> isCloseEnough: (x: Double, y: Double)Boolean
  
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      println("guess = " + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  
  def averageDamp(f: Double => Double)(x: Double) = (x + f(x))/2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
  
  def sqrt(x: Double) = fixedPoint(averageDamp(y => x / y))(1.0)
                                                  //> sqrt: (x: Double)Double
}