package gps;

/**
 *
 * @author CoolCat
 */
public class GPScalculations {
    
    private GPSposition currentpos;
    private GPSposition oldpos;
    private GPSposition targetpos;
    private TestData test=new TestData();
    
    //Initialisierung von targetpos und currentpos
    public void start(){ 
        test.start();
        if(targetpos==null){
            setTargetPosition();
        }
        if(currentpos==null){
            setCurrentPosition();
        }
    }
    
    //Überprüfung ob Ziel erreicht
    public boolean targetreached(){
        if(currentpos.getLatitude()==targetpos.getLatitude() && currentpos.getLongitude()==targetpos.getLongitude()){
            return true;
        }
        else return false;
    }
    
    public GPSposition getPosition() {
        return currentpos;
    }

    //Ausgabe der Richtung zum Ziel
    //Gemessen in(0-360) Grad im Uhrzeigersinn 
    //von der Laufrichtung
    public double getDirection() {
        oldpos=currentpos;
        setCurrentPosition();
        double targetDirection=calcTargetDir();
        double moveDirection=calcMoveDir();
        double direction=moveDirection-targetDirection;
        if(direction<0){
            direction=direction+360;
        }
        return direction;
    }
    /**
     * 
     * @return Distance in km
     */
    public double getDistance() {
        return calcDistance();
    }
    
    private void setCurrentPosition(){
        currentpos=getPosGPS();
    }
    
    private void setTargetPosition(){
        targetpos=getTargetPos();
    }
    
    //Noch zu Implementieren
    //Daten vom GPS
    private GPSposition getPosGPS(){
        return test.getOwnpos();
    }
    
    //Noch zu Implementieren
    //Daten vom Ziel vom Server
    private GPSposition getTargetPos(){
        return test.getTargetpos();
    }
    
    //Berechnung der Distanz
    private double calcDistance(){
        double distance;
        distance= mMath.acos(Math.sin(currentpos.getLatitude())*Math.sin(targetpos.getLatitude())+Math.cos(currentpos.getLatitude())*Math.cos(targetpos.getLatitude())*Math.cos(currentpos.getLongitude()-targetpos.getLongitude()));
        distance= distance*6378.137;
        return distance;
    }
    
    //Berechnung der Richtung zum Ziel
    private double calcTargetDir(){
        double longDist;
        double dist;
        double dir;
        longDist=mMath.acos(Math.sin(currentpos.getLatitude())*Math.sin(currentpos.getLatitude())+Math.cos(currentpos.getLatitude())*Math.cos(currentpos.getLatitude())*Math.cos(currentpos.getLongitude()-targetpos.getLongitude()));
        longDist=longDist*6378.137;
        dist=calcDistance();
        longDist=longDist/dist;
        dir=Math.cos(longDist);
        
        //Überprüfung auf Quadrant zur Korrektur
        if(targetpos.getLongitude()>=currentpos.getLongitude()){
            if(targetpos.getLatitude()<currentpos.getLatitude()){
                dir=360-dir; //4. Quadrant
            }
        }
        else if(targetpos.getLatitude()>=currentpos.getLatitude()){
            dir=180-dir; //2. Quadrant
        }
        else dir=dir+180; //3. Quadrant
        
        return dir;
    }
    
    //Berechnung der Laufrichtung
    private double calcMoveDir(){
        double longDist;
        double dist;
        double dir;
        longDist=mMath.acos(Math.sin(currentpos.getLatitude())*Math.sin(currentpos.getLatitude())+Math.cos(currentpos.getLatitude())*Math.cos(currentpos.getLatitude())*Math.cos(currentpos.getLongitude()-oldpos.getLongitude()));
        longDist=longDist*6378.137;
        dist= mMath.acos(Math.sin(currentpos.getLatitude())*Math.sin(oldpos.getLatitude())+Math.cos(currentpos.getLatitude())*Math.cos(oldpos.getLatitude())*Math.cos(currentpos.getLongitude()-oldpos.getLongitude()));
        longDist=longDist/dist;
        dir=Math.cos(longDist);
        
        //Überprüfung auf Quadrant zur Korrektur
        if(currentpos.getLongitude()>=oldpos.getLongitude()){
            if(currentpos.getLatitude()<oldpos.getLatitude()){
                dir=360-dir; //4. Quadrant
            }
        }
        else if(currentpos.getLatitude()>=oldpos.getLatitude()){
            dir=180-dir; //2.Quadrant
        }
        else dir=dir+180; //3.Quadrant
        
        return dir;
    }

}
