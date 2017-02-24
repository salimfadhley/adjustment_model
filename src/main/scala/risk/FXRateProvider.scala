package risk

import java.time.LocalDate

/**
  * Created by salim on 2/24/2017.
  */
trait FXRateProvider {

  def getSpotRate(date: LocalDate, fromCcy: Currency, toCcy: Currency = "USD"): FxRate

}
