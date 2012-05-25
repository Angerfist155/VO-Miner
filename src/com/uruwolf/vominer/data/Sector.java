/*
 * Sector.java
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

import java.util.ArrayList;
import java.util.List;

/**
 * Contains basic location information for a specific sector
 * @author Steve "Uru" West <uruwolf@gmail.com>
 */
public class Sector {
	private int id;
	private String system;
	private String alphaCoord;
	private String numCoord;
	private String notes;
	private final List<Mineral> mineralList;
	
	/**
	 * Creates an empty sector
	 */
	public Sector(){
		this("","","", -1, "");
	}
	
	public Sector(String system, String alpha, String num, int id, String notes){
		mineralList = new ArrayList<Mineral>();
		
		setSystem(system);
		setAplhaCoord(alpha);
		setNumCoord(num);
		setId(id);
		setNotes(notes);
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
		return alphaCoord;
	}
	/**
	 * @param aplhaCoord the aplhaCoord to set
	 */
	public void setAplhaCoord(String alphaCoord) {
		this.alphaCoord = alphaCoord;
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

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Adds a mineral to this sector. Also updates the mineral with the new parent sector
	 * @param newMineral
	 */
	public void addMineral(Mineral newMineral){
		newMineral.setSector(this);
		mineralList.add(newMineral);
	}
	
	/**
	 * Removes a mineral from this sector. Also updates the mineral with a new parent sector of "null"
	 * @param toRemove
	 */
	public void removeMineral(Mineral toRemove){
		toRemove.setSector(null);
		mineralList.remove(toRemove);
	}
	
	public List<Mineral> getMinerals(){
		return mineralList;
	}
	
	public boolean equal(Object obj){
		if(obj instanceof Sector){
			Sector newS = (Sector) obj;
			return (newS.getSystem().equals(system) &&
					newS.getAplhaCoord().equals(alphaCoord) &&
					newS.getNumCoord().equals(numCoord));
		}
		
		return false;
	}
}
