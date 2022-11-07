import java.io.File

import java.nio.charset.StandardCharsets

import sbt.IO._

import scala.collection.convert.wrapAll._

val libgdxVersion = "1.11.0"
logLevel := Level.Debug

name := "libgdx-scala-3"
version := "0.1"
scalaVersion := "3.2.0"
assetsDirectory := {
  val r = file("assets")
  IO.createDirectory(r)
  r
}
libraryDependencies ++= Seq(
  "com.badlogicgames.gdx" % "gdx" % libgdxVersion,
  "com.badlogicgames.gdx" % "gdx-backend-lwjgl3" % libgdxVersion,
  "com.badlogicgames.gdx" % "gdx-platform" % libgdxVersion,

  "com.badlogicgames.gdx" % "gdx-platform" % libgdxVersion classifier "natives-desktop"
)
javaOptions ++= Seq(
  "-XstartOnFirstThread"
)
javacOptions ++= Seq(
  "-Xlint",
  "-encoding", "UTF-8",
  "-source", "17",
  "-target", "17"
)
scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-rewrite", "-indent",
  "-encoding", "UTF-8",
)
exportJars := true

Compile / fork := true
run / baseDirectory := assetsDirectory.value
Compile / unmanagedResourceDirectories += assetsDirectory.value

lazy val assetsDirectory = settingKey[File]("Directory with game's assets")
