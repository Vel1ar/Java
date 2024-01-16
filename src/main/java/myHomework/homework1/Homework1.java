package myHomework.homework1;

public class Homework1 {
   private String str;
   private String str_;
   private String strBlank;
    public Homework1 (String str, String strBlank, String str_){
        this.str = str;
        this.strBlank = strBlank;
        this.str_ = str_;
    }
    public Homework1 getResultIsEmpty(){ // пустая или не пустая строка, возвращает true/false
        System.out.println("isEmpty Moscow(false): " + str.isEmpty()); // строка не пустая
        System.out.println("isEmpty blanks(true): " + strBlank.isEmpty()); // строка пустая
        return this;
    }
    public Homework1 getResultIsBlack(){
        System.out.println("isBlank Moscow(false): " + str.isBlank()); // строка не пустая
        System.out.println("isBlank blanks(true): " + strBlank.isBlank()); // строка пустая
        return this;
    }
    public Homework1 getResultSubst(){
        System.out.println("subst Moscow: " + str.substring(0,4)); // обрезает строку
        return this;
    }
    public Homework1 getResultLastIndexOf(){
        System.out.println("LastIndex: " + str.lastIndexOf("o")); // поиск индекса последнего искомого элемента
        System.out.println("LastIndex(not found): " + str.lastIndexOf("1")); // поиск индекса последнего искомого элемента
        return this;
    }
    public Homework1 getResultIndexOf(){
        System.out.println("Index: " + str.indexOf("o")); // поиск индекса первого искомого элемента
        return this;
    }
    public Homework1 getResultToLowerCase(){
        System.out.println(str +" "+str.toLowerCase()); // приводит к нижнему ригистру
        return this;
    }
    public Homework1 getResultToUpperCase(){
        System.out.println(str +" "+str.toUpperCase()); // приводит к верхнему ригистру
        return this;
    }
    public Homework1 getResultReplace(){
        System.out.println(str +" "+str.replace("o", "#")); // ищет элимент и заменяет его
        return this;
    }
    public Homework1 getResultStartsWith(){
        System.out.println("statrtWith(true): "+str.startsWith("Mos")); // проверка, что начинается с Mos
        System.out.println("statrtWith(false): "+str.startsWith("1Mos")); // проверка, что начинается с 1Mos
        System.out.println("statrtWith(true): "+str.startsWith("os", 1)); //проверка, что символ начинается с "os" с индекса 1
        return this;
    }
    public Homework1 getResultEndsWith(){
        System.out.println("endWith(true): "+str.endsWith("cow")); // проверка, что заканчивается на Mos
        System.out.println("endWith(false): "+str.endsWith("1cow")); // проверка, что заканчивается на 1Mos
        return this;
    }
    public Homework1 getResultRepeat(){
        System.out.println(str.repeat(3)); //повторяет строку
        return this;
    }
    public Homework1 getResultContains(){
        str += " and London";
        System.out.println("contains London: " + str.contains("London")); // ищет слово в строке
        return this;
    }
    public Homework1 getResultConcat(){
        System.out.println(str.concat(" and Kazan")); // добовляет слово к строке
        return this;
    }
    public Homework1 getResultTrim(){
        System.out.println(str_.trim()); // убираем пробелы
        return this;
    }
}
