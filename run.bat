@echo off
cd %~dp0
javac -cp "src/Lib/*" -sourcepath src -d build/classes -source 11 -target 11 src/Main/Main.java
if errorlevel 1 (
    echo Compile failed!
    pause
    exit /b 1
)
echo Compile successful. Starting application...
java -cp "build/classes;src/Lib/*" Main.Main
pause
