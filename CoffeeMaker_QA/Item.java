public class Item {
	boolean has = false;
	String name;
	
	public Item(String name) {
		this.name = name;
		has = true;
	}
	
	public boolean setName(String name) {
		
		if (name == null) return false;
		
		this.name = name;
		return true;
	}
	
	public String getName() {
		if (this.name == null) return null;
		
		return this.name;
	}
}




