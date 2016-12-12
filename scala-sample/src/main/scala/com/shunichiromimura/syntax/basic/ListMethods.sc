object ListMethods {
	
	val xs = List(1,2,3,4,5)                  //> xs  : List[Int] = List(1, 2, 3, 4, 5)
	xs.length                                 //> res0: Int = 5
	xs.last                                   //> res1: Int = 5
	xs.init                                   //> res2: List[Int] = List(1, 2, 3, 4)
	xs take 3                                 //> res3: List[Int] = List(1, 2, 3)
	xs take 10                                //> res4: List[Int] = List(1, 2, 3, 4, 5)
	xs take 0                                 //> res5: List[Int] = List()
	xs drop 1                                 //> res6: List[Int] = List(2, 3, 4, 5)
	xs drop 10                                //> res7: List[Int] = List()
	
	val ys = List(10,9,8,7,6)                 //> ys  : List[Int] = List(10, 9, 8, 7, 6)
	xs ++ ys                                  //> res8: List[Int] = List(1, 2, 3, 4, 5, 10, 9, 8, 7, 6)
	xs ::: ys                                 //> res9: List[Int] = List(1, 2, 3, 4, 5, 10, 9, 8, 7, 6)
	
	xs.reverse                                //> res10: List[Int] = List(5, 4, 3, 2, 1)
	xs updated (3, 100)                       //> res11: List[Int] = List(1, 2, 3, 100, 5)
	xs indexOf 5                              //> res12: Int = 4
	
	val fruit = List("apples", "oranges", "pears")
                                                  //> fruit  : List[String] = List(apples, oranges, pears)


}