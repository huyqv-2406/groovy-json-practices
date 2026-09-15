def tests = [
    [name: "Login",    status: "PASSED"],
    [name: "Checkout", status: "FAILED"],
    [name: "Search",   status: "PASSED"],
    [name: "Payment",  status: "FAILED"]
]

// Approach 1

// Step 1: Filter tests where status is "FAILED"
def failedTests = tests.findAll { test ->
    test.status == "FAILED"
}
println "Step 1 (Filtered Maps): ${failedTests}"

// Step 2: Transform (collect) each map into just its name string
def failedNames = failedTests.collect { test ->
    test.name
}
println "Step 2 (Extracted Names): ${failedNames}"

// Approach 2: Chained Pipeline

println "\n--- Chained Pipeline (findAll + collect) ---"
def result = tests
    .findAll { test -> test.status == "FAILED" }
    .collect { test -> test.name }

println "Failed Test Names: ${result}"

