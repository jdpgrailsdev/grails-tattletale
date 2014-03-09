/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.jboss.tattletale.Main

// Default list of comma separated report names to generate.
DEFAULT_REPORTS='multiplejars,unusedjar'

// The default TattleTale profiles to use for analysis.
DEFAULT_PROFILES='spring30,java6'

// Temporary directory of the expanded WAR
EXPANDED_ARCHIVE_DIR='target/_tattletale-work'

// Output directory for the generated reports
REPORTS_DIR = buildConfig.tattletale.reportsDir ?: 'target/tattletale-report'

eventCreateWarEnd = { warName, stagingDir ->
    try {
        if(isTattleTaleEnabled()) { 
		    ant.unzip(src: warName, dest:EXPANDED_ARCHIVE_DIR, overwrite:"true")
    	    executeTattleTale("${EXPANDED_ARCHIVE_DIR}/WEB-INF/lib")
		    event("StatusFinal", ["TattleTale report generation complete - view reports in ${new File(REPORTS_DIR).absolutePath}."])
		}
	} catch(e) {
		grailsConsole.warn("Unable to execute TattleTale reports on archive $warName: ${e.toString()}")
	} finally {
        ant.delete(dir:EXPANDED_ARCHIVE_DIR, failonerror:"false", verbose:"true")
	}
}

/**
 * Determines if generation of the TattleTale report has been enabled.
 * @returns {@code true} if the TattleTale report should be generated or {@code false} if it should not be generated.
 */
boolean isTattleTaleEnabled() {
    if (argsMap.containsKey('notattling')) {
        false
    } else {
		argsMap.containsKey('tattle') || buildConfig.tattletale.enabledByDefault
    } 
}

/**
 * Removes any reports that were previously generated.
 */
def cleanPrevious() {
   	ant.delete(dir:REPORTS_DIR, failonerror:"false", verbose:"true")
	ant.mkdir(dir:REPORTS_DIR)
}

/**
 * Executes the TattleTale report.
 * @param source The source directory containing JAR files.
 */
def executeTattleTale(def source) {
    cleanPrevious()
	def tattleTale = new Main()
	tattleTale.classloaderStructure = buildConfig.tattletale.classloader ?: null
	tattleTale.source = source
	tattleTale.destination = REPORTS_DIR
	tattleTale.reports = buildConfig.tattletale.reports ?: DEFAULT_REPORTS
	tattleTale.excludes = buildConfig.tattletale.excludes ?: null
	tattleTale.profiles = buildConfig.tattletale.profiles ?: DEFAULT_PROFILES
	tattleTale.execute()
}
