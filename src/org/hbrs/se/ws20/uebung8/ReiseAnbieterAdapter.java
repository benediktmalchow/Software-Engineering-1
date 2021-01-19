package org.hbrs.se.ws20.uebung8;

import javax.management.Query;

public class ReiseAnbieterAdapter implements IHotelsuche {

    private ReiseAnbieter reiseAnbieter;

    public ReiseAnbieterAdapter(ReiseAnbieter reiseAnbieter) {
        this.reiseAnbieter = reiseAnbieter;
    }

    @Override
    public SuchErgebnis suche(SuchAuftrag s) {
        return new SuchErgebnis();
    }

    private QueryObject transformInput(SuchAuftrag s) {
        return new QueryObject();
    }

    private SuchErgebnis transformOutput(QueryResult q) {
        return new SuchErgebnis();
    }

}
