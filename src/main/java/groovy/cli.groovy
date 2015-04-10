#!/usr/bin/env groovy
package groovy

def cli = new CliBuilder(
        usage: 'nexus -d|-c [-dev -debug]',
        header: '\nAvailable options (use -h for help):\n',
        footer: '\n'
)

cli.dev(longOpt: 'dev', 'dev environment', required: false)
cli.debug(longOpt: 'debug', 'debug mode', required: false, argName: "port", args: 1)
cli.c(longOpt: 'connector', 'run connector', argName: 'dir', required: false)
cli.d(longOpt: 'dispatcher', 'run dispatcher', argName: 'foo', required: true)
cli.h(longOpt: 'help', 'show this information', required: false)

def opt = cli.parse(args)
if (!opt) {
    return
}
if (opt.h) {
    cli.usage();
    return
}

def dev = ""
if (opt.dev) {
    dev = '-Ddev=true'
}

def debug = ""
if (opt.debug) {
    debug = "-Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=${opt.debug},suspend=y"
}

component = ''
if (opt.d) {
    component = 'dispatcher'
} else if (opt.c) {
    component = 'connector'
} else {
    cli.usage()
}

Process p = "java $dev $debug lib/nexus-$component-1.3.1.jar &".execute()
p.consumeProcessOutput(System.out, System.err)

Thread.sleep(100000)
exit
