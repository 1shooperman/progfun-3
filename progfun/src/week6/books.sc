package week6

object books {
  case class Book(title: String, authors: List[String])

  val books: List[Book] = List(
    Book(title = "Structure and Interpretation of computer programs",
      authors = List("Abelson, Harald", "Sussman, Gerald J.")),
	  Book (title = "Introduction to Functional Programming",
	    authors = List("Bird, Richard","Wadler, Phil")),
    Book (title = "Effective Java",
      authors = List("Bloch, Joshua")),
	  Book (title = "Java Puzzlers",
	    authors = List("Bloch, Joshua", "Gafter, Neal")),
    Book (title = "Programmin in Scala",
      authors = List("Odersky, Martin","Spoon, Lex","Venners, Bill")))
                                                  //> books  : List[week6.books.Book] = List(Book(Structure and Interpretation of 
                                                  //| computer programs,List(Abelson, Harald, Sussman, Gerald J.)), Book(Introduct
                                                  //| ion to Functional Programming,List(Bird, Richard, Wadler, Phil)), Book(Effec
                                                  //| tive Java,List(Bloch, Joshua)), Book(Java Puzzlers,List(Bloch, Joshua, Gafte
                                                  //| r, Neal)), Book(Programmin in Scala,List(Odersky, Martin, Spoon, Lex, Venner
                                                  //| s, Bill)))
      
      
   // find the books with author bird
   for (b <- books; a <- b.authors if a startsWith "Bird,") yield b.title
                                                  //> res0: List[String] = List(Introduction to Functional Programming)
   
   // books with word program in title
//   for (b <- books if b.title indexOf "Program" >= 0) yield b.title



// 6.3
//books flatMap ( b =>
//for(a <- b.authors if a startsWith "Bird,") yield b.title
//for(a <- b.authors if
//)



}