package com.shunichiromimura.syntax.basic

object ObjectAndTypes extends App {
  
  // Classes
  val foo = new Foo
  println(foo.dingus)
  println(foo.exclaimDingus)
  
  val foo2 = new Foo2("WINGLEEE")
  println(foo2.dingus)
  println(foo2.exclaimDingus)
  
  val foo3 = new Foo3("YES scala", "!?!?", 4)
  println(foo3.exclaimDingus)
  
  // Case Classes
  val p1 = new Person("Shunichiro", "Mimura")
  val p2 = new Person("Martin", "Odersky")
  println(p1 == p2) 
  p2 match { case Person("Martin", _) => println("found Martin") }
  
  // Objects
  def plop(s:String) = "*" + s + "*"
  println(this.plop("boop"))
  
  // Companion Objects
  println(Digboogy.moar)
  println(Digboogy.moar)
  println(Digboogy.moar)
  println(Digboogy.moar)
  
  // Traits
  val f = new NewFoo
  println(f.print)
  
}

// Classes
class Foo {
  val dingus = "wingle wingle"
  def exclaimDingus = dingus + "!"
}

class Foo2(val dingus:String) {
  def exclaimDingus = dingus + "!"
}

class Foo3(val dingus:String, val punc: String, val howExcited: Int) {
  def this(dingus:String) = this(dingus, "!", 1)
  def this(dingus:String, punc:String) = this(dingus, punc, 1)
  def exclaimDingus = dingus + punc * howExcited
}

// Case Classes
case class Person(first: String, last: String)

// Companion Objects
class Digboogy(val i:Int, val s: String) {
  override def toString = "Digboody(" + i + "," + s + ")" 
}

object Digboogy {
  private var digboodyCount = 0
  def moar = {
    digboodyCount = digboodyCount + 1
    new Digboogy(digboodyCount, "I number " + digboodyCount)
  }
}

// Traits
trait PrintItself {
  def print = println("print: " + this)
}

class NewFoo extends PrintItself {
  
}

