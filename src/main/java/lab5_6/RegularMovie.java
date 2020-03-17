package lab5_6;

public class RegularMovie extends Movie{

    @Override
    protected int getNumDaysChargeBaseConst() {
        return 2;
    }

    @Override
    protected int getFrequentRenterPointsConst() {
        return 1;
    }

    @Override
    protected double getLongTermRentalCostConst() {
        return 1.5;
    }

    @Override
    protected double getBaseRentalCostConst() {
        return 2.0;
    }

    public RegularMovie(String title) {
        super(title);
    }

}
