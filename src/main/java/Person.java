import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class Person {
    String name;
    boolean starter_node=true;
    ArrayList<Person> children= new ArrayList<>();

    public Person(String name){
        this.name=name;
    }
    public void addChild(Person child){
        child.starter_node=false;
        this.children.add(child);
    }

    public String print(int loop)  {
        String temp="";
        temp="\n" + StringUtils.repeat("\t",loop) + name;

        for (Person tempPerson : children) {
            temp = temp + tempPerson.print(loop+1);
        }

        return temp;
    }


}
