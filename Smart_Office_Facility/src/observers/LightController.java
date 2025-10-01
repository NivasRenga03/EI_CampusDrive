package src.observers;

import src.models.Room;
import src.utils.Logger;

public class LightController implements RoomObserver {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            Logger.log("Lights turned on for Room " + room.getId() + ".");
        } else {
            Logger.log("Lights turned off for Room " + room.getId() + ".");
        }
    }
}