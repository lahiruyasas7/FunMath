/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package CODE;



import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * this is a parent class of the server side
 * abstraction
 */

/**
 *
 * @author lahiru yasas
 */
public interface ServiceInterface extends Remote{
    
    public void addNewPlayer(String name, String age, String password) throws RemoteException;
   
    public boolean playerLogin(String name, String password) throws RemoteException;
    
    public void submitScore(String logger, String answer) throws RemoteException;

    public String printScoreChart() throws RemoteException;

    public String printScore(int score) throws RemoteException;
    
    

}