package hlouw.dcos.service.rest.services

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.model.headers.Host
import akka.http.scaladsl.model.{HttpRequest, HttpResponse}
import akka.stream.ActorMaterializer

import scala.concurrent.{ExecutionContext, Future}

object HealthCheck {

  def check()(implicit ec: ExecutionContext): Future[String] = {
    Future.successful("check")
  }

  def pingDependencies(router: String)
                      (implicit ec: ExecutionContext, system: ActorSystem, materializer: ActorMaterializer): Future[String] = {
    val request = HttpRequest(uri = s"$router/ping", headers = List(Host("estimation-service.paym")))
    println(s"Sending request... $request")
    Http().singleRequest(request).map[String] {
      case HttpResponse(OK, _, entity, _) => entity.toString
      case _ => "Failure"
    }
  }
}
