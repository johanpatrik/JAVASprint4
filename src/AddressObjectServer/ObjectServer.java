package AddressObjectServer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.Month;
import AddressObjectDomain.Person;


public class ObjectServer {
    
    Database d = new Database();
    
    public ObjectServer()throws Exception{
        int portNumber = 12345;


            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket.isConnected());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            Object inputLine;
            //String outputLine;
            Person outputPerson;
            
            //String q = "Vems adress behöver du få veta?";
            //Fuling, vi gör såhär eftersom klienten bara tar emot Person
            oos.writeObject(new Person("Kalle", "Vems adress behöver du veta",LocalDate.of(1967, Month.SEPTEMBER, 27), "Struma", false));

           while ((inputLine = (String)ois.readObject()) != null) {
               
                outputPerson = d.getPerson(((String)inputLine).trim());
                if (outputPerson == null){
                    //String n = "Denna person finns inte i databasen";
                    oos.writeObject(new Person("Null", "Denna person finns inte i databasen",LocalDate.of(1967, Month.SEPTEMBER, 27), "Struma", false));
                }
                else{
                     oos.writeObject(outputPerson);
                }
            }
        
    }

    public static void main(String[] args)throws Exception{
        ObjectServer s = new ObjectServer();
    }
}
