package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModelProperty;

public class Automobile {
	
	@ApiModelProperty(required = true)
	private String brand;
	private String model;
	private String color;
	private String engineType;
	
	public Automobile(){
		this.brand = "";
		this.model = "";
		this.color = "";
		this.engineType = "";
	}
	
	public Automobile(String brand, String model, String color, String engineType){
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.engineType = engineType;
	}
	
	public String getBrand(){
		return brand;
	}
	
	public String getModel(){
		return model;
	}
	
	public String getEngineType(){
		return engineType;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setBrand(String brand){
		this.brand = brand;
	}
	
	public void setModel(String model){
		this.model = model;
	}
	
	public void setEngineType(String engineType){
		this.engineType = engineType;
	}
	
	public void setColor(String color){
		this.color = color;
	}
}
