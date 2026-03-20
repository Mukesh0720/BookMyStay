# UC5 - Booking Request Queue (FIFO)

## Objective

To handle multiple booking requests fairly by introducing a queue-based request intake mechanism that preserves arrival order.

---

## Concepts Covered

* Queue Data Structure
* FIFO (First-In-First-Out)
* Fairness in request handling
* Decoupling request intake from allocation

---

## Problem Statement

During peak demand, multiple booking requests may arrive simultaneously.

Without proper ordering:

* Requests may be processed unfairly
* Some users may bypass others
* System behavior becomes inconsistent

---

## Solution

A **Queue<Reservation>** is introduced to store booking requests.

* Requests are added to the queue
* Queue maintains insertion order automatically
* Processing follows FIFO principle

---

## Components

### 1. Reservation

* Represents a booking request
* Contains guest name and requested room type

### 2. BookingQueue

* Stores requests using Queue
* Adds requests using `offer()`
* Displays queue without removing elements

---

## Application Flow

1. Guest submits booking request
2. Request is added to queue
3. Requests are stored in arrival order
4. Queue is displayed
5. No inventory changes occur

---

## Key Features

* Fair request handling (FIFO)
* No request bypassing
* No inventory mutation
* Clean separation from allocation logic

---

## Output

Displays:

* Guest name
* Requested room type
* Order of requests (FIFO)

---

## Learning Outcome

* Understand Queue data structure
* Implement FIFO behavior
* Ensure fairness in system design
* Prepare for booking allocation logic

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
├── Reservation.java
├── BookingQueue.java

---

## How to Run

### Compile

javac *.java

### Run

java HotelBookingApp
