# 📱 Smart Feedback SDK & Analytics Portal

> **Bridge the gap between your users and your development team.** > A full-stack solution for collecting real-time user feedback, bug reports, and crash logs from Android applications, visualized in a powerful web dashboard.

## 📖 Overview

Users often encounter bugs but rarely report them with enough detail. Developers receive vague complaints like "it doesn't work" without context.

**Smart Feedback SDK** solves this by capturing the **entire context** in a single tap:
1.  **User Sentiment:** Rating & text feedback.
2.  **Visual Context:** Automatic screenshot capture.
3.  **Technical Context:** Device model, OS version, and **system logs (Logcat)**.
4.  **Demographics:** Optional age & gender data for audience analysis.

All data is sent to a cloud backend and presented in a live **Analytics Dashboard**.

---

## ✨ Key Features

### 🤖 Android SDK
* **One-Line Integration:** Simple API to trigger the feedback flow.
* **Automatic Screenshot:** Captures the screen state at the moment of the report.
* **Black Box Logging:** Automatically captures the last 100 lines of the app's logcat to help debug crashes and bugs.
* **Device Metadata:** Auto-collects Manufacturer, Model, SDK Version, and Country.
* **Zero-UI Friction:** Clean BottomSheetDialog implementation.

### 📊 Web Dashboard (Analytics Portal)
* **Global Satisfaction Map:** Interactive Heatmap (Google GeoChart) showing ratings by country.
* **Review Inspector:** Detailed view of specific reports including:
    * Full-size screenshot viewer.
    * **Terminal View:** A hacker-style console to inspect the device logs sent with the report.
* **Demographics Analysis:** Population pyramid chart (Age/Gender distribution).
* **Real-time Filtering:** Filter reports by ID, Feature Tag, Rating, or Device.

---

## 🛠️ Tech Stack

### Mobile (Android Client)
* **Language:** Kotlin
* **Networking:** Retrofit, OkHttp, Gson
* **Concurrency:** Kotlin Coroutines
* **UI:** Material Design Components

### Web (Dashboard)
* **Frontend:** HTML5, CSS3 (Custom Dark Mode Terminal), JavaScript (ES6)
* **Visualization:** Chart.js, Google Charts Loader
* **Styling:** Bootstrap 5

### Backend & Cloud
* **Server:** Java Spring Boot (REST API)
* **Database:** MongoDB Atlas (NoSQL)
* **Deployment:** Koyeb (Serverless)

---

## 🚀 Integration Guide (Android)

### 1. Setup
Add the SDK module to your project.

### 2. Usage
Trigger the feedback view from any Activity or Fragment. Pass the current `Activity` and a `Feature Tag` (to identify where the user is).

```kotlin
// Example: Triggering feedback from a button click
myButton.setOnClickListener {
    SmartFeedback.show(this, "Video Editor Screen")
}
3. Log Capture (Under the Hood)
The SDK includes an internal LogHelper that automatically runs:

Kotlin

Runtime.getRuntime().exec("logcat -d -v threadtime")
It filters logs specific to your app process, ensuring privacy and relevance.

🖥️ Dashboard Visuals
🌍 Global Heatmap
Visualize user satisfaction across different regions. Red indicates critical issues, while green indicates positive feedback.

📝 Review Inspector with Logs
When a developer clicks on a report, they see the exact state of the app:

Screenshot: What the user saw.

Terminal: What the code was doing (Logs).

📂 Project Structure
Bash

├── app/                # Demo Android Application
├── feedback-sdk/       # The Core SDK Module
│   ├── api/            # Public Interfaces (SmartFeedback.kt)
│   ├── internal/       # Logic (LogHelper.kt, ScreenshotUtils.kt)
│   ├── network/        # Retrofit & Data Models
│   └── ui/             # FeedbackFragment & Layouts
└── web-dashboard/      # HTML/JS/CSS files for the Analytics Portal


