# Overview
The project is a **flexible logging framework in Java** which follows **Dependency Inversion Principle**. Its core purpose is to provide a way to log messages from an application to various destinations (like a console, file, or network) without the main application code being locked into one specific logging method.

The key components are:

An `interface` named `Logger` that defines a single action: `log(String message)`.

Multiple concrete `class` implementations (`ConsoleLogger`, `FileLogger`, `NetworkLogger`, `NullLogger`) that each provide a different way to perform the log action.

A suite of **unit tests** for each implementation to ensure they work reliably and independently.

# How it follows Dependency Inversion Principle
1. This project implements a **High-Level Module** namely `UserService`.
2. The `UserService` module doesn't know anything about the type of logger it receives. It just takes the logger and log whatever it wants to.
3. It's implementation is fixed and doesn't need to change based on logger type.

# How to run?

### Either run the following given commands:
> mvn clean compile\
> mvn checkstyle:check\
> mvn test

### Or run:
> make