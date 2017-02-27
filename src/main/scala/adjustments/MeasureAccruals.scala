package adjustments

import adjustments.BalanceSheets.BalanceSheets

/**
  * Created by salim on 2/25/2017.
  */
object MeasureAccruals {

  def calculateAccruals(measure: String, balanceSheet: Option[BalanceSheets]): List[String] = {

    List("TotalPnL") ++ {
      balanceSheet match {
        case Some(x) if List(BalanceSheets.PV, BalanceSheets.Reserves).contains(x) => List("FinancePnL")
        case _ => Nil
        //        } ++ measure.match {
        //        case "Brokerage" => Nil
        //        case _ => List("TotalPnLExcludingBrokerage")
        //      }
      }
    } ++ measure.match {


    }
  }

}
