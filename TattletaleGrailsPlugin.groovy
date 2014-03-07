class TattletaleGrailsPlugin {
    // the plugin version
    def version = "1.0.0"
	// the Maven group ID
	def groupId = 'org.grails.plugins'
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.3 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Grails Tattletale Plugin"
    def author = "Jonathan Pearlin"
    def description = '''\
Grails plugin that adds support for generating JBoss Tattletale reports.  For more information, see http://www.jboss.org/tattletale. 
'''
    def documentation = "http://github.com/jdpgrailsdev/grails-tattletale"
    def license = "APACHE"
	def issueManagement = [ system: "github", url: "http://github.com/jdpgrailsdev/grails-tattletale/issues" ]
	def scm = [ url: "http://github.com/jdpgrailsdev/grails-tattletale" ]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { ctx ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
