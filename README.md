# UC7 - Add-On Service Selection

## Objective

To extend the booking system by allowing guests to select optional services without modifying core booking or inventory logic.

---

## Concepts Covered

* Map + List Combination
* One-to-Many Relationship
* Composition over Inheritance
* Separation of Concerns
* Cost Aggregation

---

## Problem Statement

Without add-on service support:

* Bookings remain static and inflexible
* No way to attach additional services
* Real-world booking scenarios cannot be modeled
* Pricing lacks modularity

---

## Solution

An AddOnServiceManager is introduced to:

* Attach multiple services to a reservation
* Maintain a mapping between reservation and services
* Calculate additional cost separately
* Keep booking and inventory logic unchanged

---

## Components

### 1. AddOnService

* Represents a service (e.g., Breakfast, Spa)
* Contains service name and cost

### 2. AddOnServiceManager

* Manages service selection
* Stores mapping of reservation → services

### 3. Map<String, List<AddOnService>>

* Maps reservation ID to list of services
* Enables efficient lookup and flexible expansion

---

## Application Flow

1. Booking is completed (from UC6)
2. Guest selects add-on services
3. Services are added to a list
4. List is mapped to reservation ID
5. Total add-on cost is calculated
6. Booking system remains unchanged

---

## Key Features

* Multiple services per reservation
* Clean separation from booking logic
* Easy addition of new services
* Modular cost calculation
* No impact on inventory system

---

## Learning Outcome

* Implement one-to-many relationships
* Use Map and List together effectively
* Design extensible systems
* Separate core and optional features
* Build modular pricing systems

---

## File Structure

app/src/
├── HotelBookingApp.java
├── RoomInventory.java
├── BookingQueue.java
├── BookingService.java
├── AddOnService.java
├── AddOnServiceManager.java
... (other files)

---

## How to Run

### Compile

javac *.java

### Run

java HotelBookingApp
