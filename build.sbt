val Http4sVersion = "1.0.0-M38"
val CirceVersion = "0.14.3"
val MunitVersion = "0.7.29"
val LogbackVersion = "1.2.11"
val MunitCatsEffectVersion = "1.0.7"
val DerevoVersion = "0.13.0"
val NewtypeVersion = "0.4.4"

ThisBuild / evictionErrorLevel := Level.Warn

lazy val root = (project in file("."))
  .settings(
    organization := "dev.haalto",
    name := "cats-http4s-todos",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-ember-server" % Http4sVersion,
      "org.http4s" %% "http4s-ember-client" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "io.circe" %% "circe-core" % CirceVersion,
      "io.circe" %% "circe-generic" % CirceVersion,
      "org.scalameta" %% "munit" % MunitVersion % Test,
      "org.typelevel" %% "munit-cats-effect-3" % MunitCatsEffectVersion % Test,
      "ch.qos.logback" % "logback-classic" % LogbackVersion % Runtime,
      "org.scalameta" %% "svm-subs" % "20.2.0",
      "io.estatico" %% "newtype" % NewtypeVersion,
      "tf.tofu" %% "derevo-core" % DerevoVersion,
      "tf.tofu" %% "derevo-cats" % DerevoVersion,
      "tf.tofu" %% "derevo-circe-magnolia" % DerevoVersion
    ),
    addCompilerPlugin(
      "org.typelevel" %% "kind-projector" % "0.13.2" cross CrossVersion.full
    ),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    scalacOptions ++= Seq(
      "-Ymacro-annotations",
      "-Wconf:cat=unused:info"
    ),
    testFrameworks += new TestFramework("munit.Framework")
  )
