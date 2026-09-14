def status = "FAILED"

if (status == "PASSED") {
    println "Test passed"
} else if (status == "SKIPPED") {
    println "Test skipped"
} else {
    println "Test failed"
}