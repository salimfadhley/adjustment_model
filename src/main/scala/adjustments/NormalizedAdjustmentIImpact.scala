package adjustments

import adjustments.MeasureType.MeasureType
import fx.{Currency, FXRateProvider}

/**
  * Created by salim on 2/24/2017.
  */
case class NormalizedAdjustmentImpact(
                             id: Long,
                             tradeId: Option[String],
                             bookId: Option[String],
                             groupId: Option[String],
                             instrumentId: Option[String],
                             adminId: Option[String],
                             instrumentType: Option[String],
                             measure: String,
                             measureType: MeasureType,
                             measureValue: Double,
                             ccy: Currency,
                             qualifier: Currency,
                             comment: Option[String],
                             data_source: PlexDataSource.Value
                           ) {

  def convertCCY(c: Currency, fxp:FXRateProvider):NormalizedAdjustmentImpact = {
    this
  }


}