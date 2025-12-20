@echo off

setlocal
set WWW_ROOT="./admin-website"
set LISTEN_HOST="127.0.0.1"
set LISTEN_PORT=8011

echo "Serving %WWW_ROOT% on http://%LISTEN_HOST%:%LISTEN_PORT% (^C to stop)."

for /f %%i in ('ruby --version') do set RUBY_VERSION=%%i
for /f %%i in ('php -v') do set PHP_VERSION=%%i
for /f %%i in ('npx --version') do set NPX_VERSION=%%i
for /f %%i in ('python3 --version') do set PYTHON_VERSION=%%i

IF /I "%RUBY_VERSION%" NEQ "" (
    ruby -run -e httpd %WWW_ROOT% -p %LISTEN_PORT% -- -c "CacheDisable on"
) ELSE IF /I "%PHP_VERSION%" NEQ "" (
    php -S "%LISTEN_HOST%:%LISTEN_PORT%" -t %WWW_ROOT%
) ELSE IF /I "%NPX_VERSION%" NEQ "" (
    npx serve %WWW_ROOT% -l %LISTEN_PORT%
) ELSE IF /I "%PYTHON_VERSION%" NEQ "" (
    cd %WWW_ROOT% && python3 -m http.server %LISTEN_PORT%
) ELSE (
    echo.
    echo.
    echo ERROR: Admin Server not started
    echo.
    echo It appears you don't have the required dependencies to start the Admin server.
    echo.
    echo.
    echo 1. Install the Node LTS from https://nodejs.org/
    echo.
    echo 2. Open a new terminal window
    echo.
    echo 3. Re-run this script again.
    echo.
    echo =======================
    echo.
)
