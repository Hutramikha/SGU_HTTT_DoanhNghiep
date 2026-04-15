# Test SQL Server Connection
Write-Host "Testing SQL Server Connection..." -ForegroundColor Cyan
Write-Host ""

$conn = New-Object System.Data.SqlClient.SqlConnection
$connString = 'Server=localhost;Database=QuanLyQuanCaPhe;User Id=sa;Password=123;Connection Timeout=5'
$conn.ConnectionString = $connString

try {
    Write-Host '[Testing] Connecting to SQL Server...' -ForegroundColor Yellow
    $conn.Open()
    Write-Host '[SUCCESS] Connected! ✓' -ForegroundColor Green
    Write-Host "Connection Details:"
    Write-Host "  Server: localhost"
    Write-Host "  Database: $($conn.Database)"
    Write-Host "  State: $($conn.State)"
    $conn.Close()
} catch {
    Write-Host '[ERROR] Connection failed! ✗' -ForegroundColor Red
    Write-Host "Error Details:"
    Write-Host $_.Exception.Message
}

Write-Host ""
Write-Host "Test completed."
