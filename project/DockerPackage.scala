import com.typesafe.sbt.packager.Keys._
import com.typesafe.sbt.packager.archetypes.JavaServerAppPackaging
import com.typesafe.sbt.packager.docker._
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport.Docker
import sbt._

object DockerPackage {

  private lazy val setupAlpine = Seq(
    Cmd("RUN", "apk --update add openjdk8-jre"),
    Cmd("RUN", "apk --update add bash")
  )

  private val settings = Seq(
    dockerBaseImage := "alpine",
    dockerRepository := Some("hlouw"),
    packageName in Docker := "dcos-rest-service",
    dockerExposedPorts := Seq(8080),
    dockerCommands := dockerCommands.value.head +: setupAlpine ++: dockerCommands.value.tail
  )

  implicit class DockerProject(project: Project) {

    def withDocker: Project = project.settings(settings: _*)
      .enablePlugins(JavaServerAppPackaging, DockerPlugin)
  }
}