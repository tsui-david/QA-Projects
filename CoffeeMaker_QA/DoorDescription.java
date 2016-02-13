public class DoorDescription {
	String description;
	
	public DoorDescription (String name) {
		this.description = name;
	}
	
	public boolean setDescription (String name) {
		if (name == null) return false;
		this.description = name;
		return true;
	}
	
	public String getDescription () {
		return description;
	}
}