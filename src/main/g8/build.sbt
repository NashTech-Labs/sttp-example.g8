name := "sttp-example"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp" %% "core" % "1.0.2",
  "com.google.code.gson" % "gson" % "2.8.2",
  "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"
)
