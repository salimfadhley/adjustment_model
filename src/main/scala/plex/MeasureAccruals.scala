package plex

import adjustments.BalanceSheets
import adjustments.BalanceSheets.BalanceSheets

/**
  * Created by salim on 2/25/2017.
  */
object MeasureAccruals {
  val subledger_accrued_balance_sheets = List(BalanceSheets.PV, BalanceSheets.Reserves)

  def calculateAccruals(s: String, measureType:MeasureType.Value, balanceSheet:Option[BalanceSheets]):List[String] = {
    (s, measureType, balanceSheet) match {
      case (m:String, MeasureType.PlexMeasure, b) if subledger_accrued_balance_sheets.contains(b)=>
        List("TotalPnL", "TotalPnLExcludingReserves", "FinancePnL")
      case (m:String, MeasureType.PlexMeasure, b) =>
        List("TotalPnL", "TotalPnLExcludingReserves")
      case _ => Nil
    }
  }

}
