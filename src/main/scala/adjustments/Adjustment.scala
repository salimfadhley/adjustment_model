package adjustments

/**
  * Created by salim on 2/23/2017.
  */
trait Adjustment {
  def getAdjustmentImpacts:List[AdjustmentImpact]
  def getNormalizedAdjustmentImpacts:List[NormalizedAdjustmentImpact]
}
