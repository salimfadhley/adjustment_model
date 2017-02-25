package plex

import adjustments.BalanceSheets
import MeasureType.MeasureType

/**
  * Created by salim on 2/25/2017.
  */
case class NormalizedPlexRow(

                             id: Long,
                             tradeId: Option[String],
                             bookId: Option[String],
                             groupId: Option[String],
                             instrumentId: Option[String],
                             adminId: Option[String],
                             instrumentType: Option[String],
                             measure: String,
                             measureValue: Double,
                             measureType: MeasureType,
                             ccy: Currency,
                             qualifier: Currency,
                             comment: Option[String],
                             data_source: PlexDataSource.Value

                           ) {

}
