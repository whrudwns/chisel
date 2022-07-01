package RCA
import chisel3._
import chisel3.iotesters.PeekPokeTester
import org.scalatest._

class PowerManagement_WFT(dut: PowerManagement) extends PeekPokeTester(dut) {

  poke(dut.io.p_flag, 0)
  step(2)

  poke(dut.io.p_flag, 1)
  step(5)

  poke(dut.io.p_flag, 0)
  step(5)
}

class PowerManagement_WF extends FlatSpec with Matchers {
  "Waveform" should "pass" in {
    chisel3.iotesters.Driver.execute(Array("--generate-vcd-output", "on"), () => new PowerManagement()) { 
      c => new PowerManagement_WFT(c)
    } should be (true)
  }
}
