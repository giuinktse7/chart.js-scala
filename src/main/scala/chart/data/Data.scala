package chart.data

import scala.scalajs.js
import scala.scalajs.js.JSConverters._


@js.native
trait DataItem extends js.Object {
  val label: String = js.native
  val backgroundColor: String = js.native
  val data: js.Array[Int] = js.native
}

object DataItem {
  def apply(
             label: String,
             backgroundColor: String,
             data: Seq[Int]
           ): DataItem = js.Dynamic.literal(
    label = label,
    backgroundColor = backgroundColor,
    data = data.toJSArray
  ).asInstanceOf[DataItem]
}

@js.native
trait Data extends js.Object {
  val labels: js.Array[js.Any] = js.native
  val datasets: js.Array[DataItem] = js.native
}