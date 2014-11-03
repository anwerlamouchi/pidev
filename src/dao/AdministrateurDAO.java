package dao;





import entities.Administrateur;
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
public class AdministrateurDAO {
    
      
      
      
    public ArrayList<Administrateur> SelectAdmin() {
        try {
        
            String requete = "select * from administrateur";
            PreparedStatement ps;
            ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Administrateur> tadmin = new ArrayList<Administrateur>();
            while (result.next()) {
               Administrateur admin = new Administrateur();
                admin.setNom(result.getString(2));
                admin.setPrenom(result.getString(3));
                admin.setEmail(result.getString(4));
                admin.setLogin(result.getString(5));
                admin.setPass(result.getString(6));
              
                tadmin.add(admin);
                
                  System.out.println("admin "+admin.getLogin());
            }
            return tadmin;
        } catch (Exception ee) {
            System.out.println("erreur dan select administrateur " + ee.getMessage());
        }
        return null;
    }

    public ArrayList<String> SelectLogin(String pattern) {
        try {
            String requete = "select login from administrateur where login like'" + pattern + "%'";
            PreparedStatement ps;
            ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            Administrateur admin = new   Administrateur();
            ArrayList<String> tadmin = new ArrayList<>();
            while (result.next()) {
                tadmin.add(result.getString(1));
            }
            return tadmin;
        } catch (Exception ee) {
            System.out.println("erreur dan select administrateur " + ee.getMessage());
        }
        return null;
    }

    public void ajoutAdministrateur(   Administrateur  admin) {
        try {
            String requete = "INSERT INTO `administrateur`(`id`, `prenom`, `nom`, `email`, `dateNaissance`, `telephone`, `adresse`, `login`, `pass`)VALUES (null,?,?,?,?,?,?,?,?)";
             PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, admin.getPrenom());
            ps.setString(2, admin.getNom());
                 ps.setString(3, admin.getEmail());
            ps.setString(4, admin.getDateNaissance());
            ps.setInt(5, admin.getTelephone());
            ps.setString(6, admin.getAdresse());
            ps.setString(7, admin.getLogin());
            ps.setString(8, admin.getPass());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erreur dans la methode ajout administrateur " + e.getMessage() + " " + e.getLocalizedMessage());
        }
    }

    public void deleteAdmin(String login) {
        String requete = "delete from administrateur where login=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ps.executeUpdate();
            System.out.println("administrateur supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression administrateur" + ex.getMessage());
        }
    }

    public void updateAdmin(String login, String password) {
        String requete = "UPDATE administrateur SET pass=? WHERE login=?";
        try {
            PreparedStatement ps =  MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, password);
            ps.setString(2, login);
           
            ps.executeUpdate();
            System.out.println("admin update");
        } catch (SQLException ex) {
            System.out.println("erreur lors de modification  Admin" + ex.getMessage());
        }
    }
    
    
    public Administrateur findAdministrateurByLogin (String login){
      Administrateur admin =null;
        String requete = "select login,pass from administrateur where login='"+login+"'";
        try {
           Statement statement =  MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
               admin = new Administrateur();
               admin.setLogin(resultat.getString(1));
               admin.setPass(resultat.getString(2));
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des administrateurs "+ex.getMessage());
        }
        return admin;
    }
      
    
    
}
