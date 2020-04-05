package odz.ShoppingCart;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Map;

/**
 * Class for formatting table of items
 */
public class TableFormatter {
    private static final String[] columnsOrder = new String[] {"#", "Title", "Price", "Quantity", "Discount", "Total"};
    private static final Map<String, String> columnFormats = Map.of("#", "%2s ",
                                                        "Title", "%-23s ",
                                                        "Price", "%7s ",
                                                        "Quantity", "%8s ",
                                                        "Discount", "%8s ",
                                                        "Total", "%10s ");
    private static final int tableWidth = 62;

    private static final NumberFormat MONEY;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        MONEY = new DecimalFormat("$#.00", symbols);
    }

    /**
     * Main method to form the table
     * @param items iterator of elements
     * @return string presentation of table
     */
    public String formatTable(Iterable<Item> items){
        StringBuffer table = new StringBuffer();
        table.append(createHead());
        table.append(createSplitLine());
        int counter = 1;
        double total = 0.0;
        for (Item item : items){
            table.append(formatItemRow(counter, item));
            total += item.calculateTotal();
            ++counter;
        }
        table.append(createSplitLine());
        table.append(createFooter(counter, total));
        return table.toString();
    }

    /**
     * Create header with all column names
     * @return
     */
    private String createHead(){
        StringBuffer row = new StringBuffer();
        for(String columnHeader : columnsOrder){
            String value = buildCell(columnHeader, columnHeader);
            row.append(value);
        }
        return row.toString().trim() +  "\n";
    }

    /**
     * Create line like '-----' with tableWidth value width
     * @return separate line consist of ----
     */
    private String createSplitLine(){
        return "-".repeat(tableWidth)+"\n";
    }

    /**
     * Print cell in a format for this column
     * @param cellValue String value of cell
     * @param columnKey name of the column
     * @return string presentation of cell
     */
    private String buildCell(Object cellValue, String columnKey){
        String format = columnFormats.get(columnKey);
        return String.format(format, cellValue);
    }

    /**
     * Build string representation of item
     * @param number number of the raw in all items
     * @param item object that give data about item
     * @return string representation of item
     */
    private String formatItemRow(int number, Item item){
        StringBuffer row = new StringBuffer();
        String val = buildCell(number, "#");
        row.append(buildCell(String.valueOf(number), "#"));

        String title = item.getTitle();
        String cellValue = title.length() > 20 ? title.substring(0,20)+"...":title;
        row.append(buildCell(cellValue, "Title"));

        row.append(buildCell(MONEY.format(item.getPrice()), "Price"));
        row.append(buildCell(String.valueOf(item.getQuantity()), "Quantity"));
        row.append(buildCell(String.format("%d%%", item.calculateDiscount()), "Discount"));
        row.append(buildCell(MONEY.format(item.calculateTotal()), "Total"));

        return row.toString().trim() + "\n";
    }

    /**
     * Create last result raw of the table
     * @param lastNumber last number of all elements
     * @param total total sum of items
     * @return string representation of the footer
     */
    private String createFooter(int lastNumber, double total){
        StringBuffer footer = new StringBuffer();
        footer.append(buildCell(String.valueOf(lastNumber), "#"));
        int deltaWidth = tableWidth - 2;
        footer.append(String.format("%" + String.valueOf(deltaWidth) + "s", MONEY.format(total)));
        return footer.toString().trim();
    }
}
