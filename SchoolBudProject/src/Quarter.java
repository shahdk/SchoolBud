
public class Quarter {
	
	private String quaterName;

	public Quarter(String name) {
		if(name.length() == 0){
			throw new IllegalArgumentException();
		}
		this.quaterName = name;
	}

	public String getName() {
		return this.quaterName;
	}

	public void setName(String name) {
		if(name.length()==0){
			throw new IllegalArgumentException();
		}
		this.quaterName = name;
	}


}
