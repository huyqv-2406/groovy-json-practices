def results = [
    [name: "Login",    status: "PASSED", duration: 450],
    [name: "Search",   status: "FAILED", duration: 1200],
    [name: "Checkout", status: "FAILED", duration: 800],
    [name: "Logout",   status: "PASSED", duration: 300]
]

// Total tests
int total = results.size()

// Filter passed tests
def passedTests = results.findAll { test -> test.status == "PASSED" }
int passedCount = passedTests.size()

// Filter failed tests and extract names
def failedTests = results.findAll { test -> test.status == "FAILED" }
int failedCount = failedTests.size()
def failedTestNames = failedTests.collect { test -> test.name }

// Calculate pass rate
double passRate = (total > 0) ? (passedCount / total) * 100 : 0
String passRateFormatted = "${Math.round(passRate)}%"

// Filter slow tests (duration > 1000 ms) and extract names
def slowTests = results.findAll { test -> test.duration > 1000 }
def slowTestNames = slowTests.collect { test -> test.name }

// --- Test Report ---
println "Total: ${total}"
println "Passed: ${passedCount}"
println "Failed: ${failedCount}"
println "Pass Rate: ${passRateFormatted}"
println()
println "Failed Tests:"
failedTestNames.each { name ->
    println "- ${name}"
}
println()
println "Slow Tests:"
slowTestNames.each { name ->
    println "- ${name}"
}

