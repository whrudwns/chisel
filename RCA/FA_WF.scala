package RCA
import chisel3._
import chisel3.iotesters.PeekPokeTester
import org.scalatest._

class FA_WFT(dut: FA) extends PeekPokeTester(dut) {
  poke(dut.io.in_A, 0)
  poke(dut.io.in_B, 0)
  poke(dut.io.in_C, 0)
  step(2)

  poke(dut.io.in_A, 0)
  poke(dut.io.in_B, 1)
  step(2)

  poke(dut.io.in_A, 1)
  poke(dut.io.in_B, 0)
  step(2)

  poke(dut.io.in_A, 1)
  poke(dut.io.in_B, 1)
  step(2)
}

class FA_WF extends FlatSpec with Matchers {
  "Waveform" should "pass" in {
    chisel3.iotesters.Driver.execute(Array("--generate-vcd-output", "on"), () => new FA()) { 
      c => new FA_WFT(c)
    } should be (true)
  }
}
