import java.util.*;

class Participant {
    private int id;
    private String name;
    private String email;

    public Participant(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}

class Event {
    private int eventId;
    private String eventName;
    private int capacity;
    private List<Participant> participants;

    public Event(int eventId, String eventName, int capacity) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.capacity = capacity;
        this.participants = new ArrayList<>();
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public boolean addParticipant(Participant p) {
        if (participants.size() < capacity) {
            participants.add(p);
            return true;
        }
        return false;
    }

    public void displayParticipants() {
        if (participants.isEmpty()) {
            System.out.println("No participants registered.");
        } else {
            for (Participant p : participants) {
                System.out.println(p);
            }
        }
    }
}

public class EventManagementSystem {
    private static Map<Integer, Event> events = new HashMap<>();

    public static void main(String[] args) {
        Event event1 = new Event(1, "Tech Fest", 2);
        events.put(1, event1);

        Participant p1 = new Participant(101, "Arun", "arun@gmail.com");
        Participant p2 = new Participant(102, "Bala", "bala@gmail.com");
        Participant p3 = new Participant(103, "Cathy", "cathy@gmail.com");

        event1.addParticipant(p1);
        event1.addParticipant(p2);

        if (!event1.addParticipant(p3)) {
            System.out.println("Event capacity is full. Cathy cannot be registered.");
        }

        System.out.println("\nParticipants for " + event1.getEventName() + ":");
        event1.displayParticipants();
    }
}