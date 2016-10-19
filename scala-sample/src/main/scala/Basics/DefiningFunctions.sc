package Basics

object DefiningFunctions {
  def abs(x: Double) = if (x >= 0) x else -x      //> abs: (x: Double)Double
  
  
  def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)
                                                  //> fac: (n: Int)Int
  
  // omitted the = symbol - not returning value
  def box(s : String) {
  	val border = "-" * (s.length+2) + "--\n"
  	println(border + "| " + s + " |\n" + border)
  }                                               //> box: (s: String)Unit
  
  box("Hello World!!!")                           //> ------------------
                                                  //| | Hello World!!! |
                                                  //| ------------------
                                                  //| 
  // dont forget = if you want to return value
  def _fac(n: Int) {
  	var r = 1
  	for(i <- 1 to n) r = r * i
  	r
 	}                                         //> _fac: (n: Int)Unit
 	
 	val result = _fac(10)                     //> result  : Unit = ()
 	
 	// Named argument
 	def decorate(str: String, left: String = "[", right: String = "]") =
 		left + str + right                //> decorate: (str: String, left: String, right: String)String
 	
 	decorate("HELLO")                         //> res0: String = [HELLO]
 	decorate("HELLO", "{{", "}}")             //> res1: String = {{HELLO}}
 	decorate("HELLO", right = ">===")         //> res2: String = [HELLO>===
 	
 	
 	// varargs
 	def sum(args: Int*) = {
 		var result = 0
 		for(arg <- args) result += arg
 		result
 	}                                         //> sum: (args: Int*)Int
 	
 	
 	val s = sum(5,6,3,7,9,4,4,57,89)          //> s  : Int = 184
 	sum(1 to 100: _*)                         //> res3: Int = 5050
 	
 	// More arguments
 	def recursiveSum(args: Int*): Int = {
 		if (args.length == 0) 0
 		else args.head + recursiveSum(args.tail : _*)
 	
 	}                                         //> recursiveSum: (args: Int*)Int
 	
 	recursiveSum(5,6,3,7,9,4,4,57,89)         //> res4: Int = 184
 	
 	// experiment
 	def _isVowel(ch: Char) = ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                                                  //> _isVowel: (ch: Char)Boolean
 	def isVowel(ch: Char) = "aeiou".contains(ch)
                                                  //> isVowel: (ch: Char)Boolean
 	def vowels1(s: String) = {
 		var result = ""
 		for (ch <- s) {
 			if (isVowel(ch)) result += ch
 		}
 		result
 	}                                         //> vowels1: (s: String)String
 	
 	vowels1("Nicaragua")                      //> res5: String = iaaua
  
  // This is much better...
  def vowels2(s: String) =
  	for(ch <- s if isVowel(ch)) yield ch      //> vowels2: (s: String)String
                  
  vowels2("Nicaragua")                            //> res6: String = iaaua
  
  def vowels3(s: String): String = {
  	if (s.length == 0) ""
  	else {
  		val ch = s(0)
  		val rest = vowels3(s.substring(1))
  		if (isVowel(ch)) ch + rest else rest
  	}
  }                                               //> vowels3: (s: String)String
  
  vowels3("Nicaragua")                            //> res7: String = iaaua
  
  def vowels4(s: String): String = {
  	var i = 0
  	var result = ""
  	while (i < s.length) {
  		val ch = s(i)
  		if (isVowel(ch)) result += ch
  		i += 1
  	}
  	result
  }                                               //> vowels4: (s: String)String
  
  vowels4("Nicaragua")                            //> res8: String = iaaua
  
  def vowels(s: String, vowelChars: String = "aeiou", ignoreCase: Boolean = true): String =
  	if (ignoreCase) vowels(s.toLowerCase, vowelChars, false)
  	else for (ch <- s if isVowel(ch)) yield ch//> vowels: (s: String, vowelChars: String, ignoreCase: Boolean)String
  	
 	vowels("August")                          //> res9: String = auu
 	vowels("Shunichiro MIMURA")               //> res10: String = uiioiua
  
}