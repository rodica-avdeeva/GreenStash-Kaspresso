# Project to demonstrate knowledge in Android UI testing using Kaspresso, CI/CD with GitHub Actions, Allure Reports, and test execution with Marathon

This is a sample project with UI tests for an Android app.
It uses Kaspresso to write the tests, Allure to generate reports, and GitHub Actions with Marathon to run tests automatically in CI.

The tests check how the app behaves in different user scenarios

[![CI](https://github.com/rodica-avdeeva/GreenStash-Kaspresso/actions/workflows/ui-tests.yml/badge.svg)](https://github.com/rodica-avdeeva/GreenStash-Kaspresso/actions/workflows/ui-tests.yml)
[![Pages Status](https://img.shields.io/badge/GitHub%20Pages-Online-green)](https://rodica-avdeeva.github.io/GreenStash-Kaspresso/)


---

# 📋 Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [How to Run Tests Locally](#how-to-run-tests-locally)
- [GitHub Actions CI/CD](#github-actions-cicd)
- [Allure Reports](#allure-reports)
- [License](#license)

## Project Overview

This project provides a simple and extensible setup for automating UI tests of Android applications.
It supports local test execution on emulators or real devices, and automated CI runs using Marathon (with optional parallel execution).
The tests target the [GreenStash](https://github.com/Pool-Of-Tears/GreenStash) Android app — a simple open-source Android app for planning and tracking savings goals.


Allure reports are generated automatically and can be viewed locally or published to GitHub Pages.


## Technologies Used

- Kotlin  
- Gradle  
- Kaspresso  
- JUnit  
- Allure Reports  
- Marathon  
- GitHub Actions  

---


## Project Structure

```
.
├── .github/
│   └── workflows/
│       └── ui-tests.yml            # GitHub Actions workflow for CI
├── app/
│   ├── build.gradle                # Dependencies and config for test setup
│   └── src/
│       ├── main/                   # Main application code
│       └── androidTest/
│           └── starry/greenstash/
│               ├── annotations/    # Custom annotations for tests
│               ├── base/           # Base classes
│               ├── helpers/        # Utility functions and helpers
│               ├── screens/        # Kaspresso Screen objects (Page Objects)
│               └── tests/          # UI test classes
├── Marathonfile                    # Marathon configuration
├── LICENSE
└── README.md

```


---

## How to Run Tests Locally

### Prerequisites

- Java 17  
- Android SDK with at least one running emulator or connected device  
- [Marathon installed](https://docs.marathonlabs.io/runner/)  
- Allure CLI (optional, to view reports)

### Steps

```bash
# Clone the repository
git clone https://github.com/rodica-avdeeva/GreenStash-Kaspresso.git
cd GreenStash-Kaspresso

# Start an emulator or connect a real Android device
# Make sure it's visible:
adb devices

# Run UI tests with Marathon
marathon

# (Optional) Open Allure report
allure serve build/reports/marathon/device-files/allure-results

```

## GitHub Actions CI/CD

This project uses GitHub Actions to run UI tests and publish Allure reports automatically.

The workflow is defined in `.github/workflows/ui-tests.yml` and consists of two jobs:

- `ui-tests`:  
  - Builds the app and test APKs  
  - Starts an Android emulator  
  - Runs tests using Marathon 
  - Uploads Allure results as a build artifact

- `deploy-allure-report`:  
  - Downloads test results  
  - Generates an Allure HTML report  
  - Deploys the report to [GitHub Pages](https://rodica-avdeeva.github.io/GreenStash-Kaspresso)

Allure reports are available after each run, even if some tests fail.

---


## Allure Reports

After every test run, an Allure report is generated and published at:

🔗 [rodica-avdeeva.github.io/GreenStash-Kaspresso](https://rodica-avdeeva.github.io/GreenStash-Kaspresso)

Each test includes 📷 screenshots and 📹 video recordings.


## License

This project is based on the [GreenStash](https://github.com/Pool-Of-Tears/GreenStash) Android app.  
It is distributed under the MIT License. See the [LICENSE](LICENSE) file for full details.
