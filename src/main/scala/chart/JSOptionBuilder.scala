package chart

import chart.JSOptionBuilder.OptMap

import scala.language.implicitConversions
import scala.scalajs.js
import scala.scalajs.js.JSConverters._

/**
  * Trait enabling hierarchical option structures where options can
  * be inherited from other classes.
  * Originally from https://github.com/bwbecker/jsFacadeOptionBuilder
  * 6/3/2018
  *
  * @tparam T See [[JSOptionBuilder]]
  * @tparam B See [[JSOptionBuilder]]
  */
trait JSOptionSetter[T <: js.Object, B <: JSOptionBuilder[T, _]] {
  def set[X](key: String)(value: X): B
}

/**
  * Helper class for defining strongly-typed "options" classes to pass into Scala.js facades.
  * This approach is particularly helpful for jQuery-based facades, which often take very
  * complex options objects, with large numbers of polymorphic fields.
  *
  * @tparam T A placeholder facade trait -- usually just a declaration of a trait that inherits from js.Object.
  * @tparam B This class. (It is probably possible to eliminate this declaration, but I haven't figured it out yet.)
  */
abstract class JSOptionBuilder[T <: js.Object, B <: JSOptionBuilder[T, _]] extends JSOptionSetter[T, B] {
  type Type[X] = X => B

  private def setFn(key: String, f: js.Function) = jsOpt(key, f)

  def property[X](key: String): X = dict(key).asInstanceOf[X]

  def setValue[X](key: String, value: X) = set(key)(value)

  def set[X](key: String)(value: X) = {
    value match {
      case x: Seq[_] => jsOpt(key, x)
      case f: Function1[_, _] => setFn(key, f)
      case f: Function2[_, _, _] => setFn(key, f)
      case f: Function3[_, _, _, _] => setFn(key, f)
      case f: Function4[_, _, _, _, _] => setFn(key, f)
      case f: Function5[_, _, _, _, _, _] => setFn(key, f)
      case f: Function6[_, _, _, _, _, _, _] => setFn(key, f)
      case f: Function7[_, _, _, _, _, _, _, _] => setFn(key, f)
      case f: Function8[_, _, _, _, _, _, _, _, _] => setFn(key, f)
      case f: Function9[_, _, _, _, _, _, _, _, _, _] => setFn(key, f)
      case x => jsOpt(key, x)
    }
  }

  def setRaw(key: String, value: Any) = jsOpt(key, value)


  /**
    * In a class X that extends JSOptionBuilder, implement the boilerplate
    *
    * {{{
    * def copy(newDictionary: OptMap): X = {
    *    new X(newDictionary)
    * }
    * }}}
    *
    * The original version of JSOptionBuilder passed this as a class parameter.  However,
    * IntelliJ refused to do autocompletion with that version and seemed to consume lots of CPU.
    * Doing it this way works.
    */
  def copy(newDictionary: OptMap): B

  /**
    * This is a dictionary of option values. It is usually *very* heterogeneous,
    * mixing everything from Ints to Functions. So it needs to be js.Any.
    */
  protected def dict: OptMap

  /**
    * Define one field in an options class.
    *
    * Note that jsOpt is not, in and of itself, strongly-typed. You use this helper to
    * add a strongly-typed method for each field.
    */
  //private def jsOpt[X, Y](name: String, opt: |[X, Y]): B = copy(dict + (name -> opt.asInstanceOf[js.Any]))
  private def jsOpt[X](name: String, opt: Seq[X]): B = copy(dict + (name -> opt.toJSArray))
  private def jsOpt(name: String, opt: Any): B = copy(dict + (name -> opt))

  /**
    * Extract the built-up options, in a form suitable for passing into a typical facade.
    */
  private def _result = dict.toJSDictionary.asInstanceOf[T]

  def build = _result


  override def toString = {
    s"""{\n${dict.keys.map{ key => s"  $key = ${dict(key).toString}"}.mkString("\n")}\n}"""
  }
}

object JSOptionBuilder {

  /**
    * Automatically extract the result from a JSOptionBuilder when necessary.
    */
  implicit def builder2Options[T <: js.Object](builder: JSOptionBuilder[T,_]): T = builder._result
  type OptMap = Map[String, Any]
  val noOpts = Map.empty[String, Any]
}