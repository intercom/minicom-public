@echo off
setlocal

set "JAVA_BIN=java"
set "HINT=Install JDK 21 or newer, or set JAVA_HOME to one."
if not defined JAVA_HOME goto :check
set "JAVA_BIN=%JAVA_HOME%\bin\java.exe"
set "HINT=JAVA_HOME is set to %JAVA_HOME%. Point it at a JDK 21 or newer, or unset it to use java from PATH."

:check
"%JAVA_BIN%" -version >nul 2>&1
if errorlevel 1 goto :notfound

set "JV="
for /f tokens^=2^ delims^=^" %%v in ('""%JAVA_BIN%" -version 2^>^&1"') do if not defined JV set "JV=%%v"

rem Old style "1.8.0_x" has the major version second; "21.0.4" has it first.
set "MAJOR="
for /f "tokens=1,2 delims=.-+_" %%a in ("%JV%") do call :major %%a %%b

if not defined JV set "JV=unknown"
set "MAJOR_NUM=0"
set /a MAJOR_NUM=%MAJOR% 2>nul
if %MAJOR_NUM% LSS 21 goto :tooold

cd java
call gradlew.bat build
exit /b %errorlevel%

:major
if "%1"=="1" (set "MAJOR=%2") else set "MAJOR=%1"
exit /b 0

:notfound
echo Error: Java not found, looked for %JAVA_BIN%
echo %HINT%
exit /b 1

:tooold
echo Error: Java 21 or newer is required.
echo Checked %JAVA_BIN%, found version: %JV%
echo %HINT%
exit /b 1
