# openshift-amq-perftest

Something with maven in it, and a pom in order to run amq perf tests.

The base java-fis image comes with maven pre-bundled.  So hoping to build this from s2i.


	oc new-app https://github.com/welshstew/openshift-amq-perftest.git --strategy=docker --name=maven-pod


