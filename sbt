exec java -d32 -XX:PermSize=256M -XX:MaxPermSize=512  -Xss10M -Xmx1g ${SBT_OPTS} -Djava.library.path=/usr/local/lib -jar `dirname $0`/sbt-launch.jar "$@"
