package ÖvnUppg6_Adressbok.Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.Month;
import ÖvnUppg5_Adressbok.Server.Kompis;
import ÖvnUppg5_Adressbok.Server.DAO;


public class ObjectServer {
    
    DAO d = new DAO();
    
    public ObjectServer()throws Exception{
        int portNumber = 12345;

        try(
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            ObjectOutputStream oos = new ObjectOutputStream(
                    clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(
                    clientSocket.getInputStream());){
                 
            Object inputLine;
            Kompis outputPerson;

            //Fuling, vi gör såhär eftersom klienten bara tar emot Person
            oos.writeObject(new Kompis(null, 
                    "Vems adress behöver du veta",null));

           while ((inputLine = (String)ois.readObject()) != null) {
               
                outputPerson = d.getPersonByName(((String)inputLine)
                        .trim());
                if (outputPerson == null){
                    //String n = "Denna person finns inte i databasen";
                    oos.writeObject(new Kompis("Null", 
                            "Denna person finns inte i databasen",
                            LocalDate.of(1967, Month.SEPTEMBER, 27)));
                }
                else{
                     oos.writeObject(outputPerson);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args)throws Exception{
        ObjectServer s = new ObjectServer();
    }
}
