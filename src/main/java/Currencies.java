import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public enum Currencies {
    EUR(new int[]{200, 100, 50, 20, 10, 5, 2, 1, 500}),
    HUF(new int[]{2000,20000, 10000, 5000, 1000, 500, 200, 100, 50, 20, 10, 5});

    private int[] bankNotes;

    Currencies(int[] bankNotes) {
        this.bankNotes = bankNotes;
    }

    public ArrayList<Integer> getBankNotesSortedDesc() {
        ArrayList<Integer> bankNoteList = new ArrayList<>(Arrays.stream(bankNotes).boxed().collect(Collectors.toList()));
        bankNoteList.sort(Collections.reverseOrder());
        return bankNoteList;
    }

    public boolean isRoundable(){
        ArrayList<Integer> bankNoteList = new ArrayList<>(getBankNotesSortedDesc());
        if(bankNoteList.get(bankNoteList.size() - 1) != 1){
            return true;
        }
        else {
            return false;
        }
    }
}
