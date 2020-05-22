
ThisBuild / scalaVersion     := "2.12.10"

lazy val root = (project in file("."))
  .settings(
    name := "literal-identifiers",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.1.1" % Test
    ),
    fork in Test := true
  )
