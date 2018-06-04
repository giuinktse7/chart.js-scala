package chart.option.scale

import chart.JSOptionBuilder
import chart.JSOptionBuilder.OptMap

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

@js.native
  trait Scale extends js.Object

  object Scale extends ScaleBuilder()
  class ScaleBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[Scale, ScaleBuilder] {
    def copy(map: OptMap) = new ScaleBuilder(map)

    def `type`: Type[String] = set("type")
    def position: Type[String] = set("position")
    def offset: Type[Boolean] = set("offset")
    def id: Type[String] = set("id")
    def gridLines: Type[GridLines] = set("gridLines")
    def scaleLabel: Type[ScaleLabel] = set("scaleLabel")
    def ticks: Type[Ticks] = set("ticks")
  }

@js.native
trait Ticks extends js.Object {
  var minor: TickConfig = js.native
  var major: TickConfig = js.native
}

@js.native
trait GridLines extends js.Object {
  val display: Boolean = js.native
  val color: String = js.native
  val borderDash: js.Array[Double] = js.native
  val borderDashOffset: Double = js.native
  val lineWidth: Double = js.native
  val drawBorder: Boolean = js.native
  val drawOnChartArea: Boolean = js.native
  val drawTicks: Boolean = js.native
  val tickMarkLength: Double = js.native
  val zeroLineWidth: Double = js.native
  val zeroLineColor: String = js.native
  val zeroLineBorderDash: js.Array[Double] = js.native
  val zeroLineBorderDashOffset: Double = js.native
  val offsetGridLines: Boolean = js.native
}

object GridLines {
  def apply(
             display: Boolean = true,
             color: String = "rgba(0, 0, 0, 0.1)",
             borderDash: Seq[Double] = Seq(),
             borderDashOffset: Double = 0,
             lineWidth: Double = 1,
             drawBorder: Boolean = true,
             drawOnChartArea: Boolean = true,
             drawTicks: Boolean = true,
             tickMarkLength: Double = 10,
             zeroLineWidth: Double = 1,
             zeroLineColor: String = "rgba(0, 0, 0, 0.25)",
             zeroLineBorderDash: Seq[Double] = Seq(),
             zeroLineBorderDashOffset: Double = 0,
             offsetGridLines: Boolean = false,
           ) = js.Dynamic.literal(
    display = display,
    color = color,
    borderDash = borderDash.toJSArray,
    borderDashOffset = borderDashOffset,
    lineWidth = lineWidth,
    drawBorder = drawBorder,
    drawOnChartArea = drawOnChartArea,
    drawTicks = drawTicks,
    tickMarkLength = tickMarkLength,
    zeroLineWidth = zeroLineWidth,
    zeroLineColor = zeroLineColor,
    zeroLineBorderDash = zeroLineBorderDash.toJSArray,
    zeroLineBorderDashOffset = zeroLineBorderDashOffset,
    offsetGridLines = offsetGridLines
  ).asInstanceOf[GridLines]
}

@js.native
trait ScaleLabel extends js.Object {
  val display: Boolean = js.native
  val labelString: String = js.native
  val lineHeight: Double = js.native
  val fontColor: String = js.native
  val fontFamily: String = js.native
  val fontSize: Double = js.native
  val fontStyle: String = js.native
  val padding: Double = js.native
}

object ScaleLabel {
  def apply(
             display: js.UndefOr[Boolean] = js.undefined,
             labelString: js.UndefOr[String] = js.undefined,
             lineHeight: js.UndefOr[Double] = js.undefined,
             fontColor: js.UndefOr[String] = js.undefined,
             fontFamily: js.UndefOr[String] = js.undefined,
             fontSize: js.UndefOr[Double] = js.undefined,
             fontStyle: js.UndefOr[String] = js.undefined,
             padding: js.UndefOr[Double] = js.undefined
           ) = {
    val r = js.Dynamic.literal()

    display.foreach(r.display = _)
    labelString.foreach(r.labelString = _)
    lineHeight.foreach(r.lineHeight = _)
    fontColor.foreach(r.fontColor = _)
    fontFamily.foreach(r.fontFamily = _)
    fontSize.foreach(r.fontSize = _)
    fontStyle.foreach(r.fontStyle = _)
    padding.foreach(r.padding = _)

    r.asInstanceOf[ScaleLabel]
  }
}

@js.native
trait TickConfig extends js.Object {
  val callback: js.Function3[js.Any, Int, js.Array[js.Any], Unit] = js.native
  val fontColor: String = js.native
  val fontFamily: String = js.native
  val fontSize: Double = js.native
  val fontStyle: String = js.native
}

object TickConfig {
  def apply(
             callback: js.UndefOr[js.Function3[js.Any, Int, js.Array[js.Any], Unit]] = js.undefined,
             fontColor: js.UndefOr[String] = js.undefined,
             fontFamily: js.UndefOr[String] = js.undefined,
             fontSize: js.UndefOr[Double] = js.undefined,
             fontStyle: js.UndefOr[String] = js.undefined
           ) = {
    val r = js.Dynamic.literal()

    callback.foreach(r.callback = _)
    fontColor.foreach(r.fontColor = _)
    fontFamily.foreach(r.fontFamily = _)
    fontSize.foreach(r.fontSize = _)
    fontStyle.foreach(r.fontStyle = _)

    r.asInstanceOf[TickConfig]
  }
}