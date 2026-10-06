java -version 2>&1 | findstr "21\." >nul
if errorlevel 1 (
  echo Error: Java 21 is required.
  exit /b 1
)

cd java
call gradlew.bat build
