package chart.data

import chart.JSOptionBuilder
import chart.JSOptionBuilder.OptMap

import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.|

@js.native
trait LineChartData extends Data {

}

object LineChartData {
  def apply(
             labels: Seq[String] = Seq.empty[String],
             datasets: Seq[DataSet] = Seq.empty[DataSet]
           ): LineChartData = {
    js.Dynamic.literal(
      labels = labels.toJSArray,
      datasets = datasets.toJSArray
    ).asInstanceOf[LineChartData]
  }

  @js.native
    trait DataObjectOptions extends js.Object

    object DataObjectOptions extends DataObjectOptionsBuilder()
    class DataObjectOptionsBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[DataObjectOptions, DataObjectOptionsBuilder] {
      def copy(map: OptMap) = new DataObjectOptionsBuilder(map)

      def x: Type[Double | js.Date] = set("x")
      def y: Type[Double | js.Date] = set("y")
    }

  @js.native
  trait DataSet extends js.Object

  object DataSet extends DataSetOptionsBuilder()
  class DataSetOptionsBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[DataSet, DataSetOptionsBuilder] {
    def copy(map: OptMap) = new DataSetOptionsBuilder(map)

    def label: Type[String] = set("label")
    def xAxisID: Type[String] = set("xAxisID")
    def data: Type[Seq[DataObjectOptions | Double]] = set("data")
    def yAxisID: Type[String] = set("yAxisID")
    def backgroundColor: Type[String] = set("backgroundColor")
    def borderColor: Type[String] = set("borderColor")
    def borderWidth: Type[Double] = set("borderWidth")
    def borderDash: Type[Seq[Double]] = set("borderDash")
    def borderDashOffset: Type[Double] = set("borderDashOffset")
    def borderCapStyle: Type[String] = set("borderCapStyle")
    def borderJoinStyle: Type[String] = set("borderJoinStyle")
    def cubicInterpolationMode: Type[String] = set("cubicInterpolationMode")
    def fill: Type[Boolean | String] = set("fill")
    def lineTension: Type[Double] = set("lineTension")
    def pointBackgroundColor: Type[String | Seq[String]] = set("pointBackgroundColor")
    def pointBorderColor: Type[String | Seq[String]] = set("pointBorderColor")
    def pointBorderWidth: Type[Double | Seq[Double]] = set("pointBorderWidth")
    def radius: Type[Double | Seq[Double]] = set("radius")
    def pointStyle: Type[String | Seq[String]] = set("pointStyle")
    def pointHitRadius: Type[Double | Seq[Double]] = set("pointHitRadius")
    def pointHoverBackgroundColor: Type[String | Seq[String]] = set("pointHoverBackgroundColor")
    def pointHoverBorderColor: Type[String | Seq[String]] = set("pointHoverBorderColor")
    def pointHoverBorderWidth: Type[Double | Seq[Double]] = set("pointHoverBorderWidth")
    def pointHoverRadius: Type[Double | Seq[Double]] = set("pointHoverRadius")
    def showLine: Type[Boolean] = set("showLine")
    def spanGaps: Type[Boolean] = set("spanGaps")
    def steppedLine: Type[Boolean | String] = set("steppedLine")
  }


}