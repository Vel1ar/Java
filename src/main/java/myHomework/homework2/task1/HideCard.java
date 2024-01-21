package myHomework.homework2.task1;

public class HideCard {
    private String str;

    public HideCard(String str) {
        this.str = str;
    }

    public void hideCard() {
        String strNew = str.replaceAll(" ", "");
        System.out.println("**** **** **** "+strNew.substring(12));
    }
}
