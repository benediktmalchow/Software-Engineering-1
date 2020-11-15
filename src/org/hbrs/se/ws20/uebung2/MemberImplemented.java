package org.hbrs.se.ws20.uebung2;

public class MemberImplemented implements Member {


    private Integer id;

    public MemberImplemented(Integer id){
        this.id = id;
    }

    @Override
    public Integer getID(){
        return id;
    }

    @Override
    public String toString(){
        return "Member (ID = " + id  + ")";
    }
}
