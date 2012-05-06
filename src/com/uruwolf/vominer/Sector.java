package com.uruwolf.vominer;

/**
 * Contains basic location information for a specific sector
 * @author Steve "Uru" West
 */
public class Sector {
	private String system;
	private String aplhaCoord;
	private String numCoord;
	
	/**
	 * Creates an empty sector
	 */
	public Sector(){
		this("","","");
	}
	
	public Sector(String system, String alpha, String num){
		setSystem(system);
		setAplhaCoord(alpha);
		setNumCoord(num);
	}
	
	/**
	 * @return the system
	 */
	public String getSystem() {
		return system;
	}
	/**
	 * @param system the system to set
	 */
	public void setSystem(String system) {
		this.system = system;
	}
	/**
	 * @return the aplhaCoord
	 */
	public String getAplhaCoord() {
		return aplhaCoord;
	}
	/**
	 * @param aplhaCoord the aplhaCoord to set
	 */
	public void setAplhaCoord(String aplhaCoord) {
		this.aplhaCoord = aplhaCoord;
	}
	/**
	 * @return the numCoord
	 */
	public String getNumCoord() {
		return numCoord;
	}
	/**
	 * @param numCoord the numCoord to set
	 */
	public void setNumCoord(String numCoord) {
		this.numCoord = numCoord;
	}
	
	
}
