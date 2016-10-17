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
   
   println("#Newton's method - sqrt")             //> #Newton's method - sqrt
   println("sqrt(2) = " + sqrt(2))                //> sqrt(2) = 1.4142156862745097
   println()                                      //> 
    
    println("#Greatest Common Divisor - gcd")     //> #Greatest Common Divisor - gcd
    println("gcd(14, 21) = " + gcd(14, 21))       //> gcd(14, 21) = 7
    println()                                     //> 
    
    println("#Factorial - factorial")             //> #Factorial - factorial
    println("factorial(5) = " + factorial(5))     //> factorial(5) = 120
    println()                                     //> 
    
    println("#Pascal's Triangle")                 //> #Pascal's Triangle
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
        println()
    }                                             //> 1 
                                                  //| 1 1 
                                                  //| 1 2 1 
                                                  //| 1 3 3 1 
                                                  //| 1 4 6 4 1 
                                                  //| 1 5 10 10 5 1 
                                                  //| 1 6 15 20 15 6 1 
                                                  //| 1 7 21 35 35 21 7 1 
                                                  //| 1 8 28 56 70 56 28 8 1 
                                                  //| 1 9 36 84 126 126 84 36 9 1 
                                                  //| 1 10 45 120 210 252 210 120 45 10 1 
    println()                                     //> 
    
    println("#Parenthese balance check")          //> #Parenthese balance check
    println("Is () balanced? = " + balance("()".toList).toString())
                                                  //> Is () balanced? = true
    println("Is )( balanced? = " + balance(")(".toList))
                                                  //> Is )( balanced? = false
    println("Is (()()) balanced? = " + balance("(()())".toList))
                                                  //> Is (()()) balanced? = true
    println("Is ((A)(A)(Test)) balanced? = " + balance("((A)(A)(Test))".toList))
                                                  //> Is ((A)(A)(Test)) balanced? = true
    println()                                     //> 
  
  def abs(x: Double) = if (x > 0) x else -x       //> abs: (x: Double)Double
    
  def factorial(n: Int): Int = {
    
    def loop(acc:Int, n: Int): Int =
      if(n == 0) acc
      else loop(acc * n, n - 1)
    
    loop(1, n)
  }                                               //> factorial: (n: Int)Int
  
  def sqrt(x: Double) = {
      
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    
    def isGoodEnough (guess: Double) =
      abs(guess * guess - x) < 1.0e-3
    
    def improve(guess: Double) =
      (guess + x / guess) / 2
      
    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double
  
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x % y)
                                                  //> gcd: (x: Int, y: Int)Int
  
  def pascal(c: Int, r: Int): Int = {
    if(c == 0 || r == c) 1
    else if(c <= r/2) pascal(c - 1, r - 1) + pascal(c, r - 1)
    else if(c >r /2) pascal(r - c - 1, r - 1) + pascal(r - c, r - 1)
    else 0
  }                                               //> pascal: (c: Int, r: Int)Int
  
  def balance(chars: List[Char]): Boolean = {
    def isBalanced(chars: List[Char], cnt: Int): Boolean = {
      if (cnt<0) false
      else if(chars.isEmpty) cnt == 0
      else if(chars.head == '(') isBalanced(chars.tail, cnt + 1)
      else if(chars.head == ')') isBalanced(chars.tail, cnt - 1)
      else isBalanced(chars.tail, cnt)
    }
    
    isBalanced(chars, 0)
  }                                               //> balance: (chars: List[Char])Boolean
  
  
}