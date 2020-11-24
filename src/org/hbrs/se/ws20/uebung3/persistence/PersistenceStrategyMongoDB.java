package org.hbrs.se.ws20.uebung3.persistence;

import java.util.List;

public class PersistenceStrategyMongoDB<Member> implements PersistenceStrategy<Member> {
    @Override
    public void openConnection() throws PersistenceException {
        try{
            throw new java.lang.UnsupportedOperationException("Not implemented!");
        } catch (UnsupportedOperationException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Not implemented!");
        }

    }

    @Override
    public void closeConnection() throws PersistenceException {
        try{
            throw new java.lang.UnsupportedOperationException("Not implemented!");
        } catch (UnsupportedOperationException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Not implemented!");
        }
    }

    @Override
    public void save(List<Member> member) throws PersistenceException {
        try{
            throw new java.lang.UnsupportedOperationException("Not implemented!");
        } catch (UnsupportedOperationException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Not implemented!");
        }

    }

    @Override
    public List<Member> load() throws PersistenceException {
        try{
            throw new java.lang.UnsupportedOperationException("Not implemented!");
        } catch (UnsupportedOperationException e){
            throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Not implemented!");
        }
    }
}
