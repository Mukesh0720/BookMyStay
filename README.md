# UC4 - Room Search (Read-Only Access)

## Objective

To enable guests to view available rooms and their details without modifying system state, ensuring safe data access and clear separation of responsibilities.

---

## Concepts Covered

* Read-Only Access
* Separation of Concerns
* Defensive Programming
* Domain Model Usage
* Validation Logic

---

## Problem Statement

In previous use cases, room details and availability were displayed directly from the main application.

This approach:

* Mixed display logic with business logic
* Did not enforce read-only behavior
* Made the system harder to scale and maintain

---

## Solution

A dedicated **RoomSearchService** is introduced to handle search functionality.

* Retrieves availability from `RoomInventory`
* Uses `Room` objects for room details
* Filters out unavailable rooms
* Ensures no modification of system state

---

## Description

### Components Involved

#### 1. RoomInventory

* Acts as a centralized data source
* Provides availability using HashMap
* No updates are performed during search

#### 2. Room (Domain Model)

* Provides room details such as:

    * Room type
    * Number of beds
    * Price

#### 3. RoomSearchService

* Handles search logic
* Filters rooms with availability > 0
* Displays only valid options

---

## Application Flow

1. User runs the application
2. Inventory is initialized
3. Search service is created
4. Search operation is performed
5. Only available rooms are displayed
6. Application terminates

---

## Key Features

* No modification of inventory data
* Only available rooms are shown
* Clean separation between search and booking logic
* Reusable and scalable design

---

## Output

Displays:

* Room type
* Number of beds
* Price
* Available count (only if > 0)

---

## Learning Outcome

* Understand read-only system operations
* Implement safe data access patterns
* Apply separation of concerns in system design
* Use validation to filter meaningful results
* Prepare system for future booking integration

---

## File Structure

app/src/
├── HotelBookingApp.java
├── Room.java
├── SingleRoom.java
├── DoubleRoom.java
├── SuiteRoom.java
├── RoomInventory.java
├── RoomSearchService.java

---

## How to Run

### Compile

javac *.java

### Run

java HotelBookingApp
