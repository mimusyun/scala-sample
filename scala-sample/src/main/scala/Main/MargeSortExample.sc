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
  }                                               //> msort: (xs#277462: List#222914[Int#1111])List#222914[Int#1111]
  
  msort(List(5,4,7,-10,35,94,-28))                //> res0: List#222914[Int#1111] = List(-28, -10, 4, 5, 7, 35, 94)
  
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
  }                                               //> msort2: [T#277455](xs#277864: List#222914[T#277455])(lt#277865: (T#277455, T
                                                  //| #277455) => Boolean#2533)List#222914[T#277455]
  
  msort2(List(5,4,7,-10,35,94,-28))((x: Int, y: Int) => x < y)
                                                  //> res1: List#222914[Int#1111] = List(-28, -10, 4, 5, 7, 35, 94)
  msort2(List("apple","orange","banana","mango"))((x: String, y: String) => x.compareTo(y) < 0)
                                                  //> res2: List#222914[String#234] = List(apple, banana, mango, orange)
  
  import scala.math.Ordering
  def msort3[T](xs: List[T])(ord: Ordering[T]): List[T] = {
  	val n = xs.length/2
  	if(n == 0) xs
  	else {
  		def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match{
  			case (Nil, ys) => ys
  			case (xs, Nil) => xs
  			case (x :: xs1, y :: ys1) => {
  				if (ord.lt(x, y)) x :: merge(xs1, ys)
  				else y :: merge(xs, ys1)
  			}
  		}
  		val (fst, snd) = xs splitAt n
  		merge(msort3(fst)(ord), msort3(snd)(ord))
  	}
  }                                               //> msort3: [T#277459](xs#278079: List#222914[T#277459])(ord#278080: scala#27.m
                                                  //| ath#2758.Ordering#37676[T#277459])List#222914[T#277459]
  
  msort3(List(5,4,7,-10,35,94,-28))(Ordering.Int) //> res3: List#222914[Int#1111] = List(-28, -10, 4, 5, 7, 35, 94)
  
  
  
}