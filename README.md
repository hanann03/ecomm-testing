# E-commerce Test Automation Project

## Overview
This project contains automated tests for an e-commerce website, covering various functionalities including product search, filtering, and other e-commerce features. The test suite is built using Selenium WebDriver and follows the Page Object Model design pattern for better maintainability and reusability.

## Setup Instructions

### Prerequisites
- Java JDK 8 or higher
- Maven
- Chrome/Firefox browser
- IDE (IntelliJ IDEA recommended)

### Installation Steps
1. Clone the repository:
```bash
git clone [repository-url]
cd ecomm-test
```

2. Install dependencies using Maven:
```bash
mvn clean install
```

3. Configure your environment:
   - Ensure you have the correct browser driver (ChromeDriver/GeckoDriver) installed
   - Set up your browser driver path in the project configuration

## Running Tests

### Test Execution
To run all tests:
```bash
mvn test
```

To run specific test classes:
```bash
mvn test -Dtest=TestClassName
```

### Test Coverage
The test suite covers the following scenarios:
- Product search functionality
- Product filtering
- Shopping cart operations
- User authentication
- Checkout process

### Important Note About Test Environments
The product search and filter tests are executed on a different website than the main test suite. This is because these specific features were not available in the original test website. The tests are configured to run on:
- Main test website: https://www.saucedemo.com
- Product search/filter tests: https://demowebshop.tricentis.com

This separation ensures comprehensive test coverage while maintaining the ability to test all required functionality. 