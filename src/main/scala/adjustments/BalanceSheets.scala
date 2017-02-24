package adjustments

/**
  * Created by salim on 2/24/2017.
  */
object BalanceSheets extends Enumeration {
  // Represents the different types of balance sheets
  // to which an adjustment may accrue.
  type BalanceSheets = Value
  val CashToday, Reserves, PV, Bonds = Value
}
