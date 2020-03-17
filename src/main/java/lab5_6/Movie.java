package lab5_6;

public abstract class Movie {

    protected int getNumDaysChargeBaseConst() {
        return -1;
    }

    protected int getFrequentRenterPointsConst() {
        return -1;
    }

    protected double getLongTermRentalCostConst() {
        return -1;
    }

    protected double getBaseRentalCostConst() {
        return -1;
    }

    private String _title;

    public Movie(String title) {
        _title = title;
    }

    public String get_title() {
        return _title;
    }

    public int getFrequentRenterPoints(int daysRaunted){
        return getFrequentRenterPointsConst();
    }

    public double getCharge(int daysGraunted){
        double res = getBaseRentalCostConst();
        int days = getNumDaysChargeBaseConst();
        if (daysGraunted > days){
            res += (daysGraunted - days) * getLongTermRentalCostConst();
        }
        return res;
    }
}
