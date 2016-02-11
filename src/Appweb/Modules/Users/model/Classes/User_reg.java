package Appweb.Modules.Users.model.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Appweb.Classes.Date.ClassDate;

/**
 * 
 * @author Jorge Martinez Frias
 * @version 1.0 start 19_11_2015
 * @version 1.1 start 22_11_2015
 * 
 *
 */

// create a class Admin(its son of User) and writte extends User
@XStreamAlias("User_reg")
public class User_reg extends User implements Serializable {

	@XStreamAlias("activity_u")
	private int activity_u;
	@XStreamAlias("karma")
	private String karma;

	// Constructor type one all Attributes
	public User_reg(String Dni, String Name, String Last_name, String Mobile, ClassDate Date_birth, String Email, String User, String Password,
			String Avatar, String Status, int activity_u) {
		super(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status);

		this.activity_u = activity_u;
		this.setKarma(Cal_karma());
		super.setBenefits(Cal_benefits());

	}

	// Constructor type two nothing
	public User_reg() {
		super();
	}

	// constructor trhee
	// constructor get primary key
	public User_reg(String Dni) {

		super(Dni);

	}

	// constructor four // constructor users request
	public User_reg(int i, String s, int n, float f, ClassDate c) {

		switch (i) {

		case 0:

			super.setDni(s);

			break;
		case 1:

			super.setName(s);

			break;
		case 2:

			super.setLast_name(s);

			break;
		case 3:

			super.setMobile(s);

			break;
		case 4:

			super.setDate_birth(c);

			break;
		case 5:

			super.setAge(n);

			break;
		case 6:

			super.setEmail(s);

			break;
		case 7:

			super.setUser(s);

			break;
		case 8:

			super.setPassword(s);

			break;
		case 9:

			super.setAvatar(s);

			break;
		case 10:

			super.setStatus(s);

			break;

		case 11:

			super.setBenefits(f);

			break;

		case 12:

			this.activity_u = n;

			break;

		case 13:

			this.karma = s;

			break;

		}

	}

	// Getters and setters

	public int getActivity_u() {
		return activity_u;
	}

	public void setActivity_u(int activity_u) {
		this.activity_u = activity_u;
		this.setKarma(Cal_karma());

	}

	public String getKarma() {
		return karma;

	}

	public void setKarma(String karma) {
		this.karma = karma;
		super.setBenefits(Cal_benefits());
	}

	public float Cal_benefits() {

		float ben = 0.0f;

		if (getKarma().equals("High level"))
			ben = 200;
		else if (getKarma().equals("Medium level"))
			ben = 100;
		else
			ben = 0;

		return ben;
	}

	public String Cal_karma() {

		String karma = "";

		if (getActivity_u() > 70)

			karma = "High level";

		else if ((getActivity_u() >= 35) || (getActivity_u() <= 70))

			karma = "Medium level";
		else

			karma = "Low level";

		return karma;
	}

	// String type one
	// to string all attributes mum and son
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("Data User \n" + super.toString() + "\n");
		buffer.append("Data registered user \n" + "Activity" + this.getActivity_u() + "\n");
		buffer.append("Karma level: " + this.getKarma() + "\n");

		return buffer.toString();

	}

	// String type two
	// only show key attribute
	public String toString(String Dni) {

		return super.toString(Dni);
	}

	// String type three
	// Only show users request
	public String toString(int i) {

		String cad = "";

		switch (i) {

		case 0:
			cad = cad + "Dni: " + super.getDni() + "\n";
			break;
		case 1:
			cad = cad + "Name: " + super.getName() + "\n";
			break;
		case 2:
			cad = cad + "Last_name: " + super.getLast_name() + "\n";
			break;
		case 3:
			cad = cad + "Mobile: " + super.getMobile() + "\n";
			break;
		case 4:
			cad = cad + "Date birth: " + super.getDate_birth() + "\n";
			break;
		case 5:
			cad = cad + "Age: " + super.getAge() + "\n";
			break;
		case 6:
			cad = cad + "Email: " + super.getEmail() + "\n";
			break;
		case 7:
			cad = cad + "User: " + super.getUser() + "\n";
			break;
		case 8:
			cad = cad + "Password: " + super.getPassword() + "\n";
			break;
		case 9:
			cad = cad + "Avatar: " + super.getAvatar() + "\n";
			break;
		case 10:
			cad = cad + "Status: " + super.getStatus() + "\n";
			break;
		case 11:
			cad = cad + "Benefits: " + super.getBenefits() + "\n";
			break;
		case 12:
			cad = cad + "Activity user: " + this.getActivity_u() + "\n";
			break;
		case 13:
			cad = cad + "Karma: " + this.getKarma() + "\n";
			break;
			

		}
		return cad;
	}

}
