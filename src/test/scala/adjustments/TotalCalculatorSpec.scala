package adjustments

import org.scalatest.{FlatSpec, Matchers}
import plex.PlexDataSource.PlexAdjustment

/**
  * Created by salim on 2/25/2017.
  */
class TotalCalculatorSpec extends FlatSpec with Matchers {

  "TotalCalulator" should "expand balance sheet measures to total sheets" in {

    val pr0 = AdjustmentImpact(
      id=0L,
      tradeId = Some("123"),
      bookId = Some("YMaster.ABCD"),
      groupId = Some("group1"),
      instrumentId = Some("Foo123"),
      adminId = Some("1234A"),
      instrumentType = Some("Swap"),
      measure = "foo",
      balanceSheetMeasure = Some(BalanceSheets.PV),
      measureValue = 2.3,
      ccy="USD",
      qualifier="USD",
      comment=Some("Hello World"),
      data_source = PlexAdjustment
    )

    //    val expended = TotalCalculator.calculateTotals(pr0)



  }

}
