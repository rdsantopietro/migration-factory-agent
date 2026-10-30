@echo off
setlocal

set "SCRIPT_DIR=%~dp0"
set "JAR=%SCRIPT_DIR%target\migration-factory-agent-0.0.1-SNAPSHOT.jar"
set "JAVA_COMMAND=java"

if defined JAVA_HOME if exist "%JAVA_HOME%\bin\java.exe" set "JAVA_COMMAND=%JAVA_HOME%\bin\java.exe"

if not exist "%JAR%" (
  call "%SCRIPT_DIR%mvnw.cmd" -q -DskipTests package
  if errorlevel 1 exit /b %errorlevel%
)

"%JAVA_COMMAND%" -jar "%JAR%" %*
exit /b %errorlevel%
