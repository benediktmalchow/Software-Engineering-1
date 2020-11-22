package org.hbrs.se.ws20.uebung2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Container {

    //private HashSet<Member> map = new HashSet<>();

    //Fuer Uebung 3 wird eine Liste gefordert
    private List<Member> list = new ArrayList<>();

    public void addMember(Member member) throws ContainerException{
        if(list.contains(member)){
            ContainerException exception = new ContainerException();
            exception.addId(member.getID());
            throw exception;
        }
        list.add(member);
    }

    //Beantwortung Aufgabe 2.FA2
    //1. Fehlerhandling ist nicht direkt erkennbar für andere Entwickler (genaues reinlesen)
    //2. Fehlerbehandlung kann nicht weiterdeligiert werden wie z.B. bei geprüften Exceptions
    //3. Erschwertes Testen, da nicht auf Exceptions geprüft werden kann, sondern immer der eigene Fehlercode überprüft werden muss!
    public String deleteMember(Integer id){
        for(Member m : list){
            if(m.getID().equals(id)){
                list.remove(m);
                return "Remove of Member " + id + " successfull!";
            }
        }
        return "Remove of Member " + id + " not successfull!";
    }

    public void dump(){
        for(Member m : list){
            System.out.println(m.toString());
        }
    }

    public int size(){
        return list.size();
    }

}
