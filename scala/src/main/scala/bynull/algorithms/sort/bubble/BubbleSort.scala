package bynull.algorithms.sort.bubble

/**
  * Created by null on 8/8/16.
  */
object BubbleSort extends App {

  println(bubbleSimple(Seq(8, 7, 6, 5, 4, 3, 2, 1)))

  def bubbleSimple(source: Seq[Int]): Seq[Int] = {
    println(s"Bubble sort: $source")

    source match {
      case current :: next :: tail if current < next =>
        current +: bubbleSimple(next :: tail)
      case current :: next :: tail if current > next =>
        bubbleSimple(next +: bubbleSimple(current :: tail))
      case current :: Nil =>
        source
    }
  }

  def bubble(source: Seq[Int]): Seq[Int] = {
    println(s"Sort: $source")

    source match {
      case current :: next :: tail if current > next =>
        println(s"Swap: $current, $next")
        bubble(next :: current :: tail)
      case current :: next :: tail if current < next =>
        println(s"Don't swap: $current, $next")
        bubble(next :: tail) match {
          case subList if current < subList.head =>
            println(s"Compare with next sublist. Current less than subSorted sublist head: $current, $subList")
            Seq(current) ++ subList
          case subList if current > subList.head =>
            println(s"Current bigger than next. Combine current with next: $current, $subList")
            bubble(subList ++ Seq(current))
        }
      case current :: Nil =>
        println("End of current sorting stage")
        source
    }
  }
}
