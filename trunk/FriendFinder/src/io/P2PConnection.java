package io;

import java.io.IOException;
//import java.security.MessageDigest;
import java.util.Random;
import javax.microedition.pim.Contact;
import main.MainMIDlet;
import main.Person;
import smsconnect.SMSRequest;

/**
 * Singleton-Implemenation of the connection between
 * @author Chris2u
 */
public class P2PConnection {
    private static P2PConnection inst;
       
    private String sessionId;
    private SMSRequest request;
    private HTTPConnection conn;
    private boolean connectionEstablished = false;
       
    public static P2PConnection getInstance() {
        if (inst==null) throw new IllegalStateException("The Connection hasn't been initialized.");
        return inst;
    }
    
    /**
     * Initiate a FriendFinder-Guide from Person A
     * @param contact
     * @return
     * @throws java.io.IOException
     */
    public static P2PConnection request(Contact contact) throws IOException {
        return inst = new P2PConnection(contact);
    }
    
    /**
     * Prepare for confirm of FF-Guide received from Person A at Person B
     * @param request
     * @return
     */
    public static P2PConnection establish(SMSRequest request) {
        Person.other().setMobilenumber(request.getPhoneNumber());
        // ask the user for confirmation
        MainMIDlet.getInstance().newFFrequest();
        return inst = new P2PConnection(request.getSessionId());
    }
    
    public void confirm() {
        
    }

    public boolean isConnectionEstablished() {
        return connectionEstablished;
    }

    public void setConnectionEstablished(boolean connectionEstablished) {
        this.connectionEstablished = connectionEstablished;
    }
    
    public void update() {
        
    }
    
    public boolean write(String message) {
        return true;
//        conn.send((Person.me().getPosition().toString(), message);
    }
    
    public void read() {
        /**
         * [0] GPSString
         * [1] message or null if no message available
         */
        String[] answer = conn.read();
//        Person.other().setPosition(new GPSposition(answer[0]));
//        Person.other().setMessage(answer[1]));
    }

    public Person getMe() {
        return Person.me();
    }

    public Person getOther() {
        return Person.other();
    }

    public String getSessionId() {
        return sessionId;
    }


    
    private P2PConnection() {
    }
    
    /**
     * See .request()
     * @param contact
     * @throws java.io.IOException
     */
    private P2PConnection(Contact contact) throws IOException {
        createSessionId();
        request = new SMSRequest(contact, sessionId);
        String message = request.send();
    }

    /**
     * See .establish()
     * @param sessionId
     */
    private P2PConnection(String sessionId) {
        this.sessionId = sessionId;
    }
    
    private void createSessionId() {
        sessionId = new Random().nextInt(Integer.MAX_VALUE)+"";
        
        /* We don't need a real Hash, do we?
        
        MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
        mdAlgorithm.update(randomKey.getBytes(), 0, randomKey.length());

        byte[] digest = mdAlgorithm.digest();
        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < digest.length; i++) {
            plainText = Integer.toHexString(0xFF & digest[i]);

            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }

            hexString.append(plainText);
        }*/
    }

}