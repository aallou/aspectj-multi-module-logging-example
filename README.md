AspectJ Multi-module Compile-Time Example
=====================

Example using [AspectJ](https://eclipse.org/aspectj/) in multi-module project with [Maven](http://maven.apache.org).

### Compile and Install to local repository ###

in base folder

```
mvn clean install
```

### Run ###

in app folder

```
mvn exec:java
```

### Create executable jar with dependencies ###

in base folder

```
mvn clean compile package
```