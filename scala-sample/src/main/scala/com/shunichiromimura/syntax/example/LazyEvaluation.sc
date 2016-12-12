package Examples

object LazyEvaluation {

	def expr = {
		val x = { print("[val:x]"); 1 }
		lazy val y = { print("[lazy val:y]"); 2 }
		def z = { print("[def:z]"); 3 }
		z + y + x + z + y + x
	}                                         //> expr: => Int
	
	expr                                      //> [val:x][def:z][lazy val:y][def:z]res0: Int = 12
	
	
	
}