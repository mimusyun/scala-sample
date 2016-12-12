package Examples

object Streams {

	//
  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
                                                  //> xs  : Stream.Cons[Int] = Stream(1, ?)
  (1 to 1000).toStream                            //> res0: scala.collection.immutable.Stream[Int] = Stream(1, ?)
  
  def streamRange(lo: Int, hi: Int): Stream[Int] =
  	if (lo >= hi) Stream.empty
  	else Stream.cons(lo, streamRange(lo + 1, hi))
                                                  //> streamRange: (lo: Int, hi: Int)Stream[Int]
 	def listRange(lo: Int, hi: Int): List[Int] =
 		if (lo >= hi) Nil
 		else lo :: listRange(lo + 1, hi)  //> listRange: (lo: Int, hi: Int)List[Int]
 		
 	streamRange(1, 10)                        //> res1: Stream[Int] = Stream(1, ?)
 	listRange(1, 10)                          //> res2: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  streamRange(1, 10).tail                         //> res3: scala.collection.immutable.Stream[Int] = Stream(2, ?)
  listRange(1, 10).tail                           //> res4: List[Int] = List(2, 3, 4, 5, 6, 7, 8, 9)
  
  streamRange(1, 10).take(3).toList               //> res5: List[Int] = List(1, 2, 3)
  // x #:: xs == Stream.cons(x, xs)
  
}