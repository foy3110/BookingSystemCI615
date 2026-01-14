package Model;
// java bean for room class
public class RoomBean {
    private String roomId;
    private String type;
    private int capacity;
    private String equipment;

    public RoomBean() {}

    public RoomBean(String roomId, String type, int capacity, String equipment) {
        this.roomId = roomId;
        this.type = type;
        this.capacity = capacity;
        this.equipment = equipment;
    }
    // getters
    public String getRoomId() {
        return roomId;
    }
    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
    public String getEquipment() {
        return equipment;
    }

}
