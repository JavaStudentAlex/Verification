package lab9_10;

import java.util.*;
import java.text.*;

/**
 * Containing items and calculating price.
 */
public class ShoppingCart {
    /**
     * Tests all class methods.
     */
    public static void main(String[] args) {
    }
    /**
     * Adds new item.
     *
     * @param title item title 1 to 32 symbols
     * @param price item ptice in USD, > 0
     * @param quantity item quantity, from 1
     * @param type item type
     *
     * @throws IllegalArgumentException if some value is wrong
     */
    public void addItem(String title, double price, int quantity, Item.ItemType type){
        Item newItem = new Item(title, price, quantity, type);
        items.add(newItem);
    }

    /**
     * Formats shopping price.
     *
     * @return string as lines, separated with \n,
     * first line: # Item Price Quan. Discount Total
     * second line: ---------------------------------------------------------
     * next lines: NN Title $PP.PP Q DD% $TT.TT
     * 1 Some title $.30 2 - $.60
     * 2 Some very long $100.00 1 50% $50.00
     * ...
     * 31 Item 42 $999.00 1000 - $999000.00
     * end line: ---------------------------------------------------------
     * last line: 31 $999050.60
     *
     * if no items in cart returns "No items." string.
     */
    public String formatTicket(){
        double total = calcItemsParameters();
        return getFotmattedTable(total);
    }

    private String getFotmattedTable(double total) {
        if (items.size() == 0)
            return "No items.";
        String[] header = {"#","Item","Price","Quan.","Discount","Total"};
        int[] align = new int[] { 1, -1, 1, 1, 1, 1 };
        List<String[]> lines = convertItemsToTableLines();
        int index = items.size() + 1;
        String[] footer = { String.valueOf(index),"","","","",
                MONEY.format(total) };
// formatting table
// column max length
        int[] width = new int[]{0,0,0,0,0,0};
        for (String[] line : lines) {
            adjustColumnWidth(width, line);
        }
        adjustColumnWidth(width, header);
        adjustColumnWidth(width, footer);
// line length
        int lineLength = width.length - 1;
        for (int w : width)
            lineLength += w;
        StringBuilder sb = new StringBuilder();
        // header
        appendFormattedLine(sb, header, align, width, true);
        //margin
        appendSeparator(sb, lineLength);
        //lines
        for (String[] line : lines) {
            appendFormattedLine(sb, line , align, width, true);
        }
        //margin
        appendSeparator(sb, lineLength);
        // footer
        appendFormattedLine(sb, footer, align, width, false);
        return sb.toString();
    }

    private List<String[]> convertItemsToTableLines() {
        List<String[]> lines = new ArrayList<String[]>();
        int index=0;
        for(Item item : items){
            double itemDiscount = item.getDiscount();
            double itemTotal = item.getTotal();
            lines.add(new String[]{
                    String.valueOf(++index),
                    item.title,
                    MONEY.format(item.price),
                    String.valueOf(item.quantity),
                    (itemDiscount == 0) ? "-" : (String.valueOf(itemDiscount) + "%"),
                    MONEY.format(itemTotal)
            });
        }
        return lines;
    }

    private double calcItemsParameters() {
        double total = 0.00;
        for (Item item : items) {
            int discount = item.getDiscount();
            double itemTotal = item.getTotal();
            total += itemTotal;
        }
        return total;
    }

    private void appendFormattedLine(StringBuilder sb, String[] line, int[] align, int[] width, boolean newLine) {
        for (int i = 0; i < line.length; i++)
            appendFormatted(sb, line[i], align[i], width[i]);
        if(newLine)
            sb.append("\n");
    }

    private void appendSeparator(StringBuilder sb, int lineLength) {
        for (int i = 0; i < lineLength; i++)
            sb.append("-");
        sb.append("\n");
    }

    private void adjustColumnWidth(int[] width, String[] columns) {
        for (int i = 0; i < columns.length; i++)
            width[i] = (int) Math.max(width[i], columns[i].length());
    }

    // --- private section -----------------------------------------------------
    private static final NumberFormat MONEY;
    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        MONEY = new DecimalFormat("$#.00", symbols);
    }
    /**
     * Appends to sb formatted value.
     * Trims string if its length > width.
     * @param align -1 for align left, 0 for center and +1 for align right.
     */
    public static void appendFormatted(StringBuilder sb, String value, int align, int
            width){
        if (value.length() > width)
            value = value.substring(0,width);
        int before = (align == 0) ? (width - value.length()) / 2
                : (align == -1) ? 0 : width - value.length();
        int after = width - value.length() - before;
        while (before-- > 0)
            sb.append(" ");
        sb.append(value);
        while (after-- > 0)
            sb.append(" ");
    }

    /** item info */
    public static class Item {
        public static enum ItemType { NEW, REGULAR, SECOND_FREE, SALE };

        String title;
        double price;
        int quantity;
        ItemType type;

        private double total;
        private int discount;

        public double getTotal() {
            return total;
        }

        public int getDiscount() {
            return discount;
        }

        public Item(String title, double price, int quantity, ItemType type) throws IllegalArgumentException{
            if (title == null || title.length() == 0 || title.length() > 32)
                throw new IllegalArgumentException("Illegal title");
            if (price < 0.01)
                throw new IllegalArgumentException("Illegal price");
            if (quantity <= 0)
                throw new IllegalArgumentException("Illegal quantity");
            this.title = title;
            this.price = price;
            this.quantity = quantity;
            this.type = type;
            discount = calcDiscount(type, quantity);
            total = calcTotalPrice();
        }

        public static int calcDiscount(ItemType type, int quantity){
            int resDiscount = 0;
            switch (type) {
                case NEW:
                    return 0;
                case REGULAR:
                    resDiscount = 0;
                    break;
                case SECOND_FREE:
                    if (quantity > 1)
                        resDiscount = 50;
                    break;
                case SALE:
                    resDiscount = 70;
                    break;
            }
            if (resDiscount < 80) {
                resDiscount += quantity / 10;
                if (resDiscount > 80)
                    resDiscount = 80;
            }
            return resDiscount;
        }

        private double calcTotalPrice(){
            return price * quantity * (100.00 - discount) / 100.00;
        }
    }

    /** Container for added items */
    private List<Item> items = new ArrayList<Item>();
}
