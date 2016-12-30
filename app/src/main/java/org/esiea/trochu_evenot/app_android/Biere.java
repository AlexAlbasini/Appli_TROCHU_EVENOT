package org.esiea.trochu_evenot.app_android;

        import java.io.Serializable;

/**
 * Created by Rémi on 15/12/2016.
 */

public class Biere implements Serializable{

    public String category_id;
    public String country;
    public String created_at;
    public String description;
    public String id;
    public String name;
    public String note;


    public Biere (String category_id, String country, String created_at, String description, String id, String name, String note){
        this.category_id=category_id;
        this.country=country;
        this.created_at=created_at;
        this.description=description;
        this.id=id;
        this.name=name;
        this.note=note;

    }

    public String getCategory_id(){
        return category_id;
    }

    public String getCountry(){
        return country;
    }

    public String getCreated_at(){
        return created_at;
    }

    public String getDescription(){
        return description;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getNote(){
        return note;
    }

}
