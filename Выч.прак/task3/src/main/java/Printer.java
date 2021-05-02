
import java.io.PrintStream;

import static java.lang.String.format;

public class Printer {
    private final PrintStream out;
    private final String asNull;

    public Printer(PrintStream out) {
        this(out, "(NULL)");
    }

    public Printer(PrintStream out, String asNull) {
        this.out = out;
        this.asNull = asNull;
    }

    private String border(int[] widths) {
        final StringBuilder builder = new StringBuilder(256);
        builder.append(' ');
        for (final int w : widths) {
            for (int i = 0; i < w; i++) {
                builder.append('-');
            }
            builder.append(' ');
        }
        return builder.toString();
    }

    public void print(String[][] table) {
        if (table.length == 0) {
            return;
        }
        final int[] width = new int[maxCol(table)];
        tuneWidth(table, width);
        printTable(table, width, border(width));
    }

    private void printTable(String[][] table, int widths[], String horizontalBorder) {
        final int lineLength = horizontalBorder.length();
        for (final String[] row : table) {
            if (row != null) {
                out.println(makeRow(row, widths, lineLength));
            }
        }
    }


    private static String get(String[] array, int index, String defaultValue) {
        return index < array.length ? array[index] : defaultValue;
    }

    private void tuneWidth(String[][] rows, int[] widths) {
        for (final String[] row : rows) {
            if (row != null) {
                for (int i = 0; i < widths.length; i++) {
                    final String cv = getCellValue(get(row, i, asNull));
                    final int l = cv.length();
                    if (widths[i] < l) {
                        widths[i] = l;
                    }
                }
            }
        }
    }
    private String makeRow(String[] row, int[] widths, int lineLength) {
        final StringBuilder builder = new StringBuilder(lineLength).append('|');
        final int maxWidths = widths.length;
        for (int i = 0; i < maxWidths; i++) {
            builder.append(padRight(getCellValue(get(row, i, null)), widths[i]))
                    .append('|');
        }
        return builder.toString();
    }

    private static String padRight(String s, int n) {
        return format("%1$-" + n + "s", s);
    }


    private String getCellValue(Object value) {
        return value == null ? asNull : value.toString();
    }
    private int maxCol(String[][] rows) {
        int max = 0;
        for (final String[] row : rows) {
            if (row != null && row.length > max) {
                max = row.length;
            }
        }
        return max;
    }
}
