public class ToChange {

    private Currencies currency;

    private int priceToChange;

    public ToChange(Currencies currency, int priceToChange) {
        this.currency = currency;
        this.priceToChange = priceToChange;
    }

    public Currencies getCurrency() {
        return currency;
    }

    public int getPriceToChange() {
        return priceToChange;
    }
}
