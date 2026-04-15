@echo off
setlocal enabledelayedexpansion
cd /d "%~dp0"

if not exist "build\classes" mkdir "build\classes"

set "SOURCES="
for /r "src" %%f in (*.java) do (
    set "SOURCES=!SOURCES! "%%f""
)

javac -encoding UTF-8 -source 17 -target 17 -cp "src;src/Lib/*" -d build/classes !SOURCES!
if errorlevel 1 (
    echo Compile failed!
    pause
    exit /b 1
)
echo Compile successful. Starting application...
java -cp "build/classes;src/Lib/*" Main.Main
pause
