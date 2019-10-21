import Dependencies._

name := "spark-streaming-jdbc-source"

version := "0.1"

scalaVersion := "2.11.12"

parallelExecution in ThisBuild := false

libraryDependencies ++= Seq(sparkCore % "provided", sparkSql % "provided", scalatest % "test", h2database % "test", sparkTestingBase % "test")

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

fork in Test := true

logBuffered in Test := false

scalacOptions ++= Seq(
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-encoding",
  "utf-8", // Specify character encoding used by source files.
  "-explaintypes", // Explain type errors in more detail.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials", // Existential types (besides wildcard types) can be written and inferred
  "-language:experimental.macros", // Allow macro definition (besides implementation and application)
  "-language:higherKinds", // Allow higher-kinded types
  "-language:implicitConversions", // Allow definition of implicit functions called views
  "-unchecked", // Enable additional warnings where generated code depends on assumptions.
  "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
  "-Xfatal-warnings", // Fail the compilation if there are any warnings.
  "-Xfuture", // Turn on future language features.
  "-Yno-adapted-args", // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
  "-Ywarn-dead-code", // Warn when dead code is identified.
  "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
  "-Ywarn-infer-any", // Warn when a type argument is inferred to be `Any`.
  "-Ywarn-nullary-override", // Warn when non-nullary `def f()' overrides nullary `def f'.
  "-Ywarn-nullary-unit", // Warn when nullary methods return Unit.
  "-Ywarn-numeric-widen", // Warn when numerics are widened.
  "-Ywarn-unused", // Warn is unused.
  "-Ywarn-value-discard" // Warn when non-Unit expression results are unused.
)

logBuffered in Test := false

//
//lazy val commonSettings = Seq(
//  scalacOptions ++= compilerOptions,
//  parallelExecution in Test := false,
//  fork := true,
//  ,
//  resolvers ++= Seq(
//    "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/",
//    "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
//    "Second Typesafe repo" at "http://repo.typesafe.com/typesafe/maven-releases/",
//    "Artima Maven Repository" at "http://repo.artima.com/releases",
//    "hdpSpark" at "http://repo.hortonworks.com/content/repositories/releases/",
//    "datanucleus" at "http://www.datanucleus.org/downloads/maven2/",
//    Resolver.sonatypeRepo("public")
//  )
//)

assemblyMergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf")     => MergeStrategy.discard
  case m if m.toLowerCase.matches("meta-inf.*\\.sf$") => MergeStrategy.discard
  case "log4j.properties"                             => MergeStrategy.discard
  case m if m.toLowerCase.startsWith("meta-inf/services/") =>
    MergeStrategy.concat
  case _ => MergeStrategy.first
}
