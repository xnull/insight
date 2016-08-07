package bynull.algorithms.sort.bubble

/**
  * Created by null on 8/8/16.
  */
object BubbleSort extends App {

  println(bubble(Seq(7, 6, 5, 4, 3, 2, 1)))

  def bubble(source: Seq[Int]): Seq[Int] = {
    println(s"Sort: $source")

    source match {
      case current :: next :: tail =>
        if (current > next) {
          println(s"Swap: $current, $next")
          bubble(next :: current :: tail)
        } else {
          println(s"Don't swap: $current, $next")
          bubble(next :: tail) match {
            case sortNext if current < sortNext.head =>
              println(s"Compare with next sublist. Current less than subSorted sublist head: $current, $sortNext")
              Seq(current) ++ sortNext
            case sortNext if current > sortNext.head =>
              println(s"Current bigger than next. Combine current with next: $current, $sortNext")
              bubble(sortNext ++ Seq(current))
          }
        }
      case current :: Nil =>
        println("End of current sorting stage")
        source
    }
  }

  def bubbleSimple(source: Seq[Int]): Seq[Int] = {
    println(s"Sort: $source")

    source match {
      //TODO need to fix
      case current :: next :: afterNext :: tail if current < next =>
        Seq(current) ++ bubbleSimpleOnlyMatching(Seq(next, afterNext) ++ tail)
      //TODO need to fix
      case current :: next :: afterNext :: tail if current > next =>
        bubbleSimpleOnlyMatching(tail ++ Seq(next, current, afterNext))

      case current :: next :: tail =>
        if (current > next) {
          println(s"Swap: $current, $next")
          bubbleSimple(next :: current :: tail)
        } else {
          println(s"Don't swap: $current, $next")
          Seq(current) ++ bubbleSimple(next :: tail)
        }
      case current :: next :: Nil =>
        if (current < next) Seq(current, next) else Seq(next, current)
      case current :: Nil =>
        println("End of current sorting stage")
        source
    }
  }

  /**
    * Desn't work. I have to use properly first and second case
    * @param source
    * @return
    */
  def bubbleSimpleOnlyMatching(source: Seq[Int]): Seq[Int] = source match {
    // TODO need to fix case current :: next :: afterNext :: tail if current < next => Seq(current) ++ source
    //TODO need to fix  case current :: next :: afterNext :: tail if current > next => bubbleSimpleOnlyMatching(tail ++ Seq(next, current, afterNext))

    case current :: next :: tail => {
      if (current > next) {
        bubbleSimpleOnlyMatching(next :: current :: tail)
      } else {
        bubbleSimpleOnlyMatching(next :: tail)
      }
    }

    case current :: next :: Nil =>
      if (current < next) Seq(current, next) else Seq(next, current)

    case current :: Nil =>
      source
  }
}
