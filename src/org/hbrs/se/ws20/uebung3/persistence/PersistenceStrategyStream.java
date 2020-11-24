package org.hbrs.se.ws20.uebung3.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;
    private List<Member> newListe = null;

    @Override
    public void openConnection() throws PersistenceException {

        try {
            if(oos == null){
                oos = new ObjectOutputStream(new FileOutputStream("members.ser"));
            }
            if(ois == null){
                ois = new ObjectInputStream(new FileInputStream("members.ser"));
            }
        } catch(IOException e) {
            System.err.println(e);
        }

    }

    @Override
    public void closeConnection() throws PersistenceException {

        try {
            if(oos != null){
                oos.close();
            }
            if(ois != null){
                ois.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException {

        try{
            oos = new ObjectOutputStream(new FileOutputStream("members.ser"));
            for(Member m : member) {
                oos.writeObject(m);
            }
            oos.close();

        } catch (IOException e) {
            System.err.println(e);
        }
    }



    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load() throws PersistenceException, IOException, ClassNotFoundException {

        newListe = new ArrayList<>();
        ois = new ObjectInputStream(new FileInputStream("members.ser"));
        try {
            while(true){
                Object obj = ois.readObject();
                newListe.add((Member) obj);
            }
        } catch (EOFException e) {
            System.out.println("End of Stream");
            ois.close();
        }

        return newListe;
    }
}
