import java.util.Arrays;
import java.util.List;

/**
 * RoomSearchService handles read-only search operations.
 * It retrieves available rooms without modifying system state.
 */
class RoomSearchService {

    private RoomInventory inventory;

    public RoomSearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    // Search and display available rooms
    public void searchAvailableRooms() {

        System.out.println("\n--- Available Rooms ---");

        // List of all room types (domain objects)
        List<Room> rooms = Arrays.asList(
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        );

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.roomType);

            // Show only available rooms
            if (available > 0) {
                room.displayDetails();
                System.out.println("Available: " + available + "\n");
            }
        }
    }
}