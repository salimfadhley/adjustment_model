package adjustments

import plex.PlexDataSource

/**
  * Created by salim on 2/23/2017.
  */

class PlexAdjustment(adjustment: AdjustmentContent) extends Adjustment {

  override def getAdjustmentImpacts: List[AdjustmentImpact] = {
    adjustment.components.map {
      (component: PlexAdjustmentComponent) => AdjustmentImpact(
        id = adjustment.id,
        tradeId = adjustment.tradeId,
        bookId = adjustment.bookId,
        groupId = adjustment.groupId,
        instrumentId = adjustment.instrumentId,
        adminId = adjustment.adminId,
        instrumentType = adjustment.instrumentType,
        measure = component.measureName,
        balanceSheetMeasure = component.balanceSheetImpact,
        ccy = component.ccy,
        measureValue = component.adjustmentValue,
        qualifier = component.ccy,
        comment = component.comment,
        data_source = PlexDataSource.PlexAdjustment
      )
    }

  }

  override def getNormalizedAdjustmentImpacts: List[NormalizedAdjustmentImpact] = {



  }
}
