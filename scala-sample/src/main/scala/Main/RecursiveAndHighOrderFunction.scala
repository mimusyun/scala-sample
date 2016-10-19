package Main

object RecursiveAndHighOrderFunction extends App {
  
  
  /*
   *  Recursive Functions
   */
  
  def factorial(n: Int): Int = n match {
		case 0 => 1
		case _ => n * factorial(n-1)
	} 
  
  println(factorial(5))
  
  def minimum(l: List[Int]): Int = l match {
    case Nil => throw new Exception
		case x :: Nil => x
		case x :: y :: Nil => if (x < y) x else y
		case x :: xs => if(x < minimum(xs)) x else minimum(xs)
	}
	
	println(minimum(List(5,3,4,8,10,100,9)))
	
	def betterMinimum(l: List[Int]): Int = l match {
    case Nil => throw new Exception
		case x :: Nil => x
		case x :: xs => {
		  val y = minimum(xs)
		  if (x < y) x else y
		}
	}
	
	println(minimum(List(5,3,4,8,10,100,9)))
	
	def fill(howMany: Int)(thing: Int): List[Int] = {
	  if(howMany <= 0) Nil
	  else thing :: fill(howMany-1)(thing)
	}
	
	println(fill(8)(0))
	
	def take(howMany: Int, things: List[Int]): List[Int] = {
	  if (howMany <= 0) Nil
	  else things match {
	    case Nil => Nil
	    case t :: ts => t :: take(howMany - 1, ts)
	  }
	}
	
	println(take(2, List(1,2,3)))
	println(take(10, List(1,2,3)))
	
	def backwards(things: List[Int]): List[Int] = things match {
	  case Nil => Nil
	  case t :: ts => backwards(ts) ++ List(t)
	}
	
	println(backwards(List(1,2,3,4,5,6,7,8,9)))
	println(List(1,2,3,4,5,6,7,8,9).reverse)
	
	def zip(things: List[Int], moreThings: List[Int]): List[(Int, Int)] = 
	(things, moreThings) match {
	  case (Nil, _) => Nil
	  case (_, Nil) => Nil
	  case (t :: ts, m :: ms) => (t, m) :: zip(ts, ms)
	}
	
	println(zip(List(1,2,3), List(5,6,7,8)))
	println(List(1,2,3).zip(List(5,6,7,8)))
	
	def has(things: List[Any], thing: Any): Boolean = things match {
	  case Nil => false
	  case (t :: ts) if (t == thing) => true 
	  case (t :: ts) => has(ts, thing)
	}
	
	println(List(1,2,3,4,5).contains(2))
	println(has(List(1,2,3,4,5), 2))
	
	
	def quicksort(l: List[Int]): List[Int] = l match {
	  case Nil => Nil
	  case i :: Nil => List(i)
	  case pivot :: rest => {
	    val left = quicksort(for(x <- rest if (x < pivot)) yield x)
	    val right = quicksort(for(x <- rest if (x >= pivot)) yield x)
	    left ++ List(pivot) ++ right
	  }
	}
	
	println(quicksort(List(4,9,8,2,3,6,7,1,0)))

	
	/*
	 * Higher Order Function
	 */
	
	def doTwice(x: Int, f: Int => Int) = f(f(x))
	
	println(doTwice(5, _ + 1))
	println(doTwice(5, _ * 10))
	
	def zipWith[A,B,C](l: List[A], r: List[B], f: (A, B) => C): List[C] =
	  (l, r) match {
	    case (Nil, _) => Nil
	    case (_, Nil) => Nil
	    case (t :: ts, m :: ms) => f(t, m) :: zipWith(ts, ms, f)
	  }
	
	def zipWith2[A,B,C](l: List[A], r: List[B])(f: (A, B) => C): List[C] =
	  (l, r) match {
	    case (Nil, _) => Nil
	    case (_, Nil) => Nil
	    case (t :: ts, m :: ms) => f(t, m) :: zipWith(ts, ms, f)
	  }
	
	val left = List(1,2,3)
	val right = List("happy pappy", "bananas", "generic types")
	println(zipWith(left, right, (a: Int, b: String) => a.toString + " " + b))
	println(zipWith2(left, right)((a: Int, b: String) => a.toString + " " + b))
	
	def map[A, B](l: List[A])(f: A => B): List[B] = l match {
	  case Nil => Nil
	  case h :: t => f(h) :: map(t)(f)
	}
	
	println(map(List(1,2,3,4,5))(_ + "!!"))
	println(map(List(1,2,3,4,5))(x => x * x))
	println(List(1,2,3,4,5).map(x => x * x))
	
	def filter[A, B](l: List[A])(f: A => Boolean): List[A] = l match {
	  case Nil => Nil
	  case h :: t => 
	    if (f(h)) h :: filter(t)(f)
	    else filter(t)(f)
	}
	
	println(filter(List(1,2,3,4,5))(_ < 3))
	println(filter(List("happy pappy", "bananas", "generic types"))(_ contains "p"))
	
	def quicksortWithFilter(l: List[Int]): List[Int] = l match {
	  case Nil => Nil
	  case i :: Nil => List(i)
	  case pivot :: rest => {
	    quicksort(rest.filter(_ < pivot)) ++ 
	    List(pivot) ++ 
	    quicksort(rest.filter(_ >= pivot))
	  }
	}
	
	println(quicksortWithFilter(List(4,9,8,2,3,6,7,1,0)))
	
	
	
	
	
	
}