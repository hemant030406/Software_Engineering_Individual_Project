all:
	mvn clean compile
	mvn checkstyle:check
	mvn test