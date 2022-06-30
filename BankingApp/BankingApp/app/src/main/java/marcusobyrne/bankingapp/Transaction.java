package marcusobyrne.bankingapp;

/**
 * Created by Funk on 23/04/2017.
 */

public class Transaction {

    private int _id;
    private String _description;
    private double _amount;

    public Transaction(String _description, double _amount) {
        this._description = _description;
        this._amount = _amount;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public double get_amount() {
        return _amount;
    }

    public void set_amount(double _amount) {
        this._amount = _amount;
    }
}
