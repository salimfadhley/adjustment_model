package adjustments

import java.time.LocalDate

import org.scalatest.{FlatSpec, Matchers}
import risk.PlexRow

/**
  * Created by salim on 2/23/2017.
  */
class AdjustmentSpec extends FlatSpec with Matchers {

  "Adjustments" should "be creatable as objects" in {


    val components: List[PlexAdjustmentComponent] = PlexAdjustmentComponent("foo", 2.3, Some("bar"), "USD", Some("Hello World")) :: Nil

    val adjustment = new PlexAdjustment(
      AdjustmentContent(
        id = 0L,
        tradeId = Some("123"),
        bookId = Some("YMaster.ABCD"),
        groupId = Some("xxx_yyy"),
        instrumentId = Some("Foo123"),
        adminId = Some("1234A"),
        instrumentType = Some("Swap"),
        effective_date = LocalDate.of(2017, 2, 27),
        reversal_date = Some(LocalDate.of(2017, 3, 1)),
        measures = components,
        cancelled = false
      ))

    val impacts: List[PlexRow] = adjustment.getAdjustmentImpacts


  }
}

