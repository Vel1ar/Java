package myHomework.homework22.model;

public enum InputValue {
    _FIRSTNAME("Alex"),
    _LASTNAME("Old"),
    _MIDDLENAME("Killa"),
    _EMAIL("a13213@mail.ru"),
    _URL("imgp.fp"),
    _PHONE("5346547654"),
    _BIRTHDATE("2000-01-02"),
    _BLANK("");

    private String value;

    InputValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
