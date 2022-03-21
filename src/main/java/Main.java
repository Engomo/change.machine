
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert your name: ");
        String name = scanner.nextLine();

        long startTime = System.nanoTime();

        Currency[] currencies = new Currency[]{new EUR(), new HUF()};
        Random random = new Random();
        Currency actualCurrency = currencies[random.nextInt(currencies.length)];

        int result = 0;
        int actualPrice = actualCurrency.getOriginalPrice();
        StringBuilder detailResult = new StringBuilder();

        for (int i = 0; i < actualCurrency.getBankNotes().length; i++) {
            while (actualPrice >= actualCurrency.getBankNotes()[i]) {
                int countItem = actualPrice / actualCurrency.getBankNotes()[i];
                actualPrice = actualPrice % actualCurrency.getBankNotes()[i];
                result += countItem;
                detailResult.append(countItem + "x " + actualCurrency.getBankNotes()[i] + ", ");
            }
        }

        long totalTime = System.nanoTime() - startTime;

        String fileName = name + ".txt";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
//            writer.write("Your name: " + name + "\n");
            writer.write("Currency is: " + actualCurrency.getName() + "\n");
            writer.write("Original price: " + actualCurrency.getOriginalPrice() + "\n");
            writer.write("Result: " + result + " --> " + detailResult + "\n");
            writer.write("Time of calculate: " + totalTime + " nanoseconds");
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (UnsupportedEncodingException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
