package Main

object MapExample {
  val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, X -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
  capitalOfCountry("US")                          //> res0: String = Washington
  //Exception : capitalOfCountry("Japan")
  
  // get returns OPTION(SOME/NONE)
  capitalOfCountry get "Japan"                    //> res1: Option[String] = None
  capitalOfCountry get "US"                       //> res2: Option[String] = Some(Washington)
  
  def showCapital(country: String) = capitalOfCountry.get(country) match {
  	case Some(capital) => capital
  	case None => "Missing data"
  }                                               //> showCapital: (country: String)String
  
  showCapital("Japan")                            //> res3: String = Missing data
  
  // orderBy/groupBy
  val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
  fruit sortWith (_.length < _.length)            //> res4: List[String] = List(pear, apple, orange, pineapple)
  fruit.sorted                                    //> res5: List[String] = List(apple, orange, pear, pineapple)
  
  fruit groupBy (_.head)                          //> res6: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
  // Polynomials
  // x^3 - 2x + 5
  Map(0 -> 5, 1 -> -2, 3 -> 1)                    //> res7: scala.collection.immutable.Map[Int,Int] = Map(0 -> 5, 1 -> -2, 3 -> 1)
                                                  //| 
  
  class Poly(val terms0: Map[Int, Double]) {
  	def this(bindings: (Int, Double)*) = this(bindings.toMap)
  	val terms = terms0 withDefaultValue 0.0
  	def adjust(term: (Int, Double)): (Int, Double) = {
  		val (exp, coeff) = term
  		terms get exp match {
  			case Some(coeff1) => exp -> (coeff1 + coeff)
  			case None => exp -> coeff
  		}
  	}
  	def + (other: Poly) = new Poly(terms ++ (other.terms map adjust))
  	override def toString =
  		(for ((exp, coeff) <- terms.toList.sorted.reverse) yield coeff + "x^" + exp) mkString " + "
  }
  
  val p1 = new Poly(Map(0 -> 5.0, 1 -> -2.0, 3 -> 1.0))
                                                  //> p1  : Main.MapExample.Poly = 1.0x^3 + -2.0x^1 + 5.0x^0
  val p2 = new Poly(Map(0 -> 3.3, 4 -> 2.0))      //> p2  : Main.MapExample.Poly = 2.0x^4 + 3.3x^0
  p1 + p2                                         //> res8: Main.MapExample.Poly = 2.0x^4 + 1.0x^3 + -2.0x^1 + 8.3x^0
  p1.terms(7)                                     //> res9: Double = 0.0
  
  // set default values to map
  val cap = capitalOfCountry withDefaultValue "<unknown>"
                                                  //> cap  : scala.collection.immutable.Map[String,String] = Map(US -> Washington
                                                  //| , Switzerland -> Bern)
  
  
  // example
  val mnem = Map(
  	'2' -> "ABC",
  	'3' -> "DEF",
  	'4' -> "GHI",
  	'5' -> "JKL",
  	'6' -> "MNO",
  	'7' -> "PQRS",
  	'8' -> "TUV",
  	'9' -> "WXYZ"
  )                                               //> mnem  : scala.collection.immutable.Map[Char,String] = Map(8 -> TUV, 4 -> GH
                                                  //| I, 9 -> WXYZ, 5 -> JKL, 6 -> MNO, 2 -> ABC, 7 -> PQRS, 3 -> DEF)
  
  val charCode: Map[Char, Char] =
  	for ( (digit, str) <- mnem; ltr <- str) yield ltr -> digit
                                                  //> charCode  : Map[Char,Char] = Map(E -> 3, X -> 9, N -> 6, T -> 8, Y -> 9, J 
                                                  //| -> 5, U -> 8, F -> 3, A -> 2, M -> 6, I -> 4, G -> 4, V -> 8, Q -> 7, L -> 
                                                  //| 5, B -> 2, P -> 7, C -> 2, H -> 4, W -> 9, K -> 5, R -> 7, O -> 6, D -> 3, 
                                                  //| Z -> 9, S -> 7)
  	
  def wordCode(word: String): String = word.toUpperCase map charCode
                                                  //> wordCode: (word: String)String
  wordCode("Java")                                //> res10: String = 5282
  
  
  
}