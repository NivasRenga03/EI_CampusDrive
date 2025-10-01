package src.observers;

import src.models.Room;
import src.utils.Logger;

public class ACController implements RoomObserver {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            Logger.log("AC turned on for Room " + room.getId() + ".");
        } else {
            Logger.log("AC turned off for Room " + room.getId() + ".");
        }
    }
}