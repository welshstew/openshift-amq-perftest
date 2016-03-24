def variablesToPass = []

def props = new Properties()
new File('defaults.properties').withInputStream {
    stream -> props.load(stream)
}

def propKeyToEnvKeyMap = [:]
def envKeyToPropKeyMap = [:]

def lowercaseList = props.keys().collect()

lowercaseList.each {
    def envVar = it.toString().replace('.', '_').toUpperCase()
    propKeyToEnvKeyMap.put(it, envVar)
    envKeyToPropKeyMap.put(envVar, it)
}

def env = System.getenv()
env.each {
    if(envKeyToPropKeyMap.containsKey(it.key)){
        //we have an env var - just check that the value is different from the default...
        if(it.value != props.getProperty(envKeyToPropKeyMap.get(it.key)).toString()){

            variablesToPass.add("-D" + envKeyToPropKeyMap.get(it.key) + "=" + it.value)

        }
    }
}

if(env.get("AMQTEST_TYPE") == 'producer'){
    //'activemq-perf:producer'
    println "mvn activemq-perf:producer " + variablesToPass.join(" ")
}else{
 //   'activemq-perf:consumer'
    println "mvn activemq-perf:consumer " + variablesToPass.join(" ")
}