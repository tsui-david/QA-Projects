package cs1632;

public class Room {
	public String furnishing;
	public String description;
	public Room south_room;
	public Room north_room;
	public String north_room_door_description;
	public String south_room_door_description;
	public String item;
	
	public String getFurnishing() {
		return furnishing;
	}
	public void setFurnishing(String furnishing) {
		this.furnishing = furnishing;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Room getSouth_room() {
		return south_room;
	}
	public void setSouth_room(Room south_room, String south_room_description) {
		this.south_room = south_room;
		this.south_room_door_description = south_room_description;
	}
	public Room getNorth_room() {
		return north_room;
	}
	public void setNorth_room(Room north_room, String north_room_description) {
		this.north_room = north_room;
		this.north_room_door_description = north_room_description;
	}
	public String getNorth_room_door_description() {
		return north_room_door_description;
	}
	public String getSouth_room_door_description() {
		return south_room_door_description;
	}

	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	
	
	
	
	
}
