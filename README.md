# Simple Calculator App (MNTI 2018/2019 -  CALSO subject. First Assignment) 

#### This document explains how to achieve or how have been done the different exercises of the deliverable.

##### 1. Implementation of the app.
This project implements a simple calculator compound of three classes (Sources in: [src/main/java](src/main/java)). 
   * Calculator: Is the main class, a simple Java console application, which depending on the user's input performs an operation or another.
   * Operations: Is the class with the calculator methods. It has 6 different methods:
      1. Addition: Calculates the addition of two numbers.
      2. Subtraction: Calculates the subtraction between two numbers.
      3. Division: Calculates the division between two numbers.
      4. Multiplication: Calculates the multiplication of two numbers.
      5. Biggest: Given two numbers calculates the biggest one.
      6. Smallest: Given two numbers calculates the smallest one.
   * NonDivisionByZeroExeption: Arithmetic exception raised by the operation Division. 
##### 2. TestSuite development.
The testsuit can be located in src/test/java, it is called AllTest.java and consists of two JUnit test classes (Sources in: [src/main/test](src/main/test)): 
   * MainTest: Is the test class in charge of testing the Calculator class, i.e. the main method of the app. There 10 different test cases are defined  in file [src/main/resources/maintest.xml](src/main/resources/maintest.xml). These test cases are retrieved using JTestCase, which is a java library that helps in separating test case data from test case units.
   * OperationsTest: This test class tests all the operations method defined in the previous section. In this case the test cases can be located in [src/main/resources/operationstest.xml](src/main/resources/operationstest.xml). There are defined two test cases for each test in the class. Moreover, in order to try the assertparam tag there is a test case that triggers the NonDivisionByZero exception. The exception test case is asserted with the error message expected, which is written in the operationstests.xml file.
##### 3. Automate the building process using Maven.
In this project Maven was selected as the project management and building tool. This section explains what plugins are used to perform the different tasks of the project life-cycle:
   * **Initialize:** Not implemented, maven creates the directories automatically when needed.
   * **Clean**: Used Maven Clean plugin, this plugins cleans the working directory when its goal Clean is used. Usage:
      * ``` $ mvn clean ```
   * **createzip:** Packages the source files and the POM.xml file in a zip. For this purpose the assembly plugin is used. This plugin needs is configured through two files, first in the pom.xml as any other plugin and second in a [zip.xml](src/main/assembly/zip.xml) file created in src/main/assembly directory. This [zip.xml](src/main/assembly/zip.xml)  defines what resources must be included in the zip file. If you want to use it manually (outside of package phase) you can do it this way:
      * ``` $ mvn assembly:single@manual ```
   * **document:** Maven Javadoc plugin creates Javadoc documentation of the java files located in [src/main/java](src/main/java) directory. You can define the output directory with destDir or outputDirectory parameters. Usage:
      * ``` $ mvn javadoc:javadoc ```
   *  **compile:**  Compiling in Maven is an easy task. You can use Maven Compiler plugin for this purpose. Maven Compiler plugin's compile and testCompile goals are used to compile the application sources and test sources respectively. Take into account that testCompile goal depends on compile because test sources depend on the application sources. Usage:
      * ``` $ mvn compiler:compile  ```     
      * ``` $ mvn compiler:testCompile  ```   
   *  **createjar**: Maven Jar plugin packages the compiled sources and the pom.xml in a jar file. To make it runnable i.e. adding the main class in the Manifest, you only have to add the following code in the configuration section of the plugin: 
      ```xml 
         <manifest>
            <addClasspath>true</addClasspath>
            <mainClass>mainclass.qualified.name</mainClass>
         </manifest> 
      ```
      This plugin depends on the compiler plugin because it needs the compiled sources in order to add them to the jar file. Usage:
      * ``` $ mvn jar:jar  ```     
   *  **run and runjar**: The Exec Maven plugin is able to run a program from the project .class files and is also capable of running an external jar file. The plugin has two different goals to perform those tasks. The java goal executes the supplied java classes (compiled classes) in the current VM with the enclosing project's dependencies as classpath. On the other side, the exec goal supports executing external programs, for example a previously packaged jar file. The java and exec goals depend on the compiler and jar plugins respectively as the first one needs the compiled classes whereas the second one the packaged jar file. Usage:
      * ``` $ mvn exec:java  ```     
      * ``` $ mvn exec:exec  ```   
   * **reports**: In this project different test reports are created by means of three different plugins. After generating any of the reports they can be found in the target/test-report directory. The reports are the following ones:
      * **JUnit Report (Surefire):** Similar to JUnit Report it creates an html file including the results of the Junit tests. This report is generated by the Maven Surefire Report plugin and can be located in target/test-report/junit-report directory. You can generate the report in the following way:
         * ``` $ mvn surefire-report:report ```
      * **Junit PDF Report:** Maven does not support JUnit PDF Report as Ant does, instead it has a PDF plugin that converts the surefire html report into PDF format. Adding the surefire plugin to the reporting section of the pom.xml is all you need in order to generate a pdf report. In this way, the PDF plugin first creates the surefire html report and then converts it to a pdf format. The report can be found in target/test-report/pdf. Usage:
         * ``` $ mvn pdf:pdf ```
      * **Cobertura Report:** The last report is the Cobertura report, this shows the application test coverage percentage. The report is generated by the Cobertura Maven Plugin and can be found in target/test-report/cobertura. Generation of the report is started in the following way:
         * ``` $ mvn cobertura:cobertura ```
 ##### 4. Test suite evaluation with Mutation Testing tool (Maven Pitest Plugin)
In this project Maven Pitest Plugin is the tool responsible for evaluating the test suit by means of mutation testing. This plugin creates all the possible mutants for the selected sources using as mutators the different possibilities available in [Pitest mutators list](http://pitest.org/quickstart/mutators/)
