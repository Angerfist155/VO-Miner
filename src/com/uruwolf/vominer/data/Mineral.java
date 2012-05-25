/*
 * Mineral.java
 * Copyright (C) 2011 Steve "Uru" West <uruwolf@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 */
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
