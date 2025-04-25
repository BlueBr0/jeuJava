package fr;
import java.util.HashMap;

public class Zone 
{
    public String description;

    private boolean isLoocked;

    public Zone unlocks;

    public Zone(String description, boolean b) {
        this.description = description;
        this.isLoocked = b;
    }

    public String toString() {
        return description;
    }

    public boolean isLoocked(){
        return this.isLoocked;
    }

    public void setUnlocks(Zone u ){
        this.unlocks = u;
    }

//    public void ajouteSortie(Sortie sortie, Zone zoneVoisine) {
//        sorties.put(sortie.name(), zoneVoisine);
//    }
//
//    public String nomImage() {
//        return nomImage;
//    }
//
//    public String toString() {
//        return description;
//    }
//
//    public String descriptionLongue()  {
//        return "Vous êtes dans " + description + "\nSorties : " + sorties();
//    }
//
//    private String sorties() {
//        return sorties.keySet().toString();
//    }
//
//    public Zone obtientSortie(String direction) {
//    	return sorties.get(direction);
//    }
}

