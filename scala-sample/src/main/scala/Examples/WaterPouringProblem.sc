package Examples

object WaterPouringProblem {

  val problem = new Pouring(Vector(4, 9, 19))     //> problem  : Examples#33.Pouring#790923 = Examples.Pouring@34b7bfc0
  problem.moves                                   //> res0: scala#27.collection#2770.immutable#5855.IndexedSeq#8419[Product#936 wi
                                                  //| th Serializable#1854 with Examples#33.WaterPouringProblem#772717.problem#224
                                                  //| 7453.Move#2247461] = Vector(Empty(0), Empty(1), Empty(2), Fill(0), Fill(1), 
                                                  //| Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), Pour(2,1))
  
  problem.pathSets.take(2).toList                 //> res1: List#485472[Set#434887[Examples#33.WaterPouringProblem#772717.problem#
                                                  //| 2247453.Path#2247475]] = List(Set(--> Vector(0, 0, 0)), Set(Fill(0)--> Vecto
                                                  //| r(4, 0, 0), Fill(1)--> Vector(0, 9, 0), Fill(2)--> Vector(0, 0, 19)))
  
  problem.solution(17)                            //> res2: Stream#485486[Examples#33.WaterPouringProblem#772717.problem#2247453.P
                                                  //| ath#2247475] = Stream(Fill(0) Fill(1) Pour(0,2) Pour(1,2) Fill(0) Pour(0,2)-
                                                  //| -> Vector(0, 0, 17), ?)
}

class Pouring(capacity: Vector[Int]) {

	// State
	type State = Vector[Int]
	val initialState = capacity map (x => 0)
	
	// Move
	trait Move {
		def change(state: State): State
	}
	case class Empty(glass: Int) extends Move {
		def change(state: State) = state updated (glass, 0)
	}
	case class Fill(glass: Int) extends Move {
		def change(state: State) = state updated (glass, capacity(glass))
	}
	case class Pour(from: Int, to: Int) extends Move {
		def change(state: State) = {
			val amount = state(from) min (capacity(to) - state(to))
			state updated (from, state(from) - amount) updated (to, state(to) + amount)
		}
	}

	val glasses = 0 until capacity.length
	
	val moves =
		(for (g <- glasses) yield Empty(g)) ++
		(for (g <- glasses) yield Fill(g)) ++
		(for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))
		
	// Paths
	class Path(history: List[Move], val endState: State) {
		//def endState: State = (history foldRight initialState) (_ change _)
		def extend(move: Move) = new Path(move :: history, (move change endState))
		override def toString = (history.reverse mkString " ") + "--> " + endState
	}
	
	val initialPath = new Path(Nil, initialState)
	
	def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] =
		if (paths.isEmpty) Stream.empty
		else {
			val more = for{
				path <- paths
				next <- moves map path.extend
				if !(explored contains next.endState)
			} yield next
			paths #:: from(more, explored ++ (more map (_.endState)))
		}
	
	val pathSets = from(Set(initialPath), Set(initialState))
	
	def solution(target: Int): Stream[Path] = {
		for {
			pathSet <- pathSets
			path <- pathSet
			if path.endState contains target
		} yield path
	}
}