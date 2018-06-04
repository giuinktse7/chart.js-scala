package chart.option.scale

import chart.JSOptionBuilder
import chart.JSOptionBuilder.OptMap

import scala.scalajs.js
@js.native
  trait LinearScale extends Scale

  object LinearScale extends LinearScaleBuilder()
  class LinearScaleBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[LinearScale, LinearScaleBuilder] {
    def copy(map: OptMap) = new LinearScaleBuilder(map)

    def `type`: Type[String] = set("type")
    def position: Type[String] = set("position")
    def offset: Type[Boolean] = set("offset")
    def id: Type[String] = set("id")
    def gridLines: Type[GridLines] = set("gridLines")
    def scaleLabel: Type[ScaleLabel] = set("scaleLabel")
    def ticks: Type[LinearTicks] = set("ticks")
    def withStacked: Type[Boolean] = set("stacked")
    def stacked = setRaw("stacked", true)
  }

@js.native
trait LinearTicks extends js.Object

object LinearTicks extends LinearTicksBuilder()
class LinearTicksBuilder(val dict: OptMap = JSOptionBuilder.noOpts) extends JSOptionBuilder[LinearTicks, LinearTicksBuilder] {
  def copy(map: OptMap) = new LinearTicksBuilder(map)

  def beginAtZero = setRaw("beginAtZero", true)
  def min: Type[Double] = set("min")
  def max: Type[Double] = set("max")
  def maxTicksLimit: Type[Double] = set("maxTicksLimit")
  def stepSize: Type[Double] = set("stepSize")
  def suggestedMax: Type[Double] = set("suggestedMax")
  def suggestedMin: Type[Double] = set("suggestedMin")
}