import io.Source._
import scala.collection._

package com.claydonkey {
  object Birthday extends App {

    val nBD: Double = (364.0 / 365.0)
    def statement(i: Double): String = "There is a " + i * 100 + "% chance there are at least 2 birthdays on the same day"

    implicit def String_OptionInt(str: String): Option[Int] = {
      if (str.trim == "x")
        System.exit(0)
      try {
        Some(Integer.parseInt(str.trim))
      } catch {
        case e: NumberFormatException => None
      }
    }

    implicit def String_Int_(str: String): Int = {
      if (str.trim == "x")
        System.exit(0)
      Integer.parseInt(str.trim)
    }

    def cp2(c: Option[Int]): Double = {
      c match {
        case Some(c) =>
          var likelyhood: Double = 1
          0 to (c - 1) map (likelyhood *= Math.pow(nBD, _))
          1 - likelyhood
      }
    }

    def cp1(c: Option[Int]): Double = {
      c match {
        case Some(c) => 1 - Math.pow(nBD, (0 until c).foldLeft(0)(_ + _))
        case None => 0.0
      }
    }

    /* ((i: Int) => 1 - Math.pow(364.0/365, (0 until i).fold(0)(_ + _)))(10) */
    println("Enter number of people: (Type 'x' to exit)")
    stdin.getLines map ((i) => (cp1(i), cp2(i), 1 - Math.pow(nBD, (0 until i).fold(0)(_ + _)))) foreach println _

  }
}