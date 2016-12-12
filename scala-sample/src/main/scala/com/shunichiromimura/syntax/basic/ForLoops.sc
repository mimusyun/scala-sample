package Basics

object ForLoops {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  for(i <- 1 to 10) println(i)                    //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
  
  for (c <- "Hello World") println(c)             //> H
                                                  //| e
                                                  //| l
                                                  //| l
                                                  //| o
                                                  //|  
                                                  //| W
                                                  //| o
                                                  //| r
                                                  //| l
                                                  //| d
  
  // Multiple Generators
  for (i <- 1 to 3; j <- 1 to 3) println((10 * i + j))
                                                  //> 11
                                                  //| 12
                                                  //| 13
                                                  //| 21
                                                  //| 22
                                                  //| 23
                                                  //| 31
                                                  //| 32
                                                  //| 33
  
  // with Guards
  for (i <- 1 to 3; j <- 1 to 3 if i != j) println((10 * i + j))
                                                  //> 12
                                                  //| 13
                                                  //| 21
                                                  //| 23
                                                  //| 31
                                                  //| 32
  
  // Collecting results
  for (i <- 1 to 10) yield i % 3                  //> res0: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 0, 1, 2, 0, 
                                                  //| 1, 2, 0, 1)
  
  // Vector is something similar to array list?
  
}