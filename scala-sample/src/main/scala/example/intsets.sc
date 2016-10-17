package example

object intsets {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val t1 = new NonEmpty(5, new Empty, new Empty)  //> t1  : example.NonEmpty = {.5.}
  val t2 = t1 incl 10                             //> t2  : example.IntSet = {.5{.10.}}
  val t3 = t2 incl 1                              //> t3  : example.IntSet = {{.1.}5{.10.}}
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
}

class Empty extends IntSet {
	def contains(x: Int): Boolean = false
	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
	override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	def contains(x: Int): Boolean =
		if (x < elem) left contains x
		else if (x > elem) right contains x
		else true
	def incl(x: Int): IntSet =
		if (x < elem) new NonEmpty(elem, left incl x, right)
		else if (x > elem) new NonEmpty(elem, left, right incl x)
		else this
	override def toString = "{" + left  + elem + right + "}"
}