# PowerShell compilation script
cd "d:\Github\SGU_HTTT_DoanhNghiep"

# Find javac
$javaHome = $env:JAVA_HOME
if (-not $javaHome) {
    # Try to find Java in common locations
    $javacPath = Get-Command javac -ErrorAction SilentlyContinue
    if ($javacPath) {
        $javaHome = Split-Path -Parent (Split-Path -Parent $javacPath.Source)
    }
}

if (-not $javaHome) {
    Write-Host "Java not found in PATH or JAVA_HOME"
    exit 1
}

$javac = "$javaHome\bin\javac.exe"
Write-Host "Using javac: $javac"

# Delete old compiled class for n10_ThongkePanel
Remove-Item "build/classes/GUI/n10_ThongkePanel*.class" -Force -ErrorAction SilentlyContinue

# Compile the modified file
Write-Host "Compiling n10_ThongkePanel.java..."
& $javac -cp "src:src/Lib/*" -d "build/classes" -encoding UTF-8 @(
    "src/BUS/*.java"
    "src/DAO/*.java"
    "src/DTO/*.java"
    "src/Util/*.java"
    "src/GUI/n10_ThongkePanel.java"
)

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful!"
} else {
    Write-Host "Compilation failed with exit code: $LASTEXITCODE"
}
