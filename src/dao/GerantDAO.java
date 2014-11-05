package dao;





import entities.Gerant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.MyConnection;


/**
 *
 * @author anwer
 */
public class GerantDAO {
     public ArrayList<Gerant> SelectGerant() {
        try {
        
            String requete = "select * from gerant";
            PreparedStatement ps;
            ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Gerant> gerants = new ArrayList<Gerant>();
            while (result.next()) {
              Gerant gerant= new Gerant();
               gerant.setId(result.getInt(1));
                gerant.setPrenom(result.getString(2));
                gerant.setNom(result.getString(3));
                gerant.setEmail(result.getString(4));
             
                gerant.setTelephone(result.getString(5));
                gerant.setAdresse(result.getString(6));
                 gerant.setLogin(result.getString(7));
               gerant.setPass(result.getString(8));
              
                gerants.add(gerant);
                
                  System.out.println("Gerant "+gerant.getLogin());
            }
            return gerants;
        } catch (Exception ee) {
            System.out.println("erreur dan select gerants " + ee.getMessage());
        }
        return null;
    }

    public ArrayList<String> SelectLogin(String pattern) {
        try {
            String requete = "select login from gerant where login like'" + pattern + "%'";
            PreparedStatement ps;
            ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet result = ps.executeQuery();
             Gerant gerant = new   Gerant();
            ArrayList<String> tgerant = new ArrayList<>();
            while (result.next()) {
                tgerant.add(result.getString(1));
            }
            return tgerant;
        } catch (Exception ee) {
            System.out.println("erreur dan select gerant " + ee.getMessage());
        }
        return null;
    }

    public void ajoutGerant(  Gerant  gerant) {
        try {
            String requete = "INSERT INTO `gerant`(`Id`, `prenom`, `nom`, `email`,`telephone`, `adresse`, `login`, `pass`)VALUES (null,?,?,?,?,?,?,?,?)";
             PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, gerant.getPrenom());
            ps.setString(2, gerant.getNom());
                 ps.setString(3, gerant.getEmail());
         
            ps.setString(5,gerant.getTelephone() );
            ps.setString(6, gerant.getAdresse());
            ps.setString(7, gerant.getLogin());
            ps.setString(8, gerant.getPass());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erreur dans la methode ajout gerant " + e.getMessage() + " " + e.getLocalizedMessage());
        }
    }

    public void deleteGerant(String login) {
        String requete = "delete from gerant where login=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ps.executeUpdate();
            System.out.println("gerantsupprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression gerant" + ex.getMessage());
        }
    }

    public void updateGerant(String login, String password) {
        String requete = "UPDATE gerant SET pass=? WHERE login=?";
        try {
            PreparedStatement ps =  MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, password);
            ps.setString(2, login);
           
            ps.executeUpdate();
            System.out.println("gerant update");
        } catch (SQLException ex) {
            System.out.println("erreur lors de modification  gerants" + ex.getMessage());
        }
    }
    
    
    public Gerant findGerantByLogin (String login){
     Gerant gerant =null;
        String requete = "select login,pass from Gerant where login='"+login+"'";
        try {
           Statement statement =  MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
              gerant = new  Gerant();
               gerant.setLogin(resultat.getString(1));
               gerant.setPass(resultat.getString(2));
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des geran "+ex.getMessage());
        }
        return gerant;
    }
      
      
      
   
}
