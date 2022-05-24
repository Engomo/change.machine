import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ToChange {

    private Currencies currency;

    private int priceToChange;

    public ToChange(Currencies currency, int priceToChange) {
        if (priceToChange < 0) {
            throw new IllegalArgumentException("Nem lehet negatív!");
        }
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
        if (this.getCurrency().isRoundable()) {
            return roundHUF();
        } else {
            return this.priceToChange;
        }
    }

    private int roundHUF() {
        if (this.priceToChange % 5 == 0) {
            return this.priceToChange;
        } else if (this.priceToChange % 5 <= 2) {
            this.priceToChange = this.priceToChange - this.priceToChange % 5;
            return this.priceToChange;
        } else {
            this.priceToChange = this.priceToChange + (5 - this.priceToChange % 5);
            return this.priceToChange;
        }
    }

    public static ToChange createRandomToChange(){
        Random random = new Random();
        int priceToChange = Math.abs(random.nextInt());
        List<Currencies> currencies = Arrays.asList(Currencies.values());
        Currencies currency = currencies.get(random.nextInt(currencies.size()));
        ToChange randomToChange = new ToChange(currency, priceToChange);
        return randomToChange;
    }
}
