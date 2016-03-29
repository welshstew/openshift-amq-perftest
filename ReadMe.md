# openshift-amq-perftest

Based on [https://github.com/welshstew/fis-groovy-openshift](https://github.com/welshstew/fis-groovy-openshift), a Docker Image containing jdk8, groovy, and maven.

### What does it do?

Uses groovy to parse a number of environment variables and ensures these are passed to the amq perf tests plugin.  For more information on the perf-test plugin go to [http://activemq.apache.org/activemq-performance-module-users-manual.html](http://activemq.apache.org/activemq-performance-module-users-manual.html)

In temp directory:

	mvn activemq-perf:consumer -Dfactory.brokerURL=tcp://broker-amq-tcp:61616 -Dfactory.userName=admin -Dfactory.password=admin

	mvn activemq-perf:producer -Dfactory.brokerURL=tcp://broker-amq-tcp:61616 -Dfactory.userName=admin -Dfactory.password=admin

Please see the DockerFile and the defaults.properties for the environment variables.

## TODO:

- Create a template with 2 replication controllers.  Ensure the replication controller allows the pod to die cleanly (and not recreate it on death)
- 1 replication controller for the activemq producer
- 1 replication controller for the activemq consumer
- write some bash to loop over the sysTest, producer, consumer envivronment variables and construct the run command

## Plain Old Docker Build
	
	docker build -t welshstew/openshift-amq-perftest:1.0 .


## Openshift build/run

	oc new-app https://github.com/welshstew/openshift-amq-perftest.git -e FACTORY_BROKERURL="tcp://broker-amq-tcp:61616" -e FACTORY_USERNAME="admin" -e FACTORY_PASSWORD="admin" -e MAVEN_OPTS="-Xmx2g -Xms1g" --strategy=docker