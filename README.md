# Appium Automation Project - Setup Guide

## Introduction

This project is designed for automating mobile application testing using **Appium** with **TestNG**. It includes test scripts, configurations, and utilities for executing automated UI tests on Android devices.

## Prerequisites

Before setting up and running the project, ensure you have the following installed on your system:

1. **Java Development Kit (JDK) 11 or later**

   - Download and install from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
   - Set `JAVA_HOME` in system environment variables.

2. **Node.js and npm**

   - Download and install from the official [Node.js website](https://nodejs.org/).
   
   **Installation:**
   
   - Open your terminal or command prompt.
   - Run the following command to install Appium globally:
     ```sh
     npm install -g appium
     ```
   - The `-g` flag installs Appium globally, making it accessible from any directory.
   
   **Verification:**
   
   - After installation, verify Appium by running:
     ```sh
     appium --version
     ```
   - This should display the installed Appium version.

3. **Android Studio & SDK**

   - Install [Android Studio](https://developer.android.com/studio)
   - Open Android Studio and install the latest **Android SDK, Platform Tools, and ADB**.
   - Configure `ANDROID_HOME` and add `platform-tools` to system environment variables:
     - **Windows:**
       - Right-click **This PC** → **Properties** → **Advanced system settings** → **Environment Variables**
       - Add a new variable:
         - **Variable name:** ANDROID_HOME
         - **Variable value:** Path to Android SDK (e.g., `C:\Users\YourUser\AppData\Local\Android\Sdk`)
       - Edit the **Path** variable and add:
         - `%ANDROID_HOME%\platform-tools`
     - **Mac/Linux:**
       - Add the following lines to `~/.bashrc` or `~/.zshrc`:
         ```sh
         export ANDROID_HOME=$HOME/Library/Android/sdk
         export PATH=$ANDROID_HOME/platform-tools:$PATH
         ```

4. **TestNG Plugin for Eclipse/IntelliJ**

   - **Eclipse:**
     - Open **Eclipse** → **Help** → **Eclipse Marketplace** → Search for `TestNG` → Install.
   - **IntelliJ IDEA:**
     - Open **IntelliJ** → **File** → **Settings** → **Plugins** → Search for `TestNG` → Install.

5. **Enable USB Debugging on Android Device**

   - Connect your device via USB.
   - Open **Settings** → **About Phone** → Tap **Build Number** 7 times to enable Developer Mode.
   - Go to **Developer Options** and enable **USB Debugging**.

## Project Setup

### 1. Download the Project

- Download the project ZIP file or clone the repository if available.
- Extract the ZIP file to your desired location.

### 2. Open the Project in Eclipse/IntelliJ

- Open **Eclipse** or **IntelliJ IDEA**.
- Click **File** → **Open** and select the extracted project folder.

### 3. Configure Dependencies

- Open `pom.xml`.
- Ensure all required dependencies (Appium, TestNG, ExtentReports, etc.) are listed.

### 4. Configure Appium Capabilities in BaseTest Class

- Navigate to `src/test/java/BaseTest.java`.
- Ensure the following capabilities are set correctly:
  ```java
  DesiredCapabilities capabilities = new DesiredCapabilities();
  capabilities.setCapability("deviceName", "emulator-5554");
  capabilities.setCapability("platformName", "Android");
  capabilities.setCapability("appPackage", "com.example.app");
  capabilities.setCapability("appActivity", "com.example.app.MainActivity");
  driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
  ```

### 5. Start Appium Server

- Open a terminal and run:
  ```sh
  appium
  ```
  This will start the Appium server.

### 6. Running Tests

- Open **TestNG XML file** (`src/test/resources/testng.xml`).
- Right-click and select **Run As → TestNG Suite** in Eclipse/IntelliJ.

## Functionalities Tested

1. **Login** (Valid OTP and Invalid OTP)
2. **Ask Limo**
3. **Add Coins**
4. **Edit Profile** (Edit Email)
5. **Add Alert**

## Log4j2 Logging Configuration

Logging is configured using `log4j2.xml` located in `src/test/resources`:

```xml
<Configuration status="WARN">
    <Appenders>
        <File name="FileLogger" fileName="logs/appium.log">
            <PatternLayout>
                <Pattern>%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %logger{36} - %msg%n</Pattern>
            </PatternLayout>
        </File>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="FileLogger"/>
        </Root>
    </Loggers>
</Configuration>
```

## Extent Reports Configuration

Extent Reports are integrated for test execution reporting. Configuration is in `ExtentReportManager.java`:

```java
public class ExtentReportManager {
    private static ExtentReports extent;
    
    public static ExtentReports getReportInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
```

Reports will be generated in the `reports` folder after test execution.

## Folder Structure

```
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- com.automation.pages  # Page Object Model classes
|   |   |   |-- com.automation.utils  # Utility functions (Waits, Configs, etc.)
|   |-- test
|   |   |-- java
|   |   |   |-- com.automation.tests  # TestNG test cases
|   |-- resources
|   |   |-- log4j2.xml  # Logging Configuration
   |   |-- testng.xml  # TestNG test execution configuration
```

## Reports & Logs

After test execution:

- **Extent Test Reports:** Available in  `reports/index.html`
- reports folder also includes the Failed test cases screenshots.
- **Logs:** Stored in `logs/application.log`

This setup ensures an efficient test automation framework with Appium, TestNG, Log4j2 logging, and Extent Reports for detailed reporting. Feel free to modify configurations as needed for your project.


