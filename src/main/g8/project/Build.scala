import sbt._
import sbt.Keys._

object Dependencies {
  val specs2 = "org.specs2" %% "specs2" % "2.3.10" % "test"
  val all = Seq(specs2)
}

object Resolvers {
  val snapshots = "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
  val releases = "releases"  at "http://oss.sonatype.org/content/repositories/releases"
  val all = Seq(snapshots, releases)
}

object Build extends Build {

  lazy val $name;format="camel"$ = Project(
    id = "$name;format="norm"$",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "$name$",
      organization := "$organization$",
      version := "$version$",
      scalaVersion := "$scala_version$",
      libraryDependencies ++= Dependencies.all,
      resolvers ++= Resolvers.all
      // add other settings here
    )
  )
}
