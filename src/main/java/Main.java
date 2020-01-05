import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        char[] chars = game.initialize();
        System.out.println(game.designTheTable(chars));
        boolean isValidCoordinates;
        char order = 'X';
        XyValue xyValue;
        do {
            do {
                System.out.print("Enter the coordinates: ");
                String x = sc.next();
                String y = sc.next();
                xyValue = new XyValue(x, y);
                isValidCoordinates = game.isInputCoordinatesValid(chars, xyValue);
            } while (!isValidCoordinates);
            char[] renewedChars = game.addCharInPosition(chars, xyValue, order);
            order = game.swapOrders(order);
            System.out.println(game.designTheTable(renewedChars));
        }while (!game.hasFinished(chars));
    }
}
