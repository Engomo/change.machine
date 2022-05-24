
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert your name: ");
        String name = scanner.nextLine();

        long startTime = System.nanoTime();

        Random random = new Random();
        List<Currencies> currencies = Arrays.asList(Currencies.values());
        ToChange actualChange = new ToChange(currencies.get(random.nextInt(currencies.size())),Math.abs(random.nextInt()));
        actualChange.roundThePriceIfNeeded();

        int result = 0;
        int actualPrice = actualChange.getPriceToChange();
        StringBuilder detailResult = new StringBuilder();

        result = getResult(actualChange, result, actualPrice, detailResult);

        long totalTime = System.nanoTime() - startTime;

        writeTheFile(name, actualChange, result, detailResult, totalTime);
    }

    private static void writeTheFile(String name, ToChange actualChange, int result, StringBuilder detailResult, long totalTime) {
        String fileName = name + ".txt";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
            writer.write("Your name: " + name + "\n");
            writer.write("Currency is: " + actualChange.getCurrency().name() + "\n");
            writer.write("Original price: " + actualChange.getPriceToChange() + "\n");
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

    private static int getResult(ToChange actualChange, int result, int actualPrice, StringBuilder detailResult) {
        for (int i = 0; i < actualChange.getCurrency().bankNotes.length; i++) {
            while (actualPrice >= actualChange.getCurrency().bankNotes[i]) {
                int countItem = actualPrice / actualChange.getCurrency().bankNotes[i];
                actualPrice = actualPrice % actualChange.getCurrency().bankNotes[i];
                result += countItem;
                detailResult.append(countItem + "x " + actualChange.getCurrency().bankNotes[i] + ", ");
            }
        }
        return result;
    }
}
