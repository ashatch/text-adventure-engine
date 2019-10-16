package xyz.devosmium.games.textadventureengine.locations;

import java.util.ArrayList;
import xyz.devosmium.games.textadventureengine.mobiles.Mobile;
import xyz.devosmium.games.textadventureengine.util.Coordinate;

/**
 * Base class for creating a Location instance. Library users should extend this
 * class and put the buildLocation() methods in the constructor. Each
 * LocationFactory should represent one Area (or domain) in the world.
 */
public class LocationFactory {

  private ArrayList<Location> locations;

  public ArrayList<Location> getLocations() { return locations; }

  public LocationFactory() { locations = new ArrayList<Location>(); }

  /**
   * Creates a new location with Mobiles.
   *
   * @param coordinates The coordinates of the location in the world
   * @param shortString The title of the location
   * @param longString The scenic description of the room
   * @param mobiles An ArrayList of Mobile instances
   * @return The Location instance
   */
  public Location buildLocation(Coordinate coordinates, String shortString,
                                String longString, ArrayList<Mobile> mobiles) {
    Location newLoc =
        new Location(coordinates, shortString, longString, mobiles);

    return newLoc;
  }

  /**
   * Creates a new Location without Mobiles.
   *
   * @see buildLocation()
   * @return The Location instance
   */
  public Location buildLocation(Coordinate coordinates, String shortString,
                                String longString) {
    Location newLoc = new Location(coordinates, shortString, longString);

    return newLoc;
  }

  /**
   * Creates a new location without Mobiles and registers it with an Area
   *
   * @param coordinates The coordinates of the location in the world
   * @param shortString The title of the location
   * @param longString The scenic description of the room
   * @param area The area to add the location to
   */
  public Location addLocation(Coordinate coordinates, String shortString,
                              String longString, Area area) {
    Location newLoc = new Location(coordinates, shortString, longString);
    area.registerLocation(newLoc);

    return newLoc;
  }

  /**
   * Creates a new location without Mobiles and registers it with an area
   *
   * @param coordinates The coordinates of the location in the world
   * @param shortString The title of the location
   * @param longString The scenic description of the room
   * @param area The area to add the location to
   */
  public Location addLocation(Coordinate coordinates, String shortString,
                              String longString, ArrayList<Mobile> mobiles,
                              Area area) {
    Location newLoc = new Location(coordinates, shortString, longString);
    area.registerLocation(newLoc);

    return newLoc;
  }
}