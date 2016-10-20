package Basics

object ArrayAndArrayBuffer {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val a = new Array[Int](10)                      //> a  : Array[Int] = Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  
  for (i <- 0 until a.length) a(i) = i * i
  a                                               //> res0: Array[Int] = Array(0, 1, 4, 9, 16, 25, 36, 49, 64, 81)
  
  for (elem <- a) println(elem)                   //> 0
                                                  //| 1
                                                  //| 4
                                                  //| 9
                                                  //| 16
                                                  //| 25
                                                  //| 36
                                                  //| 49
                                                  //| 64
                                                  //| 81
  
  import scala.collection.mutable.ArrayBuffer
  val b = ArrayBuffer("Mary","had","a","little","lamb")
                                                  //> b  : scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Mary, had, a
                                                  //| , little, lamb)
  
  b += "its"                                      //> res1: Basics.ArrayAndArrayBuffer.b.type = ArrayBuffer(Mary, had, a, little, 
                                                  //| lamb, its)
  b += ("fleece", "was", "white")                 //> res2: Basics.ArrayAndArrayBuffer.b.type = ArrayBuffer(Mary, had, a, little, 
                                                  //| lamb, its, fleece, was, white)
  b ++ Array("as", "snow")                        //> res3: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Mary, had, 
                                                  //| a, little, lamb, its, fleece, was, white, as, snow)
  
  b.remove(3)                                     //> res4: String = little
  b                                               //> res5: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Mary, had, 
                                                  //| a, lamb, its, fleece, was, white)
  
  b.insert(3, "medius-sized")
  b                                               //> res6: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Mary, had, 
                                                  //| a, medius-sized, lamb, its, fleece, was, white)
  
  b.trimEnd(5)
  b                                               //> res7: scala.collection.mutable.ArrayBuffer[String] = ArrayBuffer(Mary, had, 
                                                  //| a, medius-sized)
  // transformation
  val c = Array(2,3,5,7,11)                       //> c  : Array[Int] = Array(2, 3, 5, 7, 11)
  val result = for(elem <- c) yield 2 * elem      //> result  : Array[Int] = Array(4, 6, 10, 14, 22)
  val result2 = for(elem <- c if elem%2 != 0) yield 2 * elem
                                                  //> result2  : Array[Int] = Array(6, 10, 14, 22)
	// common algorithms
	val d = ArrayBuffer(1,7,2,9)              //> d  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 7, 2, 9)
	d.sorted                                  //> res8: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 7, 9)
	d                                         //> res9: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 7, 2, 9)
	val sortedD = d.sorted                    //> sortedD  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 7, 
                                                  //| 9)
  d.reverse                                       //> res10: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(9, 2, 7, 1)
  
  Array(1,2,3).toString                           //> res11: String = [I@6ea12c19
  Array(1,2,3).mkString("|")                      //> res12: String = 1|2|3
  Array(1,2,3).mkString("[[", "," ,"]]")          //> res13: String = [[1,2,3]]
	
	// experiment
	
	val buf = ArrayBuffer(1,2,-3,4,-5,6,-7,8) //> buf  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, -3, 4, 
                                                  //| -5, 6, -7, 8)
	
	def removeAllButFirstNegative(b: ArrayBuffer[Int]) {
		var first = true
		var i = 0
		while (i < b.length) {
			if (b(i) < 0) {
				if (first) {
					first = false
					i += 1
				}
				else b.remove(i)
			}
			else i += 1
		}
		}                                 //> removeAllButFirstNegative: (b: scala.collection.mutable.ArrayBuffer[Int])Un
                                                  //| it
	
	
	def removeAllButFirstNegative2(buf: ArrayBuffer[Int]) = {
 		val indexesToRemove = (for(i <- 0 until buf.length if buf(i) < 0) yield i).drop(1)
		for (i <- indexesToRemove.reverse) buf.remove(i)
	}                                         //> removeAllButFirstNegative2: (buf: scala.collection.mutable.ArrayBuffer[Int]
                                                  //| )Unit
	buf                                       //> res14: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, -3, 4,
                                                  //|  -5, 6, -7, 8)
	removeAllButFirstNegative2(buf)
	buf                                       //> res15: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, -3, 4,
                                                  //|  6, 8)
	
	def removeAllButFirstNegative3(buf: ArrayBuffer[Int]) = {
		val indexesToRemove = (for (i <- 0 until buf.length if buf(i) < 0) yield i).drop(1)
    for(i <- 0 until buf.length if !indexesToRemove.contains(i)) yield buf(i)
	}                                         //> removeAllButFirstNegative3: (buf: scala.collection.mutable.ArrayBuffer[Int]
                                                  //| )scala.collection.immutable.IndexedSeq[Int]
	
	// group by
	val words = "Mary had a little lamb its fleece was white as snow and everywhere that Mary whent the lamb was sure to go".split(' ')
                                                  //> words  : Array[String] = Array(Mary, had, a, little, lamb, its, fleece, was
                                                  //| , white, as, snow, and, everywhere, that, Mary, whent, the, lamb, was, sure
                                                  //| , to, go)
	
	val groupedWords = words.groupBy(_.substring(0, 1))
                                                  //> groupedWords  : scala.collection.immutable.Map[String,Array[String]] = Map(
                                                  //| e -> Array(everywhere), s -> Array(snow, sure), t -> Array(that, the, to), 
                                                  //| f -> Array(fleece), a -> Array(a, as, and), M -> Array(Mary, Mary), i -> Ar
                                                  //| ray(its), g -> Array(go), l -> Array(little, lamb, lamb), h -> Array(had), 
                                                  //| w -> Array(was, white, whent, was))
	
	for ((k, v) <- groupedWords) println(k + ":" + v.mkString(","))
                                                  //> e:everywhere
                                                  //| s:snow,sure
                                                  //| t:that,the,to
                                                  //| f:fleece
                                                  //| a:a,as,and
                                                  //| M:Mary,Mary
                                                  //| i:its
                                                  //| g:go
                                                  //| l:little,lamb,lamb
                                                  //| h:had
                                                  //| w:was,white,whent,was
	

}