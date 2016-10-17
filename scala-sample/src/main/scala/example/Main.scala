

package example

object Main extends App {
  
  // move to scala test later
  //TypicalAlgorithms.execute()
  
  // HigherOrderFunction 
//  println(HigherOrderFunction.sum_1((x: Int) => x * x * x, 1, 10))
//  println(HigherOrderFunction.sum_2((x: Int) => x * x * x, 1, 10))
//  println()
  
//  println(HigherOrderFunction.fixedPoint(x => x)(1))
//  println(HigherOrderFunction.fixedPoint(x => x/2+1)(1))
//  println(HigherOrderFunction.fixedPoint(x => x/2+2)(1))
//  println(HigherOrderFunction.fixedPoint(x => x/3+2)(1))
//  println(HigherOrderFunction.fixedPoint(x => 2 * x/3+2)(1))
  
//HigherOrderFunction.sqrt(10)
  
  // Currying
//  println(Currying.product(x => x * x)(3, 4))
//  println(Currying.mapReduce(x => x * x, ((a, b) => a*b), 1)(3, 4))
//  println(Currying._product(x => x * x)(3, 4))
//  println(Currying.fact(5))
  
  // Class Example
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  println(new Rational(3,10) add new Rational(1,2))
  println(new Rational(3,10) + new Rational(1,2))

  
}
