package Basics

object ClassesAndObjets {
  val p = new Point(3,4)                          //> p  : Basics.Point = (3.0, 4.0)!!
  p.move(10,20)                                   //> res0: Basics.Point = (13.0, 24.0)!!
  p.distanceFromOrigin                            //> res1: Double = 5.0
  p.x                                             //> res2: Double = 3.0
  p.y                                             //> res3: Double = 4.0
  p.toString                                      //> res4: String = (3.0, 4.0)!!
  
  val p2 = new MutablePoint(3,4)                  //> p2  : Basics.MutablePoint = Basics.MutablePoint@6be46e8f
  p2.x = 12
  
  val p3 = new Point3()                           //> Welcome to (0.0, 0.0)
                                                  //| p3  : Basics.Point3 = Basics.Point3@3567135c
  val p4 = new Point3(10, 15)                     //> Welcome to (10.0, 15.0)
                                                  //| p4  : Basics.Point3 = Basics.Point3@327471b5
  1 to 10 map (_ * 3) filter (_ % 5 == 2)         //> res5: scala.collection.immutable.IndexedSeq[Int] = Vector(12, 27)
  1 :: 2 :: 3 :: Nil                              //> res6: List[Int] = List(1, 2, 3)
  
  val morning = new Time(8, 30)                   //> morning  : Basics.Time = 8:30
  val night = new Time(20, 30)                    //> night  : Basics.Time = 20:30
 	morning.before(night)                     //> res7: Boolean = true
 	morning before night                      //> res8: Boolean = true
 	
 	val noon = new Time(12)                   //> noon  : Basics.Time = 12:00
 	noon.hours                                //> res9: Int = 12
 	
 	val nt = new NewTime(16, 45)              //> nt  : Basics.NewTime = 16:45
 	nt.hours                                  //> res10: Int = 16
 	nt.minutes = 30

 	nt                                        //> res11: Basics.NewTime = 16:30
 	
 	val nt2 = new NewTime(19, 20)             //> nt2  : Basics.NewTime = 19:20
 	nt2.-(nt)                                 //> res12: Int = 170
 	
 	NewTime(12, 30)                           //> res13: Basics.NewTime = 12:30
 	// new NewTime(14:30)
 	
}

// immutable class - cannot change the val fields
class Point(val x:Double, val y: Double) {
	
	// constructor
	def this() { this(0, 0) }

	def move(dx: Double, dy: Double) = new Point(x + dx, y + dy)
	def distanceFromOrigin = math.sqrt(x*x + y*y)
	override def toString = f"(${x}, ${y})!!"
}

// define class with default args
class Point2(val x:Double = 0, val y: Double = 0) {}

class Point3(val x:Double = 0, val y: Double = 0) {
	println(f"Welcome to (${x}, ${y})")
}

class MutablePoint(var x: Double, var y: Double) {}

object Accounts {
	private var lastNumber = 0
	def newUniqueNumber () = {
		lastNumber += 1
		lastNumber
	}
}

class Time(val hours: Int, val minutes: Int) {

	def this(h: Int) { this(h, 0) }

	if(hours <= 0 || hours >= 24 || minutes < 0 || minutes >= 60)
		throw new IllegalArgumentException
	
	def before(other: Time) =
		hours < other.hours || hours == other.hours && minutes < other. minutes
	
	def < (other: Time) =
		hours < other.hours || hours == other.hours && minutes < other. minutes
	
	def -(other: Time) = (hours * 60 + minutes) - (other.hours * 60 + other.minutes)
	
	override def toString = f"${hours}:${minutes}%02d"
	
}

class NewTime(h: Int, m: Int) {
	private var minutesSinceMidnight = h * 60 + m
	def hours = minutesSinceMidnight / 60
	def minutes = minutesSinceMidnight % 60
	def minutes_= (newVal: Int) {
		if (m < 0 || m >= 60) throw new IllegalArgumentException
		minutesSinceMidnight = h * 60 + newVal
	}

	if(h <= 0 || h >= 24 || m < 0 || m >= 60)
		throw new IllegalArgumentException
	
	def before(other: NewTime) = minutesSinceMidnight < other.minutesSinceMidnight
	def -(other: NewTime) = (hours * 60 + minutes) - (other.hours * 60 + other.minutes)
	override def toString = f"${hours}:${minutes}%02d"
	
}

object NewTime {
	def apply(h: Int, m: Int) = new NewTime(h, m)
}