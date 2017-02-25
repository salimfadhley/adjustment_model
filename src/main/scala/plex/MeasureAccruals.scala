package plex

import adjustments.BalanceSheets
import adjustments.BalanceSheets.BalanceSheets

import scala.collection.immutable

/**
  * Created by salim on 2/25/2017.
  */
object MeasureAccruals {

  def calculateAccruals(measure: String, measureType:MeasureType.Value, balanceSheet:Option[BalanceSheets]):List[String] = {

    measureType match {
      case MeasureType.PlexMeasure => List("TotalPnL") ++ {
        balanceSheet match {
          case Some(x) if List(BalanceSheets.PV, BalanceSheets.Reserves).contains(x) => List("FinancePnL")
          case _ => Nil
        }
      } ++ { measure match {
        case "Brokerage" => Nil
        case _ => List("TotalPnLExcludingBrokerage")
      }}
      case _ => Nil
    }


  }

}
