package src.mode;

public class deletingMethod {
    private String roomNum;
    private String time;

    public deletingMethod() {
    }

    public deletingMethod(String roomNum, String time) {
        this.roomNum = roomNum;
        this.time = time;
    }

    public deletingMethod(String time) {
        this.time=time;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "deletingMethod{" +
                "roomNum='" + roomNum + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getRoom() {
        return getRoom();
    }

    public String getCleaningTime() {
        return getCleaningTime();
    }
}
