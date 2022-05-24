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

    public static ToChange createRandomToChange(){
        Random random = new Random();
        int priceToChange = Math.abs(random.nextInt());
        List<Currencies> currencies = Arrays.asList(Currencies.values());
        Currencies currency = currencies.get(random.nextInt(currencies.size()));
        ToChange randomToChange = new ToChange(currency, priceToChange);
        return randomToChange;
    }
}
