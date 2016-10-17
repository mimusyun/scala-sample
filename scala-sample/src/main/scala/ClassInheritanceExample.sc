package example

object ClassExample {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val t1 = new NonEmpty(10, new Empty, new Empty) //> t1  : example.NonEmpty = {.10.}
  val t2 = t1 incl 15                             //> t2  : example.IntSet = {.10{.15.}}
  val t3 = new NonEmpty(1, new Empty, new Empty)  //> t3  : example.NonEmpty = {.1.}
  val t4 = t3 union t2                            //> t4  : example.IntSet = {{.1.}10{.15.}}
}

abstract class IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
}

class Empty extends IntSet {
	def contains(x: Int): Boolean = false
	def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
	def union(other: IntSet): IntSet = other
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
	def union(other: IntSet): IntSet = ((left union right) union other) incl elem
	override def toString = "{" + left  + elem + right + "}"
}