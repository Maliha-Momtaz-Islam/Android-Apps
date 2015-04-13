package entityclass;

public class Emergency {

	private int _id;
	private String Name;
	private String Address;
	private String Phone;
	private String Type;
	private double latitude;
	private double longitude;
	public Emergency(int _id, String name, String address, String phone,
			String type,double longitude,double latitude) {
		this._id = _id;
		Name = name;
		Address = address;
		Phone = phone;
		Type = type;
		this.latitude=latitude;
		this.longitude=longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public int get_id() {
		return _id;
	}

	public String getName() {
		return Name;
	}

	public String getAddress() {
		return Address;
	}

	public String getPhone() {
		return Phone;
	}

	public String getType() {
		return Type;
	}
}
