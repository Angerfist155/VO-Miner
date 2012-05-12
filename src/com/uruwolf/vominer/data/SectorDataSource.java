package com.uruwolf.vominer.data;

import com.uruwolf.vominer.R;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Acts as a layer between Objects and SQL for sectors
 * @author Steve "Uru" West <uruwolf@gmail.com>
 *
 */
public class SectorDataSource {
	
	private SQLiteDatabase database;
	private SQLiteHelper dbHelper;
	
	public SectorDataSource(Context context){
		dbHelper = new SQLiteHelper(context);
	}
	
	public void open() throws SQLException{
		database = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}
	
	/**
	 * Populates the given Sector with information from the database
	 * @param info Must have system, alpha and num coords
	 * @return
	 */
	public Sector populate(Sector info){
		if(info.getSystem() == "" || info.getAplhaCoord() == "" || info.getNumCoord() == "")
			throw new IllegalArgumentException("Given sector does not provide enough identification");
		
		Sector sector = loadSector(info);
		if(sector == null)
			return create(info);
		
		return sector;
	}
	
	/**
	 * Tries to load all the information on the given sector.
	 * @param id must have system, alpha coorrd and numerical coord
	 * @return null if a sector could not be loaded
	 */
	private Sector loadSector(Sector id){
		if(id.getSystem() == "" || id.getAplhaCoord() == "" || id.getNumCoord() == "")
			throw new IllegalArgumentException("Given sector does not provide enough identification");
		Sector sector = null;
		
		//Set up the where statement
		String whereString = SQLiteHelper.COL_SECTORS_SYSTEM+"=? AND "+
							 SQLiteHelper.COL_SECTORS_ALPHA+"=? AND "+
							 SQLiteHelper.COL_SECTORS_NUM+"=?";
		
		String[] whereList = {id.getSystem(), id.getAplhaCoord(), id.getNumCoord()};
		
		//Run the query and get the results
		Cursor cursor = database.query(SQLiteHelper.TABLE_SECTORS,
				null,
				whereString,
				whereList,
				null,
				null,
				null
				);
		//Check that we have a result to work with
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			//Populate the sector
			sector = cursorToSector(cursor);
		}
		
		cursor.close();
		return sector;
	}
	
	/**
	 * Creates a sector with the given information. ID will be overwritten with the new insert ID
	 * @param sector
	 * @return
	 */
	private Sector create(Sector sector){
		//Set up the values to insert
		ContentValues values = new ContentValues();
		values.put(SQLiteHelper.COL_SECTORS_SYSTEM, sector.getSystem());
		values.put(SQLiteHelper.COL_SECTORS_ALPHA, sector.getAplhaCoord());
		values.put(SQLiteHelper.COL_SECTORS_NUM, sector.getNumCoord());
		values.put(SQLiteHelper.COL_SECTORS_NOTES, sector.getNotes());
		//Perform the insert and get the ID for later
		long insertID = database.insert(SQLiteHelper.TABLE_SECTORS, null, values);
		
		//Grab our new row so we can return it
		Cursor cursor = database.query(SQLiteHelper.TABLE_SECTORS,
				null,
				SQLiteHelper.COL_ID+"="+insertID,
				null, null, null, null);
		Sector newSector = cursorToSector(cursor);
		cursor.close();
		
		return newSector;
	}
	
	private Sector cursorToSector(Cursor cursor){
		cursor.moveToFirst();
		//Populate the sector
		Sector sector = new Sector();
		sector.setId(cursor.getInt(0)); //Load the ID
		sector.setSystem(cursor.getString(1)); //Load the System
		sector.setAplhaCoord(cursor.getString(2)); //Load the alpha Coord
		sector.setNumCoord(cursor.getString(3)); //Load the num coord
		sector.setNotes(cursor.getString(4)); //Get the system notes
		return sector;
	}
	
	/**
	 * Attempts to add a mineral to the given sector
	 * @param sector Must have an id >= 0
	 * @param mineral
	 */
	public void addMineralToSector(Sector sector, Mineral mineral){
		if(sector.getId() < 0)
			throw new IllegalArgumentException("Sector needs a valid id.");
		
		ContentValues values = new ContentValues();
		values.put(SQLiteHelper.COL_SECTOR_MINERALS_MINERAL, mineral.getMineral());
		values.put(SQLiteHelper.COL_SECTOR_MINERALS_SECTOR, sector.getId());
		
		mineral.setId(database.insert(SQLiteHelper.TABLE_SECTOR_MINERALS, null, values));
		sector.addMineral(mineral);
	}
}
