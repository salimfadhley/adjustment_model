package adjustments

import plex.PlexRow

/**
  * Created by salim on 2/23/2017.
  */
trait Adjustment {



  def getAdjustmentImpacts:List[PlexRow]

}
