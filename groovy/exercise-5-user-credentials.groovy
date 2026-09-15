// Exercise 5: User Credentials

def users = [
    clientA: [username: "userA", password: "passA"],
    clientB: [username: "userB", password: "passB"],
    clientC: [username: "userC", password: "passC"]
]

def client = "clientB"

// --- Part 1: Find and print username ---
def username = users[client]?.username
println "Username for ${client}: ${username}"

// --- Part 2: What happens if "clientD" doesn't exist? ---

// Approach 1: Direct access → returns null (no exception)
def missingUser = users["clientD"]
println "\nDirect access for clientD: ${missingUser}"     // null

// Approach 2: Safe navigation (?.) → avoids NullPointerException
def safeMissing = users["clientD"]?.username
println "Safe navigation for clientD: ${safeMissing}"    // null

// Approach 3: Elvis operator (?:) → provide a fallback/default value
def fallback = users["clientD"]?.username ?: "Guest"
println "With fallback for clientD: ${fallback}"         // Guest

// Approach 4: Explicit null check with a guard message
if (users["clientD"]) {
    println "clientD found: ${users['clientD'].username}"
} else {
    println "clientD does not exist in the map!"
}

