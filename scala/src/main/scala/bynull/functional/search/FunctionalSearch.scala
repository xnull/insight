package bynull.functional.search

import scala.annotation.tailrec

/**
  * Created by bynull on 30.06.16.
  */
object FunctionalSearch {

  /**
    * Functional search in scala
    */
  @tailrec
  def search(firstGroup: Seq[Man], secondGroup: Seq[Man]): Option[Man] = {
    println("Get and handle current user from the first group: " + firstGroup.head.name)

    firstGroup match {
      case manFromFirstGroup :: rest =>
        println(s" - Looking for the man: '${manFromFirstGroup.name}' in the second group")

        secondGroup.find(manFromSecondGroup => manFromFirstGroup == manFromSecondGroup) match {
          case foundPerson@Some(man) =>
            println(s" - A match was found: '${manFromFirstGroup.name}'")
            foundPerson
          case None =>
            println(s" - '${manFromFirstGroup.name}' not found in the second group")
            search(rest, secondGroup)
        }
      case Nil =>
        println("There is no a man who stay in both groups")
        None
    }
  }
}
