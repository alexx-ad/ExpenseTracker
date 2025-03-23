import javax.swing.*;
import java.awt.*;

public class ExpenseTrackerGUI {
    private JTextField expenseInput;
    private JLabel label;
    private JList<String> expenseList;
    private ExpenseTracker expenseTracker;
    private DefaultListModel<String> listModel;

    public ExpenseTrackerGUI() {
        expenseTracker = new ExpenseTracker();
        listModel = new DefaultListModel<>();
        expenseList = new JList<>(listModel);
        label = new JLabel();
        expenseInput = new JTextField(20);

        JFrame frame = new JFrame("Expense Tracker");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JButton addExpense = new JButton("Add Expense");
        JButton totalExpense = new JButton("Calculate Expense");
        JButton deleteExpense = new JButton("Delete Expense");

        addExpense.addActionListener(e -> addExpense());
        totalExpense.addActionListener(e -> totalExpense());
        deleteExpense.addActionListener(e -> deleteExpense());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Expense: "));
        panel.add(expenseInput);
        panel.add(addExpense);
        panel.add(totalExpense);
        panel.add(deleteExpense);

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(expenseList), BorderLayout.CENTER);

        frame.setVisible(true);
    }
    public void addExpense() {
        String name = expenseInput.getText().trim();
        if (!name.isEmpty()){
            expenseTracker.addExpense(100, "Food", "2024-10-03", name);
            updateExpenseList();
            expenseInput.setText("");
        }
    }
    public void totalExpense() {
        double total = expenseTracker.calculateExpense();
        label.setText("Total Expenses: $" + total);
    }
    public void deleteExpense() {
        int selectedIndex = expenseList.getSelectedIndex();
        if (selectedIndex != -1){
            expenseTracker.deleteExpense(selectedIndex);
            updateExpenseList();
        }
    }
    private void updateExpenseList() {
        listModel.clear();
        for (Expense expense : expenseTracker.getExpense()){
            listModel.addElement(expense.toString());
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ExpenseTrackerGUI::new);
    }
}
