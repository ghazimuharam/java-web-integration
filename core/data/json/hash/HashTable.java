package hash;

/**
 * Kelas untuk membangun hashtable
 * 
 * @author Muhammad Ghazi Muharam
 * @since 25-May-2020
 */
public class HashTable {
    Linkedlist[] hash;

    /**
     * method untuk penginisialisasi hashtable
     * 
     * @param size size dari Linkedlist
     */
    public HashTable(int size) {
        this.hash = new Linkedlist[size];
    }

    /**
     * method untuk add editor dan title
     * 
     * @param editor nama editor
     * @param title  titlenya
     * @see Linkedlist#add(String, String)
     * @see HashTable#key(String)
     */
    public void add(String editor, String title) {
        int index = this.key(editor);
        if (hash[index] == null)
            hash[index] = new Linkedlist();
        hash[index].add(editor, title);
    }

    /**
     * method untuk menampilkan semua editor dan title
     * 
     * @see HashTable#display(int)
     */
    public void display() {
        System.out.println("[");
        for (int a = 0; a < hash.length; a++) {
            this.display(a);
        }
        System.out.println("{}");
        System.out.println("]");
    }

    /**
     * method untuk menampilkan editor berdasarkan hashkeynya
     * 
     * @param index hash key
     * @see Linkedlist#display(int)
     */
    public void display(int index) {
        if (this.hash[index] != null)
            this.hash[index].display(2);
    }

    /**
     * method untuk mencari hash key
     * 
     * @param editor hash key editor
     * @return hash key
     */
    private int key(String editor) {
        int uplowchar = (int) Math.pow(2, 8);
        int digit = 1;
        int index = 0;
        for (char i : editor.toCharArray()) {
            index = (index + (i + 1) * digit) % hash.length;
            digit = (digit * uplowchar) % hash.length;
        }
        return index;
    }

    /**
     * method untuk mencari editor
     * 
     * @param editor nama editor
     * @see Node
     * @see Node#getData()
     * @see Linkedlist#search(String)
     * @see HashTable#key(String)
     * @see Data#display()
     * @see Data#getFreq()
     */
    public void searchKey(String editor) {
        int index = this.key(editor);
        boolean isBegin = false;
        if (this.hash[index] != null) {
            Node current = this.hash[index].search(editor);
            System.out.print("[");
            if (current != null) {
                if (isBegin)
                    System.out.print(",");
                System.out.print("{\"editor\":" + "\"" + current.getData().getEditor() + "\",\n");
                System.out.print("\"freq\":" + "\"" + current.getData().getFreq() + "\"}");
                isBegin = true;
            }
            System.out.print("]");
        } else
            System.out.print("[]");
    }

    public void searchMatchCase(String editor) {
        System.out.print("[");
        for (int a = 0; a < hash.length; a++) {
            if (this.hash[a] != null) {
                this.hash[a].matchCase(editor);
            }
        }
        System.out.print("{}]");
    }
}