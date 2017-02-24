package plex

/**
  * Created by salim on 2/23/2017.
  */
trait CurrencyConverter {

  def convert(row: PlexRow, toCCY: Currency = "USD"): PlexRow

  def convert(rows: Stream[PlexRow]):Stream[PlexRow] = {
    rows.map((row: PlexRow) => convert(row))
  }




}
