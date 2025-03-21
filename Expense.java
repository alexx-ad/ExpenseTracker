public class Expense {
    private double amount;
    private String category, date, details;

    public Expense(double amount, String category, String date, String details) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.details = details;
    }
    public double getAmount() {
        return amount;
    }
    public String getCategory() {
        return category;
    } 
    public String getDate() {
        return date;
    }
    public String getDetails() {
        return details;
    }
    @Override
    public String toString() {
        return String.format("Expense: %.2f | Category: %s | Date: %s | Details: %s",
         amount, category, date, details);
    }
}