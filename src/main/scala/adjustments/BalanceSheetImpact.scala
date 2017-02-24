package adjustments

/**
  * Created by salim on 2/24/2017.
  */
object BalanceSheetImpact extends Enumeration {
  // Represents the different types of balance sheets
  // to which an adjustment may accrue.
  type BalanceSheetImpact = Value
  val CashToday, Reserves, PV, Bonds = Value
}
