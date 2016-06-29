package bynull.functional.search

/**
  * Created by bynull on 29.06.16.
  */

object SearchApp extends App {
  val ivan = Man("Ivan")
  val andrey = Man("Andrey")
  val bill = Man("Bill")

  val firstGroup = Seq(ivan, andrey)
  val secondGroup = Seq(bill, andrey)

  println (FunctionalSearch.search(firstGroup, secondGroup))
}

case class Man(name: String)

object ProceduralSearch {

  def search(firstGroup: Seq[Man], secondGroup: Seq[Man]): Option[Man] = {
    var found = false
    var index = 0
    while (!found) {
      val x: Option[Man] = firstGroup.lift(index)
    }
  }
}

object FunctionalSearch {

  def search(firstGroup: Seq[Man], secondGroup: Seq[Man]): Option[Man] = {
    println("Get and handle current user from the first group")

    firstGroup match {
      case manFromFirstGroup :: rest =>
        println(s"Looking for the man: '${manFromFirstGroup.name}' in the second group")
        secondGroup.find(manFromSecondGroup => manFromFirstGroup == manFromSecondGroup) match {
          case foundPerson@Some(man) =>
            println(s"A match was found: '${manFromFirstGroup.name}'")
            foundPerson
          case None =>
            println(s"'${manFromFirstGroup.name}' not found in the second group")
            search(rest, secondGroup)
        }
      case Nil =>
        println("There is no a man who stay in both groups")
        None
    }
  }
}
