seq(webSettings :_*)

name := "helloworld"

version := "1.0"

scalaVersion := "2.8.1"

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies ++= Seq(
    "net.liftweb" %% "lift-webkit" % "2.3" % "compile",
    "org.eclipse.jetty" % "jetty-webapp" % "7.3.0.v20110203" % "container",
    "ch.qos.logback" % "logback-classic" % "0.9.26"
    )