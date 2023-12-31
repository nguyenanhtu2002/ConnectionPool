package controller;

import dao.TransactionDAO;
import dao.implement.TransactionDAOImpl;
import model.TagFinance;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionController {
    private TransactionDAO transactionDAO = new TransactionDAOImpl();

    public List<Transaction> getAllTransaction() {
        List<Transaction> list = new ArrayList<>();
        return transactionDAO.getAllTransactions();
    }

    public void insertTransaction(List<TagFinance> tagFinanceList) {
        Transaction transaction = createTransaction(tagFinanceList);
        transactionDAO.insertTransaction(transaction);
    }

    public void updateTransaction(List<TagFinance> tagFinanceList, int idUpdateTransaction) {
        Transaction transaction = createTransaction(tagFinanceList);
        transactionDAO.updateTransaction(transaction, idUpdateTransaction);
    }

    public void deleteTransactions(int idDelete) {
        transactionDAO.deleteTransaction(idDelete);
    }

    public List<Transaction> searchTransactionByTagfinal(int idSearch) {

        List<Transaction> list = new ArrayList<>();
        return transactionDAO.searchTransactionByTagfinal(idSearch);

    }

    public List<Transaction> searchTransactionByName(String name) {
        List<Transaction> list = new ArrayList<>();
        return transactionDAO.searchTransactionByName(name);
    }

    public Transaction createTransaction(List<TagFinance> tagFinanceList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter id tagFinance you want to add transaction");
        int idTag = scanner.nextInt();
        scanner.nextLine();
        TagFinance tagFinance = new TagFinance();

        boolean check = false;
        for (int i = 0; i < tagFinanceList.size(); i++) {
            if (tagFinanceList.get(i).getId() == idTag) {
                tagFinance = tagFinanceList.get(i);
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Not found");
            return null;
        }
        int id = 0;
        System.out.println("create At");
        String createdAt = scanner.nextLine();
        System.out.println("title");
        String title = scanner.next();
        System.out.println("description");
        String description = scanner.next();
        scanner.nextLine();
        System.out.println("amount");
        double amount = scanner.nextInt();


        Transaction transaction = new Transaction(createdAt, title, description, amount, idTag, tagFinance);
        return transaction;
    }
}
