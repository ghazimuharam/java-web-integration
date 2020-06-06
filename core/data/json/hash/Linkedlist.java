package hash;

/**
 * kelas untuk membangun linkedlist
 * 
 * @author Muhammad Ghazi Muharam
 * @since 25-May-2020
 */
public class Linkedlist {
    private Node head;
    private int size;

    /**
     * inisialisasi linkedlist
     */
    public Linkedlist() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
        this.incSize();
    }

    public void incSize() {
        this.size++;
    }

    public void decSize() {
        this.size--;
    }

    public int Size() {
        return this.size;
    }

    public Node getHead() {
        return this.head;
    }

    /**
     * method untuk menambah editor dan title
     * 
     * @param editor nama editor
     * @param title  titlenya
     * @see Node
     * @see Node#getData()
     * @see Data#incFreq()
     * @see Data#addTitle(String)
     * @see Linkedlist#search(String)
     * @see Linkedlist#setHead(Node)
     * @see Linkedlist#getHead()
     */
    public void add(String editor, String title) {
        Node current = this.search(editor);
        if (current == null)
            this.setHead(new Node(new Data(editor, title), this.getHead()));
        else {
            current.getData().incFreq();
            current.getData().addTitle(title);
        }
    }

    /**
     * method untuk menambahkan title
     * 
     * @param title title dari editor
     * @see Linkedlist#getHead()
     */
    public void add(String title) {
        this.setHead(new Node(new Data(title), this.getHead()));
    }

    /**
     * method untuk mencari node editor
     * 
     * @param editor nama editor
     * @return node
     * @see Node
     * @see Node#hasNext()
     * @see Node#getNext()
     * @see Node#getData()
     * @see Data#getEditor()
     * @see Linkedlist#getHead()
     */
    public Node search(String editor) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getEditor().equals(editor)) {
                return current;
            }
            if (!current.hasNext())
                break;
            current = current.getNext();
        }
        return null;
    }

    /**
     * method untuk mencari node editor
     * 
     * @param editor nama editor
     * @return node
     * @see Node
     * @see Node#hasNext()
     * @see Node#getNext()
     * @see Node#getData()
     * @see Data#getEditor()
     * @see Linkedlist#getHead()
     */
    public void matchCase(String editor) {
        Node current = this.getHead();
        while (current != null) {
            if (current.getData().getEditor().toLowerCase().contains(editor.toLowerCase())) {
                System.out.print("{\"editor\":" + "\"" + current.getData().getEditor() + "\",\n");
                System.out.print("\"freq\":" + "\"" + current.getData().getFreq() + "\"},");
            }
            if (!current.hasNext())
                break;
            current = current.getNext();
        }
    }

    /**
     * method untuk menampilkan editor atau title
     * 
     * @param option opsi yang dipilih 0 atau 1
     * @see Linkedlist#getHead()
     * @see Node
     * @see Node#getNext()
     * @see Node#getData()
     * @see Data#getFreq()
     * @see Data#getEditor()
     * @see Data#display()
     */
    public void display(int option) {
        Node current = this.getHead();
        int number = 1;
        while (current != null) {
            if (option == 0) {
                System.out.println(
                        "Editor  : " + current.getData().getEditor() + "\nArtikel : " + current.getData().getFreq());
                current.getData().display();
            } else if (option == 1)
                System.out.println("   " + String.format("%3d", number++) + ". " + current.getData().getEditor());
            else if (option == 2)
                System.out.println("{\"editor\":" + "\"" + current.getData().getEditor() + "\",\n\"freq\":" + "\"" + current.getData().getFreq() + "\"},");
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
    }
}