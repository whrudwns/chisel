package RCA

import org.scalatest._
import chisel3._

/*
class FA_S extends FlatSpec with Matchers {
  "Integers" should "add" in {
    val i = 1
    val j = 0
    i + j should be (1)
  }
}
*/

class FA_ST extends FlatSpec with Matchers {
  "Tester" should "pass" in {
    chisel3.iotesters.Driver(() => new FA()) { c => new FA_PP(c)
    } should be (true)
  }
}
