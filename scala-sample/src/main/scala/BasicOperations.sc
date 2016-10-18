object BasicOperations {
	
	// Basic Math
	5 + 82                                    //> res0: Int(87) = 87
	17 * 18                                   //> res1: Int(306) = 306
	3 - 3721                                  //> res2: Int(-3718) = -3718
	7 / 3                                     //> res3: Int(2) = 2
	7 / 3.0                                   //> res4: Double(2.3333333333333335) = 2.3333333333333335
	
	// Boolean logic
	true && true                              //> res5: Boolean(true) = true
	false && true                             //> res6: Boolean(false) = false
	true || false                             //> res7: Boolean(true) = true
	!false                                    //> res8: Boolean = true
	!(true && true || false)                  //> res9: Boolean = false
	
	// Eqiality
	1 == 2                                    //> res10: Boolean(false) = false
	3 == 3                                    //> res11: Boolean(true) = true
	7 != 9                                    //> res12: Boolean(true) = true
	9 != 9                                    //> res13: Boolean(false) = false
	
	"Scala" == "Scala"                        //> res14: Boolean = true
	"Scala" == "Crappy"                       //> res15: Boolean = false
	"Scala" != "Crappy"                       //> res16: Boolean = true
	
	"Scala" ==
	"7" == 7                                  //> res17: Boolean = false
	'7' == 7                                  //> res18: Boolean(false) = false
	"Scala" == 'Scala                         //> res19: Boolean = false
	
	5. == (6)                                 //> res20: Boolean(false) = false
	5 == (6)                                  //> res21: Boolean(false) = false
	5 == 6                                    //> res22: Boolean(false) = false
	
	val a = 5                                 //> a  : Int = 5
	var b = 6                                 //> b  : Int = 6
	def c = 7                                 //> c: => Int
	
	a + b                                     //> res23: Int = 11
	a + c                                     //> res24: Int = 12
	
	def d = a + b                             //> d: => Int
	d                                         //> res25: Int = 11
	
	b = 1278312
	d                                         //> res26: Int = 1278317
	
	// Functions
	def addOne(x: Int): Int = x + 1           //> addOne: (x: Int)Int
	addOne(100)                               //> res27: Int = 101
	
	val addAnotherOne = (x: Int) => x + 1     //> addAnotherOne  : Int => Int = <function1>
	addAnotherOne(4)                          //> res28: Int = 5
	
	def addWeirdOne = (x: Int) => x + 1       //> addWeirdOne: => Int => Int
	addWeirdOne(5)                            //> res29: Int = 6
	
	val addHardToTypeOne:(Int => Int) = x => x + 1
                                                  //> addHardToTypeOne  : Int => Int = <function1>
	def hardToTypeMethod:(Int => Int) = addHardToTypeOne
                                                  //> hardToTypeMethod: => Int => Int
	addHardToTypeOne(6)                       //> res30: Int = 7
	hardToTypeMethod(7)                       //> res31: Int = 8
	
	def twiceTheFun(x: Int):Int = x + x       //> twiceTheFun: (x: Int)Int
	twiceTheFun(8)                            //> res32: Int = 16
	twiceTheFun(11)                           //> res33: Int = 22
	
	def sumOf(x: Int, y: Int): Int = x + y    //> sumOf: (x: Int, y: Int)Int
	def newAddOne(x: Int): Int = sumOf(x, 1)  //> newAddOne: (x: Int)Int
	
	def someDoublyFun(x: Int, y: Int) = sumOf(twiceTheFun(x), twiceTheFun(y))
                                                  //> someDoublyFun: (x: Int, y: Int)Int
  someDoublyFun(5, 8)                             //> res34: Int = 26
  
  // Conditionals
  if (1 > 0) 5                                    //> res35: AnyVal = 5
  if(1 > 0) 5 else 10                             //> res36: Int = 5
  
  def nextCollatz(i: Int) = {
  	if (i % 2 == 0) i /2
  	else 3 * i + 1
  }                                               //> nextCollatz: (i: Int)Int
  nextCollatz(13)                                 //> res37: Int = 40
  nextCollatz(40)                                 //> res38: Int = 20
  nextCollatz(20)                                 //> res39: Int = 10
  nextCollatz(10)                                 //> res40: Int = 5
  nextCollatz(5)                                  //> res41: Int = 16
  nextCollatz(8)                                  //> res42: Int = 4
  nextCollatz(2)                                  //> res43: Int = 1
  
  // List
  List(1,2,3)                                     //> res44: List[Int] = List(1, 2, 3)
	List("Glactus", "Mephisto", "Doom", "The Stranger")
                                                  //> res45: List[String] = List(Glactus, Mephisto, Doom, The Stranger)
  List()                                          //> res46: List[Nothing] = List()
  List(1, "derp")                                 //> res47: List[Any] = List(1, derp)
  
  List(1,2,3) ++ List(4,5)                        //> res48: List[Int] = List(1, 2, 3, 4, 5)
  1 :: List(2)                                    //> res49: List[Int] = List(1, 2)
  
  // Empty List - Nil
  Nil                                             //> res50: scala.collection.immutable.Nil.type = List()
  List()                                          //> res51: List[Nothing] = List()
  
  1 :: 2 :: 3 :: 4 :: Nil                         //> res52: List[Int] = List(1, 2, 3, 4)
  1 :: 2 :: 3 :: List(4)                          //> res53: List[Int] = List(1, 2, 3, 4)
  1 :: 2 :: List(3, 4)                            //> res54: List[Int] = List(1, 2, 3, 4)
  1 :: List(2, 3, 4)                              //> res55: List[Int] = List(1, 2, 3, 4)
  
  val l = List(1,2,3)                             //> l  : List[Int] = List(1, 2, 3)
  l(1)                                            //> res56: Int = 2
  l.apply(1)                                      //> res57: Int = 2

  l.head                                          //> res58: Int = 1
  l.tail                                          //> res59: List[Int] = List(2, 3)
  l.last                                          //> res60: Int = 3
  l.init                                          //> res61: List[Int] = List(1, 2)
  
  if (l.length >= 1) l.head                       //> res62: AnyVal = 1
  if (!l.isEmpty) l.head                          //> res63: AnyVal = 1
  if (l.nonEmpty) l.head                          //> res64: AnyVal = 1
  
  l.take(1)                                       //> res65: List[Int] = List(1)
  l.take(3)                                       //> res66: List[Int] = List(1, 2, 3)
  l.take(2)                                       //> res67: List[Int] = List(1, 2)
  l.take(4)                                       //> res68: List[Int] = List(1, 2, 3)
  List().take(1)                                  //> res69: List[Nothing] = List()
  
  List(1,2,3,4,5,6,7,8,9,10).drop(2)              //> res70: List[Int] = List(3, 4, 5, 6, 7, 8, 9, 10)
	List(1,2,3,4,5,6,7,8,9,10).drop(8)        //> res71: List[Int] = List(9, 10)
	List().drop(9876)                         //> res72: List[Nothing] = List()
	List(1,2,3).reverse                       //> res73: List[Int] = List(3, 2, 1)
  
  List(1,2,3).max                                 //> res74: Int = 3
  List(1,2,3).min                                 //> res75: Int = 1
  
  List("jane", "kid koala", "bob").max            //> res76: String = kid koala
  List("jane", "kid koala", "bob").min            //> res77: String = bob
  List("jane", "kid koala", "bob").sorted         //> res78: List[String] = List(bob, jane, kid koala)
  
  List(1,4,6,2,6, 7.0).sum                        //> res79: Double = 26.0
  List(1,4,6,2,6, 7.0).product                    //> res80: Double = 2016.0
  
  // Ranges
  1 until 10                                      //> res81: scala.collection.immutable.Range = Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
  (1 to 10).max                                   //> res82: Int = 10
  ('a' until 'm').min                             //> res83: Char = a
  (5 to 20 by 5)                                  //> res84: scala.collection.immutable.Range = Range(5, 10, 15, 20)
  
  // Comprehensions
  2 to 10 by 2                                    //> res85: scala.collection.immutable.Range = Range(2, 4, 6, 8, 10)
  (2 to 5000 by 2).take(10)                       //> res86: scala.collection.immutable.Range = Range(2, 4, 6, 8, 10, 12, 14, 16,
                                                  //|  18, 20)
  for(x <- 1 to 5) yield x * 2                    //> res87: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10)
  for(x <- -10 to 10 if (x > 5 || x < -5)) yield x * 2
                                                  //> res88: scala.collection.immutable.IndexedSeq[Int] = Vector(-20, -18, -16, -
                                                  //| 14, -12, 12, 14, 16, 18, 20)
  for(x <- -1 to 3; y <- 5 to 15 by 5) yield x + y//> res89: scala.collection.immutable.IndexedSeq[Int] = Vector(4, 9, 14, 5, 10,
                                                  //|  15, 6, 11, 16, 7, 12, 17, 8, 13, 18)
  for(x <- -1 to 3; y <- 5 to 15 by 5; if ( (x+y) % 2 == 0 )) yield x + y
                                                  //> res90: scala.collection.immutable.IndexedSeq[Int] = Vector(4, 14, 10, 6, 16
                                                  //| , 12, 8, 18)
  // Tuples
  (1, "Two")                                      //> res91: (Int, String) = (1,Two)
  List(1, "two")                                  //> res92: List[Any] = List(1, two)
  ('a, 10, "yeah!", 'b')                          //> res93: (Symbol, Int, String, Char) = ('a,10,yeah!,b)
  (List('a','b','c'), "easy as", List(1,2,3))     //> res94: (List[Char], String, List[Int]) = (List(a, b, c),easy as,List(1, 2, 
                                                  //| 3))
  (1, "Two")._1                                   //> res95: Int = 1
  (1, "Two") ._2                                  //> res96: String = Two
  
  List(1,2,3,4,5,6).zip(List("a","b","c","d","e","f"))
                                                  //> res97: List[(Int, String)] = List((1,a), (2,b), (3,c), (4,d), (5,e), (6,f))
                                                  //| 
  List(1,2,3,4,5,6).zip(List("a","b","c","d"))    //> res98: List[(Int, String)] = List((1,a), (2,b), (3,c), (4,d))
  
  // practical example - get all valid triangles
  def allTriangles(a: Int) =
  	for(z <- 1 to a;
  			y <- 1 to z;
  			x <- 1 to y;
  			if(Math.pow(x,2) + Math.pow(y,2) == Math.pow(z,2))
  			) yield (x, y, z)         //> allTriangles: (a: Int)scala.collection.immutable.IndexedSeq[(Int, Int, Int)
                                                  //| ]

	def rightTriangles(a: Int, b: Int) =
  	for(z <- 1 to a;
  			y <- 1 to z;
  			x <- 1 to y;
  			if(Math.pow(x,2) + Math.pow(y,2) == Math.pow(z,2));
  			if (x + y + z) == b)
  	yield (x, y, z)                           //> rightTriangles: (a: Int, b: Int)scala.collection.immutable.IndexedSeq[(Int,
                                                  //|  Int, Int)]
  
  allTriangles(10)                                //> res99: scala.collection.immutable.IndexedSeq[(Int, Int, Int)] = Vector((3,4
                                                  //| ,5), (6,8,10))
  rightTriangles(5, 12)                           //> res100: scala.collection.immutable.IndexedSeq[(Int, Int, Int)] = Vector((3,
                                                  //| 4,5))
  rightTriangles(5, 10)                           //> res101: scala.collection.immutable.IndexedSeq[(Int, Int, Int)] = Vector()
  rightTriangles(50, 24)                          //> res102: scala.collection.immutable.IndexedSeq[(Int, Int, Int)] = Vector((6,
                                                  //| 8,10))
  
 }