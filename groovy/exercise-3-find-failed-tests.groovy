def results = [
        "Login - PASSED",
        "Checkout - FAILED",
        "Search - PASSED",
        "Payment - FAILED"
]

// Approach 1: Manual Loop
println("Approach 1: ")
for (result in results) {
    if (result.contains("FAILED")) {
        println result
    }
}

// Approach 2: findAll
println("Approach 2: ")
def failedTests = results.findAll { String result -> result.contains("FAILED") }
failedTests.each { String result -> println result }
