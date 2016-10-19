object VariableAndTypes {
  // Variables
	
	// - val is immutable!
	// reassignment causes an error!
	val answer = 8 * 5 + 2                    //> answer  : Int = 42
	answer                                    //> res0: Int = 42
	
	// - var is mutable
	// but you cannot change type
	var response = 42                         //> response  : Int = 42
	response = 53
	// response = "hello" causes an error
	
	var greeting: String = null               //> greeting  : String = null
	greeting = "bye bye"
	
	// Types
	// everything is an object
	
	// string methods are augmented
	"Hello".intersect("World")                //> res1: String = lo
	
	// big number is usable
	val x: BigInt = 123456789                 //> x  : BigInt = 123456789
	x * x * x * x                             //> res2: scala.math.BigInt = 232305722798259244150093798251441
	
	// Infix notation / regular method notation
	1 to 10                                   //> res3: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7
                                                  //| , 8, 9, 10)
	1 + 10                                    //> res4: Int(11) = 11
	1.+(10)                                   //> res5: Int(11) = 11
	
	// ++ -- operations do not exist
}