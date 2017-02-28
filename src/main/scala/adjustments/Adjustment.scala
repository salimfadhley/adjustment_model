package adjustments

/**
  * Created by salim on 2/23/2017.
  */
trait Adjustment {
  def getNormalizedAdjustmentImpacts:List[NormalizedAdjustmentImpact]
}
