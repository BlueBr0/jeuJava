package fr.Entities;

public class Entity {

    protected int health;

    protected int armor;

    protected String name;

    public Entity( String name, int health, int armor){
        this.health = health;
        this.armor = armor;
        this.name = name;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int h){
        this.health = h;
    }


}
