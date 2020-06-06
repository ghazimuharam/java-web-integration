import hash.*;
import file.ReadFile;
import java.util.Scanner;

/**
 * Implementasi Linkedlist di java
 * 
 * @author Muhammad Ghazi Muharam
 * @since 25-May-2020
 */
public class Main {
    public static void main(String q[]) {
        ReadFile file = new ReadFile("file/data.txt");
        HashTable hash = new HashTable(file.getLine().size());
        file.getLine().forEach((line) -> {
            String[] data = line.split("::");
            hash.add(data[0], data[1]);
        });

        Scanner user = new Scanner(System.in);
        if(q[0].equals("all")){
            hash.display();
        }else{
            hash.searchMatchCase(q[0]);
        }
        user.close();
    }
}