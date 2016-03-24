# openshift-amq-perftest

Something with maven in it, and a pom in order to run amq perf tests.

The base java-fis image comes with maven pre-bundled.  So hoping to build this from s2i.


	oc new-app https://github.com/welshstew/openshift-amq-perftest.git --strategy=docker --name=maven-pod

In temp directory:

	mvn activemq-perf:consumer -Dfactory.brokerURL=tcp://broker-amq-tcp:61616 -Dfactory.userName=admin -Dfactory.password=admin

	mvn activemq-perf:producer -Dfactory.brokerURL=tcp://broker-amq-tcp:61616 -Dfactory.userName=admin -Dfactory.password=admin


## TODO:

- Create a template with 2 replication controllers.  Ensure the replication controller allows the pod to die cleanly (and not recreate it on death)
- 1 replication controller for the activemq producer
- 1 replication controller for the activemq consumer
- write some bash to loop over the sysTest, producer, consumer envivronment variables and construct the run command

- for i in _ {a..z} {A..Z}; do eval "echo \${!$i@}" ; done | xargs printf "%s\n"

for i in _ {a..z} {A..Z}; do
   for var in `eval echo "\\${!$i@}"`; do
      echo "$var=${!var}"
      # you can test if $var matches some criteria and put it in the file or ignore
   done 
done


## Plain Old Docker Build
	
	docker build -t welshstew/openshift-amq-perftest:1.0 .
	


	