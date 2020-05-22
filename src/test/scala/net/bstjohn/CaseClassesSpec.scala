package net.bstjohn

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

case class BadRecord(
  `CMMC Capability Number`: String,
  `CMMC Capability`: String
)

case class GoodRecord1(
  `CMMC Capability Number`: String,
  CMMC_Capability: String
)

case class GoodRecord2(
  `CMMC Capability Number`: String,
  `CMMC xCapability`: String
)

class CaseClassesSpec extends AnyFunSpec with Matchers {
  describe("case classes") {
    it("should preserve the data inserted in the BadRecord case class") {
      val record = BadRecord(
        "test-capability-number",
        "test-capability"
      )

      record.`CMMC Capability Number` shouldEqual "test-capability-number"

      // This assertion will fail.
      // The field contains the string from `CMMC Capability Number` instead
      record.`CMMC Capability` shouldEqual "test-capability"
    }

    it("should preserve the data inserted in the GoodRecord1 case class") {
      val record = GoodRecord1(
        "test-capability-number",
        "test-capability"
      )

      record.`CMMC Capability Number` shouldEqual "test-capability-number"

      // This passes
      record.CMMC_Capability shouldEqual "test-capability"
    }

    it("should preserve the data inserted in the GoodRecord2 case class") {
      val record = GoodRecord2(
        "test-capability-number",
        "test-capability"
      )

      record.`CMMC Capability Number` shouldEqual "test-capability-number"

      // This passes
      record.`CMMC xCapability` shouldEqual "test-capability"
    }
  }
}
