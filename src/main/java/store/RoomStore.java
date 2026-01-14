package store;
import Model.RoomBean;
import java.util.ArrayList;
import java.util.List;


public class RoomStore {
    private static RoomStore instance;
    private List<RoomBean> rooms = new ArrayList<>();

    private RoomStore() {
        // creates instances of the room bean class and adds them to the list
        rooms.add(new RoomBean("R1","synth Studio",1,"Synth"));
        rooms.add(new RoomBean("R2","Piano Studio",2,"Piano"));
        rooms.add(new RoomBean("R3","Acoustic Suite",3,"guitar, banjo"));
        rooms.add(new RoomBean("R4","drumming Studio",1,"Piano"));
        rooms.add(new RoomBean("R5","all Purpose",4,"na"));
    }
    //creates new instance or returns existing
    public static RoomStore getInstance() {
        if (instance == null) {
            instance = new RoomStore();
        }
        return instance;
    }
    //getter for the list
    public List<RoomBean> getRooms() {
        return rooms;
    }
}
