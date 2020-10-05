
Nova Futur Technical test

Created a Maven Project with name NovoFuturTests and 37 Tests are included as part of the suite for CRUD Opeartions

Pre-requisites of Softwares to execute the Repository :

1. Java
2. Maven
3. Eclipse

Import the project through Eclipse by navigating to File - Import - Maven - Existing Maven Project - Click Next - Select the projct using Browse option
Once sucessfully imported, Refresh the project to ensure the all the Maven dependencies are loaded sucessfully.

Tests can be used executed using the below mentioned ways

1. Using Junit - After successfull import of the project to Eclipse, Open TestRunner.java file from path (NovoFuturTests-Tests\src\test\java\cucumber\Options). 
				Once opened, Right click on the file - Select Run As - Junit Test

2. Using Feature file - Project should be downloaded and suceesfully imported to Eclipse.
				 Open respective feature file(using NovoFuturTests\src\test\java\Features) which needs to be executed - Right click on the file - Run As - Cucumber Feature

Please find below for the individual sections along with their descritpion from the project structure.

a. NovoFuturTests\src\test\java\cucumber\Options - This consists of the TestRunner file. This helps to execute the tests present as part of the project.
	By Default I have configured this file to execute all tests. We can customise using features and tags options(if multiple feature files are added)
	Tags - Are used to help to execute specific test case rather than entire suite. Currently this is configured as NULL to execute all tests
		i. @AddComputergreenpathscenarios - Used to test all scenarios defined in the feature file to execute Add computer green path scenarios without error
	   ii. @AddComputerredpathscenarios - Used to test all scenarios defined in the feature file to execute all possible error scenarios while adding a computer
	  iii. @UpdateComputergreenpathscenarios - Used to test all scenarios defined in the feature file to execute Update computer postive scenarios without error
	   iv. @UpdateComputerredpathscenarios - Used to test all scenarios defined in the feature file to execute all possible error scenarios while updating a computer
	    v. @DeleteComputergreenpathscenarios - Used to test all scenarios defined in the feature file while user to delete a computer usig sample application
	   vi. @ReadComputergreenpathscenarios	- Used to test all scenarios defined in the feature file while user tries to read values of a computer usig sample application

b. NovoFuturTests\src\test\java\Features - Contains a feature file for every endpoint

	i. CRUDOperations.feature - This feature file consists of all tests related to CRUD operations of sample application

c. NovoFuturTests\src\test\java\StepDefinitions - Contains respective Step definition file for every endpoint. 

	i. AddComputerNameSteps.java - This file consists of all step implementations for the steps defined in i. CRUDOperations.feature as part of CRUD operations

d. NovoFuturTests\src\test\java\Pages - This section is created to pass input required for the project
	
	i. AddComputerPage.java	 - This file consists of all objects and methods to interact which are  present in AddComputer/UpdateComputer/DeleteComputer/UpdateComputer
	ii. HomePage.java - This file consists of all objects and methods to interact which are present on Homepage for AddComputer/UpdateComputer/DeleteComputer/UpdateComputer operations


e. NovoFuturTests\src\test\java\resources - This section is created to pass input required for the project

	i. global.properties - This consistsists of all the static information required for the execution.
	

	
	
