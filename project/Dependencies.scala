import sbt._

object Dependencies {
  val akkaV         = "2.4.6"
  val scalaTestV    = "2.2.6"
  val akkaHttpJsonV = "1.5.2"
  val json4sV       = "3.3.0"

  val all = Seq(
    "com.typesafe.akka"     %% "akka-actor"                           % akkaV,
    "com.typesafe.akka"     %% "akka-stream"                          % akkaV,
    "com.typesafe.akka"     %% "akka-http-core"                       % akkaV,
    "com.typesafe.akka"     %% "akka-http-experimental"               % akkaV,
    "com.typesafe.akka"     %% "akka-http-testkit"                    % akkaV % "test",
    "org.scalatest"         %% "scalatest"                            % scalaTestV % "test",
    "de.heikoseeberger"     %% "akka-http-json4s"                     % akkaHttpJsonV,
    "org.json4s"            %% "json4s-core"                          % json4sV,
    "org.json4s"            %% "json4s-native"                        % json4sV,
    "org.json4s"            %% "json4s-ext"                           % json4sV
  )
}