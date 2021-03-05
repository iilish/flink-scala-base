import Versions._
import sbt._

object Dependencies {

  object Flink {
     val scala = "org.apache.flink" %% "flink-scala" % flinkVersion % "provided"
     val stream = "org.apache.flink" %% "flink-streaming-scala" % flinkVersion % "provided"
     val clients = "org.apache.flink" %% "flink-clients" % flinkVersion % "provided"
  }
  
  object FlinkConnector {
    val kafka = "org.apache.flink" %% "flink-connector-kafka" % flinkVersion
  }
  
  object Test {
    val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion % "test"
    val mockito = "org.mockito" % "mockito-core" % mockitoVersion % "test"
  }

  object Logger {
    val log4j = "log4j" % "log4j" % log4jVersion % "runtime"
    val sfl4j = "org.slf4j" % "slf4j-log4j12" % sfl4jVersion % "runtime"
  }


  val flinkDependencies : Seq[ModuleID] = Seq(Flink.scala, Flink.stream, Flink.clients, FlinkConnector.kafka)
  val testDependencies: Seq[ModuleID] = Seq(Test.scalaTest, Test.mockito)
  val commonDependencies: Seq[ModuleID] = Seq(Logger.log4j, Logger.sfl4j)

  val projectDependencies: Seq[ModuleID] = commonDependencies ++ flinkDependencies ++ testDependencies
}
