
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Currency[] currencies = new Currency[]{new EUR(), new HUF()};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Insert your name: ");
        String name = scanner.nextLine();

        long startTime = System.nanoTime();

        Currency actualCurrency = currencies[random.nextInt(currencies.length)];

        int result = 0;
        int actualPrice = actualCurrency.getOriginalPrice();

        for (int i = 0; i < actualCurrency.getBankNotes().length; i++) {
            while (actualPrice >= actualCurrency.getBankNotes()[i]) {
                int countIntem = actualPrice / actualCurrency.getBankNotes()[i];
                actualPrice = actualPrice % actualCurrency.getBankNotes()[i];
                result += countIntem;
            }
        }

        long totalTime = System.nanoTime() - startTime;

        String fileName = name + ".txt";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
            writer.write("Your name: " + name + "\n");
            writer.write("Currency is: " + actualCurrency.getName() + "\n");
            writer.write("Original price: " + actualCurrency.getOriginalPrice() + "\n");
            writer.write("Result is: " + result + "\n");
            writer.write("Time of calculate: " + totalTime + " nanoseconds");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
