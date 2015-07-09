import sbt._
import sbt.Keys._

object Dependencies {
  val scalatest="org.scalatest" % "scalatest_2.11" % "$scalatest_version$" % "test"
  val all = Seq(scalatest)
}

object Resolvers {
  val snapshots = "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
  val releases = "releases"  at "http://oss.sonatype.org/content/repositories/releases"
  val all = Seq(snapshots, releases)
}

object Format {
  import com.typesafe.sbt.SbtScalariform._

  lazy val all = scalariformSettings ++ Seq(
    ScalariformKeys.preferences in Compile := formattingPreferences,
    ScalariformKeys.preferences in Test := formattingPreferences
  )

  def formattingPreferences = {
    import scalariform.formatter.preferences._
    FormattingPreferences()
      .setPreference(AlignParameters, true)
      .setPreference(AlignSingleLineCaseStatements, false)
  }
}

object Options {
  lazy val all = Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Xlint"
  )
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
      scalacOptions := Options.all,
      libraryDependencies ++= Dependencies.all,
      resolvers ++= Resolvers.all
      // add other settings here
    ) ++ Format.all
  )
}
