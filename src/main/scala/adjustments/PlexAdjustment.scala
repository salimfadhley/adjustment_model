package adjustments

import adjustments.MeasureType.MeasureType

/**
  * Created by salim on 2/23/2017.
  */

class PlexAdjustment(adjustment: AdjustmentContent) extends Adjustment {

  override def getNormalizedAdjustmentImpacts: List[NormalizedAdjustmentImpact] = {
    adjustment.components.flatMap {
      case c => MeasureAccruals.calculateAccruals(c.measureName, c.balanceSheetImpact).map(
        (a: (MeasureType, String)) => {
          pa(c, a._1, a._2)
        })
    }
  }

  def pa(c:PlexAdjustmentComponent, measureType: MeasureType, measureName:String): NormalizedAdjustmentImpact = {
    NormalizedAdjustmentImpact(
      id = adjustment.id,
      tradeId = adjustment.tradeId,
      bookId = adjustment.bookId,
      groupId = adjustment.groupId,
      instrumentId = adjustment.instrumentId,
      adminId = adjustment.adminId,
      instrumentType = adjustment.instrumentType,
      measure = measureName,
      measureType = measureType,
      ccy = c.ccy,
      measureValue = c.adjustmentValue,
      qualifier = c.ccy,
      comment = c.comment,
      data_source = PlexDataSource.PlexAdjustment
    )
  }
}
