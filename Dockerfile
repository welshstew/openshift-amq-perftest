FROM welshstew/fis-groovy-openshift:latest

ADD configuration/settings.xml /tmp/settings.xml

ADD scripts/bootstrap.groovy /tmp/bootstrap.groovy

WORKDIR /tmp

CMD ["groovy", "bootstrap.groovy"]