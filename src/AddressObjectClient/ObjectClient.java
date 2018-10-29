package AddressObjectClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import AddressObjectDomain.Person;



public class ObjectClient {

    ObjectClient() throws Exception{
        String hostName = "127.0.0.1";  //localhost
        int portNumber = 12345;
  
        Socket addressSocket = new Socket(hostName, portNumber);
        ObjectOutputStream oos = new ObjectOutputStream(addressSocket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(addressSocket.getInputStream());
        
        //String fromServer;
        Person fromServer;
        String fromUser;
        BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            
        
        while ((fromServer = (Person)ois.readObject()) != null) {

            System.out.println("Server: " + fromServer.getAddress());

            fromUser = stdIn.readLine();
            if (fromUser != null) {
                System.out.println("Client: " + fromUser);
                oos.writeObject(fromUser);
            }
        }
        
    }
    
    public static void main(String[] args) throws Exception{
        ObjectClient c = new ObjectClient();
    }
    
}
