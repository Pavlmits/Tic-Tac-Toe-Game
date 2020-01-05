import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Game {

    private Map<XyValue, Integer> xyMap = CoordinatesUtil.getCoordinates();

    char[] initialize() {
        char[] chars = new char[9];
        Arrays.fill(chars, ' ');
        return chars;
    }

    String designTheTable(char[] chars) {
        final StringBuilder table = new StringBuilder();
        char[] replaced = CharUtil.replaceUnderscoresWithSpaces(chars);
        table.append("---------\n");
        for (int i = 0; i < chars.length; i = i + 3) {
            table.append("| ").append(replaced[i]).append(" ").append(replaced[i + 1]).append(" ").append(replaced[i + 2]).append(" |\n");
        }
        table.append("---------\n");
        return table.toString();
    }

    char[] addCharInPosition(char[] chars, XyValue xyValue, char charOrder) {
        int value = xyMap.get(xyValue);
        chars[value] = charOrder;
        return chars;
    }

    boolean isInputCoordinatesValid(char[] chars, XyValue xyValue) {
        int value = xyMap.get(xyValue) == null ? 0 : xyMap.get(xyValue);
        if (!isNumeric(xyValue.getX()) && !isNumeric(xyValue.getY())) {
            System.out.println("You should enter numbers!");
            return false;
        } else if (Integer.parseInt(xyValue.getX()) > 3 || Integer.parseInt(xyValue.getY()) > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        } else if (chars[value] == 'X' || chars[value] == 'O') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        } else return true;
    }

    boolean hasFinished(char[] chars) {
        final CharUtil charUtil = new CharUtil();
        if (checkWinner(chars) != 'N') return true;
        else if (charUtil.isAnyOccurrences(chars, ' ') && !charUtil.isAnyOccurrences(chars, '_')) return false;
        else {
            System.out.println("Draw");
            return true;
        }
    }

    char swapOrders(char currentOrder) {
        if (currentOrder == 'X') return 'O';
        else return 'X';
    }

    private char checkWinner(char[] chars) {
        List<Character> winners = new ArrayList<>();
        winners.add(takeThreeInARowDiagonal(chars));
        winners.add(takeThreeInARowVertical(chars));
        winners.add(takeThreeInARowHorizontal(chars));
        if (winners.contains('X')) {
            System.out.println("X wins");
            return 'X';
        } else if (winners.contains('O')) {
            System.out.println("O wins");
            return 'O';
        } else return 'N';
    }

    private char takeThreeInARowHorizontal(char[] chars) {
        for (int i = 0; i < chars.length; i = i + 3) {
            if (chars[i] == chars[i + 1] && chars[i] == chars[i + 2] && chars[i] != '_' && chars[i] != ' ') {
                return chars[i];
            }
        }
        return 'N';
    }

    private char takeThreeInARowVertical(char[] chars) {
        for (int i = 0; i < 3; i++) {
            if (chars[i] == chars[i + 3] && chars[i] == chars[i + 6] && chars[i] != '_' && chars[i] != ' ') {
                return chars[i];
            }
        }
        return 'N';
    }

    private char takeThreeInARowDiagonal(char[] chars) {
        if (chars[0] == chars[4] && chars[0] == chars[8] && chars[0] != '_' && chars[0] != ' ') {
            return chars[0];
        } else if (chars[2] == chars[4] && chars[2] == chars[6] && chars[2] != '_' && chars[2] != ' ') {
            return chars[2];
        }
        return 'N';
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
