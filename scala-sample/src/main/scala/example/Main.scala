

package example

object Main extends App {
  
  // move to scala test later
  //TypicalAlgorithms.execute()
  
  // HigherOrderFunction 
//  println(HigherOrderFunction.sum_1((x: Int) => x * x * x, 1, 10))
//  println(HigherOrderFunction.sum_2((x: Int) => x * x * x, 1, 10))
//  println()
  
  println(HigherOrderFunction.fixedPoint(x => x)(1))
  println(HigherOrderFunction.fixedPoint(x => x/2+1)(1))
  println(HigherOrderFunction.fixedPoint(x => x/2+2)(1))
  println(HigherOrderFunction.fixedPoint(x => x/3+2)(1))
  println(HigherOrderFunction.fixedPoint(x => 2 * x/3+2)(1))
  
  // Currying
//  println(Currying.product(x => x * x)(3, 4))
//  println(Currying.mapReduce(x => x * x, ((a, b) => a*b), 1)(3, 4))
//  println(Currying._product(x => x * x)(3, 4))
//  println(Currying.fact(5))
  
  
  
}
