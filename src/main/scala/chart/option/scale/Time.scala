package chart.option.scale

import chart.JSOptionBuilder
import chart.JSOptionBuilder.OptMap
import moment.Date

import scala.scalajs.js
import scala.scalajs.js.|

object Distribution {
  val Linear = "linear"
  val Series = "series"
}

object Bounds {
  /**
    * Make sure data are fully visible, labels outside are removed
    */
  val Data = "data"
  /**
    * Make sure ticks are fully visible, data outside are truncated
    */
  val Ticks = "ticks"
}


@js.native
  trait TimeScale extends Scale

  object TimeScale extends TimeScaleBuilder()
  class TimeScaleBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[TimeScale, TimeScaleBuilder] {
    def copy(map: OptMap) = new TimeScaleBuilder(map)

    def distribution: Type[String] = set("distribution")
    def bounds: Type[String] = set("bounds")
    def ticks: Type[TimeTicks] = set("ticks")
    def time: Type[TimeTime] = set("time")
    def withStacked: Type[Boolean] = set("stacked")
    def stacked = setRaw("stacked", true)
  }

@js.native
trait TimeTicks extends Ticks {
  val source: String = js.native
}

object TickSource {
  val Auto = "auto"
  val Data = "data"
  val Labels = "labels"
}

object TimeTicks {
  def apply(
           source: String = "auto",

           // From Ticks
           minor: TickConfig = TickConfig(),
           major: TickConfig = TickConfig()
           ) = js.Dynamic.literal(
    source = source,
    minor = minor,
    major = major,
  ).asInstanceOf[TimeTicks]
}

@js.native
trait TimeTime extends js.Object {
  val isoWeekday: Boolean = js.native
  val min: Date = js.native
  val max: Date = js.native
  val parser: String | js.Function0[Date] = js.native
  val round: String = js.native
  val tooltipFormat: String = js.native
  val unit: String = js.native
  val stepSize: Double = js.native
  val minUnit: String = js.native
}

object TimeTime {
  def apply(
             isoWeekday: js.UndefOr[Boolean] = js.undefined,
             min: js.UndefOr[Date] = js.undefined,
             max: js.UndefOr[Date] = js.undefined,
             parser: js.UndefOr[String] = js.undefined,
             round: js.UndefOr[String] = js.undefined,
             tooltipFormat: js.UndefOr[String] = js.undefined,
             unit: js.UndefOr[String] = js.undefined,
             stepSize: js.UndefOr[Double] = js.undefined,
             minUnit: js.UndefOr[String] = js.undefined
           ) = {
    val r = js.Dynamic.literal()

    isoWeekday.foreach(r.isoWeekday = _)
    min.foreach(r.min = _)
    max.foreach(r.max = _)
    parser.foreach(r.parser = _)
    round.foreach(r.round = _)
    tooltipFormat.foreach(r.tooltipFormat = _)
    unit.foreach(r.unit = _)
    stepSize.foreach(r.stepSize = _)
    minUnit.foreach(r.minUnit = _)

    r.asInstanceOf[TimeTime]
  }
}
