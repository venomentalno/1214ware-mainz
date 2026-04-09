#!/bin/sh

##############################################################################
# Gradle start up script for POSIX
##############################################################################

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`
DIRNAME=`dirname "$0"`
APP_HOME=`cd "$DIRNAME" >/dev/null && pwd`

CLASSPATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar

JAVA_HOME="${JAVA_HOME:-/usr/lib/jvm/java-21-openjdk-amd64}"
JAVA_EXE="$JAVA_HOME/bin/java"

if [ ! -x "$JAVA_EXE" ]; then
    JAVA_EXE="java"
fi

exec "$JAVA_EXE" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"
