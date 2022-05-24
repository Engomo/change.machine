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

    public int roundThePriceIfNeeded() {
        if (this.getCurrency() == Currencies.HUF) {
            return roundHUF();
        } else {
            return this.priceToChange;
        }
    }

    private int roundHUF() {
        int num = this.priceToChange;

        if (num % 5 == 0) {
            return num;
        } else if (num % 5 <= 2) {

            num = num - num % 5;
            return num;
        } else {
            num = num + (5 - num % 5);
            return num;
        }
    }
}
