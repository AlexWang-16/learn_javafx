package application;

//Attn 1: new imports
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
	
	/* Attn 2: Declare all of its variables JavaFX Properties 
	 * 		   to allow future actions to be performed based on events.
	 */
	private final SimpleIntegerProperty id;
	private final SimpleStringProperty name;
	private final SimpleStringProperty surname;
	private final SimpleIntegerProperty age;
	
	public Student(Integer id, String name, String surname, Integer age) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
		this.age = new SimpleIntegerProperty(age);
	}
	
	public String getName() {
		return name.get();
	}

	public String getSurname() {
		return surname.get();
	}

	public Integer getAge() {
		return age.get();
	}

	public Integer getId(){
		return id.get();
	}
}
