package RCA
import chisel3._
import chisel3.iotesters.PeekPokeTester
class FA_PP (dut: FA) extends PeekPokeTester(dut) {
  poke(dut.io.in_C, 0.U)
  poke(dut.io.in_A, 0.U)
  poke(dut.io.in_B, 0.U)
  step(1)
  println("sum is: "+peek(dut.io.sum).toString)
  println("c_out is: "+peek(dut.io.c_out).toString)
  poke(dut.io.in_A, 0.U)
  poke(dut.io.in_B, 1.U)
  step(1)
  println("sum is: "+peek(dut.io.sum).toString)
  println("c_out is: "+peek(dut.io.c_out).toString)
  poke(dut.io.in_A, 1.U)
  poke(dut.io.in_B, 0.U)
  step(1)
  println("sum is: "+peek(dut.io.sum).toString)
  println("c_out is: "+peek(dut.io.c_out).toString)
  poke(dut.io.in_A, 1.U)
  poke(dut.io.in_B, 1.U)
  step(1)
  println("sum is: "+peek(dut.io.sum).toString)
  println("c_out is: "+peek(dut.io.c_out).toString)
}
object FA_PP extends App {
  println("Testing the FullAdder")
  chisel3.iotesters.Driver(() => new FA()) { c => new FA_PP(c)
  }
}
