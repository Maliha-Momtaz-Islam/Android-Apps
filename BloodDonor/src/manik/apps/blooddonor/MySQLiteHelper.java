package manik.apps.blooddonor;

import java.util.LinkedList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "DonorDB";

	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	private static final String TABLE_DONORS = "donor";
	private static final String KEY_ID = "id";
	private static final String KEY_MOBILENO = "mobilenumber";
	private static final String KEY_NAME = "donorname";
	private static final String KEY_BLOODGROUP = "bloodgroup";
	private static final String KEY_BIRTHDATE = "birthdate";
	private static final String KEY_ADDRESS = "address";
	private static final String KEY_LASTDONATE = "lastdonate";
	private static final String KEY_IDENTITY = "identity";
	private static final String[] COLUMNS = {KEY_ID,KEY_MOBILENO,KEY_NAME,KEY_BLOODGROUP,KEY_BIRTHDATE,KEY_ADDRESS,KEY_LASTDONATE,KEY_IDENTITY};

	@Override
	public void onCreate(SQLiteDatabase db) {
		// SQL statement to create book table
		String CREATE_BOOK_TABLE = "CREATE TABLE Donor ( "
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "mobilenumber TEXT, " + "donorname TEXT, "
				+ "bloodgroup TEXT, " + "birthdate TEXT, " + "address TEXT, "
				+ "lastdonate TEXT, identity TEXT )";

		// create books table
		db.execSQL(CREATE_BOOK_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older books table if existed
		// db.execSQL("DROP TABLE IF EXISTS books");

		// create fresh books table
		// this.onCreate(db);
	}

	public void addDonor(Donor donor) throws Exception {
		try {
			// for logging
			Log.d("addDonor", donor.toString());

			// 1. get reference to writable DB
			SQLiteDatabase db = this.getWritableDatabase();

			// 2. create ContentValues to add key "column"/value
			ContentValues values = new ContentValues();
			values.put(KEY_MOBILENO, donor.MobileNumber);
			values.put(KEY_NAME, donor.DonorName);
			values.put(KEY_BLOODGROUP, donor.BloodGroup);
			values.put(KEY_BIRTHDATE, donor.BirthDate);
			values.put(KEY_ADDRESS, donor.Address);
			values.put(KEY_LASTDONATE, donor.LastDonate);
			values.put(KEY_IDENTITY, donor.Identity);

			db.insert(TABLE_DONORS, // table
					null, // nullColumnHack
					values); // key/value -> keys = column names/ values =
								// column
								// values

			db.close();

		} catch (Exception e) {
			throw e;
		}

	}

	public int updateDonor(Donor donor) throws Exception {
		try {
			// 1. get reference to writable DB
			SQLiteDatabase db = this.getWritableDatabase();

			// 2. create ContentValues to add key "column"/value
			ContentValues values = new ContentValues();
			values.put(KEY_MOBILENO, donor.MobileNumber);
			values.put(KEY_NAME, donor.DonorName);
			values.put(KEY_BLOODGROUP, donor.BloodGroup);
			values.put(KEY_BIRTHDATE, donor.BirthDate);
			values.put(KEY_ADDRESS, donor.Address);
			values.put(KEY_LASTDONATE, donor.LastDonate);
			values.put(KEY_IDENTITY, donor.Identity);

			// 3. updating row
			int i = db.update(TABLE_DONORS, // table
					values, // column/value
					KEY_ID + " = ?", // selections
					new String[] { String.valueOf(donor.Id) }); // selection
																// args

			// 4. close
			db.close();

			return i;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	public List<Donor> getAllDonors() throws Exception {
		List<Donor> donors = new LinkedList<Donor>();
		try {
			// 1. build the query
			String query = "SELECT  * FROM " + TABLE_DONORS;

			// 2. get reference to writable DB
			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(query, null);

			// 3. go over each row, build book and add it to list
			Donor donor = null;
			if (cursor.moveToFirst()) {
				do {
					donor = new Donor();
					donor.Id = Integer.parseInt(cursor.getString(0));
					donor.MobileNumber = cursor.getString(1);
					donor.DonorName = cursor.getString(2);
					donor.BloodGroup = cursor.getString(3);
					donor.BirthDate = cursor.getString(4);
					donor.Address = cursor.getString(5);
					donor.LastDonate = cursor.getString(6);
					donor.Identity = cursor.getString(7);

					// Add book to books
					donors.add(donor);
				} while (cursor.moveToNext());
			}

			Log.d("getAllDonors()", donors.toString());

			// return books
			return donors;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

	public void deleteDonor(int id) throws Exception {
		try {
			// 1. get reference to writable DB
			SQLiteDatabase db = this.getWritableDatabase();

			// 2. delete
			db.delete(TABLE_DONORS, // table name
					KEY_ID + " = ?", // selections
					new String[] { String.valueOf(id) }); // selections args

			// 3. close
			db.close();

			// log
			Log.d("deleteDonor", String.valueOf(id));
		} catch (Exception e) {
			throw e;
		}

	}

	public List<Donor> searchDonor(String bg,String address) throws Exception{
		try {
			List<Donor> donors = new LinkedList<Donor>();
	        // 1. get reference to readable DB
	        SQLiteDatabase db = this.getReadableDatabase();
	        Cursor cursor = null;
	        String query = "SELECT  * FROM " + TABLE_DONORS;
	        if(bg!="" && address!="")
	        {
	        	query+=" WHERE bloodgroup LIKE '%"+bg+"%' AND address LIKE '%"+address+"%'";
	        /*cursor = 
	                db.query(TABLE_DONORS, // a. table
	                COLUMNS, // b. column names
	                " bloodgroup = ? AND address LIKE '%?%' ", // c. selections 
	                new String[] { bg, address}, // d. selections args
	                null, // e. group by
	                null, // f. having
	                null, // g. order by
	                null); // h. limit
*/	        }
	        else if(bg!="" && address=="")
	        {
	        	query+=" WHERE bloodgroup LIKE '%"+bg+"%'";
	        	/*cursor = 
		                db.query(TABLE_DONORS, // a. table
		                COLUMNS, // b. column names
		                KEY_BLOODGROUP + "=?", // c. selections 
		                new String[] { bg}, // d. selections args
		                null, // e. group by
		                null, // f. having
		                null, // g. order by
		                null); // h. limit
*/	        }
	        else if(bg=="" && address!="")
	        {
	        	query+=" WHERE address LIKE '%"+address+"%'";
	        	/*cursor = 
		                db.query(TABLE_DONORS, // a. table
		                COLUMNS, // b. column names
		                "  address LIKE '%?%' ", // c. selections 
		                new String[] { address}, // d. selections args
		                null, // e. group by
		                null, // f. having
		                null, // g. order by
		                null); // h. limit
*/	        }
	        //query = "SELECT  * FROM " + TABLE_DONORS;
	        cursor = db.rawQuery(query, null);
	        // 3. if we got results get the first one
	        if (cursor != null)
	            cursor.moveToFirst();
	 
	        Donor donor = null;
			if (cursor.moveToFirst()) {
				do {
					donor = new Donor();
					donor.Id = Integer.parseInt(cursor.getString(0));
					donor.MobileNumber = cursor.getString(1);
					donor.DonorName = cursor.getString(2);
					donor.BloodGroup = cursor.getString(3);
					donor.BirthDate = cursor.getString(4);
					donor.Address = cursor.getString(5);
					donor.LastDonate = cursor.getString(6);
					donor.Identity = cursor.getString(7);

					// Add book to books
					donors.add(donor);
				} while (cursor.moveToNext());
			}
	 
	        Log.d("searchDonor("+bg+ ", " +address +")", String.valueOf(donors.size()));
	 
	        // 5. return book
	        return donors;
		} catch (Exception e) {
			//Log.d("getAllDonors()", e.getMessage());
			throw e;
		}
		
    }
}
