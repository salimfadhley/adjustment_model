package risk

/**
  * Created by salim on 2/24/2017.
  */
case class PlexRow(
                    id: Long,
                    tradeId: Option[String],
                    bookId: Option[String],
                    groupId: Option[String],
                    instrumentId: Option[String],
                    adminId: Option[String],
                    instrumentType: Option[String],
                    measure: String,
                    measureValue: Double,
                    ccy: Currency,
                    qualifier: Currency,
                    comment: Option[String],
                    data_source: Option[DataSource.type] // "PlexAdjusek
                    // "
                  ) {

}