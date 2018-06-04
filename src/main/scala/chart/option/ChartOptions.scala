package chart.option

import chart.option.layout.LayoutOptions
import chart.option.scale.Scale
import chart.{Chart, JSOptionBuilder}
import chart.JSOptionBuilder.OptMap
import chart.data.Data
import org.scalajs.dom.raw.Event

import scala.scalajs.js

object LegendPosition {
  val Top = "top"
  val Left = "left"
  val Bottom = "bottom"
  val Right = "right"
}

@js.native
trait LegendOptions extends js.Object {
  val display: Boolean = js.native
  val position: String = js.native
  val fullWidth: Boolean = js.native
  val onClick: js.Function2[Event, js.Any, Unit] = js.native
  val onHover: js.Function2[Event, js.Any, Unit] = js.native
  val reverse: Boolean = js.native
  val labels: LegendLabelOptions = js.native
}

@js.native
  trait LegendLabelOptions extends js.Object

  object LegendLabelOptions extends LegendLabelOptionsBuilder()
  class LegendLabelOptionsBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[LegendLabelOptions, LegendLabelOptionsBuilder] {
    def copy(map: OptMap) = new LegendLabelOptionsBuilder(map)

    type Self = LegendLabelOptionsBuilder

    def boxWidth: Type[Double] = set("boxWidth")
    def fontSize: Type[Double] = set("fontSize")
    def fontStyle: Type[String] = set("fontStyle")
    def fontColor: Type[String] = set("fontColor")
    def fontFamily: Type[String] = set("fontFamily")
    def padding: Type[Double] = set("padding")
    def generateLabels: Type[Chart => js.Object] = set("generateLabels")
    def filter: Type[(LegendItem, Data) => Unit] = set("filter")
    def usePointStyle: Type[Boolean] = set("usePointStyle")
  }

@js.native
trait LegendItem extends js.Object {
  val text: String = js.native
  val fillStyle: String = js.native
  val hidden: Boolean = js.native
  val lineCap: String = js.native
  val lineDash: js.Array[Double] = js.native
  val lineDashOffset: Double = js.native
  val lineJoin: String = js.native
  val lineWidth: Double = js.native
  val strokeStyle: String = js.native
  val pointStyle: String = js.native
}

@js.native
  trait ChartOptions extends js.Object

  object ChartOptions extends ChartOptionsBuilder()
  class ChartOptionsBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[ChartOptions, ChartOptionsBuilder] {
    def copy(map: OptMap) = new ChartOptionsBuilder(map)

   def scales: Type[ScaleOptions] = set("scales")
   def layout: Type[LayoutOptions] = set("layout")
   def legend: Type[LegendOptions] = set("legend")
  }


@js.native
trait ScaleOptions extends js.Object

object ScaleOptions extends ScaleOptionsBuilder()
class ScaleOptionsBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[ScaleOptions, ScaleOptionsBuilder] {
  def copy(map: OptMap) = new ScaleOptionsBuilder(map)

  def xAxes(scales: Scale*) = setValue("xAxes", scales.toSeq)
  def yAxes(scales: Scale*) = setValue("yAxes", scales.toSeq)
}