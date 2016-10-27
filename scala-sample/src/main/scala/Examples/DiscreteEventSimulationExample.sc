package Examples

object DiscreteEventSimulationExample {
	
	// Run simulation
	object sim extends Circuits with Parameters
  import sim._
  
//  val in1, in2, sum, carry = new Wire
//  halfAdder(in1, in2, sum, carry)
  
  // current values
//  probe("sum", sum)
//  probe("carry", carry)
  
//  in1 setSignal true
//  run()
  
//  in2 setSignal true
//  run()
  
//  in1 setSignal false
//  run()
  
}

trait Parameters {
	def InverterDelay = 2
	def AndGateDelay = 3
	def OrGateDelay = 5
}

abstract class Simulation {
  	
	  	type Action = () => Unit
	  	
	  	case class Event(time: Int, action: Action)
	  	
	  	private var curtime: Int = 0
	  	def currentTime: Int = curtime
	  	
	  	private var agenda: List[Event] = List()
	  	
	  	private def insert(ag: List[Event], item: Event): List[Event] = ag match {
	  		case first :: rest if first.time <= item.time => first :: insert(rest, item)
	  		case _ => item:: ag
	  	}
	  	
	  	def afterDelay(delay: Int)(block: => Unit): Unit = {
	  		val item = Event((currentTime) + delay, () => block)
	  		agenda = insert(agenda, item)
	  	}
	  	
	  	def run(): Unit = {
	  		afterDelay(0) {
	  			println("*** siulation started, time = " + currentTime + " ***")
	  		}
	  		loop()
	  	}
	  	
	  	private def loop(): Unit = agenda match {
	  		case first :: rest =>
	  			agenda = rest
	  			curtime = first.time
	  			first.action()
	  			loop()
	  		case Nil =>
	  	}
}
  
  abstract class Gates extends Simulation {
  
  	def InverterDelay: Int
		def AndGateDelay: Int
		def PrGateDelay: Int
  
  	class Wire {
  	
	  	private var sigVal = false
	  	private var actions: List[Action] = List()
	  	
	  	def getSignal: Boolean = sigVal
	  	
	  	def setSignal(s: Boolean): Unit =
	  		if (s != sigVal) {
	  			sigVal = s
	  			actions foreach (_())
	  		}
	  	def addAction(a: Action): Unit = {
	  		actions = a :: actions
	  		a()
	  	}
  	}
  
	  def inverter(input: Wire, output: Wire): Unit = {
	  	def invertAction(): Unit = {
	  		val inputSig = input.getSignal
	  		afterDelay(1) { output setSignal !inputSig }
	  	}
	  	input addAction invertAction
	  }
  
	  def andGate(in1: Wire, in2: Wire, output: Wire) = {
	  	def andAction() = {
	  		val in1Sig = in1.getSignal
	  		val in2Sig = in2.getSignal
	  		afterDelay(1) { output setSignal (in1Sig & in2Sig) }
	  	}
	  	
	  	in1 addAction andAction
	  	in2 addAction andAction
	  
	  }
  
	  def orGate(in1: Wire, in2: Wire, output: Wire): Unit = {
	  	def orAction() = {
	  		val in1Sig = in1.getSignal
	  		val in2Sig = in2.getSignal
	  		afterDelay(1) { output setSignal (in1Sig | in2Sig) }
	  	}
	  	
	  	in1 addAction orAction
	  	in2 addAction orAction
	  
	  }
	  
	  def probe(name: String, wire: Wire): Unit = {
  		def probeAction(): Unit = {
  			println(s"$name $currentTime value = ${wire.getSignal}")
  		}
  		wire addAction probeAction
  	}
  
  }
  
  abstract class Circuits extends Gates {
	
		def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire) {
			val d, e = new Wire
			orGate(a, b, d)
			andGate(a, b, c)
			inverter(c, e)
			andGate(d, e, s)
		}
		
		def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire) {
			val s, c1, c2 = new Wire
			halfAdder(a, cin, s, c1)
			halfAdder(b, s, sum, c2)
			orGate(c1, c2, cout)
		}
	
	}
	