ThisBuild / scalaVersion := Versions.scalaVersion
ThisBuild / organization := "org.irach"
ThisBuild / version := "1.0.0-SNAPSHOT"
ThisBuild / name := "example"
 
/*
ThisBuild / resolvers ++= Seq(
  "Apache Development Snapshot Repository" at "https://repository.apache.org/content/repositories/snapshots/",
  Resolver.mavenLocal
)
*/

lazy val root = (project in file("."))
  .settings(libraryDependencies ++= Dependencies.projectDependencies)
  
assembly / mainClass := Some("org.irach.WordCount")

// make run command include the provided dependencies
Compile / run := Defaults.runTask(Compile / fullClasspath,
  Compile / run / mainClass,
  Compile / run / runner
).evaluated

// stays inside the sbt console when we press "ctrl-c" while a Flink programme executes with "run" or "runMain"
 Compile / run / fork := true
 Global / cancelable := true

// exclude Scala library from assembly
assembly / assemblyOption := (assembly / assemblyOption).value.copy(includeScala = false)

