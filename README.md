# Simple Calculator App (MNTI 2018/2019 -  CALSO subject. First Assignment) 

#### This document explains how to achieve or how have been done the differents exercises of the deliverable.

##### 1. Implementation of the app.
This project implements a simple calculator componed of three classes.
   * Calculator: Is the main class a simple Java console application which depending on the user's input performs an operation or other.
   * Operations: Is the class with the calculator methods. It has 6 different methods:
        1. Addition: Calculates the addition of two numbers.
        2. Substraction: Calculates the substraction between two numbers.
        3. Division: Calculates the division between two numbers.
        4. Multiplication: Calculates the multiplication of two numbers.
        5. Biggest: Given two numbers calculates the biggest one.
        6. Smallest: Given two numbers calculates the smallest one.
    * NonDivisionByZeroExeption: Arithmetic exception raised by the operation Division.
    
##### 2. TestSuite development.
The testsuit can be located in src/test/java, it is called AllTest.java and cosnsits of two JUnit test classes:
   * MainTest: Is the test class in charge of testing the Calculator class i.e. the main method of the app. There are defined 10 different test cases in file src/main/resources/maintest.xml. These test cases are retrieved using JTestCase, which is a java library that helps in separating test case data from test case units.
   * OperationsTest: This test class tests all the operations method defined in the previous section. In this case the test cases can be located in src/main/resources/operationstest.xml. There are defined two test cases for each test in the class. Morover, in order to try the assertparam tag there is a test case that triggers the NonDivisionByZero exception. This test case is asserted with the error message expected from the exception.
##### 3. Automatize the building process using Maven.
In this project Maven was selected as the project management and building tool
