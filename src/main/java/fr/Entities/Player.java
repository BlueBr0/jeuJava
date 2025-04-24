package fr.Entities;

public class Player extends Entity{

    private final int BASE_AMO = 10;

    private int amo;

    public Player(String name, int health, int armor) {
        super(name, health, armor);
        this.amo = BASE_AMO;
    }

    @Override
    public String toString(){
        return name + "\r\nPV : " + health + "\r\nARMOR :" + armor + "\r\nMUNITIONS : " + amo;
    }

}
