package adjustments

import java.time.LocalDate

/**
  * Created by salim on 2/24/2017.
  */
case class AdjustmentContent(
                              id: Long,
                              tradeId: Option[String],
                              bookId: Option[String],
                              groupId: Option[String],
                              instrumentId: Option[String],
                              adminId: Option[String],
                              instrumentType: Option[String],
                              effective_date: LocalDate,
                              reversal_date: Option[LocalDate],
                              measures: List[PlexAdjustmentComponent],
                              cancelled: Boolean
                            ) {

}
