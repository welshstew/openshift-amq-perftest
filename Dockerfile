FROM registry.access.redhat.com/jboss-fuse-6/fis-java-openshift:latest

MAINTAINER Stu <stuart.winchester@gmail.com>

ADD script/run.sh /tmp/run.sh
RUN chmod +x /tmp/run.sh

CMD ["/tmp/run.sh"]