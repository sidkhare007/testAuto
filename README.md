# Modern India Test Automation Framework

Java 17 + Maven + Selenium 4 + Cucumber 7 + RestAssured 5.  
Generates **Cucumber HTML reports**, runs locally or on **Selenium Grid** via Docker, and on **GitHub Actions**.

## Quick start
```bash
# Local UI tests (headed Chrome)
mvn -q test -Dcucumber.features=src/test/resources/features/ui -Dheadless=false

# API tests
mvn -q test -Dcucumber.features=src/test/resources/features/api

# Full suite + reports
mvn -q test && mvn -q verify
open target/cucumber-report-html/cucumber-html-reports/overview-features.html
```

## Run against Selenium Grid
```bash
docker compose up -d
SELENIUM_REMOTE=true mvn test
```

## Project layout
- `src/test/resources/features` - Cucumber features (UI + API)
- `src/test/java/com/example/taf/steps` - Step definitions
- `src/test/java/com/example/taf/pages` - Page Objects
- `src/test/java/com/example/taf/utils` - Driver, config, API helpers
- `src/test/java/com/example/taf/hooks` - Hooks for setup/teardown
- `docker-compose.yml` - Selenium Grid (Hub + Chrome node)
- `.github/workflows/maven.yml` - CI pipeline with artifact upload of reports
