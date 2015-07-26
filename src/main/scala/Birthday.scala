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
    try {
      Some(Integer.parseInt(str.trim))
    } catch {
      case e: NumberFormatException => None
    }

  }

  def calcProb(cntPeople: Option[Int]): Double =
    {
      cntPeople match {
        case Some(cntPeople) =>
          val notBday : Double = 0.9972602739726027
          var likelyhood: Double = 1
          0 to cntPeople map ( likelyhood *= Math.pow(notBday,_))
          1 - likelyhood
        case None => 0.0

      }
    }

  def main(args: Array[String]): Unit = {
    stdin.getLines map (calcProb(_)) foreach println
  }
}
