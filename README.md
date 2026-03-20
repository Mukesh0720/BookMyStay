# UC2 - Room Modeling using OOP

## Objective

To introduce object-oriented design concepts such as abstraction, inheritance, and polymorphism by modeling different types of rooms in a hotel booking system.

---

## Concepts Covered

* Abstract Class
* Inheritance
* Polymorphism
* Encapsulation
* Static Availability Representation
* Separation of Domain and State

---

## Description

This use case models hotel room types using object-oriented principles.

* `Room` is an abstract class that defines common properties like room type, number of beds, and price.
* `SingleRoom`, `DoubleRoom`, and `SuiteRoom` extend the `Room` class.
* Availability is stored using simple variables instead of data structures.
* Room details and availability are displayed on the console.

---

## Application Flow

1. Application starts from `main()` method
2. Room objects are created using polymorphism
3. Availability is assigned using variables
4. Room details and availability are printed
5. Application terminates

---

## Output

```
====================================
 Welcome to Hotel Booking System 
 Version: v1.0 
====================================

--- Room Details & Availability ---

Room Type: Single Room
Beds: 1
Price: ₹1000
Available: 5

Room Type: Double Room
Beds: 2
Price: ₹2000
Available: 3

Room Type: Suite Room
Beds: 3
Price: ₹5000
Available: 2

Application terminated.
```

---

## Learning Outcome

* Understand abstraction using abstract classes
* Learn inheritance and code reuse
* Use polymorphism for flexible design
* Separate domain objects from system state
* Prepare for future data structure integration

---

## File Structure

```
app/src/
├── HotelBookingApp.java
├── Room.java
├── SingleRoom.java
├── DoubleRoom.java
├── SuiteRoom.java
```
