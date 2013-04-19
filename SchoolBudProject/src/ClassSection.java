import java.util.ArrayList;

/**
 * 
 */

/**
 * @author John
 *
 */
public class ClassSection {

	private String teacher;
	private ArrayList<ClassDay> classDays;
	
	public ClassSection (String teacher, ArrayList<ClassDay> days) throws InstantiationError{
		
		if (days.size() != 7) {
			throw new InstantiationError();
		}
		this.setClassDays(days);
		this.setTeacher(teacher);
	}

	/**
	 * @return the teacher
	 */
	public String getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the classDays
	 */
	public ArrayList<ClassDay> getClassDays() {
		return classDays;
	}

	/**
	 * @param classDays the classDays to set
	 */
	public void setClassDays(ArrayList<ClassDay> classDays) {
		this.classDays = classDays;
	}
	
	public static ArrayList<ClassDay> create7DayArrayList() {
		ArrayList<ClassDay> list = new ArrayList<ClassDay>();
		for (int i = 0; i < 7; i++) {
			list.add(new ClassDay(new ArrayList<Integer>()));
		}
		return list;
		
	}
}
