package adjustments

import adjustments.BalanceSheets.BalanceSheets
import adjustments.MeasureType.MeasureType

/**
  * Created by salim on 2/25/2017.
  */
object MeasureAccruals {
  type MeasureAccrual = (MeasureType.MeasureType, String)

  val subledger_accrued_balance_sheets = List(BalanceSheets.PV, BalanceSheets.CashToday)

  def getBalanceSheetAccruals(balanceSheet: Option[BalanceSheets.BalanceSheets]):List[MeasureAccrual] = {
    balanceSheet match {
      case Some(bs) if subledger_accrued_balance_sheets.contains(bs) => List((MeasureType.BalanceSheet, bs.toString), (MeasureType.Calculated, "FinancePnL"))
      case Some(bs) => List((MeasureType.BalanceSheet, bs.toString))
      case None => Nil
    }
  }

  def getTotalPnLExcludingBrokerage(measureName: String): List[MeasureAccrual] = {
    measureName match {
      case "Brokerage" => Nil
      case _ => (MeasureType.Calculated, "TotalPnLExcludingBrokerage") :: Nil
    }
  }

  def calculateAccruals(measureName: String, balanceSheet: Option[BalanceSheets.BalanceSheets]): List[MeasureAccrual] = {
    (MeasureType.PlexMeasure, measureName) :: (MeasureType.Calculated, "TotalPnL") :: Nil ++ getTotalPnLExcludingBrokerage(measureName) ++ getBalanceSheetAccruals(balanceSheet)
  }
}
