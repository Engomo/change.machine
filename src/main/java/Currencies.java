public enum Currencies {
    EUR(new int[]{500, 200, 100, 50, 20, 10, 5, 2, 1}),
    HUF(new int[]{20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5});

    public int[] bankNotes;

    Currencies(int[] bankNotes) {
        this.bankNotes = bankNotes;
    }

}
