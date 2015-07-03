/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.TGSBgame.control;

import byui.cit260.TGSBgame.exceptions.ChallengesControlException;
import byui.cit260.TGSBgame.exceptions.LocationControlException;
import byui.cit260.TGSBgame.model.Location;
import byui.cit260.TGSBgame.model.Player;
import byui.cit260.TGSBgame.model.Scene;

/**
 *
 * @author Adriana
 */
public class LocationControl {

    public static void startLocationControl(int spaces) throws LocationControlException, ChallengesControlException {
        Location locationObj;
        
        moveToNextLocation(spaces);
        locationObj = MapControl.getLocationFromMap(spaces);
        doLocationAction(locationObj);
    }

    private static Scene[] createScenes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //class variables
    public static int location;

    public static int getLocation() {
        return location;
    }

    //returns 0 on success, -1 on failure

    public static void setLocation(int row, int column) throws LocationControlException {

        int newLocation = (5 * row) - (5 - column);

        if (newLocation < 1 || newLocation > 35) {
            throw new LocationControlException("Can not move actor to location"
                    + " because that location is outside "
                    + " the bounds of the map.");
        } else {
            location = newLocation;
        }
    }
 
    private static void moveToNextLocation(int spaces) throws LocationControlException {

        int newLocation = location + spaces;

        if (newLocation > 35) {
            throw new LocationControlException("Can not move actor to location"
                    + " because that location is outside "
                    + " the bounds of the map.");
        } else {
            location = newLocation;

        }
    }    
    
    private static void doLocationAction(Location location) throws ChallengesControlException {
        String challengeString;
        
        // show description of scene for this location
        System.out.println("\ndebug:" + location);  //debug can delete later
        System.out.println(location.getScene());
        
        // get random actor for this location
        System.out.println("\n" + SceneControl.getActor());
        System.out.println("This person presents you with the following challenge:");
        
        // get random challenge for this location
        challengeString = ChallengesControl.getChallenge(location.getLinearLocation());
        System.out.println(challengeString);
        
    }

  }
