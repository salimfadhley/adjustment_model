package plex

import adjustments.AdjustmentImpact

/**
  * Created by salim on 2/23/2017.
  */
trait CurrencyConverter {

  def convert(row: AdjustmentImpact, toCCY: Currency = "USD"): AdjustmentImpact

  def convert(rows: Stream[AdjustmentImpact]):Stream[AdjustmentImpact] = {
    rows.map((row: AdjustmentImpact) => convert(row))
  }




}
