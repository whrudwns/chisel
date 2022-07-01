package RCA

import chisel3.util.Cat
import chisel3._
import chisel3.stage.ChiselStage


//4-bit FA
class FA_4 extends Module {
  val io = IO(new Bundle {
    val in_A = Input(UInt(4.W))
    val in_B = Input(UInt(4.W))
    val in_C = Input(UInt(1.W))
    val sum = Output(UInt(4.W))
    val c_out = Output(UInt(1.W))
  })
  
  //Adder for bit 0
  //val Adder0 = Module(new FullAdder())
  val Adder0 = Module(new FA())
  Adder0.io.in_A := io.in_A(0)
  Adder0.io.in_B := io.in_B(0)
  Adder0.io.in_C := io.in_C

  val s0 = Adder0.io.sum


  //Adder for bit 1
  //val Adder1 = Module(new FullAdder())
  val Adder1 = Module(new FA())
  Adder1.io.in_A := io.in_A(1)
  Adder1.io.in_B := io.in_B(1)
  Adder1.io.in_C := Adder0.io.c_out

  val s1 = Cat(Adder1.io.sum, s0)


  //Adder for bit 2
  //val Adder2 = Module(new FullAdder())
  val Adder2 = Module(new FA())
  Adder2.io.in_A := io.in_A(2)
  Adder2.io.in_B := io.in_B(2)
  Adder2.io.in_C := Adder1.io.c_out

  val s2 = Cat(Adder2.io.sum, s1)


  //Adder for bit 3
  //val Adder3 = Module(new FullAdder())
  val Adder3 = Module(new FA())
  Adder3.io.in_A := io.in_A(3)
  Adder3.io.in_B := io.in_B(3)
  Adder3.io.in_C := Adder2.io.c_out

  io.sum := Cat(Adder3.io.sum, s2)
  io.c_out := Adder3.io.c_out

  println("FA_4 is generated")
}

object FA_4 extends App{
  (new ChiselStage).emitVerilog(new FA_4, args)
}

