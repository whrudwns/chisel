package RCA

import chisel3._
import chisel3.iotesters.PeekPokeTester

class FA_4_Test(dut: FA_4) extends PeekPokeTester(dut) {
  poke(dut.io.in_A, 0.U)
  poke(dut.io.in_B, 0.U)
  poke(dut.io.in_C, 0.U)
  step(2)
  println("in_A is: "+peek(dut.io.in_A).toString)
  println("in_B is: "+peek(dut.io.in_B).toString)
  println("in_C is: "+peek(dut.io.in_C).toString)
  println("sum is: "+peek(dut.io.sum).toString)
  println("c_out is: "+peek(dut.io.c_out).toString)

  poke(dut.io.in_A, 0.U)
  poke(dut.io.in_B, 1.U)
  step(2)
  println("\n")
  println("in_A is: "+peek(dut.io.in_A).toString)
  println("in_B is: "+peek(dut.io.in_B).toString)
  println("in_C is: "+peek(dut.io.in_C).toString)
  println("sum is: "+peek(dut.io.sum).toString)
  println("c_out is: "+peek(dut.io.c_out).toString)

  poke(dut.io.in_A, 1.U)
  poke(dut.io.in_B, 0.U)
  step(2)
  println("\n")
  println("in_A is: "+peek(dut.io.in_A).toString)
  println("in_B is: "+peek(dut.io.in_B).toString)
  println("in_C is: "+peek(dut.io.in_C).toString)
  println("sum is: "+peek(dut.io.sum).toString)
  println("c_out is: "+peek(dut.io.c_out).toString)

  poke(dut.io.in_A, 1.U)
  poke(dut.io.in_B, 1.U)
  step(2)
  println("\n")
  println("in_A is: "+peek(dut.io.in_A).toString)
  println("in_B is: "+peek(dut.io.in_B).toString)
  println("in_C is: "+peek(dut.io.in_C).toString)
  println("sum is: "+peek(dut.io.sum).toString)
  println("c_out is: "+peek(dut.io.c_out).toString)
}


object FA_4_Test extends App {
  println("Testing the FullAdder")
  chisel3.iotesters.Driver(() => new FA_4()) { c => new FA_4_Test(c)
  }
}
