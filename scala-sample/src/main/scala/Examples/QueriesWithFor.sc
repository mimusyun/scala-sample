package Examples

object QueriesWithFor {

	case class Book(title: String, authors: List[String])
	
	// Data source
	val books: List[Book] = List(
		Book(title  = "Structure and Interpretation of Computer Programs",
				authors = List("Alvelson, Harald", "Sussman, Gerald J.")),
		Book(title  = "Introduction to Functional Programming",
				authors = List("Bird, Richard", "Wadler, Phil")),
		Book(title  = "Effective Java",
				authors = List("Block, Joshua")),
		Book(title  = "Java Puzzlers",
				authors = List("Bloch, Joshua", "Fagter, Neal")),
		Book(title  = "Programming in Scala",
				authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill"))
	)                                         //> books  : List[Examples.QueriesWithFor.Book] = List(Book(Structure and Interp
                                                  //| retation of Computer Programs,List(Alvelson, Harald, Sussman, Gerald J.)), B
                                                  //| ook(Introduction to Functional Programming,List(Bird, Richard, Wadler, Phil)
                                                  //| ), Book(Effective Java,List(Block, Joshua)), Book(Java Puzzlers,List(Bloch, 
                                                  //| Joshua, Fagter, Neal)), Book(Programming in Scala,List(Odersky, Martin, Spoo
                                                  //| n, Lex, Venners, Bill)))
  // find the titles of books whose author's name is "Bird
 	for (b <- books; a <- b.authors if a startsWith "Bird,") yield b.title
                                                  //> res0: List[String] = List(Introduction to Functional Programming)
  // find all the books which have the work "Program"
	for (b <- books if b.title.indexOf("Program") >= 0) yield b.title
                                                  //> res1: List[String] = List(Structure and Interpretation of Computer Programs,
                                                  //|  Introduction to Functional Programming, Programming in Scala)
	

}