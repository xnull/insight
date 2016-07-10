package bynull.functional.functional.idiom

import scala.language.higherKinds

/**
  * Created by null on 7/9/16.
  */
object Idioms {

  trait Monoid[T] {
    /**
      * Identity value
      */
    def zero: T

    /**
      * Associative operation
      * @param a parameter
      * @param b parameter
      * @return
      */
    def op(a: T, b: T): T
  }

  trait Monad[M[_]] {
    def apply[T](a: T): M[T]
    def flatMap[T, U](m: M[T])(f: T=>M[U]): M[U]
  }



}
