package Main

object HigherOrderListFunctionExamples {
  
  // Map & Filter
  def scaleList(xs: List[Double], factor: Double): List[Double] = xs match {
  	case Nil => xs
  	case y :: ys => y * factor :: scaleList(ys, factor)
  }                                               //> scaleList: (xs: List[Double], factor: Double)List[Double]
  
  scaleList(List(1,2,3,4,5), 3.0)                 //> res0: List[Double] = List(3.0, 6.0, 9.0, 12.0, 15.0)
  
  def scaleListMap(xs: List[Double], factor: Double): List[Double]
  	= xs map (x => x * factor)                //> scaleListMap: (xs: List[Double], factor: Double)List[Double]
  	
 	scaleListMap(List(1,2,3,4,5), 3.0)        //> res1: List[Double] = List(3.0, 6.0, 9.0, 12.0, 15.0)
 	
 	def posElems(xs: List[Int]): List[Int] = xs match {
 		case Nil => xs
 		case y :: ys => if (y > 0) y :: posElems(ys) else posElems(ys)
 	}                                         //> posElems: (xs: List[Int])List[Int]
 	
 	posElems(List(1,2,-3,-4,5,-6,7,-8,9))     //> res2: List[Int] = List(1, 2, 5, 7, 9)
 	
 	def posElemsFilter(xs: List[Int]): List[Int]
 		= xs filter (x => x > 0)          //> posElemsFilter: (xs: List[Int])List[Int]
 		
 	posElemsFilter(List(1,2,-3,-4,5,-6,7,-8,9))
                                                  //> res3: List[Int] = List(1, 2, 5, 7, 9)
 	
 	val nums = List(2, -4, -5, 7, 1)          //> nums  : List[Int] = List(2, -4, -5, 7, 1)
 	val fruits = List("apple", "pineapple", "orange", "banene")
                                                  //> fruits  : List[String] = List(apple, pineapple, orange, banene)
 	
 	nums filter (x => x > 0)                  //> res4: List[Int] = List(2, 7, 1)
 	nums filterNot (x => x > 0)               //> res5: List[Int] = List(-4, -5)
 	nums partition (x => x > 0)               //> res6: (List[Int], List[Int]) = (List(2, 7, 1),List(-4, -5))
 	nums takeWhile (x => x > 0)               //> res7: List[Int] = List(2)
 	nums dropWhile (x => x > 0)               //> res8: List[Int] = List(-4, -5, 7, 1)
 	nums span (x => x > 0)                    //> res9: (List[Int], List[Int]) = (List(2),List(-4, -5, 7, 1))
 	
 	def pack[T](xs: List[T]): List[List[T]] = xs match {
 		case Nil => Nil
 		case x :: xs1 =>
 			val (first, rest) = xs span (y => y == x)
 			first :: pack(rest)
 	}                                         //> pack: [T](xs: List[T])List[List[T]]
 	
 	pack(List("a","a","a","b","c","c","a"))   //> res10: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a
                                                  //| ))
 	
 	pack(List("a","a","a","b","c","c","a")) map (x => (x.head, x.length))
                                                  //> res11: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
 	
  def encode[T](xs: List[T]): List[(T, Int)] = pack(xs) map (x => (x.head, x.length))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
  encode(List("a","a","a","b","c","c","a"))       //> res12: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
 	
 	
 	// FoldLeft
 	List(1,2,3,4,5,6,7,8,9) reduceLeft ((x,y) => x + y)
                                                  //> res13: Int = 45
 	List(1,2,3,4,5,6,7,8,9) reduceLeft (_ + _)//> res14: Int = 45
 	
  def sum(xs: List[Int]) = (0 :: xs) reduceLeft (_ + _)
                                                  //> sum: (xs: List[Int])Int
  sum(List(1,2,3,4,5,6,7,8,9))                    //> res15: Int = 45
  
 	List(1,2,3,4,5,6,7,8,9) reduceLeft ((x,y) => x * y)
                                                  //> res16: Int = 362880
  List(1,2,3,4,5,6,7,8,9) reduceLeft (_ * _)      //> res17: Int = 362880
  
 	def product(xs: List[Int]) = (1 :: xs) reduceLeft (_ * _)
                                                  //> product: (xs: List[Int])Int
 	product(List(1,2,3,4,5,6,7,8,9))          //> res18: Int = 362880
 	
 	def concat[T](xs: List[T], ys: List[T]): List[T] =
 		(xs foldRight ys)(_ :: _)         //> concat: [T](xs: List[T], ys: List[T])List[T]
 	
 	concat(List(1,2,3,4,5),List(6,7,8,9))     //> res19: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  
}