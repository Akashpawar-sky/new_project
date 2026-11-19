# SailPoint IdentityIQ UI Automation - Learning Framework

A beginner-friendly Java + Selenium + TestNG + Maven framework designed to teach the structure used in enterprise UI automation projects.

## Current runnable demo

Because an IdentityIQ test instance is not included, the first two UI tests run against the public SauceDemo practice site:
- Valid login should open the inventory page.
- Invalid password should display an error.

This is a practice target, **not a real SailPoint IIQ integration**. See [IIQ_AUTOMATION_GUIDE.md](IIQ_AUTOMATION_GUIDE.md) for how to adapt the framework once you have authorized IIQ lab access.

## Tech stack
- Java 17
- Maven
- Selenium WebDriver 4.27
- TestNG 7.11
- Page Factory
- TestNG listener and failure screenshots

## Import into Eclipse
1. Download or clone this repository.
2. In Eclipse, choose **File → Import → Maven → Existing Maven Projects**.
3. Select the extracted project folder and finish.
4. Right-click the project → **Maven → Update Project**.
5. Confirm that JDK 17 is selected under **Project → Properties → Java Build Path**.

## Run
From the project directory:

```bash
mvn clean test
```

Or right-click `src/test/resources/testng.xml` and choose **Run As → TestNG Suite**.

Selenium Manager (bundled with Selenium 4) attempts to resolve the matching ChromeDriver automatically. Chrome and internet access are required. If your network uses a corporate proxy or blocks driver downloads, follow your organization's approved browser-driver setup.

## Demo credentials
The public SauceDemo practice site publishes these sample credentials:
- Username: `standard_user`
- Password: `secret_sauce`

They are demo credentials, not personal or corporate credentials.

## Reports and screenshots
- TestNG/Surefire reports: `target/surefire-reports/`
- Failure screenshots: `target/screenshots/`

## Configuration
Edit `src/test/resources/config.properties` to change the demo URL, browser mode, credentials, or wait duration. Do not commit real credentials or tokens.

## Framework structure
- `base/BaseTest.java`: browser setup and teardown
- `config/ConfigReader.java`: reads properties
- `pages/LoginPage.java`: Page Factory elements and page actions
- `tests/`: TestNG test cases
- `listeners/TestListener.java`: pass/fail logging and failure screenshots
- `testng.xml`: test suite configuration

## Important safety note
Use only authorized test environments and test identities. Do not automate production provisioning, access requests, or aggregation without explicit project approval.
