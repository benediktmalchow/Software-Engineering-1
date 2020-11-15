package org.hbrs.se.ws20.uebung2;
import java.util.HashSet;

public class Container {

    private HashSet<Member> map = new HashSet<>();

    public void addMember(Member member) throws ContainerException{
        if(map.contains(member)){
            ContainerException exception = new ContainerException();
            exception.addId(member.getID());
            throw exception;
        }

        map.add(member);
    }

    //Beantwortung Aufgabe 2.FA2
    //1. Fehlerhandling ist nicht direkt erkennbar für andere Entwickler (genaues reinlesen)
    //2. Fehlerbehandlung kann nicht weiterdeligiert werden wie z.B. bei geprüften Exceptions
    //3. Erschwertes Testen, da nicht auf Exceptions geprüft werden kann, sondern immer der eigene Fehlercode überprüft werden muss!
    public String deleteMember(Integer id){
        for(Member m : map){
            if(m.getID().equals(id)){
                map.remove(m);
                return "Remove of Member " + id + " successfull!";
            }
        }
        return "Remove of Member " + id + " not successfull!";
    }

    public void dump(){
        for(Member m : map){
            System.out.println(m.toString());
        }
    }

    public int size(){
        return map.size();
    }

}
