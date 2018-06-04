import Transform.{ColumnData, DataEntry}
import chart.JSOptionBuilder.OptMap
import chart._
import chart.data.BarChartData.DataObject
import chart.data.{BarChartData, LineChartData}
import chart.option._
import chart.option.layout.{LayoutOptions, Padding}
import chart.option.scale._
import org.scalajs.dom
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom.html
import org.scalajs.dom.html.Canvas

import scala.scalajs.js

@js.native
trait TestObj extends js.Object

object TestObj extends TestObjBuilder()
class TestObjBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[TestObj, TestObjBuilder] {
  def copy(map: OptMap) = new TestObjBuilder(map)

  def fn: Type[String => Unit] = set("theFunction")
}

object Body {

  final case class Props() {
    @inline def render: VdomElement = Component(this)
  }

  //implicit val reusabilityProps: Reusability[Props] =
  //  Reusability.derive

  final class Backend($: BackendScope[Props, Unit]) {
    def render(p: Props): VdomElement = {
      test()
      <.canvas()
    }

    def mount: Callback = test >> Callback.empty

    private def test(): CallbackTo[Chart] = {
      $.getDOMNode.map(node => stackedBarChart(node.domCast[Canvas]))
    }

    private def newDate(days: Int) = moment.Moment.utc().add(days, "d").hours(0).toDate()
    private def newDataPoint(days: Int) = {
      DataObject
        .t(newDate(days))
        .y(Math.floor(Math.random() * 150))
    }

    def stackedBarChart(canvas: html.Canvas): Chart = {
      def randomData() = Seq("A", "B", "C", "D").map(l => DataEntry(l, Math.random() * 150))

      val dates = (0 to 15).map(newDate)
      val columns = dates.map(d => ColumnData(
        d.toUTCString(),
        randomData()
      ))

      val ctx = canvasContext(canvas)
      //val testData = Seq(0, 22, 15, 70, 35, 41, 31, 110, 59, 530, 200, 100, 225, 50, 20, 55, 90, 0)
      val testData = (0 to 45).map(newDataPoint)
      val testLabel = testData.map(_.t.asInstanceOf[js.Date]).map(Label.apply)

      val data = Transform.toBarChartData(columns)

      val options = ChartOptions
        .scales(ScaleOptions
          .xAxes(TimeScale
            .time(TimeTime(unit = "day"))
            .ticks(TimeTicks(source = TickSource.Labels))
            .bounds(Bounds.Data)
            .stacked
          )
          .yAxes(
            LinearScale
              .ticks(LinearTicks.beginAtZero)
              .stacked
          )
        )
        .layout(LayoutOptions.padding(Padding.left(50).right(50)))

      printObj(options)

      Chart.Bar(ctx, data, options)
    }

    def canvasContext(canvas: html.Canvas) = {
      canvas.getContext("2d").asInstanceOf[dom.CanvasRenderingContext2D]
    }

    def testFns() = {
      val obj = TestObj.fn(x => println(x))
      printObj(obj)
    }


    def createChart(canvas: html.Canvas): Chart = {
      val ctx = canvasContext(canvas)
      val data = BarChartData
        .labels(Seq("Western Province", "Kigali City", "South Province", "North Province").map(Label.apply))
        .datasetsFree(
          BarChartData.DataSet
            .label("# of attendance in provinces")
            .data(Seq(7, 1, 1, 1))
            .fill(true)
            .backgroundColor("#ff0000"),
          BarChartData.DataSet
            .label("# of citizens in provinces")
            .data(Seq(10, 2, 1, 1))
            .fill(true)
            .backgroundColor("#00ff00")
        )

      val options = ChartOptions
        .scales(ScaleOptions
          .xAxes(LinearScale.ticks(LinearTicks.beginAtZero).stacked)
          .yAxes(LinearScale.ticks(LinearTicks.beginAtZero).stacked)
      )

      printObj(options)

      Chart.Bar(ctx, data, options)
    }

    def lineChart(canvas: html.Canvas) = {
      testFns()
      val ctx = canvasContext(canvas)
      val data = LineChartData(
        labels = Seq("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"),
        datasets = Seq(
          LineChartData.DataSet
            .label("Test")
            .data(Seq(65, 59, 80, 81, 56, 55, 40,60,55,30,78))
            .pointHitRadius(10)
            .radius(15)
            .pointBackgroundColor("#821700")
        )
      )

      val options = ChartOptions

      printObj(
        LineChartData.DataSet
          .label("Test")
          .data(Seq(65, 59, 80, 81, 56, 55, 40,60,55,30,78))
          .pointHitRadius(10)
          .radius(15)
      )

      Chart.Line(ctx, data, options)
    }
  }


  def printObj(obj: js.Any) = js.Dynamic.global.console.dir(obj)

  val Component = ScalaComponent.builder[Props]("Body")
    .renderBackend[Backend]
    .componentDidMount(_.backend.mount)
    //.configure(Reusability.shouldComponentUpdate)
    .build

  def apply() = Component(Props())
}