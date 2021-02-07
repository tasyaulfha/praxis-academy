function carijava{


    param
    (
        [Parameter(Mandatory=$true)][string]$namadirektori
    )
    
    $carijava=Get-Childitem -Path $Path -Include *.java -Recurse
    
    if($carijava)
    {
        Write-Host "Ada file Java pada direktori {$namadirektori}"
    }
    else
    {
        Write-Host "Tidak ada file Java yang ditemukan"
    }

}