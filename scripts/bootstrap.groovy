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

// Build the maven run command

def execString = ""
def execList = []

execList.add("mvn")

if(env.get("AMQTEST_TYPE") == 'producer'){
    //'activemq-perf:producer'
    execString = "mvn activemq-perf:producer" + variablesToPass.join(" ")
    execList.add("activemq-perf:producer")

}else{
    execString = "mvn activemq-perf:consumer" + variablesToPass.join(" ")
    execList.add("activemq-perf:consumer")
}

execList.add("--settings")
execList.add("/tmp/settings.xml")
execList.addAll(variablesToPass)

println execString

def process= new ProcessBuilder(execList).redirectErrorStream(true).start()
process.inputStream.eachLine {println it}




