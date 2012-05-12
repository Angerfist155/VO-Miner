package com.uruwolf.vominer.data;

/**
 * Contains information about a single mineral within a sector
 * @author Steve "Uru" West <uruwolf@gmail.com>
 *
 */
public class Mineral {

	private Sector sector;
	private String mineral;
	private long id;

	public Mineral(){
		this(null, "");
	}
	
	public Mineral(Sector sector, String mineral){
		setSector(sector);
		setMineral(mineral);
	}

	/**
	 * @return the sector
	 */
	public Sector getSector() {
		return sector;
	}

	/**
	 * @param sector the sector to set
	 */
	public void setSector(Sector sector) {
		this.sector = sector;
	}

	/**
	 * @return the mineral
	 */
	public String getMineral() {
		return mineral;
	}

	/**
	 * @param mineral the mineral to set
	 */
	public void setMineral(String mineral) {
		this.mineral = mineral;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
}
