package Examples

object FunctionalRandomGenerators {
  
  trait Generator[+T] {
  	
  	self => //an alias for "this"
  	
  	def generate: T
  	
  	def map[S](f: T => S): Generator[S] = new Generator[S] {
  		def generate = f(self.generate)
  	}
  	
  	def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
  		def generate = f(self.generate).generate
  	}
  }
  
  val integers = new Generator[Int] {
  	val rand = new java.util.Random
  	def generate = rand.nextInt()
  }                                               //> integers  : Examples.FunctionalRandomGenerators.Generator[Int]{val rand: jav
                                                  //| a.util.Random} = Examples.FunctionalRandomGenerators$$anonfun$main$1$$anon$3
                                                  //| @73c6c3b2

  val booleans = integers.map(_ >= 0)             //> booleans  : Examples.FunctionalRandomGenerators.Generator[Boolean] = Example
                                                  //| s.FunctionalRandomGenerators$Generator$$anon$1@7a0ac6e3
}