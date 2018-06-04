import org.scalajs.dom
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._


object Main {

  def main(args: Array[String]): Unit = {
    Body().renderIntoDOM(dom.document.getElementById("root"))
  }

}
