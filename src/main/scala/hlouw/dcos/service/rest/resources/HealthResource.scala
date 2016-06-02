package hlouw.dcos.service.rest.resources

import akka.actor.ActorSystem
import akka.http.scaladsl.marshalling.ToResponseMarshallable
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.stream.Materializer
import hlouw.dcos.service.rest.services.HealthCheck

import scala.concurrent.ExecutionContextExecutor

class HealthResource(implicit system: ActorSystem, executor: ExecutionContextExecutor, materializer: Materializer) {

  val routes =
    path("ping") {
      complete("pong")
    } ~
    path("health") {
      complete {
        HealthCheck.check().map[ToResponseMarshallable] {
          case s => StatusCodes.OK -> s
        }
      }
    }

}
