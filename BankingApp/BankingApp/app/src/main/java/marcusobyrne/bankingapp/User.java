package marcusobyrne.bankingapp;



public class User {

    private int _id;
    private String _name;
    private String _address1;
    private String _address2;
    private int _accNo;
    private int _PIN;
    private double _currentbalance;


    public User(String _name, String _address1, String _address2, int _accNo, int _PIN, double _currentbalance) {
        this._name = _name;
        this._address1 = _address1;
        this._address2 = _address2;
        this._accNo = _accNo;
        this._PIN = _PIN;
        this._currentbalance = _currentbalance;
    }

    public User(int _PIN) {
        this._PIN = _PIN;
    }



    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_address1(String _address1) {
        this._address1 = _address1;
    }

    public void set_address2(String _address2) {
        this._address2 = _address2;
    }

    public void set_accNo(int _accNo) {
        this._accNo = _accNo;
    }

    public void set_PIN(int _PIN) {
        this._PIN = _PIN;
    }

    public void set_currentbalance(double _currentbalance) {
        this._currentbalance = _currentbalance;
    }

    public int get_id() {
        return _id;
    }

    public String get_name() {
        return _name;
    }

    public int get_PIN() {
        return _PIN;
    }

    public double get_currentbalance() {
        return _currentbalance;
    }

    public String get_address1() {
        return _address1;
    }

    public String get_address2() {
        return _address2;
    }

    public int get_accNo() {
        return _accNo;
    }
}
