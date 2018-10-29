package ÖvnUppg8_Sessionsobjekt;

import java.io.*;
import java.net.*;

public class RiddleClient {
    public static void main(String[] args) throws IOException {
        
        String hostName = "127.0.0.1"; //localhost
        //String hostName = "172.20.200.194"; //localhost
        int portNumber = 44444;

        try (
            Socket kkSocket = new Socket(hostName, portNumber);
        ) {
            ObjectOutputStream oos= new ObjectOutputStream(kkSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(kkSocket.getInputStream());
            
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            Session session;
            
            while ((session = (Session) ois.readObject()) != null) {
                //There should be error handling for WAITING and CLIENTSENTANSWER 
                if(session.getState() == RiddleState.SERVERSENTRIDDLE){
                    System.out.println("Server: " + session.getRiddle());
                    session.setAnswer(stdIn.readLine());
                    session.setState(RiddleState.CLIENTSENTANSWER);
                }
                else if(session.getState() == RiddleState.SERVERSENTANSWER) {
                    if (session.getVerdict()){
                        System.out.println("Server: Du gissade RÄTT!");
                    }
                    else{
                        System.out.println("Server: Du gissade FEL!");
                    }
                    session.setState(RiddleState.WAITING);
                }
                
                oos.writeObject(session);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            e.printStackTrace();
            System.exit(1);
        }
        catch (ClassNotFoundException e) {
            System.err.println("Couldn't find class " +
                hostName);
            System.exit(1);
        }
    }
}