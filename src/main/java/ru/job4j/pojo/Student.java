package ru.job4j.pojo;

public class Student {
    private String FullName;
    private String Group;
    private int ReceiptDate;

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public int getReceiptDate() {
        return ReceiptDate;
    }

    public void setReceiptDate(int receiptDate) {
        ReceiptDate = receiptDate;
    }
}
