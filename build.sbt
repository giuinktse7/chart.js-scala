enablePlugins(ScalaJSPlugin, WorkbenchPlugin, ScalaJSBundlerPlugin)

name := "Scala.js Tutorial"
scalaVersion := "2.12.4"

val scalaJSReactVersion = "1.2.0"
val scalaCssVersion = "0.5.5"
val reactJSVersion = "16.3.2"

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

npmDependencies in Compile ++= Seq(
  "react" -> "16.2.0",
  "react-dom" -> "16.2.0",
  "chart.js" -> "2.7.2",
  "moment" -> "2.19.2"
)

skip in packageJSDependencies := false

jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv()

// uTest settings
testFrameworks += new TestFramework("utest.runner.Framework")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.5",
  "com.lihaoyi" %%% "utest" % "0.6.3" % "test",
  "com.github.japgolly.scalajs-react" %%% "core" % scalaJSReactVersion,
  "com.github.japgolly.scalajs-react" %%% "extra" % scalaJSReactVersion,
  "com.github.japgolly.scalacss" %%% "core" % scalaCssVersion,
  "com.github.japgolly.scalacss" %%% "ext-react" % scalaCssVersion,
  "ru.pavkin" %%% "scala-js-momentjs" % "0.9.1"
)

