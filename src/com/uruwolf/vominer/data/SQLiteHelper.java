/*
 * SQLiteHelper.java
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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Contains the magical code to talk to the SQLite database
 * @author Steve "Uru" West <uruwolf@gmail.com>
 *
 */
public class SQLiteHelper extends SQLiteOpenHelper {

	//General structure information
	//Tables
	public static final String TABLE_SECTORS = "sectors";
	public static final String TABLE_SECTOR_MINERALS = "sector_minerals";
	//The default ID col name
	public static final String COL_ID = "_id";
	
	//Sector column names
	public static final String COL_SECTORS_SYSTEM = "system";
	public static final String COL_SECTORS_ALPHA = "alpha";
	public static final String COL_SECTORS_NUM = "num";
	public static final String COL_SECTORS_NOTES = "notes";
	
	//Sector minerals column names
	public static final String COL_SECTOR_MINERALS_SECTOR = "sector";
	public static final String COL_SECTOR_MINERALS_MINERAL = "mineral";
	
	//Information on the database itself
	private static final String DATABSE_NAME = "sector_info.db";
	public static final int DATABSE_VERSION = 1;
	
	public SQLiteHelper(Context context){
		super(context, DATABSE_NAME, null, DATABSE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String createSectorsQuery = "create table "+TABLE_SECTORS+"(" +
				COL_ID+" integer primary key autoincrement,"+
				COL_SECTORS_SYSTEM+" text not null,"+
				COL_SECTORS_ALPHA+" text not null,"+
				COL_SECTORS_NUM+" text not null,"+
				COL_SECTORS_NOTES+" text not null"+
				");";
		
		String createMineralsQuery = "create table "+TABLE_SECTOR_MINERALS+"("+
				COL_ID+" integer primary key autoincrement,"+
				COL_SECTOR_MINERALS_SECTOR+" integer not null,"+
				COL_SECTOR_MINERALS_MINERAL+" text not null,"+
				"FOREIGN KEY("+COL_SECTOR_MINERALS_SECTOR+") REFERENCES "+TABLE_SECTORS+"("+COL_ID+") ON UPDATE CASCADE"+
				");";
		
		Log.d(com.uruwolf.vominer.VoMinerActivity.TAG, "Creating new database");
		db.execSQL(createSectorsQuery);
		db.execSQL(createMineralsQuery);
		Log.d(com.uruwolf.vominer.VoMinerActivity.TAG, "Database created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d(com.uruwolf.vominer.VoMinerActivity.TAG, "Upgrade the database? I don't know how the fuck to do that!");
	}

}
