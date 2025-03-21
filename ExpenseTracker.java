import java.util.ArrayList;

public class ExpenseTracker {
    private ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(double amount, String category, String date, String details) {
        expenses.add(new Expense(amount, category, date, details));
    }
    public void deleteExpense(int index) {
        if (index >= 0 && index <= expenses.size()){
            expenses.remove(index);
        }
    }
    public void calculateExpense() {
        
    }
    public void getExpense() {

    }
}
