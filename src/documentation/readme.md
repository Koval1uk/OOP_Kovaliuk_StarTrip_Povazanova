# Oleksandr Kovaliuk

## Star Trip

My program works in such a way that you can either be an admin or a receptionist. The concept is that you can, as a receptionist, record some kind of vacation, for example, reserve a room in a hotel, or choose a restaurant and reserve a table in a restaurant with all your information. At the end of the day it all comes down to lenghs so you will be billed for each activity you seek.

## Fulfillment of criteria

- Encapsulation
- MultiThreading for creating bots
- RTTI
- Lambda
- Nested class and interface
- Patterns
- Singletone
- Own exceptions
- DataBaseException, UserException
- Interface default method
- Seriallization

## Certain implementations

* Polymorphism
* Inheritance
* Interface
* DataBase.java

### Main criteria

* Polymorphism
    * NationalRestaurant
    * TraditionalRestaurant
* Inheritance
    * all apartmentsPart/restaurantsPart and transportation
* Interface
    * DataBaseItemInterface.java

### Secondary criteria

* Encapsulation
    * Almost every class
* Patterns
    * Singletone | DataBaseSQL.java
* Own exceptions
    * DataBaseException, UserException
* MultiThreading
    * NationalRestaurant
* RTTI
    * Transportation
* Lambda
    * NationalRestaurant
* Nested class
    * Transportation
* Interface
  * ApartmentsOperations
  * DataBaseItemInterface
* Interface default method
    * ApartmentOperations
* Serialization
    * NationalRestaurant
    *  TraditionalDish
* Aggregation
    * Apartments
    * Tenant
    * SharedApartment
* DataBase
    * MySQL

### Technical details:

*  Environment setup
  *  Intellij 2022.2
  *   JDK 20
  *   JavaFX 19
  * JFoenix 8.0.8
  *  Scene
  *   MySQL Connector/J 9.0.05
*  Installation
  *   Download Mysql and write userName and password for this, so the programm will work properly.
  * Do not forget to apply all your modification and libraries in InteliJIDEA or Eclipse  
* VM options:
  *   --module-path "lib" --add-modules javafx.controls,javafx.fxml
  *    lib - path to JavaFX libary, for example - C:\Users\Admin\Desktop\JavaFX\lib
  *    If you're using Eclipse, change your PATH to true
*    MySQL
  *  After launching MySQL you have to recompile my programm so it will work properly. Do not forget to write into MySQL Workbench in the servers my own localhost, if no, programm will not show you tables

~~~~