package adjustments

import fx.Currency

/**
  * Created by salim on 2/24/2017.
  */
case class PlexAdjustmentComponent(
                                    measureName: String,
                                    adjustmentValue: Double,
                                    balanceSheetImpact: Option[BalanceSheets.BalanceSheets],
                                    ccy: Currency,
                                    comment: Option[String]
                                  ) {
  // Represents the actual measure and quantity being adjusted.

}
