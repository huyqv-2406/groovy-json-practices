def testCases = [
    [name: "Login",    type: "UI",  priority: "High"],
    [name: "Get User", type: "API", priority: "High"],
    [name: "Search",   type: "UI",  priority: "Low"],
    [name: "Payment",  type: "API", priority: "High"]
]

// Approach 1: Manual for-in loop
println "--- Approach 1: Manual Loop ---"
for (testCase in testCases) {
    if (testCase.type == "API" && testCase.priority == "High") {
        println testCase.name
    }
}

// Approach 2: findAll
println "\n--- Approach 2: findAll ---"
def highPriorityApiTests = testCases.findAll { testCase ->
    testCase.type == "API" && testCase.priority == "High"
}

highPriorityApiTests.each { testCase ->
    println testCase.name
}

