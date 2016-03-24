

/**
 * Created by swinchester on 21/03/2016.
 */

println 'hello'

def env = System.getenv()

def envVarDefaults = [:]

def envVarMap = [
        AMQ_FACTORY_BROKERURL:'factory.brokerURL',
        AMQ_FACTORY_USERNAME:'factory.userName',
        AMQ_FACTORY_PASSWORD:'factory.password',
        AMQ_SYSTEST_CLIENTPREFIX:'sysTest.clientPrefix',
        AMQ_PRODUCER_SESSTRANSACTED: 'producer.sessTransacted',
        AMQ_PRODUCER_SESSACKMODE: 'producer.sessAckMode',
        AMQ_PRODUCER_COMMITAFTERXMSGS: 'producer.commitAfterXMsgs',
        AMQ_PRODUCER_DESTNAME: 'producer.destName',
        AMQ_PRODUCER_DESTCOMPOSITE: 'producer.destComposite',
        AMQ_PRODUCER_DELIVERYMODE: 'producer.deliveryMode',
        AMQ_PRODUCER_MESSAGESIZE: 'producer.messageSize',
        AMQ_PRODUCER_MSGFILENAME: 'producer.msgFileName',
        AMQ_PRODUCER_CREATENEWMSG: 'producer.createNewMsg',
        AMQ_PRODUCER_SENDDELAY: 'producer.sendDelay',
        AMQ_PRODUCER_SENDTYPE: 'producer.sendType',
        AMQ_PRODUCER_SENDCOUNT: 'producer.sendCount',
        AMQ_PRODUCER_SENDDURATION: 'producer.sendDuration',
        AMQ_PRODUCER_HEADER: 'producer.header',
]

//sysTest.clientPrefix=whatever
//sysTest.numClients=1
//sysTest.totalDests=1
//sysTest.destDistro=all
//sysTest.reportDir=./
//sysTest.reportName=null
//sysTest.reportType=xml
//sysTest.samplers=tp,cpu
//sysTest.spiClass=org.apache.activemq.tool.spi.ActiveMQClassLoaderSPI

//producer.sessTransacted=false
//producer.sessAckMode
//producer.commitAfterXMsgs
//producer.destName
//producer.destComposite
//producer.deliveryMode
//producer.messageSize
//producer.msgFileName
//producer.createNewMsg
//producer.sendDelay
//producer.sendType
//producer.sendCount
//producer.sendDuration
//producer.header

println "mvn activemq-perf:consumer -Dfactory.doStuff=things"

env.each { var ->
    println var

//    attempt to build the following run commands from the dir containing the pom.xml
//    mvn activemq-perf:consumer -Dfactory.brokerURL=tcp://broker-amq-tcp:61616 -Dfactory.userName=admin -Dfactory.password=admin
//    mvn activemq-perf:producer -Dfactory.brokerURL=tcp://broker-amq-tcp:61616 -Dfactory.userName=admin -Dfactory.password=admin
}


