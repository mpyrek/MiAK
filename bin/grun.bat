@echo off

REM Run ANTLR4 TestRig
SET CLASSPATH=".;../lib/antlr-4.11.1-complete.jar;%CLASSPATH%" 
java -classpath %ANTLR4_HOME%\lib\antlr-4.11.1-complete.jar;. org.antlr.v4.gui.TestRig %*