name := "spark-amazon-s3-parquet"

scalaVersion := "2.12.12"

val sparkVersion = "3.0.1"

libraryDependencies += "log4j" % "log4j" % "1.2.17"
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.hadoop" % "hadoop-aws" % "3.3.0"
libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "3.3.0"

resolvers += "Cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"


assemblyMergeStrategy in assembly := {
  case PathList("org","aopalliance", xs @ _*) => MergeStrategy.last
  case PathList("javax", "inject", xs @ _*) => MergeStrategy.last
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case "overview.html" => MergeStrategy.rename
  case "about.html" => MergeStrategy.rename
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case PathList("changelog.txt") => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)}



assemblyJarName in assembly := "spark-amazon-s3-parquet.jar"
