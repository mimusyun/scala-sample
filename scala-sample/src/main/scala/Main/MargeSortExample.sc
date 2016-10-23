package src.main.scala.Main

object MargeSortExample {
  
  def msort(xs: List[Int]): List[Int] = {
  	val n = xs.length/2
  	if(n == 0) xs
  	else {
  		def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match{
  			case (Nil, ys) => ys
  			case (xs, Nil) => xs
  			case (x :: xs1, y :: ys1) => {
  				if (x < y) x :: merge(xs1, ys)
  				else y :: merge(xs, ys1)
  			}
  		}
  		val (fst, snd) = xs splitAt n
  		merge(msort(fst), msort(snd))
  	}
  }                                               //> msort: (xs: List[Int])List[Int]
  
  msort(List(5,4,7,-10,35,94,-28))                //> res0: List[Int] = List(-28, -10, 4, 5, 7, 35, 94)
  
  def msort2[T](xs: List[T])(lt: (T, T) => Boolean): List[T] = {
  	val n = xs.length/2
  	if(n == 0) xs
  	else {
  		def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match{
  			case (Nil, ys) => ys
  			case (xs, Nil) => xs
  			case (x :: xs1, y :: ys1) => {
  				if (lt(x, y)) x :: merge(xs1, ys)
  				else y :: merge(xs, ys1)
  			}
  		}
  		val (fst, snd) = xs splitAt n
  		merge(msort2(fst)(lt), msort2(snd)(lt))
  	}
  }                                               //> msort2: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]
  
  msort2(List(5,4,7,-10,35,94,-28))((x: Int, y: Int) => x < y)
                                                  //> res1: List[Int] = List(-28, -10, 4, 5, 7, 35, 94)
  msort2(List("apple","orange","banana","mango"))((x: String, y: String) => x.compareTo(y) < 0)
                                                  //> res2: List[String] = List(apple, banana, mango, orange)
  
}