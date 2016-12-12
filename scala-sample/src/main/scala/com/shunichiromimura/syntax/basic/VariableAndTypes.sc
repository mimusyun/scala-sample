package Basics

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
	
	// experiment
	val a = 6 * 7                             //> a  : Int = 42
	val b: BigInt = 6 * 7                     //> b  : BigInt = 42
	b.pow(1000)                               //> res6: scala.math.BigInt = 17753762175756824895023459927060785266025241338933
                                                  //| 3830121866433218470832421443603270369699806687474089104928787716429205646797
                                                  //| 9682934737077049464296605508272514364193647791450330862622357351968709701692
                                                  //| 6893626339793976210524817665943409765000450688475580477423465801765534575905
                                                  //| 4920491964687859092794286951888196893257753512961312303142500199076828672388
                                                  //| 4039475329857509148162013746924850245250142292273919281341483030761218960837
                                                  //| 8514445805866392453838204891621655580313516255949859448656514553979179772189
                                                  //| 0644779927878664436883165382211500647791238674232812627101620876741669796650
                                                  //| 3703428016749799091197870288671741073316507101401112929443006664348800957958
                                                  //| 7709799057249526838180285935375753185150620988339294477339072043844392312410
                                                  //| 9419130052412940418052056836950663290529588691785317277527334817376409223416
                                                  //| 5375653338110417193480917514902717112293281089023929392425543606079300055100
                                                  //| 344172202132003242925720
                                                  //| Output exceeds cutoff limit.
	
	
	
	
}