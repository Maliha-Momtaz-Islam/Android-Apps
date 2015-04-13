package manik.apps.blooddonor;


public class Donor {
		public int Id;
	 	public String MobileNumber;
	 	public String DonorName="";
	 	public String BloodGroup="";
	 	public String BirthDate="";
	 	public String LastDonate="";
	 	public String Identity="";
	 	public String Address="";
	 
	    public Donor(){}
	 
	    public Donor(String mobileNumber,String name, String bloodgroup,String birthdate,String lastdonate,String identity,String address) {
	        super();
	        this.MobileNumber = mobileNumber;
	        this.DonorName = name;
	        this.BloodGroup = bloodgroup;
	        this.BirthDate = birthdate;
	        this.LastDonate = lastdonate;
	        this.Identity = identity;
	        this.Address = address;
	    }
	 
	    //getters & setters
	 
	    @Override
	    public String toString() {
	        return "Donor: " + DonorName + "-" + MobileNumber;
	    }
}
