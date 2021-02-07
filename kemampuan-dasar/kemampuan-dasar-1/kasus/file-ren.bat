function carijava{

    param
    (
        [Parameter(Mandatory=$true)][string]$direktori
        [Parameter(Mandatory=$true)][string]$gantinama
    )
    
    Rename-Item $direktori $gantinama
    
   Write-Host "File di $direktori, sudah berganti nama menjadi $gantinama"
    
}
function pilih{

    param(
        [Parameter(Mandatory=$true)][string]$search,
        [Parameter(Mandatory=$true)][string]$ya_tidak
    )

    if($ya_tidak -eq "y")
    {
    gantinama $carijava
    }
    else
    {
    Write-Host "Lanjut ke langkah berikutnya"
    }
    function carijava{

     param
     (
         [Parameter(Mandatory=$true)][string]$direktori
     )

     $carijava=Get-Childitem -Path $Path -Include *.java -Recurse

     if($carijava)
     {
         Write-Host "Ada file Java pada direktori {$direktori}"
     }
     else
     {
         Write-Host "Tidak ada file Java yang ditemukan"
     }

 }
 carijava