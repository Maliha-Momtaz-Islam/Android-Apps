package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import listviewclass.foundListAdapter;

import com.example.emergencyservicebangladesh.R;

import android.content.Context;
import android.database.SQLException;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import databasepakage.Gateway;
import entityclass.Emergency;

public class Utility {
	private static Gateway aGateway;
	public static List<String> GetHeaderList(Context context,String type) throws SQLException, IOException
	{
		List<String>tempList=new ArrayList<String>();
		aGateway=new Gateway(context);
		tempList=aGateway.getPlace(type);
		return tempList;
	}
	public static Map<String, List<String>> getChildMap(Context context,String type) throws SQLException, IOException
	{
		Map<String, List<String>> map=new HashMap<String, List<String>>();
		aGateway=new Gateway(context);
		//Map<String,List<String>>temp=new HashMap<String, List<String>>();
		map=aGateway.getMapOfNameAndNumber(type);
		Log.i("map",map.size()+"");
		return map;
	}
	public static ArrayList<String> getNumbers(String phone)
	{
		ArrayList<String> phoneList=new ArrayList<String>();
		StringTokenizer st=new StringTokenizer(phone," ");
		while(st.hasMoreTokens())
		{
			phoneList.add(""+st.nextToken());
		}
		return phoneList;
	}
	public static Toast getToast(ArrayList<Emergency> foundList, FragmentActivity fragmentActivity) {
		
		Toast toast;
		if (foundList.size() == 0) {
			 toast = Toast.makeText(fragmentActivity, "Not Found",
					Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			 toast = Toast.makeText(fragmentActivity, "Found!!!",
					Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
		}
		return toast;
	}
	

}
