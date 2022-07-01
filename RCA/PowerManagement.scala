package RCA

import chisel3._
import chisel3.util._




class PowerManagement extends Module {
  val io = IO(new Bundle {
  val p_flag = Input(UInt(1.W))
  val iso_en = Output(UInt(1.W))
  val ret_en = Output(UInt(1.W))
  val pse = Output(UInt(1.W))
  })

    val isoReg = Reg(UInt(1.W))
    val retReg = Reg(UInt(1.W))
    val pReg = Reg(UInt(1.W))

  switch(io.p_flag) {
    is(1.U) { 
      retReg := 0.U 
      isoReg := ~retReg 
      pReg := ~isoReg
    }
    is(0.U) { 
      pReg := 1.U 
      isoReg := ~pReg 
      retReg := ~isoReg
    }
  }

  io.iso_en := isoReg
  io.ret_en := retReg
  io.pse := pReg

  println("FA is generated")
}



object PowerManagement extends App{
  (new chisel3.stage.ChiselStage).emitVerilog(new PowerManagement , args)
}

