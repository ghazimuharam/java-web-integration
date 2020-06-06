package hash;

/**
 * Kelas untuk objek editor dan title
 * 
 * @author Muhammad Ghazi Muharam
 * @since 25-May-2020
 */
public class Data {
    private String editor;
    private int freq;
    private Linkedlist titles;

    /**
     * Method constructor untuk memasukkan title
     * 
     * @param title title dari editor
     */
    public Data(String title) {
        this.editor = title;
        this.freq = 1;
    }

    /**
     * Method constructor untuk memasukkan nilai awal editor dan titlenya
     * 
     * @param editor nama editor
     * @param title  title dari editor
     */
    public Data(String editor, String title) {
        this.editor = editor;
        this.freq = 1;
        titles = new Linkedlist();
        this.addTitle(title);
    }

    /**
     * Method penambahan title
     * 
     * @param title title dari editor yang ingin dimasukkan
     * @see Linkedlist#add(String)
     */
    public void addTitle(String title) {
        titles.add(title);
    }

    public Linkedlist getTitles() {
        return this.titles;
    }

    /**
     * Method untuk menampilkan semua title dari editor
     * 
     * @see Linkedlist#display(int)
     */
    public void display() {
        this.titles.display(1);
    }

    public String getEditor() {
        return this.editor;
    }

    public int getFreq() {
        return this.freq;
    }

    public void incFreq() {
        this.freq += 1;
    }
}
