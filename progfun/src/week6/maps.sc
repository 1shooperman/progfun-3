package week6

object maps {

  val romanNumerals = Map('I' -> 1, 'V' -> 5, 'X' -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[Char,Int] = Map(I -> 1, V -> 
                                                  //| 5, X -> 10)

  val capitalOfCountry: Map[String, String] = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : Map[String,String] = Map(US -> Washington, Switzerland -
                                                  //| > Bern)
  // maps are functions
  capitalOfCountry("US")                          //> res0: String = Washington

  //capitalOfCountry("OZ")

  capitalOfCountry get "OZ"                       //> res1: Option[String] = None

  capitalOfCountry get "US"                       //> res2: Option[String] = Some(Washington)

  def showCapital(country: String) = capitalOfCountry.get(country) match {
    case Some(capital) => capital
    case None => "Missing Data"
  }                                               //> showCapital: (country: String)String

  showCapital("OZ")                               //> res3: String = Missing Data

  showCapital("US")                               //> res4: String = Washington

  val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
  fruit.sortWith(_.length < _.length)             //> res5: List[String] = List(pear, apple, orange, pineapple)
  fruit.sorted                                    //> res6: List[String] = List(apple, orange, pear, pineapple)

  fruit groupBy (_.head)                          //> res7: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))

  Map(0 -> 5, 1 -> 2, 3 -> 1)                     //> res8: scala.collection.immutable.Map[Int,Int] = Map(0 -> 5, 1 -> 2, 3 -> 1)


  val cap1 = capitalOfCountry withDefaultValue "<unknown>"
                                                  //> cap1  : scala.collection.immutable.Map[String,String] = Map(US -> Washington
                                                  //| , Switzerland -> Bern)
  cap1("OZ")                                      //> res9: String = <unknown>
}