package fr.esgi.al.tps.oop.classe2.tp1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

final class ZipCode {

    private static Map<String, ZipCode> _cache = new HashMap<>();

    private final int digit1;
    private final int digit2;
    private final int digit3;
    private final int digit4;
    private final int digit5;

    private ZipCode(int digit1, int digit2, int digit3, int digit4, int digit5) {
        this.digit1 = digit1;
        this.digit2 = digit2;
        this.digit3 = digit3;
        this.digit4 = digit4;
        this.digit5 = digit5;
    }

    public static ZipCode of(String value) {
        var zipCode = _cache.get(value);
        if (zipCode != null) {
            return zipCode;
        }

        zipCode = new ZipCode(
                Integer.parseInt(value.substring(0, 1)),
                Integer.parseInt(value.substring(1, 2)),
                Integer.parseInt(value.substring(2, 3)),
                Integer.parseInt(value.substring(3, 4)),
                Integer.parseInt(value.substring(4, 5)));
        _cache.put(value, zipCode);
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZipCode zipCode = (ZipCode) o;
        return digit1 == zipCode.digit1 && digit2 == zipCode.digit2 && digit3 == zipCode.digit3 && digit4 == zipCode.digit4 && digit5 == zipCode.digit5;
    }

    public String code() {
        StringBuilder sb = new StringBuilder();
        return sb.append(digit1).append(digit2).append(digit3).append(digit4).append(digit5).toString();
    }

    public String department() {
        StringBuilder sb = new StringBuilder();
        return sb.append(digit1).append(digit2).toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit1, digit2, digit3, digit4, digit5);
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "digit1=" + digit1 +
                ", digit2=" + digit2 +
                ", digit3=" + digit3 +
                ", digit4=" + digit4 +
                '}';
    }
}
