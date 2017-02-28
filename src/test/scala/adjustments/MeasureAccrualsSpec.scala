package adjustments

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by salim on 2/25/2017.
  */
class MeasureAccrualsSpec extends FlatSpec with Matchers {


  "MeasureAccruals" should "know that all plex measures accrue to totalPnl" in {
    val accruals = MeasureAccruals.calculateAccruals("xxx", Some(BalanceSheets.PV))

    accruals should contain((MeasureType.Calculated, "TotalPnL"))
    accruals should contain((MeasureType.Calculated, "TotalPnLExcludingBrokerage"))
    accruals should contain((MeasureType.Calculated, "FinancePnL"))
    accruals should contain((MeasureType.BalanceSheet, "PV"))
  }

  it should "know that calculated measures do not generate additional totals" in {
      val accruals = MeasureAccruals.calculateAccruals("Brokerage", Some(BalanceSheets.PV))
      accruals should contain((MeasureType.Calculated, "TotalPnL"))
      accruals should not contain((MeasureType.Calculated, "TotalPnLExcludingBrokerage"))
      accruals should contain((MeasureType.Calculated, "FinancePnL"))
      accruals should contain((MeasureType.BalanceSheet, "PV"))
  }

  it should "know that Bonds doest accrue to finance pnl" in {
    val accruals = MeasureAccruals.calculateAccruals("Brokerage", Some(BalanceSheets.Bonds))
    accruals should contain((MeasureType.Calculated, "TotalPnL"))
    accruals should not contain((MeasureType.Calculated, "TotalPnLExcludingBrokerage"))
    accruals should not contain((MeasureType.Calculated, "FinancePnL"))
    accruals should contain((MeasureType.BalanceSheet, "Bonds"))
  }


}