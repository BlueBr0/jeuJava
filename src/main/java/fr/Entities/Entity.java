package fr.Entities;

public class Entity {

    protected int health;

    protected String name;

    public Entity( String name, int health){
        this.health = health;
        this.name = name;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int h){
        this.health = h;
    }


}
