package plex
import adjustments.BalanceSheets
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 2/25/2017.
  */
class MeasureAccrualsSpec extends FlatSpec with Matchers {


  "MeasureAccruals" should "know that all plex measures accrue to totalPnl" in {
    val accruals = MeasureAccruals.calculateAccruals("xxx", MeasureType.PlexMeasure, Some(BalanceSheets.PV))
    accruals should contain("TotalPnL")
    accruals should contain("TotalPnLExcludingBrokerage")
    accruals should contain("FinancePnL")
  }

  it should "know that calculated measures do not generate additional totals" in {
    val accruals = MeasureAccruals.calculateAccruals("Brokerage", MeasureType.PlexMeasure, Some(BalanceSheets.PV))
    accruals should contain("TotalPnL")
    accruals should not contain("TotalPnLExcludingBrokerage")
    accruals should contain("FinancePnL")
  }

  it should "know Calculated measures do not generate additional totals" in {
    val accruals = MeasureAccruals.calculateAccruals("xxx", MeasureType.Calculated, None)
    assert(accruals == Nil)
  }

  it should "know Balance Sheet measures do not generate additional totals" in {
    val accruals = MeasureAccruals.calculateAccruals("xxx", MeasureType.BalanceSheet, None)
    assert(accruals == Nil)
  }


}
