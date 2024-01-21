package myHomework.homework1;

public class Main {
    public static void main(String[] args) {

        String str = "Moscow";
        String str_ = "            Space            ";
        String strBlank = "";

        Homework1 homework1 = new Homework1(str, strBlank, str_);

        homework1
                .getResultIsEmpty()
                .getResultIsBlack()
                .getResultSubst()
                .getResultLastIndexOf()
                .getResultIndexOf()
                .getResultToLowerCase()
                .getResultToUpperCase()
                .getResultReplace()
                .getResultStartsWith()
                .getResultEndsWith()
                .getResultRepeat()
                .getResultContains()
                .getResultConcat()
                .getResultTrim();
    }
}