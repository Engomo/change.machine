import java.util.Random;

public class HUF extends Currency{

    public HUF() {
        super.setName("HUF");
        super.setBankNotes(new int[] {20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5});
        super.setOriginalPrice(roundTheOriginalPrice());
    }

    public int roundTheOriginalPrice() {
      int num = Math.abs(new Random().nextInt());

        if (num % 5 == 0) {
            return num;
        }
        else if (num % 5 <= 2) {

            num = num - num % 5;
            return num;
        }
        else {
            num = num + (5 - num % 5);
            return num;
        }

    }
}
