/**
 * Door class for north and south door in Coffeemaker
 * @author David Neiman and David Tsui
 */
public class DoorDescription {
	String description;
	
	public DoorDescription (String name) {
		this.description = name;
	}
	/**
	 * @param name set the description of the door
	 * @return boolean returns true if not null
	 */
	public boolean setDescription (String name) {
		if (name == null) return false;
		this.description = name;
		return true;
	}
	/**
	 * @return the description of the door
	 */
	public String getDescription () {
		return description;
	}
}