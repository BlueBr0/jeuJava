package fr.Entities;

public class Player extends Entity{

    private final int baseAmo = 10;

    private int amo;

    public Player(String name, int health) {
        super(name, health);
        this.amo = baseAmo;
    }

    @Override
    public String toString(){
        return name + "\r\nPV : " + health + "\r\nMUNITIONS : " + amo;
    }

}
