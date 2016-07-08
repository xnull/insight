package bynull.functional.functional.composition

/**
  * Created by bynull on 08.07.16.
  */
object FunctionalCompositionApp extends App {

  composeAndThen()

  /**
    * Let's consider functional composition.
    */
  def composeAndThen() = {
    val plus = (x: Int) => {
      println(s"Plus operation (x + 1), value: $x, result: ${x + 1}")
      x + 1
    }
    val multiply = (x: Int) => {
      println(s"Multiply operation (x * 2), value: $x, result: ${x * 1}")
      x * 2
    }
    val divide = (x: Int) => {
      println(s"Divide operation (x / 2), value: $x, result: ${x / 2}")
      x / 2
    }

    //Execution starts from the end function
    println("Composition")
    val composition = plus/*5*/ compose plus/*4*/ compose multiply/*3*/ compose divide/*2*/ compose divide /*1*/
    println("Calculate value: " + 24)
    println("Result: " + composition.apply(24))

    println()

    //Execution stats from the beginning function. andThen is vise versa to compose
    println("'And then' composition")
    val andThen = plus/*1*/ andThen plus/*2*/ andThen multiply/*3*/ andThen divide/*4*/ andThen divide /*5*/
    println("Calculate value: " + 24)
    println("Result: " + andThen.apply(24))
  }
}
