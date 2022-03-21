import java.util.Random;

public class EUR extends Currency{

    public EUR() {
        super.setName("EUR");
        super.setBankNotes(new int[] {500, 200, 100, 50, 20, 10, 5, 2, 1});
        super.setOriginalPrice(Math.abs(new Random().nextInt()));
    }
}
