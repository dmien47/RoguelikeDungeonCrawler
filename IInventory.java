//interface
import java.util.Scanner;

public interface IInventory {
    void addItem(Item item);
    void showItems();
    void useItem(Scanner scanner, Player player);
}