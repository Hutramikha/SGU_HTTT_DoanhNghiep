@echo off
cd /d "%~dp0"
echo Testing SQL Server Connection...
echo.

echo Starting PowerShell test...
powershell.exe -NoProfile -ExecutionPolicy Bypass -File "%~dp0testconnect.ps1"

pause