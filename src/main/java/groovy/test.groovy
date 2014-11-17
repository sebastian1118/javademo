package groovy

def TOMCAT_HOME = ""


if (args.length <= 0) {
    println "ERROR: Requires at least one WAR file to continue.";
    return;
}

println "Using:"
println "TOMCAT_HOME=" + TOMCAT_HOME;
println "Stopping tomcat..."

//println Runtime.getRuntime().exec(TOMCAT_HOME + "/bin/shutdown.sh").getText();

for (def filename : args) {
    def war = filename.split("/")[-1]
    println war
    def warNameWithVersion = war.split("\\.war")[0]
    println warNameWithVersion
    def warName = warNameWithVersion.split("##")[0]
    println warName
    def warVersion = warNameWithVersion.split("##")[-1]
    println warVersion

    println "*** Deploying [$war] to Tomcat[$TOMCAT_HOME] ***"
    println "WAR Name: $warName"
    println "WAR Version: $warVersion"

    File file = new File(filename)
    if (file.exists()) {
        println "Backing up"
    }

    File webapp = new File("/Users/tian/tmp")
    for (def f : webapp.findAll()) {
        println f
    }
}

