package adjustments

/**
  * Created by salim on 2/23/2017.
  */

class PlexAdjustment(id:Long, trade:Option[String], instrument:Option[String]) extends Adjustment {

  override def getAdjustmentImpacts: List[AdjustmentImpacts] = ???

}
