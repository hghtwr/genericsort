#!/bin/bash

javac -d ./src/bin ./src/jav41/genericsorting/*.java
#java -cp ./src/bin/ jav41.genericsorting.Main
jar cvfM program.jar -C ./src/bin/ .