package com.example.cyril.td4_3;

/**
 * Created by Cyril on 29/02/2016.
 */
public class Tache {
    private String _titre;
    private Integer _priorite;
    private boolean _etat;

    public Tache(String titre,Integer priorite,boolean etat){
        _titre = titre;
        _priorite = priorite;
        _etat = etat;
    }

    public String get_titre() {
        return _titre;
    }

    public void set_titre(String _titre) {
        this._titre = _titre;
    }

    public boolean get_etat() {
        return _etat;
    }

    public void set_etat(boolean _etat) {
        this._etat = _etat;
    }

    public String get_priorite() {
        return _priorite.toString();
    }

    public void set_priorite(Integer _priorite) {
        this._priorite = _priorite;
    }


    public String toString(){
        return _titre+" "+String.valueOf(_priorite);
    }
}
