public class Currency {

    private String name;

    private int originalPrice;

    private int[] bankNotes;

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setBankNotes(int[] bankNotes) {
        this.bankNotes = bankNotes;
    }

    public String getName() {
        return name;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public int[] getBankNotes() {
        return bankNotes;
    }
}
