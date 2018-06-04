package chart.data

import chart.JSOptionBuilder.OptMap
import chart.data.BarChartData.DataSet
import chart.{JSOptionBuilder, Label}

import scala.scalajs.js
import scala.scalajs.js.|

@js.native
trait BarChartData extends Data

object BarChartData extends BarChartDataBuilder() {
  @js.native
  trait DataSet extends js.Object

  object DataSet extends DataSetBuilder()
  class DataSetBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[DataSet, DataSetBuilder] {
    def copy(map: OptMap) = new DataSetBuilder(map)

    def label: Type[String] = set("label")
    def fill: Type[Boolean] = set("fill")
    def fillColor: Type[String] = set("fillColor")
    def backgroundColor: Type[String] = set("backgroundColor")
    def strokeColor: Type[String] = set("strokeColor")
    def highlightFill: Type[String] = set("highlightFill")
    def highlightStroke: Type[String] = set("highlightStroke")
    def data: Type[Seq[DataObject | Double]] = set("data")
    def stack: Type[String] = set("stack")
  }


  @js.native
  trait DataObject extends js.Object

  object DataObject extends DataObjectBuilder()
  class DataObjectBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[DataObject, DataObjectBuilder] {
    def copy(map: OptMap) = new DataObjectBuilder(map)

    def x: Type[Double | js.Date] = set("x")
    def y: Type[Double] = set("y")
    def t: Type[Double | js.Date] = set("t")
  }
}
class BarChartDataBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[BarChartData, BarChartDataBuilder] {
  def copy(map: OptMap) = new BarChartDataBuilder(map)

  def labels[A](labels: Seq[Label[A]]) = setValue("labels", labels.map(_.value))

  /**
    * Like datasets, but allows for omittance of the wrapping Seq
    */
  def datasetsFree(dataSets: DataSet*) = setValue("datasets", dataSets.toSeq)
  def datasets(dataSets: Seq[DataSet]) = setValue("datasets", dataSets)
  def scaleGridLineColor: Type[String] = set("scaleGridLineColor")
}