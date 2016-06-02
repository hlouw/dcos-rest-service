package hlouw.dcos.service.rest.resources

import akka.actor.ActorSystem
import akka.http.scaladsl.marshalling.ToResponseMarshallable
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import hlouw.dcos.service.rest.services.HealthCheck

import scala.concurrent.ExecutionContextExecutor

class HealthResource(router: String)(implicit system: ActorSystem, executor: ExecutionContextExecutor, materializer: ActorMaterializer) {

  val routes =
    path("ping") {
      complete("pong")
    } ~
    path("health") {
      complete {
        HealthCheck.pingDependencies(router).map[ToResponseMarshallable] {
          case s => StatusCodes.OK -> s
        }
      }
    }

}
