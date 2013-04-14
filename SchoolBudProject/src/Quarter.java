
public class Quarter {
	
	private String quaterName;

	public Quarter(String name) {
		if(name.length() == 0){
			throw new IllegalArgumentException();
		}
		this.quaterName = name;
	}

}
