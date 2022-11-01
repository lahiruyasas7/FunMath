/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CODE;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

/**
 *this is the server class that is used for run the server on the local host as the service
 * @author lahiru yasas
 */
public class RMIserver {
    
    public static void main(String args[]) throws RemoteException, NotBoundException{
    
        Registry registry = null;
        RMIImplementation service = new RMIImplementation();
        
        /**
         * start the server
         */
        try {
            registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RMIserver", service);
            System.out.println("Server is Now runnig...\n");
        } catch (ExportException ex) {
            registry = LocateRegistry.getRegistry(1099);
            System.out.println("Server is Now runnig...\n");
        }
        
    }
}
