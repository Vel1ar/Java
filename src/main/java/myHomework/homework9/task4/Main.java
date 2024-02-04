package myHomework.homework9.task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("Name31", "01/01/2000"));
        companies.add(new Company("Name23", "01/01/2000"));
        companies.add(new Company("Name43", "01/01/2000"));
        companies.get(0).addMovie("Film13",8, "Horror", "France", "Yes");
        companies.get(0).addMovie("Film21",3, "Horror", "France", "No");
        companies.get(0).addMovie("Film32",6, "Horror", "France", "No");
        companies.get(1).addMovie("Film13",5, "Horror", "France", "Yes");
        companies.get(1).addMovie("Film14",5, "Horror", "France", "No");
        companies.get(2).addMovie("Film12",5, "Horror", "France", "Yes");
        System.out.println(companies);

    }
}
