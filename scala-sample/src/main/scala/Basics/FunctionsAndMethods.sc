package Basics

object FunctionsAndMethods {
  "Hello".length                                  //> res0: Int = 5
  "Hello"(4)                                      //> res1: Char = o
  "Hello".apply(4)                                //> res2: Char = o
  
  // experiment with math library
  import scala.math._
  sqrt(10)                                        //> res3: Double = 3.1622776601683795
  sqrt(10) * sqrt(10)                             //> res4: Double = 10.000000000000002
  1.to(10)                                        //> res5: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7
                                                  //| , 8, 9, 10)
  1.to(10).map(sqrt(_))                           //> res6: scala.collection.immutable.IndexedSeq[Double] = Vector(1.0, 1.41421356
                                                  //| 23730951, 1.7320508075688772, 2.0, 2.23606797749979, 2.449489742783178, 2.64
                                                  //| 57513110645907, 2.8284271247461903, 3.0, 3.1622776601683795)
  1.to(10).map(x => sqrt(x))                      //> res7: scala.collection.immutable.IndexedSeq[Double] = Vector(1.0, 1.41421356
                                                  //| 23730951, 1.7320508075688772, 2.0, 2.23606797749979, 2.449489742783178, 2.64
                                                  //| 57513110645907, 2.8284271247461903, 3.0, 3.1622776601683795)
  
  6.*(7)                                          //> res8: Int(42) = 42
  
  // string
  "Mississippi".distinct                          //> res9: String = Misp
  "Shun".permutations.toArray                     //> res10: Array[String] = Array(Shun, Shnu, Suhn, Sunh, Snhu, Snuh, hSun, hSnu,
                                                  //|  huSn, hunS, hnSu, hnuS, uShn, uSnh, uhSn, uhnS, unSh, unhS, nShu, nSuh, nhS
                                                  //| u, nhuS, nuSh, nuhS)
  
  "ABC".sum                                       //> res11: Char = Æ
  'A' + 'B' + 'C'                                 //> res12: Int = 198
  ('A' + 'B' + 'C').toChar                        //> res13: Char = Æ
  'Æ'.toDouble                                    //> res14: Double = 198.0
  
}