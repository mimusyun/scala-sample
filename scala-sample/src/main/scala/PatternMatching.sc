object PatternMatching {

  def magicNumber(n: Int) = n match {
  	case 3 => "IT'S THE MAGIC NUMBER!"
  	case _ => "just an ordinary number!"
  }                                               //> magicNumber: (n: Int)String
  
  magicNumber(3)                                  //> res0: String = IT'S THE MAGIC NUMBER!
  magicNumber(4)                                  //> res1: String = just an ordinary number!
  
  // This is bad...do not do this
  def failMatch(a: Any) = a match {
  	case _: Int => "INT!!"
  }                                               //> failMatch: (a: Any)String
  
  failMatch(1)                                    //> res2: String = INT!!
  //failMatch(3.0) - MatchError!!
  
  def newMagicNumber(n: Int) = n match {
  	case 3 => "IT'S THE MAGIC NUMBER!"
  	case x => x + " is just an ordinary number!"
  }                                               //> newMagicNumber: (n: Int)String
  
  newMagicNumber(3)                               //> res3: String = IT'S THE MAGIC NUMBER!
  newMagicNumber(43672)                           //> res4: String = 43672 is just an ordinary number!
  
  def triangular(n: Int): Int = n match {
  	case 1 => 1
  	case x => x + triangular(x - 1)
  }                                               //> triangular: (n: Int)Int
  
  triangular(10)                                  //> res5: Int = 55
  
  // Decomposition
  ("first", "second") match {
  	case (f, s) => f + " is first and next comes " + s
  }                                               //> res6: String = first is first and next comes second
  
  def vectorAdd(first: (Int, Int), second: (Int, Int)) =
  	(first._1 + second._1, first._2 + second._2)
                                                  //> vectorAdd: (first: (Int, Int), second: (Int, Int))(Int, Int)
  	
 	vectorAdd((3, 4), (1, -5))                //> res7: (Int, Int) = (4,-1)
 	
 	def newVectorAdd(first: (Int, Int), second: (Int, Int)) = (first, second) match {
 		case ((x1, y1), (x2, y2)) => (x1+x2, y1+y2)
 	}                                         //> newVectorAdd: (first: (Int, Int), second: (Int, Int))(Int, Int)
 	
 	val tuples = List((1,2),(3,4),(5,6))      //> tuples  : List[(Int, Int)] = List((1,2), (3,4), (5,6))
 	for ((x,y) <- tuples) yield x+y           //> res8: List[Int] = List(3, 7, 11)
  
  // Aliases
  (1, "hurray!") match {
  	case w@(i: Int, s: String) => w + " is made of a" + i + " and a " + s
  }                                               //> res9: String = (1,hurray!) is made of a1 and a hurray!
  
  // Guards
  def mySteps(steps: Int) =
  	if (steps < 2500) "you aren't even trying"
  	else if (steps < 5000) "that is pitifil"
  	else if (steps < 7500) "ok but still walk more"
  	else "hey, you walked. good for you"      //> mySteps: (steps: Int)String
  	
  def newMySteps(steps: Int) = steps match {
  	case s if (s < 2500) => "you aren't even trying"
  	case s if (s < 5500) => "that is pitifil"
  	case s if (s < 7500) => "ok but still walk more"
  	case _ => "hey, you walked. good for you"
  }                                               //> newMySteps: (steps: Int)String
  
  def latestMySteps(t: (String, Int)) = t match {
  	case ("fatbot", s: Int) if (s < 2500) => "you aren't even trying"
  	case ("fatbot", s: Int) if (s < 5000) => "that is pitifil"
  	case ("fatbot", s: Int) if (s < 7500) => "ok but still walk more"
  	case ("fatbot", _) => "hey, you walked. good for you"
  	case (d, _) => "What the heck is an " + d + "?"
  }                                               //> latestMySteps: (t: (String, Int))String

}