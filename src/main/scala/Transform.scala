import chart.Label
import chart.data.BarChartData

object Transform {
  /**
    * Data for one column in a StackedBarChart
    */
  case class ColumnData(columnLabel: String, data: Seq[DataEntry])

  case class DataEntry(label: String, value: Double)

  type Color = String
  type Label = String

  val defaultPalette = Seq("#68BB35", "#339AF6", "#6D6D6D", "#F1A627", "#E74226", "#BF0045")

  private def getDataLabels(columns: Seq[ColumnData]): Seq[String] = columns.flatMap(_.data.map(_.label)).distinct.sorted


  def toBarChartData(columns: Seq[ColumnData]): BarChartData = {
    val dataLabels = getDataLabels(columns)
    val colorMap: Map[Label, Color] = dataLabels.zip(defaultPalette).toMap

    toBarChartData(columns, colorMap)
  }

  private def createDataSet(label: String, entries: Seq[Double], colorMap: Map[Label, Color]) = {
    import chart.data.BarChartData.DataSet
    DataSet
      .label(label)
      .data(entries)
      .backgroundColor(colorMap(label))
      .fillColor(colorMap(label))
  }


  def toBarChartData(columns: Seq[ColumnData], colorMap: Map[Label, Color]): BarChartData = {
    val dataLabels = getDataLabels(columns)

    // Pad columns to fill in possible missing values in the data
    val paddedColumns: Seq[ColumnData] = columns.map { column =>
      dataLabels.foldLeft(column) { case (c, next) => if (!c.data.exists(_.label == next)) c.copy(data = DataEntry(next, 0) +: c.data) else c }
    }

    val labels = columns.map(_.columnLabel).map(Label.apply)
    val data = paddedColumns
      .flatMap(_.data)
      .groupBy(_.label)
      .mapValues(_.map(_.value))
      .map { case (label, entries) => createDataSet(label, entries, colorMap) }
      .toSeq
      .sortBy(_.property[String]("label"))
      .map(_.build)

    BarChartData.labels(labels).datasets(data)
  }

}
