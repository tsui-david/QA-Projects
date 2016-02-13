public class Furnishing {
	String name;
	
	public Furnishing(String name) {
		this.name = name;
	}
	
	public boolean setName(String name) {
		
		if (name == null) return false;
		
		this.name = name;
		return true;
	}
	public String getName () {
		if (this.name == null) return null;
		return this.name;
	}
}