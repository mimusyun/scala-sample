package Main

object SetsExamples {
  val fruit = Set("apple", "banana", "pear")      //> fruit  : scala.collection.immutable.Set[String] = Set(apple, banana, pear)
  val s = (1 to 6).toSet                          //> s  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)
  
  s map (_ / 2)                                   //> res0: scala.collection.immutable.Set[Int] = Set(2, 0, 3, 1)
  s contains 5                                    //> res1: Boolean = true
  
  // Eight N-Queens problem
  def queens(n: Int): Set[List[Int]] = {
    def isSafe(col: Int, queens: List[Int]): Boolean = {
    	val row = queens.length
    	val queensWithRow = (row - 1 to 0 by -1) zip queens
    	queensWithRow forall {
    		case (r, c) => col != c && math.abs(col-c) != row - r
    	}
    }
    def placeQueens(k: Int): Set[List[Int]] =
    	if (k == 0) Set(List())
    	else
    		for {
    			queens <- placeQueens(k -1)
    			col <- 0 until n
    			if isSafe(col, queens)
    		} yield col :: queens
  	placeQueens(n)
  }                                               //> queens: (n: Int)Set[List[Int]]
  
  def show(queens: List[Int]) = {
   		val lines =
   			for (col <- queens.reverse)
   			yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
   			"\n" + (lines mkString "\n")
  }                                               //> show: (queens: List[Int])String
  
  queens(4) map show mkString "\n"                //> res2: String = "
                                                  //| * * X * 
                                                  //| X * * * 
                                                  //| * * * X 
                                                  //| * X * * 
                                                  //| 
                                                  //| * X * * 
                                                  //| * * * X 
                                                  //| X * * * 
                                                  //| * * X * "
  queens(6) map show mkString "\n"                //> res3: String = "
                                                  //| * * X * * * 
                                                  //| * * * * * X 
                                                  //| * X * * * * 
                                                  //| * * * * X * 
                                                  //| X * * * * * 
                                                  //| * * * X * * 
                                                  //| 
                                                  //| * X * * * * 
                                                  //| * * * X * * 
                                                  //| * * * * * X 
                                                  //| X * * * * * 
                                                  //| * * X * * * 
                                                  //| * * * * X * 
                                                  //| 
                                                  //| * * * X * * 
                                                  //| X * * * * * 
                                                  //| * * * * X * 
                                                  //| * X * * * * 
                                                  //| * * * * * X 
                                                  //| * * X * * * 
                                                  //| 
                                                  //| * * * * X * 
                                                  //| * * X * * * 
                                                  //| X * * * * * 
                                                  //| * * * * * X 
                                                  //| * * * X * * 
                                                  //| * X * * * * "
  
}