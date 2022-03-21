import java.util.Random;

public class HUF extends Currency{

    public HUF() {
        super.setName("HUF");
        super.setBankNotes(new int[] {20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5});
        super.setOriginalPrice(Math.abs(new Random().nextInt() /5) * 5);
    }

}
