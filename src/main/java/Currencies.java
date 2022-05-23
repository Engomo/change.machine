public enum Currencies {
    EUR("EUR", new int[]{500, 200, 100, 50, 20, 10, 5, 2, 1}),
    HUF("HUF", new int[]{20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5});

    public String name;
    public int[] bankNotes;

    Currencies(String name, int[] bankNotes) {
    }

}
