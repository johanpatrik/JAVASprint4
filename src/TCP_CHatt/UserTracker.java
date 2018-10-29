package TCP_CHatt;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class UserTracker {
    
        /**
     * The set of all names of clients in the chat room.  Maintained
     * so that we can check that new clients are not registering name
     * already in use.
     */
    private static List<String> names = new ArrayList<String>();

    /**
     * The set of all the print writers for all the clients.  This
     * set is kept so we can easily broadcast messages.
     */
    private static List<PrintWriter> writers = new ArrayList<PrintWriter>();

    public void addName(String s) {
        names.add(s);
    }
    
    public void addWriter(PrintWriter p) {
        writers.add(p);
    }
    
    public List<String> getNames() {
        return names;
    }
    
    public List<PrintWriter> getWriters() {
        return writers;
    }
    
    public boolean containsName(String s) {
        return names.contains(s);
    }
    
    public void removeName(String s) {
        names.remove(s);
    }
    
    public void removeWriter(PrintWriter p) {
        writers.remove(p);
    }

}
