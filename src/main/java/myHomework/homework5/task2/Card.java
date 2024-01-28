package myHomework.homework5.task2;

public class Card {
    private String number;
    private String srkGdn;
    private String cvv;
    private Integer pinCode;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSrkGdn() {
        return srkGdn;
    }

    public void setSrkGdn(String srkGdn) {
        this.srkGdn = srkGdn;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public Card hideCard() {
        String number1 = (number.replace(" ", ""));
        if (number1.matches("\\d+")) {
            System.out.println("**** **** **** " + number1.substring(12));
        } else {
            System.out.println("Введите номер карты!");
        }
        return this;
    }

    public void enterPinCode(Integer pinCode) {
        if (pinCode.equals(this.pinCode)) {
            System.out.println(this.number);
        } else {
            System.out.println("Неверный пин код!");
        }
    }
}
