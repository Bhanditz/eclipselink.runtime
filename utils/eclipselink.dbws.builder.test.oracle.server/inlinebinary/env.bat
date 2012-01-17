@echo off
@REM User MUST set appropriate values for the following environment variables:
set JAVA_HOME=C:\Progra~1\Java\jdk1.6.0_23
set ANT_HOME=C:\Progra~1\apache-ant-1.8.2
set TOPLINK_HOME=C:\oracle\middleware\toplink

@REM Please do not change any of the following lines:

set _FIXPATH=
call :fixpath "%JAVA_HOME%"
set JAVA_HOME=%_FIXPATH:~1%
set _FIXPATH=
call :fixpath "%ANT_HOME%"
set ANT_HOME=%_FIXPATH:~1%
set _FIXPATH=
call :fixpath "%TOPLINK_HOME%"
set TOPLINK_HOME=%_FIXPATH:~1%
goto :EOF

:fixpath
if not %1.==. (
  for /f "tokens=1* delims=;" %%a in (%1) do (
    call :shortfilename "%%a" & call :fixpath "%%b"
  )
)
goto :EOF
:shortfilename
for %%i in (%1) do set _FIXPATH=%_FIXPATH%;%%~fsi
goto :EOF