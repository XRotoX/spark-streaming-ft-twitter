name := "twitter-spark"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += Resolver.sonatypeRepo("releases")


libraryDependencies ++= Seq(
"org.apache.spark" %% "spark-core" % "2.2.1",
"org.apache.spark" %% "spark-streaming" % "2.2.1",
"org.apache.spark" %% "spark-sql" % "2.2.1",
"org.twitter4j" % "twitter4j-core" % "4.0.4",
"org.twitter4j" % "twitter4j-stream" % "4.0.4",
"org.apache.bahir" %% "spark-streaming-twitter" % "2.2.1"
)
