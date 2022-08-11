import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FamilyTree {
    HashMap<String, Person> people = new HashMap<>();

    public FamilyTree(String inputname){
        File input = new File(inputname);
        Scanner scn = null;
        try {
            scn = new Scanner(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scn.hasNextLine()) {
            String temp = scn.nextLine();
            String[] line = temp.split(" ");

            Person parent = people.get(line[1]);
            Person child = people.get(line[0]);

            if(parent==null){
                parent = new Person(line[1]);

            }
            if(child==null){
                child = new Person(line[0]);
            }

            parent.addChild(child);

            people.put(line[1], parent);
            people.put(line[0], child);
        }

    }

    public void print() {
        String full="";
        for (Person temp: people.values()) {
            if(temp.starter_node) full= full + temp.print(0);
        }
        try{
            if(full.lines().count() < people.size()) throw new Exception("Circular");
        }
        catch(Exception e){
            e.printStackTrace();
            return;
        }
        System.out.println(full);
    }

    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree("src/main/java/input.txt");
        tree.print();
    }
}
