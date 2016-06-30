package bynull.functional.search

import scala.collection.JavaConversions._

/**
  * Created by bynull on 29.06.16.
  */
object SearchApp extends App {
  val ivan = Man("Ivan")
  val andrey = Man("Andrey")
  val bill = Man("Bill")

  val firstGroup = Seq(ivan, andrey)
  val secondGroup = Seq(bill, andrey)

  println("Functional search!")
  println("Result: " + ScalaFunctionalSearch.search(firstGroup, secondGroup).get)

  println

  println("Java procedural search")
  println("Result: " + JavaSearch.search(firstGroup, secondGroup).get)

  println

  println("Scala procedural search!")
  println("Result: " + ScalaProceduralSearch.search(firstGroup, secondGroup).get)
}




