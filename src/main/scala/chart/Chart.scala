package chart

import chart.data.{BarChartData, Data, LineChartData}
import chart.option.ChartOptions
import org.scalajs.dom.{CanvasRenderingContext2D, Event}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSImport, JSName}


@js.native
@JSImport("chart.js", JSImport.Namespace)
class Chart extends js.Object {
  def this(context: CanvasRenderingContext2D, config: ChartConfig) = this()
}

object Chart {
  def ifdef[A](x: js.UndefOr[A], f: () => Unit) = if (x != js.undefined) f()

  def apply(context: CanvasRenderingContext2D, config: ChartConfig): Chart = {
    new Chart(context, config)
  }

  def Bar(context: CanvasRenderingContext2D, data: BarChartData, options: ChartOptions = ChartOptions): Chart = {
    new Chart(context, ChartConfig("bar", data, options))
  }

  def Line(context: CanvasRenderingContext2D, data: LineChartData, options: ChartOptions = ChartOptions): Chart = {
    new Chart(context, ChartConfig("line", data, options))
  }
}

case class Label[T](value: T)

@js.native
trait LineChartOptions extends js.Object {
  var scaleShowHorizontalLines: Boolean = js.native
  var scaleShowVerticalLines: Boolean = js.native
  var bezierCurve: Boolean = js.native
  var bezierCurveTension: Double = js.native
  var pointDot: Boolean = js.native
  var pointDotRadius: Double = js.native
  var pointDotStrokeWidth: Double = js.native
  var pointHitDetectionRadius: Double = js.native
  var datasetStroke: Boolean = js.native
  var datasetStrokeWidth: Double = js.native
  var datasetFill: Boolean = js.native
  var responsive: Boolean = js.native
  var maintainAspectRatio: Boolean = js.native
}

@js.native
trait PointsAtEvent extends js.Object {
  var value: Double = js.native
  var label: String = js.native
  var datasetLabel: String = js.native
  var strokeColor: String = js.native
  var fillColor: String = js.native
  var highlightFill: String = js.native
  var highlightStroke: String = js.native
  var x: Double = js.native
  var y: Double = js.native
}


@js.native
trait LinearInstance extends js.Object {
  var getPointsAtEvent: js.Function1[Event, js.Array[PointsAtEvent]] = js.native
  var update: js.Function0[Unit] = js.native
  var addData: js.Function2[js.Array[Double], String, Unit] = js.native
  var removeData: js.Function0[Unit] = js.native
}

@js.native
trait ChartConfig extends js.Object {
  val `type`: String = js.native
  val data: Data = js.native
  val options: ChartOptions = js.native
}

object ChartConfig {
  def apply(chartType: String, data: Data, options: js.UndefOr[ChartOptions] = js.undefined): ChartConfig = {
    val r = js.Dynamic.literal(`type` = chartType, data = data)
    options.foreach(r.options = _)

    r.asInstanceOf[ChartConfig]
  }
}