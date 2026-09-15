def results = [
        "PASSED",
        "FAILED",
        "PASSED",
        "FAILED",
        "PASSED",
        "SKIPPED"
]

def counts = [PASSED: 0, FAILED: 0, SKIPPED: 0]

for (result in results) {
    counts[result]++
}

println "Passed: ${counts.PASSED}"
println "Failed: ${counts.FAILED}"
println "Skipped: ${counts.SKIPPED}"