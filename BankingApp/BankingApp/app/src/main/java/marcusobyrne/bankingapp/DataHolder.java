package marcusobyrne.bankingapp;



public class DataHolder {

    private static int ID;
    private static String name;
    private static String address1;
    private static String address2;
    private static int accNo;
    private static int PIN;
    private static double balance;

    public static int getID() {
        return ID;
    }

    public static String getName() {
        return name;
    }

    public static String getAddress1() {
        return address1;
    }

    public static String getAddress2() {
        return address2;
    }

    public static int getAccNo() {
        return accNo;
    }

    public static int getPIN() {
        return PIN;
    }

    public static double getBalance() {
        return balance;
    }

    public static void setID(int ID) {
        DataHolder.ID = ID;
    }

    public static void setName(String name) {
        DataHolder.name = name;
    }

    public static void setAddress1(String address1) {
        DataHolder.address1 = address1;
    }

    public static void setAddress2(String address2) {
        DataHolder.address2 = address2;
    }

    public static void setAccNo(int accNo) {
        DataHolder.accNo = accNo;
    }

    public static void setPIN(int PIN) {
        DataHolder.PIN = PIN;
    }

    public static void setBalance(double balance) {
        DataHolder.balance = balance;
    }
}
