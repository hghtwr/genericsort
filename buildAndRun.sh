#!/bin/bash

javac -d /home/development/de/akad/jav41/genericsorting/src/bin /home/development/de/akad/jav41/genericsorting/src/jav41/genericsorting/*.java
#java -cp /home/development/de/akad/jav41/genericsorting/src/bin/ -agentpath:/usr/share/visualvm/profiler/lib/deployed/jdk16/linux-amd64/libprofilerinterface.so=/usr/share/visualvm/profiler/lib,5140 jav41.genericsorting.Main
#java -cp /home/development/de/akad/jav41/genericsorting/src/bin/  jav41.genericsorting.Main -XX:+HeapDumpOnOutOfMemoryError XX:+UseCountedLoopSafepoint XX:HeapDumpPath=/tmp


jar cvfM program.jar -C /home/development/de/akad/jav41/genericsorting/src/bin/ .
java -jar program.jar
