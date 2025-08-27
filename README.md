# Overview
The project is a **flexible logging framework in Java**. Its core purpose is to provide a way to log messages from an application to various destinations (like a console, file, or network) without the main application code being locked into one specific logging method.

The key components are:

An `interface` named `Logger` that defines a single action: `log(String message)`.

Multiple concrete `class` implementations (`ConsoleLogger`, `FileLogger`, `NetworkLogger`, `NullLogger`) that each provide a different way to perform the log action.

A suite of **unit tests** for each implementation to ensure they work reliably and independently.

# How to run?

### Either run the following given commands:
> mvn clean compile\
> mvn checkstyle:check\
> mvn test

### Or run:
> make