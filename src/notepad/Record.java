package notepad;

public abstract class Record {
    private static int count = 0; //static - peremennaja dlja vsego klassa
    private int id;

    public Record() { // konstrukotr
        count++;
        id = count;
    }

    public abstract boolean hasSubString(String str);

    public int getId() {
        return id;
    }
}
