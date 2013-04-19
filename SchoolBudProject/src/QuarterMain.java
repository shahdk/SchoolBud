import java.util.ArrayList;


public class QuarterMain {
	
	private ArrayList<Quarter> quarterList;
	
	public QuarterMain(){
		this.quarterList = new ArrayList<Quarter>();
	}

	public ArrayList<Quarter> getQuarterList() {
		return this.quarterList;
	}

	public boolean removeQuarter(String name) {
		for(int i=0; i<this.quarterList.size(); i++){
			if(this.quarterList.get(i).getName().equals(name)){
				this.quarterList.remove(i);
				return true;
			}
		}
		return false;
	}

	public void addQuarter(Quarter q1) {
		for(Quarter q: this.quarterList){
			if(q.getName().equals(q1.getName())){
				throw new IllegalArgumentException();
			}
		}
		this.quarterList.add(q1);
	}

}
