/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import io.Source._

object Birthday {

  /**
   * @param args the command line arguments
   */

  implicit def toInt(str: String): Option[Int] = {
    if (str.trim == "x")
      System.exit(0)
    try {
      Some(Integer.parseInt(str.trim))
    } catch {
      case e: NumberFormatException => None
    }

  }

  def calcProb(cntPeople: Option[Int]): Double = {
       cntPeople match {
       case Some(cntPeople) =>  1 - (0.0 until cntPeople by 1.0).foldLeft(1.0) ((i,j) => (365 - j) * i ) /math.pow(365.0 ,10.0)
         case None => 0.0
      }
    }

  def main(args: Array[String]): Unit = {

    println("Enter number of persons: (Type 'x' to exit)")
    stdin.getLines drop (0) map (calcProb(_)) foreach (r => println("There is a " + r * 100 + "% chance there are at least 2 birthdays on the same day"))
  }
}
