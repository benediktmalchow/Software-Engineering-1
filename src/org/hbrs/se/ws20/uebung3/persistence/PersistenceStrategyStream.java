package org.hbrs.se.ws20.uebung3.persistence;

import java.io.*;
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
            openConnection();
            for(Member m : member) {
                oos.writeObject(m);
            }
            closeConnection();

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

        openConnection();
        Object obj = ois.readObject();
        if (obj instanceof List<?>) {
            newListe = (List) obj;
        }
        closeConnection();
        return newListe;
    }
}
