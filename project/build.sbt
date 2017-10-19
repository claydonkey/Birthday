import sbt._
import sbt.Keys._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import scalariform.formatter.preferences._

name := "birthday"

organization := "com.claydonkey"

version := "1.0.1"

scalaVersion := "2.10.6"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

resolvers ++= Seq(
	"Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases",
	"Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
	"Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/")

mainClass in (Compile, run) := Some("com.claydonkey.Birthday.main")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
.setPreference(AlignSingleLineCaseStatements, true)
.setPreference(RewriteArrowSymbols, false)
.setPreference(AlignParameters, true)
.setPreference(AlignSingleLineCaseStatements, true)
.setPreference(DoubleIndentClassDeclaration, true)
.setPreference(IndentSpaces, 2)

