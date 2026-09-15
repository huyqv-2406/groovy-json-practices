def executions = [
    [name: "TC001", browser: "Chrome",  status: "PASSED", duration: 320],
    [name: "TC002", browser: "Chrome",  status: "FAILED", duration: 1450],
    [name: "TC003", browser: "Firefox", status: "PASSED", duration: 620],
    [name: "TC004", browser: "Chrome",  status: "FAILED", duration: 2100],
    [name: "TC005", browser: "Firefox", status: "PASSED", duration: 410]
]

int totalTests = executions.size()

// Calculate failed tests
def failedTests = executions.findAll { test -> test.status == "FAILED" }
int failedCount = failedTests.size()
// Or using count: int failedCount = executions.count { test -> test.status == "FAILED" }

// Filter browser with the most failures
// Group failed tests by browser -> [ "Chrome": [TC002, TC004] ]
def failuresByBrowser = failedTests.groupBy { test -> test.browser }
// Convert to map of counts -> [ "Chrome": 2 ]
def failureCounts = failuresByBrowser.collectEntries { browser, tests ->
    [(browser): tests.size()]
}
// Find browser entry with maximum failures
def maxFailureEntry = failureCounts.max { test -> test.value }
String worstBrowser = maxFailureEntry ? "${maxFailureEntry.key} (${maxFailureEntry.value} failures)" : "None"

// Calculate the average execution time
long totalDuration = executions.collect { test -> test.duration }.sum() as long
double averageDuration = totalTests > 0 ? (totalDuration / totalTests) : 0.0

// Filter tests that took longer than one second
def slowTests = filterTestsByExecutionTime(1000)
def slowTestNames = slowTests.collect { test -> test.name }

// Calculate the pass rate
int passedCount = executions.count { test -> test.status == "PASSED" }
double passRate = totalTests > 0 ? (passedCount / totalTests) * 100 : 0.0

def filterTestsByExecutionTime = { threshold ->
    executions.findAll { test -> test.duration > threshold }
}


println "       TEST EXECUTION ANALYZER REPORT      "
println "1. Total tests executed: ${totalTests}"
println "   Tests failed        : ${failedCount}"
println "   Tests passed        : ${passedCount}"
println "-------------------------------------------"
println "2. Browser with most failures: ${worstBrowser}"
println "-------------------------------------------"
println "3. Average execution time    : ${String.format('%.2f', averageDuration)} ms"
println "-------------------------------------------"
println "4. Tests longer than 1s (>1000ms):"
if (slowTestNames) {
    slowTestNames.each { name ->
        def test = executions.find { it.name == name }
        println "   - ${name} (${test.duration} ms on ${test.browser})"
    }
} else {
    println "   (None)"
}
println "-------------------------------------------"
println "5. Pass rate                 : ${Math.round(passRate)}% (${passedCount}/${totalTests})"
println "==========================================="

