# UC6 - Booking Allocation & Inventory Update

## Objective

To confirm booking requests by assigning rooms safely while ensuring inventory consistency and preventing double-booking.

---

## Concepts Covered

* Set (Uniqueness enforcement)
* HashMap (Grouped tracking)
* FIFO Queue Processing
* Inventory Synchronization
* Atomic Operations

---

## Problem Statement

Without controlled allocation:

* Same room may be assigned multiple times
* Inventory may become inconsistent
* Booking system becomes unreliable

---

## Solution

A BookingService is introduced to:

* Process requests from queue (FIFO)
* Assign unique room IDs
* Prevent duplicates using Set
* Update inventory immediately

---

## Components

### 1. BookingService

* Handles booking logic
* Ensures safe allocation

### 2. Set<String>

* Stores allocated room IDs
* Prevents duplicates

### 3. HashMap<String, Set<String>>

* Maps room types to allocated room IDs

---

## Application Flow

1. Booking requests are dequeued
2. Availability is checked
3. Unique room ID is generated
4. Room is allocated
5. Inventory is updated
6. Booking is confirmed

---

## Key Features

* No double booking
* FIFO processing
* Real-time inventory updates
* Consistent system state

---

## Learning Outcome

* Implement uniqueness using Set
* Combine multiple data structures
* Handle real-world booking scenarios
* Ensure system consistency

---

## File Structure

app/src/
├── HotelBookingApp.java
├── RoomInventory.java
├── BookingQueue.java
├── BookingService.java
... (other files)

---

## How to Run

### Compile

javac *.java

### Run

java HotelBookingApp
