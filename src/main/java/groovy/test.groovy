package groovy

import groovy.io.FileType

import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

//*****************************************************************************
// change as needed
//*****************************************************************************
def TOMCAT_HOME = "/Users/tian/tmp"
def BACKUP_DIR = "$TOMCAT_HOME" + File.separator + "backupWars"
//*****************************************************************************

if (args.length <= 0) {
    println "Requires at least one WAR file to continue.";
    return;
}

println "Using:"
println "TOMCAT_HOME = $TOMCAT_HOME"
println "BACKUP_DIR = $BACKUP_DIR"
println ""

println "Stopping tomcat..."
//println Runtime.getRuntime().exec(TOMCAT_HOME + "/bin/shutdown.sh").getText();
println ""

for (def arg : args) {
    def filePart = arg.split("/")[-1]

    def filePath = arg.split(">>")[0];
    def arr = filePart.split(">>");
    def nameVersionWar = arr[0];



    def nameVersion = nameVersionWar.split("\\.war")[0]
    def name = nameVersion.split("##")[0]
    def version = nameVersion.split("##")[-1]

    def contextName = '';
    if (arr.length == 2) {
        contextName = arr[-1];
    } else {
        contextName = name;
    }

    def deployFileName;
    if (contextName != '') {
        deployFileName = contextName + "##" + version + ".war";
    }
    println "*** Deploying [$nameVersionWar] as [$deployFileName] to Tomcat[$TOMCAT_HOME] " + "***"
    println "WAR Name: $nameVersionWar"
    println "WAR Version: $version"
    println "WAR ContextPath: /$contextName"

    File file = new File("$TOMCAT_HOME/webapps/$deployFileName")

    def webappsDirectory = new File("$TOMCAT_HOME/webapps/")
    webappsDirectory.traverse(type: FileType.FILES, nameFilter: ~/${contextName}(##.*)?\.war$/) {
        println "Backing up $it"
        def old = it.getName()
        Files.move(Paths.get(it.absolutePath),
                Paths.get(("$BACKUP_DIR" + File.separator + "$old").toString()),
                StandardCopyOption.REPLACE_EXISTING);
    }

    println "Moving '$filePath' -> '$file.absolutePath'"
    Files.move(Paths.get(filePath), Paths.get(file.absolutePath));

}

println("Deployment completed.")

