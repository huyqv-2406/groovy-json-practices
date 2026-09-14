def responseTime = 1250

def classification
if (responseTime < 500) {
    classification = "FAST"
} else if (responseTime <= 1000) {
    classification = "ACCEPTABLE"
} else {
    classification = "SLOW"
}

println classification