import java.util.*;

/**
 * BookingService processes booking requests and performs room allocation.
 */
class BookingService {

    private RoomInventory inventory;
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> roomAllocations;

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
        this.allocatedRoomIds = new HashSet<>();
        this.roomAllocations = new HashMap<>();
    }

    // Process booking requests from queue
    public void processBookings(BookingQueue bookingQueue) {

        System.out.println("\n--- Processing Bookings ---");

        Queue<Reservation> queue = bookingQueue.getQueue();

        while (!queue.isEmpty()) {

            Reservation reservation = queue.poll(); // FIFO
            String roomType = reservation.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Store allocation
                allocatedRoomIds.add(roomId);

                roomAllocations
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                // Update inventory immediately
                inventory.updateAvailability(roomType, available - 1);

                System.out.println("Booking Confirmed!");
                System.out.println("Guest: " + reservation.getGuestName());
                System.out.println("Room Type: " + roomType);
                System.out.println("Assigned Room ID: " + roomId + "\n");

            } else {
                System.out.println("Booking Failed (No Availability) for "
                        + reservation.getGuestName() + " - " + roomType);
            }
        }
    }

    // Generate unique room ID
    private String generateRoomId(String roomType) {

        String prefix = roomType.replace(" ", "").substring(0, 3).toUpperCase();

        String roomId;
        do {
            roomId = prefix + "-" + (int) (Math.random() * 1000);
        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }
}