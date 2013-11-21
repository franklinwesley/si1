name := "lab2"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

val appDependencies =  Seq (
  javaEbean,
  javaJdbc
)

play.Project.playJavaSettings
