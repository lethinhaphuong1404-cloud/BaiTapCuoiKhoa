# Selenium + Java + TestNG starter

## Prerequisites
- JDK 17+
- Maven 3.9+
- Google Chrome
- Approved test/staging website URL and test account(s), if authentication is required

## Configure
PowerShell:
```powershell
$env:BASE_URL = "https://REPLACE-WITH-APPROVED-TEST-URL"
# Optional:
$env:HEADLESS = "false"
```
Do not put passwords, API tokens, or production secrets in source control.

## Run
From the folder containing `pom.xml`:
```powershell
mvn clean test
```

## Outputs
- TestNG/Surefire reports: `target/surefire-reports/`
- Failure screenshots: `target/screenshots/`
- Basic run logs: console output from the base test class

## Important
This is a framework starter, not a completed test suite for the assigned website.
Before claiming coverage, replace the placeholder smoke assertion with requirement-based tests and actual page objects/locators. Add POM classes under `framework.pages`, use explicit waits, and test only in an authorized environment.
