#FROM welshstew/fis-groovy-openshift:1.0
FROM registry.access.redhat.com/jboss-fuse-6/fis-java-openshift:1.0

USER root

ENV GROOVY_VERSION 2.3.9

RUN yum -y install wget

RUN cd /tmp && \
    wget http://dl.bintray.com/groovy/maven/groovy-binary-${GROOVY_VERSION}.zip && \
    unzip groovy-binary-${GROOVY_VERSION}.zip && \
    mv groovy-${GROOVY_VERSION} /opt/groovy && \
    rm groovy-binary-${GROOVY_VERSION}.zip

ENV GROOVY_HOME /opt/groovy
ENV PATH $GROOVY_HOME/bin/:$PATH

USER jboss

ENV AMQTEST_TYPE producer
ENV MAVEN_OPTS "-Xmx2g -Xms1g"

ADD configuration /tmp
ADD scripts /tmp

WORKDIR /tmp

CMD ["groovy", "bootstrap.groovy"]