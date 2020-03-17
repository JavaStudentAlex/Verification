package lab5_6;

public class NewRealiseMovie extends Movie {


    private final int NUM_DAYS_RAUNT_POINTS_BASE = 2;
    private final int NUM_FREQUENT_RENTER_POINTS_INCREASE = 1;

    @Override
    protected int getNumDaysChargeBaseConst() {
        return 1;
    }

    @Override
    protected double getBaseRentalCostConst() {
        return 3.0;
    }

    @Override
    protected int getFrequentRenterPointsConst() {
        return 1;
    }

    public NewRealiseMovie(String title) {
        super(title);
    }

    @Override
    public int getFrequentRenterPoints(int daysRaunted) {
        int res = getFrequentRenterPointsConst();
        if (daysRaunted >= NUM_DAYS_RAUNT_POINTS_BASE){
            res += NUM_FREQUENT_RENTER_POINTS_INCREASE;
        }
        return res;
    }

    @Override
    public double getCharge(int daysGraunted) {
        return daysGraunted * getBaseRentalCostConst();
    }
}
