package co.edu.model;

public class City {

	
	private Long id; 
	private String name;
	private Long idCountry;
	
	public City() {
		
	}
	public City(Long id, String name, Long idCountry) {
		super();
		this.id = id;
		this.name = name;
		this.idCountry = idCountry;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	} 
	
}
