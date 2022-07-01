package RCA

import chisel3._
//import chisel3.util._
//import chisel3.stage.ChiselStage



//1-bit FA
class FA extends Module {
  val io = IO(new Bundle {
    val in_A = Input(UInt(1.W))
    val in_B = Input(UInt(1.W))
    val in_C = Input(UInt(1.W))
    val sum = Output(UInt(1.W))
    val c_out = Output(UInt(1.W))
  })
  //sum
  val a_xor_b = io.in_A ^ io.in_B
  io.sum := a_xor_b ^ io.in_C

  //c_out
  val c_and_xor = io.in_C & a_xor_b
  val a_and_b = io.in_A & io.in_B
  io.c_out := c_and_xor | a_and_b

  /*
  //more optimization c_out
  val c_nand_xor = ~(io.in_C ^ io.a_xor_b)
  val a_nand_b = (~io.in_A & io.in_B)
  io.c_out := ~(io.c_and_xor ^ io._a_and_b)
  */

  //printf("dut: %d %d %d %d \n", io.in_A, io.in_B, io.sum, io.c_out)

  println("FA is generated")
}

object FA extends App{
  (new chisel3.stage.ChiselStage).emitVerilog(new FA, args)
}
