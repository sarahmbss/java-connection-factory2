package bancoDados;

public class CategoriesModel {

	private int id;
	private String name;
	private String description;
	
	//constructor, apenas para membros do pacote(para fins de teste)
	protected void setData(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	//getters
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	//show data
	public void showData() {
		System.out.println("Id: "+this.id);
		System.out.println("Name: "+this.name);
		System.out.println("Description: "+this.description);
	}
}
