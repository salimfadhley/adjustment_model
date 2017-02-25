package plex

import adjustments.BalanceSheets
import adjustments.BalanceSheets.BalanceSheets

/**
  * Created by salim on 2/24/2017.
  */
case class PlexRow(
                    id: Long,
                    tradeId: Option[String],
                    bookId: Option[String],
                    groupId: Option[String],
                    instrumentId: Option[String],
                    adminId: Option[String],
                    instrumentType: Option[String],
                    measure: String,
                    balanceSheetMeasure: Option[BalanceSheets.Value],
                    measureValue: Double,
                    ccy: Currency,
                    qualifier: Currency,
                    comment: Option[String],
                    data_source: PlexDataSource.Value
                  ) {

  import adjustments.BalanceSheets.BalanceSheets

}
