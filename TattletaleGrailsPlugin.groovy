class TattletaleGrailsPlugin {
    // the plugin version
    def version = "1.0.0"
	// the Maven group ID
	def groupId = 'org.grails.plugins'
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
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
}
