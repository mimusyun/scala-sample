package Basics

object MapsAndTuples {
	
	// Map
	// immutable
  var scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
                                                  //> scores  : scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, Bob 
                                                  //| -> 3, Cindy -> 8)
 	// mutable
  val mscores = scala.collection.mutable.Map("Alice" -> 10)
                                                  //> mscores  : scala.collection.mutable.Map[String,Int] = Map(Alice -> 10)
  val bobsScore = scores("Bob")                   //> bobsScore  : Int = 3
  
  // NoSuchElementException
  //scores("Fred")
  
  scores.getOrElse("Fred", 0)                     //> res0: Int = 0
  
  mscores("Bob") = 7
 	mscores                                   //> res1: scala.collection.mutable.Map[String,Int] = Map(Bob -> 7, Alice -> 10)
 	
 	scores + ("Bob" -> 10, "Fred" -> 7)       //> res2: scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, Bob -> 1
                                                  //| 0, Cindy -> 8, Fred -> 7)
 	scores                                    //> res3: scala.collection.immutable.Map[String,Int] = Map(Alice -> 10, Bob -> 3
                                                  //| , Cindy -> 8)
  // Create another immutable map
  // Seems expensive but not so much
  // this is strong in concurrency
  scores = scores + ("Bob" -> 10, "Fred" -> 7)
  scores = scores - "Alice"
  
  scores                                          //> res4: scala.collection.immutable.Map[String,Int] = Map(Bob -> 10, Cindy -> 8
                                                  //| , Fred -> 7)
  
  for((k, v) <- scores) yield(v, k)               //> res5: scala.collection.immutable.Map[Int,String] = Map(10 -> Bob, 8 -> Cindy
                                                  //| , 7 -> Fred)
  for((k, v) <- scores) println(k + " has score " + v)
                                                  //> Bob has score 10
                                                  //| Cindy has score 8
                                                  //| Fred has score 7
 	// Tuples
  val t = (1, 3.14, "Red")                        //> t  : (Int, Double, String) = (1,3.14,Red)
  // position starts from 1
  t._2                                            //> res6: Double = 3.14
  
  val (_, second, third) = t                      //> second  : Double = 3.14
                                                  //| third  : String = Red
  
  // partition
  "New York".partition(_.isUpper)                 //> res7: (String, String) = (NY,ew ork)
  
  import scala.collection.mutable.ArrayBuffer
  
  val buf = ArrayBuffer(1,2,-3,4,-5,6,-7,8)       //> buf  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, -3, 4, 
                                                  //| -5, 6, -7, 8)
  
  buf.partition(_ < 0)                            //> res8: (scala.collection.mutable.ArrayBuffer[Int], scala.collection.mutable.A
                                                  //| rrayBuffer[Int]) = (ArrayBuffer(-3, -5, -7),ArrayBuffer(1, 2, 4, 6, 8))
  val symbols = Array("<", "-", ">")              //> symbols  : Array[String] = Array(<, -, >)
  val counts = Array(2, 10, 2)                    //> counts  : Array[Int] = Array(2, 10, 2)
  val pairs = symbols.zip(counts)                 //> pairs  : Array[(String, Int)] = Array((<,2), (-,10), (>,2))
  for((s, n) <- pairs) println(s * n)             //> <<
                                                  //| ----------
                                                  //| >>

}