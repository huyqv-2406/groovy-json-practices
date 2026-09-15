// Validate Status Codes
boolean isSuccessful(int statusCode) {
    // Groovy range .. operator can be used to create a range of values.
    return statusCode in 200..299
}

// Classify Response Time
String classifyResponseTime(long milliseconds) {
    if (milliseconds < 500) {
        return "FAST"
    } else if (milliseconds <= 1000) {
        return "ACCEPTABLE"
    } else {
        return "SLOW"
    }
}

// --- Testing Function 1: isSuccessful ---
println "--- Testing isSuccessful ---"
println "Status 200: " + isSuccessful(200)
println "Status 201: " + isSuccessful(201)
println "Status 400: " + isSuccessful(400)
println "Status 500: " + isSuccessful(500)

// Assertions:
assert isSuccessful(200)
assert isSuccessful(201)
assert !isSuccessful(400)
assert !isSuccessful(500)


// --- Testing Function 2: classifyResponseTime ---
println "\n--- Testing classifyResponseTime ---"
println "450 ms  -> " + classifyResponseTime(450)
println "500 ms  -> " + classifyResponseTime(500)
println "800 ms  -> " + classifyResponseTime(800)
println "1000 ms -> " + classifyResponseTime(1000)
println "1250 ms -> " + classifyResponseTime(1250)

// Assertions for classifyResponseTime
assert classifyResponseTime(450) == "FAST"
assert classifyResponseTime(500) == "ACCEPTABLE"
assert classifyResponseTime(800) == "ACCEPTABLE"
assert classifyResponseTime(1000) == "ACCEPTABLE"
assert classifyResponseTime(1250) == "SLOW"

