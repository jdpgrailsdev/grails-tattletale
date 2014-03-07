Grails TattleTale Plugin
=================

This plugin will execute [JBoss Tattletale](http://www.jboss.org/tattletale) reports on a Grails application.  [Tattletale](http://www.jboss.org/tattletale) reports are useful for inspecting the dependencies included in a packaged application for things like unused JAR files, duplicate classes on the classpath and other inconsitencies that may cause issues at runtime.

To use this plugin in your application, add the following dependency to the `plugins` closure in your application's `grails-app/conf/BuildConfig.groovy` file:

	build 'org.grails.plugins:tattletale:1.0.0'


## Usage
By default, the [TattleTale](http://www.jboss.org/tattletale) reports will be automatically be generated after packaging of the WAR file has completed, if it has been enabled.  There are two ways to enable the [TattleTale](http://www.jboss.org/tattletale) report generation.  The first is to include the `-tattle` command line argument when packaging the application:

    grails war -tattle

The second approach is to add the `enableByDefault` configuration property to your application's `grails-app/conf/BuildConfig.groovy` file:

	tattletale {
		enableByDefault = true
	}

The plugin also supports the explicit disabling of the [TattleTale](http://www.jboss.org/tattletale) reports:

    grails war -notattling

This approach will override the `enableByDefault` configuration property.

## Configuration Options

|Property|Description|Default Value|
|:-------|:----------|:------------|
|**classloader**|Specifies which classloader structure that should be used when scanning the archives.||
|**enabledByDefault**|Enables the generation of [TattleTale](http://www.jboss.org/tattletale) reports by default when packaging a Grails application|*false*|
|**excludes**|Comma separated list of JAR files to be excluded from the reports||
|**profiles**|Comma separated list of profiles to enabled when generating [TattleTale](http://www.jboss.org/tattletale) reports|*spring30,java6*|
|**reports**|Comma separated list of [TattleTale](http://www.jboss.org/tattletale) reports to be executed on the Grails application|*multiplejars,unusedjar*|
|**reportsDir**|The output location for the generated reports|*target/tattletale-report*|

See the [TattleTale configuration documentation](http://docs.jboss.org/tattletale/userguide/1.1/html/gettingstarted.html#configuration) for more details.

## Building the plugin

To build the plugin locally, follow these steps:

1. Clone the `grails-tattletale` repository from GitHub:

		> git clone https://github.com/jdpgrailsdev/grails-tattletale.git

2. Change directory to the checked out project:

		> cd grails-tattletale
		
3.  Package and install the binary in your local Maven repository:

		> grails maven-install


## Release History:

* 1.0.0
  * Initial release of the Grails JBoss TattleTale plugin.
