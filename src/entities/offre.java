/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author anwer
 */
    public class offre {
      private int id ;
     private String description;
     private double prix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDelegation() {
        return Delegation;
    }

    public void setDelegation(String Delegation) {
        this.Delegation = Delegation;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbchambre() {
        return nbchambre;
    }

    public void setNbchambre(int nbchambre) {
        this.nbchambre = nbchambre;
    }
     private String nom;
     private String type;//villa ou appartement....
     private String nature;//localisation ou achat 
   
    private String Delegation;
    private double surface;
    private String adresse;
     private int  nbchambre;
    
    
       
    

    
}
