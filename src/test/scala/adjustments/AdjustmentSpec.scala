package adjustments

import java.time.LocalDate

import org.scalatest.{FlatSpec, Matchers}
import plex.PlexDataSource._
import plex.{MeasureType, PlexDataSource}

/**
  * Created by salim on 2/23/2017.
  */
class AdjustmentSpec extends FlatSpec with Matchers {

  "Adjustments" should "be creatable as objects" in {
    val components: List[PlexAdjustmentComponent] = PlexAdjustmentComponent("foo", 2.3, Some(BalanceSheets.PV), "USD", Some("Hello World")) :: Nil

    val adjustment = new PlexAdjustment(
      AdjustmentContent(
        id = 0L,
        tradeId = Some("123"),
        bookId = Some("YMaster.ABCD"),
        groupId = Some("group1"),
        instrumentId = Some("Foo123"),
        adminId = Some("1234A"),
        instrumentType = Some("Swap"),
        effective_date = LocalDate.of(2017, 2, 27),
        reversal_date = Some(LocalDate.of(2017, 3, 1)),
        components = components,
        cancelled = false
      ))

    val impacts: List[AdjustmentImpact] = adjustment.getAdjustmentImpacts

    val expected: List[AdjustmentImpact] = List(
      AdjustmentImpact(
        id=0L,
        tradeId = Some("123"),
        bookId = Some("YMaster.ABCD"),
        groupId = Some("group1"),
        instrumentId = Some("Foo123"),
        adminId = Some("1234A"),
        instrumentType = Some("Swap"),
        measure = "foo",
        balanceSheetMeasure = Some(BalanceSheets.PV),
        measureValue = 2.3,
        ccy="USD",
        qualifier="USD",
        comment=Some("Hello World"),
        data_source = PlexAdjustment
    ))

    assert(impacts == expected)
  }

  "it" should "be able to calculate normalized adjustment impacts" in {
    val components: List[PlexAdjustmentComponent] = PlexAdjustmentComponent("foo", 2.3, Some(BalanceSheets.PV), "USD", Some("Hello World")) :: Nil

    val adjustment = new PlexAdjustment(
      AdjustmentContent(
        id = 0L,
        tradeId = Some("123"),
        bookId = Some("YMaster.ABCD"),
        groupId = Some("group1"),
        instrumentId = Some("Foo123"),
        adminId = Some("1234A"),
        instrumentType = Some("Swap"),
        effective_date = LocalDate.of(2017, 2, 27),
        reversal_date = Some(LocalDate.of(2017, 3, 1)),
        components = components,
        cancelled = false
      ))

    val impacts: List[AdjustmentImpact] = adjustment.getNormalizedAdjustmentImpacts

    val expected: List[NormalizedAdjustmentImpact] = List(
      NormalizedAdjustmentImpact(
        id=0L,
        tradeId = Some("123"),
        bookId = Some("YMaster.ABCD"),
        groupId = Some("group1"),
        instrumentId = Some("Foo123"),
        adminId = Some("1234A"),
        instrumentType = Some("Swap"),
        measure = "foo",
        measureType = MeasureType.PlexMeasure,
        measureValue = 2.3,
        ccy="USD",
        qualifier="USD",
        comment=Some("Hello World"),
        data_source = PlexAdjustment
      ),
      NormalizedAdjustmentImpact(
        id=0L,
        tradeId = Some("123"),
        bookId = Some("YMaster.ABCD"),
        groupId = Some("group1"),
        instrumentId = Some("Foo123"),
        adminId = Some("1234A"),
        instrumentType = Some("Swap"),
        measure = "foo",
        measureType = MeasureType.BalanceSheet,
        measureValue = 2.3,
        ccy="USD",
        qualifier="USD",
        comment=Some("Hello World"),
        data_source = PlexAdjustment
      )

    )

    assert(impacts == expected)
  }



}

