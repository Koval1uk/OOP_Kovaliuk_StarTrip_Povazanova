package src.mode;

public class Restaurants {
    private String roomNum;
    private String mealType;
    private String mealTime;
    private int portion;
    private double price;


    public Restaurants() {

    }

    public Restaurants(String roomNum, String mealType, String mealTime, int portion, double price) {
        this.roomNum = roomNum;
        this.mealType = mealType;
        this.mealTime = mealTime;
        this.portion = portion;
        this.price = price;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Restaurants{" +
                "roomNum='" + roomNum + '\'' +
                ", mealType='" + mealType + '\'' +
                ", mealTime='" + mealTime + '\'' +
                ", portion=" + portion +
                ", price=" + price +
                '}';
    }

    public String getRoom() {
        return getRoom();
    }

    public String getCuisine() {
        return getCuisine();
    }

    public String getMeals() {
        return getMeals();
    }

    public String getRating() {
        return getRating();
    }
}
