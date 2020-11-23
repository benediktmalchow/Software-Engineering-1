package org.hbrs.se.ws20.uebung3.persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    private ObjectInputStream ois = null;
    private ObjectOutputStream oos = null;
    private FileInputStream fis = null;
    private FileOutputStream fos = null;
    private List<Member> newListe = null;

    @Override
    public void openConnection() throws PersistenceException {

        try {
            fis = new FileInputStream("~/Desktop/members.ser");
            ois = new ObjectInputStream(fis);
            fos = new FileOutputStream("~/Desktop/members.ser");
            oos = new ObjectOutputStream(fos);
        } catch(IOException e) {
            System.err.println(e);
        }

    }

    @Override
    public void closeConnection() throws PersistenceException {

        try {
            fis.close();
            fos.close();
            ois.close();
            oos.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException {
            openConnection();
            try {
                oos.writeObject(member);
            } catch (IOException e) {
                System.err.println(e);
            }
            closeConnection();
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load() throws PersistenceException  {
        // Some Coding hints ;-)
        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)

        openConnection();
        try{
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                newListe = (List) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
        closeConnection();
        return newListe;

        // and finally close the streams (guess where this could be...?)
    }
}
