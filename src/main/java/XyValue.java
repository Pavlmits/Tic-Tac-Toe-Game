import java.util.Objects;

public class XyValue {

    private final String x;
    private final String y;

    public XyValue(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XyValue xyValue = (XyValue) o;
        return Objects.equals(x, xyValue.x) &&
                Objects.equals(y, xyValue.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}