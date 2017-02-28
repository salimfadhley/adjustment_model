package adjustments

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 2/28/2017.
  */
class NormaliedAdjustmentImpact extends FlatSpec with Matchers {

  "NormalizedAdjustmentImact" should "be convertable to other currences" in {

    val original = NormalizedAdjustmentImpact(
      id=0L,
      tradeId = Some("123"),
      bookId = Some("YMaster.ABCD"),
      groupId = Some("group1"),
      instrumentId = Some("Foo123"),
      adminId = Some("1234A"),
      instrumentType = Some("Swap"),
      measure = "PV",
      measureType = MeasureType.BalanceSheet,
      measureValue = 2.3,
      ccy="GBP",
      qualifier="GBP",
      comment=Some("Hello World"),
      data_source = PlexDataSource.PlexAdjustment
    )

    val expected = NormalizedAdjustmentImpact(
      id=0L,
      tradeId = Some("123"),
      bookId = Some("YMaster.ABCD"),
      groupId = Some("group1"),
      instrumentId = Some("Foo123"),
      adminId = Some("1234A"),
      instrumentType = Some("Swap"),
      measure = "PV",
      measureType = MeasureType.BalanceSheet,
      measureValue = 2.3 * 1.5,
      ccy="USD",
      qualifier="GBP",
      comment=Some("Hello World"),
      data_source = PlexDataSource.PlexAdjustment
    )

    val result = original.convertCCY("USD")

    withClue("Currency conversion has failed"){
      assert(result==expected)
    }


  }


}
