package chart.option.layout

import chart.JSOptionBuilder
import chart.JSOptionBuilder.OptMap

import scala.scalajs.js

@js.native
trait LayoutOptions extends js.Object

object LayoutOptions extends LayoutOptionsBuilder()
class LayoutOptionsBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[LayoutOptions, LayoutOptionsBuilder] {
  def copy(map: OptMap) = new LayoutOptionsBuilder(map)

 def padding: Type[Padding] = set("padding")
}


@js.native
  trait Padding extends js.Object

  object Padding extends PaddingBuilder()
  class PaddingBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[Padding, PaddingBuilder] {
    def copy(map: OptMap) = new PaddingBuilder(map)

   def left: Type[Double] = set("left")
   def right: Type[Double] = set("right")
   def top: Type[Double] = set("top")
   def bottom: Type[Double] = set("bottom")
  }
