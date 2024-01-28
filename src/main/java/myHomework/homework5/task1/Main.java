package myHomework.homework5.task1;

public class Main {
    public static void main(String[] args) {

        Task1 task1 = new Task1();

        //Task #1
        task1.getIf();

        //Task #2/#3
        task1.getChetnoe(11);

        //Task #4
        task1.checkUrl("http://vk.com");

        //Task #5
        task1.validatePassword("ashgur");
        task1.validatePassword("asdfghjkkuyty");
        task1.validatePassword("4353453453453");
        task1.validatePassword("asdfghjkku123%");


        //Task#6
        task1.equalsPassword("Qwerty0987654");
        task1.equalsPassword("Qwerty0987654321");

        //Task#7
        task1.fizzBuzz();
    }
}
