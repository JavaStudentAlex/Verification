package lab5_6;

public class ChildrensMovie extends Movie {

    @Override
    protected int getNumDaysChargeBaseConst() {
        return 3;
    }

    @Override
    protected int getFrequentRenterPointsConst() {
        return 1;
    }

    @Override
    protected double getLongTermRentalCostConst() {
        return 1.25;
    }

    @Override
    protected double getBaseRentalCostConst() {
        return 1.5;
    }

    public ChildrensMovie(String title) {
        super(title);
    }
}
