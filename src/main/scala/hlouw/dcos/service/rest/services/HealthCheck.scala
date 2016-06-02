package hlouw.dcos.service.rest.services

import scala.concurrent.{ExecutionContext, Future}

object HealthCheck {

  def check()(implicit ec: ExecutionContext): Future[String] = {
    Future.successful("check")
  }
}
