/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CODE;



import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * this class is implementation of remote interface operations
 * rmi implementation class inherit all the methods from the service interface
 */

/**
 *
 * @author lahiru yasas
 */
public class RMIImplementation extends UnicastRemoteObject implements ServiceInterface{
    
    
    
    protected RMIImplementation() throws RemoteException, NotBoundException{
    
        super();
        
    }

     Connection conn = DataBaseConnection.DBConnection();
     QuickChart chart = new QuickChart();
    
    @Override                  //addNewPlayer method is ised to add new players to database
    public void addNewPlayer(String name, String age, String password) throws RemoteException {

        String sql = "INSERT INTO `register`(`name`, `password`, `age`) VALUES (?, ?, ?)";  //data send to the databse
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, age);
           
            ps.execute();
 
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex);    
        }
        
        
    }
    
    @Override     //PlayerLogin method is used to login the game
    public boolean playerLogin(String name, String password) throws RemoteException{
    
        String sql = "SELECT `name`, `password`FROM `register` WHERE `name`='"+name+"' AND `password`='"+password+"'";//search user name and password from database and check 
        ResultSet rs; 
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return true;
            }
            
 
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex);    
        }
        
        return false;
    }
    
    
    @Override
    public void submitScore(String logger, String answer) throws RemoteException {
        
        String sql = "INSERT INTO `Scoreboard`(`name`, `score`) VALUES (?, ?)";//send scores to the databse

         try {
            PreparedStatement ps = conn.prepareStatement(sql);   
            
            ps.setString(1, logger);
            ps.setInt(2, Integer.parseInt(answer));
            ps.execute();
            
            System.out.println("Answers Submitted");
 
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex);    
        }

    }
    
    
    @Override
    public String printScoreChart() throws RemoteException {
        
        String sql = "SELECT * FROM `scoreboard`"; // get data from the scoreboard table
        String [][] data = new String [5][2];
        String url = null;
        ResultSet rs;
        int i = 0;
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);   
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                data[i][0] = rs.getString("name");
                data[i][1] = rs.getString("score");
                
                i++;
            }
            
            System.out.println("scores Collected");
            
            url = chart.gameChart(data);
 
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex);    
        }
        
        
        return url;
    }
    
    
    @Override
     public String printScore(int score) throws RemoteException {
        
        String url  = null;
        String sco = String.valueOf(score);
        
        url = chart.scoreChart(sco);
        
        return url;
    }
     
     
    
    

    
    



}