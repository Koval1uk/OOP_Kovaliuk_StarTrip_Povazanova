package src.mode;

public class PaymentStat {
    private String month;
    private double roomCgh;
    private double mealCgh;
    private double serviceCgh;
    private double monthAll;
    private double yearAll;


    public PaymentStat(String text, double v, double parseDouble, double aDouble) {
        this.month=text;
        this.roomCgh=v;
        this.mealCgh=parseDouble;
        this.serviceCgh=aDouble;
    }

    public PaymentStat(String month, double roomCgh, double mealCgh, double serviceCgh, double monthAll, double yearAll) {
        this.month = month;
        this.roomCgh = roomCgh;
        this.mealCgh = mealCgh;
        this.serviceCgh = serviceCgh;
        this.monthAll = monthAll;
        this.yearAll = yearAll;
    }


    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getRoomCgh() {
        return roomCgh;
    }

    public void setRoomCgh(double roomCgh) {
        this.roomCgh = roomCgh;
    }

    public double getMealCgh() {
        return mealCgh;
    }

    public void setMealCgh(double mealCgh) {
        this.mealCgh = mealCgh;
    }

    public double getServiceCgh() {
        return serviceCgh;
    }

    public void setServiceCgh(double serviceCgh) {
        this.serviceCgh = serviceCgh;
    }
    public double getMonthAll() {
        return monthAll;
    }

    public void setMonthAll(double monthAll) {
        this.monthAll = monthAll;
    }

    public double getYearAll() {
        return yearAll;
    }

    public void setYearAll(double yearAll) {
        this.yearAll = yearAll;
    }

    @Override
    public String toString() {
        return "PaymentStat{" +
                "month='" + month + '\'' +
                ", roomCgh=" + roomCgh +
                ", mealCgh=" + mealCgh +
                ", serviceCgh=" + serviceCgh +
                ", monthAll=" + monthAll +
                ", yearAll=" + yearAll +
                '}';
    }

    public String getIncome() {
        return getIncome();
    }

    public String getExpenses() {
        return getExpenses();
    }

    public String getProfit() {
        return getProfit();
    }

    public String getTaxPaid() {
        return getTaxPaid();
    }

    public String getNetProfit() {
        return getNetProfit();
    }
}
