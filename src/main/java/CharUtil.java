public class CharUtil {

    public int countOccurrences(char[] chars, char targetChar) {
        int occurrences = 0;
        for (char aChar : chars) {
            if (aChar == targetChar) occurrences++;
        }
        return occurrences;
    }

    public boolean isAnyOccurrences(char[] chars, char targetChar) {
        for (char aChar : chars) {
            if (aChar == targetChar) return true;
        }
        return false;
    }

    public static char[] replaceUnderscoresWithSpaces(char[] chars) {
        char[] replaced = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') replaced[i] = ' ';
            else replaced[i] = chars[i];
        }
        return replaced;
    }
}

