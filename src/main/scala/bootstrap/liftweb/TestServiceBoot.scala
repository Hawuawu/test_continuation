package bootstrap.liftweb

import net.liftweb._
import util._
import Helpers._

import common._
import http._
import rest.RestContinuation
import sitemap._
import Loc._

import actors.Actor

class TestServiceBoot extends Bootable  {

  def boot {

    case class DoThis(f: (String) => Unit)

    val actor = new Actor() {
      def act() {
        react {
          case DoThis(function) => function("Doing continuation, my lord! :)")
        }
      }
    }


    actor.start()


    // where to search snippet
    LiftRules.addToPackages("com.spinoco.web.testservices.continuation")

    LiftRules.uriNotFound.prepend(NamedPF("404handler") {
      case (req, failure) => NotFoundAsTemplate(
        ParsePath(List("exceptions", "404"), "html", false, false))
    })

    // set character encoding
    LiftRules.early.append(_.setCharacterEncoding("windows-1252"))

    LiftRules.dispatch.prepend({
      case Req(List("dosomething"), _, _) => () => Full(PlainTextResponse("Doing something, my lord! :)"))

      case Req("test_cont" :: _, _, _) =>
        RestContinuation.async {
          satisfy => {
            satisfy(XmlResponse(<tag>ok</tag>))
          }
        }

    })
  }
}


