@echo off

REM Compile java code that uses ANTLR4 classes
javac -classpath %ANTLR4_HOME%\lib\antlr-4.11.1-complete.jar;. %*