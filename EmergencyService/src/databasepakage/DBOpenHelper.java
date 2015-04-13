package databasepakage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBOpenHelper extends SQLiteOpenHelper{
	
	public final static String DB_PATH = "/data/data/com.example.emergencyservicebangladesh/databases/";
	 
    public final static String policeFireAndHospitalDB= "Emergency.sqlite";
    public final static String TABLE_EMERGENCY="emergency";
    public final static String TABLE_FIRE="fire_station";
    public final static String TABLE_HOSPITAL="hospital";
   // public final static String TABLE_POLICE="police_station";
 
    private SQLiteDatabase myDataBase; 
 
    private final Context myContext;
 
    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DBOpenHelper(Context context) {
 
    	super(context, policeFireAndHospitalDB, null, 1);
        this.myContext = context;
    }	
 
  /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDatabase() throws IOException
    {

          boolean dbExist = checkDataBase();

          if(dbExist)
          {
                Log.v("DB Exists", "db exists");
                // By calling this method here onUpgrade will be called on a
                // writeable database, but only if the version number has been
                // bumped
                //onUpgrade(myDataBase, DATABASE_VERSION_old, DATABASE_VERSION);
          }
         
          boolean dbExist1 = checkDataBase();
          if(!dbExist1)
          {
                this.getReadableDatabase();
                try
                {
                      this.close();    
                      copyDataBase();
                }
                catch (IOException e)
                {
                      throw new Error("Error copying database");
                }
          }

    }

    //Check database already exist or not
    private boolean checkDataBase()
    {
          boolean checkDB = false;
          try
          {
                String myPath = DB_PATH+policeFireAndHospitalDB;
                File dbfile = new File(myPath);
                checkDB = dbfile.exists();
          }
          catch(SQLiteException e)
          {
          }
          return checkDB;
    }

    //Copies your database from your local assets-folder to the just created empty database in the system folder
    private void copyDataBase() throws IOException
    {

          String outFileName = DB_PATH +policeFireAndHospitalDB;


          OutputStream myOutput = new FileOutputStream(outFileName);
          InputStream myInput = myContext.getAssets().open(policeFireAndHospitalDB);

          byte[] buffer = new byte[1024];
          int length;
          while ((length = myInput.read(buffer)) > 0)
          {
                myOutput.write(buffer, 0, length);
          }
          myInput.close();
          myOutput.flush();
          myOutput.close();
    }

    //delete database
    public void db_delete()
    {
          File file = new File(DB_PATH + policeFireAndHospitalDB);
          if(file.exists())
          {
                file.delete();
                System.out.println("delete database file.");
          }
    }

    //Open database
    public SQLiteDatabase openDatabase() throws SQLException
    {
          String myPath = DB_PATH  + policeFireAndHospitalDB;
          myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
          return myDataBase;
    }

    public synchronized void closeDataBase()throws SQLException
    {
          if(myDataBase != null)
                myDataBase.close();
          super.close();
    }

    public void onCreate(SQLiteDatabase db)
    {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {    
          if (newVersion > oldVersion)
          {
                Log.v("Database Upgrade", "Database version higher than old.");
                db_delete();
          }
    }
    //add your public methods for insert, get, delete and update data in database.

}

