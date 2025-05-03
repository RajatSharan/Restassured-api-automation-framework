# RestAssured API Automation Framework

A robust and scalable API Automation Framework developed in Java using Rest Assured, TestNG, Extent Reports, and the Builder Design Pattern.

This framework is designed to simplify REST API testing with a modular, maintainable, and reusable structure — ideal for individual testers or teams working on API automation projects.

✨ Key Features
✅ Built with Java 17, Rest Assured, TestNG
✅ Implements Builder Design Pattern for cleaner request/response specification management
✅ Integrated Extent Reports for detailed HTML test reporting
✅ Supports soft assertions (with TestNG’s SoftAssert)
✅ Centralized configuration management via properties files
✅ Organized test data and test suites under /resources
✅ Generates detailed reports under /reports
✅ Easily extendable for new APIs and test cases
📁 Project Structure
plaintext
├── src
│   ├── main
│   │   └── java
│   │       └── [framework source code]
│   └── test
│       └── java
│           └── [test cases]
├── resources
│   ├── testdata
│   ├── testsuites
│   └── extent-config.xml
├── reports
│   └── [generated HTML reports]
├── config
│   └── config.properties
├── target
│   └── [build artifacts]
├── README.md
└── pom.xml
Explanation:
✅ /resources → external test data, config, suites
✅ /reports → auto-generated ExtentReports
✅ /config → properties/config files
✅ /src/main/java → framework code (utils, builders, base classes)
✅ /src/test/java → test classes
🚀 Getting Started
1️⃣ Prerequisites
Ensure the following are installed on your system:

Java 17+
Maven
IntelliJ IDEA (or any Java IDE)
Git
Verify installations:
bash
java -version
mvn -version
2️⃣ Clone the Repository
bash
git clone https://github.com/RajatSharan/Restassured-api-automation-framework.git
cd restassured-api-automation-framework
3️⃣ Install Dependencies
The project uses Maven for dependency management. Run the following:

bash
mvn clean install
✅ Maven will download all required dependencies.

4️⃣ Configure Properties
Update the /config/config.properties file as needed:

properties
baseURI=https://api.example.com
reportPath=./reports/
5️⃣ Run Tests
Run all tests via Maven:

bash
mvn test
Or run specific test suites via IntelliJ or terminal.

✅ TestNG generates results.
✅ Extent Reports are generated under /reports.

📝 Usage Example
A sample test class is located in /src/test/java/getMethod/SoftandHardAssertions.java:

Java
@Test
public void validateSoftAssertionsUtill() {
    SoftAssertionUtill.assertEquals(actualResponse, expectedResponse, "Validating API response");
}
You can add more test classes under /src/test/java following similar patterns.

📊 Reports
After test execution:

Navigate to /reports/.
Open the latest .html file in a browser to view interactive test reports.
Reports are generated using Extent Reports with custom configurations from /resources/extent-config.xml.

🧩 Extending the Framework
✅ Add new API request specifications → Create new Builder classes in /src/main/java.
✅ Add new tests → Create new test classes in /src/test/java.
✅ Add test data → Update /resources/testdata/ or properties files.
✅ Configure reports → Modify /resources/extent-config.xml.
