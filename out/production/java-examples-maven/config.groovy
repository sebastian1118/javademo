// We can group settings.
// The following settings are created:
// app.version, app.setting1, app.setting2, app.setting3, app.date, app.active
sss {
    version = "1.0"

    // We can use Java objects
    date = new Date()
    debug = true
}

environments {
    development {
        sss {
            debug = true
        }
    }
    production {
        sss {
            debug = false
        }
    }
}



