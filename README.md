# lsn-recruitment

### Project is example implementation of three tasks in convenient of multi module maven project, each task is placed in different module. 
### This document contains briefly information about building and execution. Each module contains own README with detailed information.

## Build

### To build project please use standard maven approaches, for example:

```
mvn clean package
```

## Execution

### To execute project use `java -jar path-to-jar`. Jars are placed in target directory of dedicated module, for example

```
java -jar task1/target/task1-1.0-SNAPSHOT.jar 10 20 30 5 2
```
