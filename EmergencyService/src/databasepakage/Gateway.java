package databasepakage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import entityclass.Emergency;

import android.content.ContentValues;
import android.content.Context;
import android.content.Entity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;

public class Gateway {
	private SQLiteDatabase sqLiteDB;
	private DBOpenHelper dbOpenHelper;
	String[] allPolicStationColumn = { "_id", "Name", "Address", "Phone",
			"Type","latitude","longitude" };

	public Gateway(Context context) {
		dbOpenHelper = new DBOpenHelper(context);
	}

	public void open() throws SQLException, IOException {
		openReadableDatabase();
		sqLiteDB = dbOpenHelper.openDatabase();
	}

	public void close() {
		dbOpenHelper.closeDataBase();
	}

	public void openReadableDatabase() throws IOException {
		dbOpenHelper.createDatabase();
	}

	public ArrayList<String> getPlace(String type) throws SQLException,
			IOException {
		open();
		ArrayList<String> departments = new ArrayList<String>();
		Cursor cursor = sqLiteDB.query(DBOpenHelper.TABLE_EMERGENCY,
				allPolicStationColumn, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			if (cursor.getString(4).compareTo(type) == 0) {
				String name = cursor.getString(1);
				departments.add(name);
			}

			cursor.moveToNext();
		}
		cursor.close();
		close();
		return departments;
	}

	public Map<String, List<String>> getMapOfNameAndNumber(String type)
			throws SQLException, IOException {

		open();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		// List<String>phonelist=new ArrayList<String>();
		Cursor cursor = sqLiteDB.rawQuery("SELECT * FROM emergency where type=\""+type+"\"", null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			if (cursor.getString(4).compareTo(type) == 0) {
				String name = cursor.getString(1);
				String phone = cursor.getString(3);
				Log.i("map", name+" "+phone);
				map.put(name, new ArrayList<String>(getPhoneNumbers(phone)));
			}
			cursor.moveToNext();
		}
		cursor.close();
		close();
	//	Log.i("phone",map.get("Demra Fire Station").get(0));
		return map;
	}

	private List<String> getPhoneNumbers(String phone) {
		StringTokenizer st = new StringTokenizer(phone, " ");
		List<String> phonelist = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			String str = st.nextToken();
			phonelist.add(str);
			Log.i("phone", str);
		}
		return phonelist;
	}

	public ArrayList<Emergency> getSearchedEntity(String string) throws SQLException, IOException {
		ArrayList<Emergency>entityList=new ArrayList<Emergency>();
		open();
		if(string.length()<3)
		{
			return entityList;
		}
		else
		{
			Cursor cursor=sqLiteDB.rawQuery("SELECT * FROM emergency where Name like '%"+string+"%' or Address like '"+string+"%'",null);
			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				entityList.add(new Emergency(Integer.parseInt(cursor.getString(0)), 
						cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),Double.parseDouble(cursor.getString(5)),Double.parseDouble(cursor.getString(6))));
				cursor.moveToNext();
			}
			cursor.close();
			close();
			return entityList;
		}
	}
	
	public ArrayList<Emergency> getAutoCompleteList(String string) throws SQLException, IOException {
		
		ArrayList<Emergency>entityList=new ArrayList<Emergency>();
		open();
		
			Cursor cursor=sqLiteDB.rawQuery("SELECT * FROM emergency where Name like '"+string+"%'",null);
			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				entityList.add(new Emergency(Integer.parseInt(cursor.getString(0)), 
						cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),Double.parseDouble(cursor.getString(5)),Double.parseDouble(cursor.getString(6))));
				cursor.moveToNext();
			}
			cursor.close();
			close();
			return entityList;
		
	}

	public double getLatitude(String headerTitle) throws SQLException, IOException {
		open();
		double latitude=0.0;
		Cursor cursor=sqLiteDB.rawQuery("SELECT latitude FROM emergency where Name like '"+headerTitle+"%'",null);
		cursor.moveToFirst();
		latitude=Double.parseDouble(cursor.getString(0));
		cursor.close();
		close();
		return latitude;
	}
	public double getLongitude(String headerTitle) throws SQLException, IOException {
		open();
		double latitude=0.0;
		Cursor cursor=sqLiteDB.rawQuery("SELECT longitude FROM emergency where Name like '"+headerTitle+"%'",null);
		cursor.moveToFirst();
		latitude=Double.parseDouble(cursor.getString(0));
		
		cursor.close();
		close();
		return latitude;
	}

}
