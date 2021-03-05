
 FROM flink:1.12-scala_2.12-java8
 #ADD ./target/scala-2.12/example-asse*.jar /opt/flink/usrlib/example.jar
 ADD ./target/scala-2.12/root*.jar /opt/flink/usrlib/root.jar

## MODE APPLICATION CLUSTER
 #FLINK_PROPERTIES="jobmanager.rpc.address: jobmanager"
 #docker run --rm --env FLINK_PROPERTIES="${FLINK_PROPERTIES}" -p 8081:8081 --name=jobmanager --network flink-network flink_with_example standalone-job
 #docker run --rm --env FLINK_PROPERTIES="${FLINK_PROPERTIES}" --name=taskmanager --network flink-network flink_with_example taskmanager

 # MODE session cluster
 #docker run --rm --name=jobmanager --network flink-network -p 8081:8081 -p 6123:6123 -p 6124:6124 -p 6125:6125  --env FLINK_PROPERTIES="${FLINK_PROPERTIES}" flink_with_example jobmanager
 #docker run --rm --name=taskmanager --network flink-network --env FLINK_PROPERTIES="${FLINK_PROPERTIES}" flink_with_example taskmanager
