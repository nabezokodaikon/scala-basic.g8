lazy val commonSettings = Seq(
  organization := "$organization$",
  name := "$name$",
  version := "$version$",
  scalaVersion := "$scala_version$",
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-unchecked" /*,
    "-Xlint",
    "-Ywarn-unused",
    "-Ywarn-unused-import",
    "-Ywarn-value-discard" */
  )
)

lazy val root = (project.in(file(".")))
  .settings(commonSettings: _*)
  .settings(
    resolvers ++= {
      Seq(
      )
    },
    libraryDependencies ++= {
      Seq(
        // Logger
        "ch.qos.logback" % "logback-classic" % "1.2.3",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
      ) ++
      Seq(
        // Test
        "org.scalactic" %% "scalactic" % "3.0.5",
        "org.scalatest" %% "scalatest" % "3.0.5" % "test",
        "org.scalacheck" %% "scalacheck" % "1.14.0" % "test",
      )
    }
  )

initialCommands in console := "import $package$._"
