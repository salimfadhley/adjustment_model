package risk

/**
  * Created by salim on 2/23/2017.
  */
trait CurrencyConverter {

  def convert(row: PlexRow, toCCY: Currency = "USD")



}
