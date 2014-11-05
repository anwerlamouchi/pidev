package dao;






import entities.Client;
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
public class ClientDAO {
    
      
      
      
    public ArrayList<Client> SelectClient() {
        try {
        
            String requete = "select * from clien";
            PreparedStatement ps;
            ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            ArrayList<Client> clients = new ArrayList<Client>();
            while (result.next()) {
               Client client = new Client();
                client.setId(result.getInt(1));
                client.setPrenom(result.getString(2));
                client.setNom(result.getString(3));
                client.setEmail(result.getString(4));
               
                client.setTelephone(result.getString(5));
                client.setAdresse(result.getString(6));
                client.setLogin(result.getString(7));
                client.setPass(result.getString(8));
              
                clients.add(client);
                
                  System.out.println("clients "+client.getLogin());
            }
            return clients;
        } catch (Exception ee) {
            System.out.println("erreur dan select clients " + ee.getMessage());
        }
        return null;
    }

    public ArrayList<String> SelectLogin(String pattern) {//authentification
        try {
            String requete = "select login from client where login like'" + pattern + "%'";
            PreparedStatement ps;
            ps = MyConnection.getInstance().prepareStatement(requete);
            ResultSet result = ps.executeQuery();
            Client client = new Client();
            ArrayList<String> tclient= new ArrayList<>();
            while (result.next()) {
                tclient.add(result.getString(1));
            }
            return tclient;
        } catch (Exception ee) {
            System.out.println("erreur dan select client " + ee.getMessage());
        }
        return null;
    }

    public void ajoutClient(   Client client) {
        try {
            String requete = "INSERT INTO `Client`(`Id`, `prenom`, `nom`, `email`, `telephone`, `adresse`, `login`, `pass`)VALUES (null,?,?,?,?,?,?,?)";
             PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, client.getPrenom());
            ps.setString(2, client.getNom());
                 ps.setString(3, client.getEmail());
          
            ps.setString(4, client.getTelephone());
            ps.setString(5, client.getAdresse());
            ps.setString(6, client.getLogin());
            ps.setString(7, client.getPass());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("erreur dans la methode ajout client " + e.getMessage() + " " + e.getLocalizedMessage());
        }
    }

    public void deleteClient(String login) {
        String requete = "delete from client where login=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, login);
            ps.executeUpdate();
            System.out.println("client supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression client" + ex.getMessage());
        }
    }

    public void updateClient(String login, String password) {
        String requete = "UPDATE client SET pass=? WHERE login=?";
        try {
            PreparedStatement ps =  MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, password);
            ps.setString(2, login);
           
            ps.executeUpdate();
            System.out.println("client update");
        } catch (SQLException ex) {
            System.out.println("erreur lors de modification  client" + ex.getMessage());
        }
    }
    
    
    public Client findClientByLogin (String login){
      Client client =null;
        String requete = "select login,pass from client where login='"+login+"'";
        try {
           Statement statement =  MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
               client  = new  Client();
               client.setLogin(resultat.getString(1));
               client.setPass(resultat.getString(2));
            }
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des client "+ex.getMessage());
        }
        return client;
        
    }
   

}
      
    
    

