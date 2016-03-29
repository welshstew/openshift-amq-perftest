FROM welshstew/fis-groovy-openshift:1.0

ENV AMQTEST_TYPE producer
ENV MAVEN_OPTS "-Xmx2g -Xms1g"

ADD configuration /tmp
ADD scripts /tmp

WORKDIR /tmp

CMD ["groovy", "bootstrap.groovy"]