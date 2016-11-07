lazy val commonSettings = Seq(
  organization := "$organization$",
  version := "$version$",
  scalaVersion := "$scala_version$",
  scalacOptions ++= Seq(
    "-deprecation",
    "-feature",
    "-unchecked",
    "-Xlint"
  ),
  shellPrompt := { state =>
    val branch = if (file(".git").exists) {
      "git branch".lines_!.find { _.head == '*' }.map { _.drop(1) }.getOrElse("")
    } else ""
    Project.extract(state).currentRef.project + branch + " > "
  }
)

lazy val root = (project.in(file(".")))
  .settings(commonSettings: _*)
  .settings(
    name := "$name$",
    resolvers ++= {
      Seq(
      )
    },
    libraryDependencies ++= {
      Seq(
        // Test
        "org.scalactic" %% "scalactic" % "3.0.0",
        "org.scalatest" %% "scalatest" % "3.0.0" % "test",
        "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",

        // Logger
        "ch.qos.logback" % "logback-classic" % "1.1.7",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
      )
    }
  )

initialCommands := "import $package$._"
