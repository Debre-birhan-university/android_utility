# Lab Manual: Simple Network Request with HttpURLConnection & Compose

## Objective
Build a single‑screen Android app that:
- Shows a “Fetch Network Data” button
- Performs an HTTP GET request to `https://jsonplaceholder.typicode.com/posts/1` using plain `HttpURLConnection`
- Displays the response JSON (or an error) inside a card
- Uses Kotlin coroutines to keep the network call off the main thread

You will understand every networking detail, from DNS lookup to UI update.

id Studio (latest stable) with Compose support

---

## Step 1 – Create the Project

1. Open Android Studio and choose **New Project**.
2. Select the **Empty Activity** template with **Compose**.
3. Name the project `NetworkLab`, set a package (e.g., `com.example.networklab`), and choose Kotlin as language.
4. Click **Finish**.

Android Studio generates a `MainActivity.kt` with a basic `Greeting` composable. We will replace that later.

---

## Step 2 – Add Internet Permission

Open `app/src/main/AndroidManifest.xml` and add the following line **above** the `<application>` tag:

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

Without this, any network call will throw `SecurityException`.

---

## Step 3 – Verify Dependencies

In your `app/build.gradle.kts` (or `.gradle`) check that the following dependencies are present (they are usually added by the Compose template):

```kotlin
dependencies {
    implementation("androidx.core:core-ktx:…")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:…")
    implementation("androidx.activity:activity-compose:…")
    implementation("androidx.compose.ui:ui:…")
    implementation("androidx.compose.material3:…")
    // No extra networking libraries needed
}
```

Kotlin coroutines are already included via `lifecycle-runtime-ktx`.

---

## Step 4 – Create the Network Client

Create a new Kotlin file named `NetworkClient.kt` in the same package. This object holds a single function that performs a synchronous GET request.

```kotlin
package com.example.networklab

import java.net.HttpURLConnection
import java.net.URL

object NetworkClient {
    fun makeGetRequest(urlLabel: String): String {
        val url = URL(urlLabel)
        val connection = url.openConnection() as HttpURLConnection
        return try {
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000   // 5 seconds to establish connection
            connection.readTimeout = 5000      // 5 seconds to wait for data

            val responseCode = connection.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the whole response body into a String
                connection.inputStream.bufferedReader().use { it.readText() }
            } else {
                "Error: $responseCode"
            }
        } finally {
            connection.disconnect()  // always close the connection
        }
    }
}
```

### What’s happening inside `makeGetRequest`?
| Code | Concept |
|------|---------|
| `URL(urlLabel)` | Parses the URL string into a structured object (protocol, host, path). |
| `url.openConnection()` | Prepares a connection object. No network activity yet. |
| `as HttpURLConnection` | Casts to HTTP‑specific class so we can set method and timeouts. |
| `requestMethod = "GET"` | The HTTP method – asks the server to return the resource. |
| `connectTimeout = 5000` | Max time to wait for TCP/TLS handshake. |
| `readTimeout = 5000` | Max time to wait between receiving bytes from the server. |
| `responseCode` | **This triggers the actual network connection**: DNS → TCP → TLS → sends the GET request → receives status line + headers. |
| `HTTP_OK` (200) | Standard success code. |
| `inputStream.bufferedReader().use { it.readText() }` | Converts the response body bytes into a `String`. `use` ensures the reader is closed. |
| `finally { disconnect() }` | Releases underlying socket and resources. |

---

## Step 5 – Build the UI (DashboardScreen)

Create another new file `DashboardScreen.kt`. This composable shows a welcome message, a card that displays either “Loading…” or the network result, and two buttons.

```kotlin
package com.example.networklab

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun DashboardScreen(username: String?, onLogout: () -> Unit) {
    val scope = rememberCoroutineScope()
    var resultText by remember { mutableStateOf("No data fetched yet") }
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome, ${username ?: "User"}!",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Network Result Card
        Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(
                text = if (isLoading) "Loading..." else resultText,
                modifier = Modifier.padding(16.dp)
            )
        }

        Button(onClick = {
            isLoading = true
            scope.launch(Dispatchers.IO) {
                val response = NetworkClient.makeGetRequest(
                    "https://jsonplaceholder.typicode.com/posts/1"
                )
                withContext(Dispatchers.Main) {
                    resultText = response
                    isLoading = false
                }
            }
        }) {
            Text("Fetch Network Data")
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = onLogout) {
            Text("Logout")
        }
    }
}
```

### UI & State Breakdown
- `resultText` and `isLoading` are **state** – changing them triggers recomposition.
- `rememberCoroutineScope()` provides a coroutine scope tied to the composable’s lifecycle.
- The “Fetch Network Data” button sets `isLoading = true`, then launches a coroutine on **`Dispatchers.IO`**.
- Inside the coroutine:
    1. `NetworkClient.makeGetRequest(...)` runs on a background thread, blocking that thread until the network call finishes.
    2. `withContext(Dispatchers.Main)` switches to the main thread to safely update the UI state.
    3. The card displays “Loading…” while `isLoading` is `true`, then the JSON string once the response is stored in `resultText`.

---

## Step 6 – Wire Up MainActivity

Open `MainActivity.kt` and replace its content with the following:

```kotlin
package com.example.networklab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    DashboardScreen(
                        username = "Android Student",
                        onLogout = { finish() }  // Closes the app
                    )
                }
            }
        }
    }
}
```

The `setContent` block applies the Material theme and displays our `DashboardScreen`. The `onLogout` simply calls `finish()` to close the activity (you might later replace it with a login flow).

---

## Step 7 – Run & Test

1. Connect a device/emulator with **internet access**.
2. Click **Run** (or Shift+F10).
3. When the app launches you’ll see:
    - “Welcome, Android Student!”
    - A card with “No data fetched yet”
    - A **“Fetch Network Data”** button and a **Logout** button.
4. Tap **“Fetch Network Data”**.
    - For a split second the card shows **“Loading…”**.
    - After the network response arrives, the card displays the JSON returned by the test API, for example:
      ```
      {
        "userId": 1,
        "id": 1,
        "title": "sunt aut facere ...",
        "body": "quia et suscipit ..."
      }
      ```
5. Tap **Logout** – the app closes.

If the network fails (e.g., no internet), you will see `"Error: -1"` or another error code after the timeouts expire.

---
