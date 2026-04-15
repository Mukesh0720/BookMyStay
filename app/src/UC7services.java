import java.util.*;
class Reservation {
    private String reservationId;
    private String guestName;
    private String roomType;

    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}
class RoomInventory {
    private Map<String, Integer> rooms = new HashMap<>();

    public void addRoomType(String type, int count) {
        rooms.put(type, count);
    }

    public int getAvailability(String type) {
        return rooms.getOrDefault(type, 0);
    }

    public void updateAvailability(String type, int count) {
        rooms.put(type, count);
    }
}
class BookingQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    public void addReservation(Reservation r) {
        queue.offer(r);
    }

    public Queue<Reservation> getQueue() {
        return queue;
    }
}
class BookingService {

    private RoomInventory inventory;
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> roomAllocations;

    public BookingService(RoomInventory inventory) {
        this.inventory = inventory;
        this.allocatedRoomIds = new HashSet<>();
        this.roomAllocations = new HashMap<>();
    }
    public void processBookings(BookingQueue bookingQueue) {

        System.out.println("\n--- Processing Bookings ---");

        Queue<Reservation> queue = bookingQueue.getQueue();

        while (!queue.isEmpty()) {

            Reservation reservation = queue.poll();
            String roomType = reservation.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                String roomId = generateRoomId(roomType);

                allocatedRoomIds.add(roomId);

                roomAllocations
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                inventory.updateAvailability(roomType, available - 1);

                System.out.println("Booking Confirmed!");
                System.out.println("Reservation ID: " + reservation.getReservationId());
                System.out.println("Guest: " + reservation.getGuestName());
                System.out.println("Room Type: " + roomType);
                System.out.println("Assigned Room ID: " + roomId + "\n");

            } else {
                System.out.println("Booking Failed for "
                        + reservation.getGuestName() + " - No Availability");
            }
        }
    }
    private String generateRoomId(String roomType) {

        String prefix = roomType.replace(" ", "").substring(0, 3).toUpperCase();

        String roomId;
        do {
            roomId = prefix + "-" + (int) (Math.random() * 1000);
        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }
}
class AddOnService {
    private String name;
    private double cost;

    public AddOnService(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + " (₹" + cost + ")";
    }
}

/**
 * Add-On Service Manager
 */
class AddOnServiceManager {

    // Reservation ID → List of Services
    private Map<String, List<AddOnService>> serviceMap = new HashMap<>();

    public void addService(String reservationId, AddOnService service) {
        serviceMap
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    public List<AddOnService> getServices(String reservationId) {
        return serviceMap.getOrDefault(reservationId, new ArrayList<>());
    }

    public double calculateTotalCost(String reservationId) {
        double total = 0;
        for (AddOnService s : getServices(reservationId)) {
            total += s.getCost();
        }
        return total;
    }

    public void displayServices(String reservationId) {
        List<AddOnService> services = getServices(reservationId);

        System.out.println("\nAdd-On Services for Reservation: " + reservationId);

        if (services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        for (AddOnService s : services) {
            System.out.println("- " + s);
        }

        System.out.println("Total Add-On Cost: ₹" + calculateTotalCost(reservationId));
    }
}
public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        inventory.addRoomType("Deluxe Room", 2);
        inventory.addRoomType("Suite", 1);
        BookingQueue queue = new BookingQueue();
        Reservation r1 = new Reservation("RES1", "Arun", "Deluxe Room");
        Reservation r2 = new Reservation("RES2", "Priya", "Suite");
        queue.addReservation(r1);
        queue.addReservation(r2);
        BookingService bookingService = new BookingService(inventory);
        bookingService.processBookings(queue);
        AddOnServiceManager serviceManager = new AddOnServiceManager();
        serviceManager.addService("RES1", new AddOnService("Breakfast", 500));
        serviceManager.addService("RES1", new AddOnService("Airport Pickup", 1200));
        serviceManager.addService("RES2", new AddOnService("Spa", 2000));
        serviceManager.displayServices("RES1");
        serviceManager.displayServices("RES2");
    }
}