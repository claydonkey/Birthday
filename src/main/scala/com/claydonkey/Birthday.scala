/*
 * The MIT License
 *
 * Copyright 2017 Anthony Campbell.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/**
 * @author Anthony Campbell contact@claydonkey.com
 */

import io.Source._
import scala.collection._
import scala.language.implicitConversions

package com.claydonkey {

  object Birthday extends App {

    val nBD: Double = (364.0 / 365.0)
    def statement(i: Double): String = "There is a " + i * 100 + "% chance there are at least 2 birthdays on the same day"

    implicit def IMPL_String_OptionInt(mstr: String): Option[Int] = {
      if (!(mstr.forall(Character.isDigit _))) System.exit(0)
      try {
        Some(Integer.parseInt(mstr.trim))
      } catch {
        case e: NumberFormatException => None
      }
    }

    implicit def IMPL_String_Int(mstr: String): Int = {
      if (!(mstr.forall(Character.isDigit _))) System.exit(0)
      Integer.parseInt(mstr.trim)
    }

    def cp2(c: Option[Int]): Double = {
      c match {
        case Some(c) =>
          var likelyhood: Double = 1
          0 until c map (likelyhood *= Math.pow(nBD, _))
          1 - likelyhood
        case None => 0.0
      }
    }

    def cp1(c: Option[Int]): Double = {
      c match {
        case Some(c) => 1 - Math.pow(nBD, (0 until c).foldLeft(0)(_ + _))
        case None => 0.0
      }
    }

    /* ((i: Int) => 1 - Math.pow(364.0/365, (0 until i).fold(0)(_ + _)))(10) */
    println("Enter number of people: (Type 'alphanumeric' to exit)")
    stdin.getLines map ((i) => (cp1(i), cp2(i), 1 - Math.pow(nBD, (0 until i).fold(0)(_ + _)))) foreach println _
  }
}