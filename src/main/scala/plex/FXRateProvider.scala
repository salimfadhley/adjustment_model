package plex

import java.time.LocalDate

/**
  * Created by salim on 2/24/2017.
  */
trait FXRateProvider {

  def getSpotRateForBookGroup(bookGroup:String, date: LocalDate, fromCcy: Currency, toCcy: Currency = "USD"): FxRate

}
