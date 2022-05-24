
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        long startTime = System.nanoTime();

        ToChange actualChange = ToChange.createRandomToChange();
//        ToChange actualChange = new ToChange(Currencies.HUF, 694977313);
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
        for (int i = 0; i < actualChange.getCurrency().getBankNotesSortedDesc().size(); i++) {
            while (actualPrice >= actualChange.getCurrency().getBankNotesSortedDesc().get(i)) {
                int countItem = actualPrice / actualChange.getCurrency().getBankNotesSortedDesc().get(i);
                actualPrice = actualPrice % actualChange.getCurrency().getBankNotesSortedDesc().get(i);
                result += countItem;
                detailResult.append(countItem + "x " + actualChange.getCurrency().getBankNotesSortedDesc().get(i) + ", ");
            }
        }
        return result;
    }
}
