object CurryingExample {
  /*
   * Currying Example
   */
  
  // (Int => Int) => (Int, Int) => (Int)
  def sum_1(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum_1: (f: Int => Int)(Int, Int) => Int
  
  // optimizes sum_1
  def sum_2(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum_2(f)(a + 1, b)   //> sum_2: (f: Int => Int)(a: Int, b: Int)Int
  
  // Example - re-write sum functions
  // def sumInts(a: Int, b: Int) = sum(x => x, a, b)
  
  def sumInts(a: Int, b: Int) = sum_1(x => x)(a, b)
                                                  //> sumInts: (a: Int, b: Int)Int
  def sumCubes(a: Int, b: Int) = sum_1(x => x * x * x)(a, b)
                                                  //> sumCubes: (a: Int, b: Int)Int
  
  // Example - function that calculates the product of the values for a given interval
  
  // product(f)(a, b) = f(a) * f(b)
  // product(x => x*x)(a, b) = a*a * (a+1)(a+a) * ... (a-1)(a-1) * b*b
  // product(x => x*x)(3, 4) = 3*3 * 4*4
  
  // fact(n) = product(x => x)(1, n) = 1 * 2 * 3 * ... * n
  
  // mapReduce(f, g, zero)(a, b) = if(a>b) zero else g(a, mapReduce(f, g, zero))
  // mapReduce(x => x, (a,b => a*b), zero )(a, b)
  //  = if(a>b) zero else f(a) * mapReduce(f, g, zero))(a+1, b)
  //  = if(a>b) zero else f(a) * f(a+1) * mapReduce(f, g, zero))(a+2, b)
  //  = if(a>b) zero else f(a) * f(a+1) * ... f(a-1) * f(b)
  
  
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)              //> product: (f: Int => Int)(a: Int, b: Int)Int
    
  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b
                                                  //| : Int)Int
  
  // rewrite product using mapReduce function
  def _product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> _product: (f: Int => Int)(a: Int, b: Int)Int
}