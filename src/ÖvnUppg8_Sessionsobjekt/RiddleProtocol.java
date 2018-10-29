package ÖvnUppg8_Sessionsobjekt;

public class RiddleProtocol {

    private int currentRiddle = 0;

    private String[] clues = { "Vad är det som går och går men aldrig kommer till dörren?", "Vilken sten är alltid ihålig?", "Vilket öga kan inte se?"};
    private String[] answers = { "Klockan",
                                 "Skorstenen",
                                 "Nålsögat" };
    
    public Session getInitialSession(){
        return new Session(clues[currentRiddle]);
    }
    
    public Session processInput(Session s) {
        RiddleState state = s.getState();
        
        //There should be error handling for SERVERSENTRIDDLE state

        if (state == RiddleState.WAITING || state == RiddleState.SERVERSENTANSWER) {
            s.setRiddle(clues[currentRiddle]);
            s.setState(RiddleState.SERVERSENTRIDDLE);
        } else if (state == RiddleState.CLIENTSENTANSWER) {
            if (s.getAnswer().equalsIgnoreCase(answers[currentRiddle])) {
                s.setVerdict(true);
            } else {
                s.setVerdict(false);
            }
            s.setState(RiddleState.SERVERSENTANSWER);
            currentRiddle++;
            currentRiddle = currentRiddle%clues.length;
        }
        return s;
    }

}