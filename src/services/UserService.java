/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import outils.MyDB;

/**
 *
 * @author ahmed
 */
public class UserService {

    Connection cnx;

    public UserService() {
        cnx = MyDB.getInstance().getCnx();
    }

    public void ajouterUser(User u) {
        try {
            String req = "INSERT INTO users(nom,prenom,age) VALUES('" + u.getNom() + "','" + u.getPrenom() + "'," + u.getAge() + ")";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("User added successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    public void modifierUser(User u) {
        try {
            String req = "UPDATE users SET nom=?, prenom=?, age=? WHERE id=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, u.getNom());
            st.setString(2, u.getPrenom());
            st.setInt(3, u.getAge());
            st.setInt(4, u.getId());
            st.executeUpdate();
            System.out.println("User modified successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    public void supprimerUser(User u) {
        try {
            String req = "DELETE FROM users WHERE id=?";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, u.getId());
            System.out.println("User deleted successfully!");
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
    }

    public List<User> afficherUsers() {
        List<User> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM users";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setAge(rs.getInt("age"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                users.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return users;
    }
    
    public List<User> getUserByID(int id){
        List<User> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM users WHERE id= "+ id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setAge(rs.getInt("age"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                users.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return users;
    }
    
     public List<User> getUserByAge(String query, int age){
        List<User> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM users WHERE "+query+"= "+ age;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setAge(rs.getInt("age"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                users.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return users;
    }
     
      public List<User> getUserByNom(String nom){
        List<User> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM users WHERE nom= '"+ nom+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setAge(rs.getInt("age"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                users.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return users;
    }
      
       public List<User> getUserByPrenom(String prenom){
        List<User> users = new ArrayList<>();
        try {
            String req = "SELECT * FROM users WHERE prenom= '"+ prenom+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setAge(rs.getInt("age"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                users.add(u);
            }
        } catch (SQLException ex) {
            System.out.println("Error!");
            System.out.println(ex);
        }
        return users;
    }
}
