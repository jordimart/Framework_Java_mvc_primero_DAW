package Appweb.Modules.Users.model.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Appweb.Modules.Config.Classconfig;
import Appweb.Classes.Date.ClassDate;
import Appweb.Classes.Language.Lang;
import Appweb.Tools.Format_tools;
import javax.swing.Icon;

/**
 * 
 * @author Jorge Martinez Frias
 * @version 1.0 start 19_11_2015
 * 
 *
 */

// create a class Admin(its son of User) and writte extends User
@XStreamAlias("Admin")
public class Admin extends User implements Serializable {
	@XStreamAlias("date_cont")
	private ClassDate date_cont;
	@XStreamAlias("antique")
	private int antique;
	@XStreamAlias("salary")
	private float salary;
	@XStreamAlias("activity")
	private int activity;

	// Constructor type one all Attributes
	public Admin(String Dni, String Name, String Last_name, String Mobile, ClassDate Date_birth, String Email, String User, String Password,
			Icon Avatar, String Status, ClassDate date_cont, float salary, int activity) {

		super(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status);
		this.date_cont = date_cont;
		this.setAntique(date_cont.Diference_system_date());
		this.salary = salary;
		this.activity = activity;
		super.setBenefits(Cal_benefits());
	}

	// Constructor type two nothing
	public Admin() {
		super();
	}

	// constructor trhee
	// constructor get primary key
	public Admin(String Dni) {

		super(Dni);

	}

	// constructor four // constructor users request
	public Admin(int i, String s, int n, float f, ClassDate c,Icon icono) {

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

			super.setAvatar(icono);

			break;
		case 10:

			super.setStatus(s);

			break;

		case 11:

			super.setBenefits(f);

			break;

		case 12:

			this.date_cont = c;

			break;

		case 13:

			this.antique = n;

			break;

		case 14:

			this.salary = f;

			break;

		case 15:

			this.activity = n;

			break;

		}

	}

	// Getters and setters

	public ClassDate getDate_cont() {
		return date_cont;
	}

	public void setDate_cont(ClassDate date_cont2) {
		this.date_cont = date_cont2;
		this.setAntique(date_cont.Diference_system_date());
	}

	public int getAntique() {
		return antique;
	}

	public void setAntique(int antique) {
		this.antique = antique;
		super.setBenefits(Cal_benefits());
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getActivity() {
		return activity;
	}

	public void setActivity(int activity) {
		this.activity = activity;
		super.setBenefits(Cal_benefits());
	}

	// metodo que calcula beneficios de admin dandole 0.5 centimos por actividad
	// y 10 euros por a�o de antiguedad..
	public float Cal_benefits() {

		float ben = 0.000f;
		ben = (float) (0.33333 * getActivity()) + (10 * getAntique());

		return ben;
	}

	// String type one
	// to string all attributes mum and son
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append( Lang.getInstance().getProperty("Data_User")+" \n" + super.toString() + "\n");
		buffer.append(Lang.getInstance().getProperty("Data_Admin")+" \n" + Lang.getInstance().getProperty("Recruitment_date") + ": " + this.getDate_cont().todate() + "\n");
		buffer.append(Lang.getInstance().getProperty("Antique") + ": " + this.getAntique() + "\n");
		buffer.append(this.toSalary());
		buffer.append(Lang.getInstance().getProperty("Activity") + ": " + this.getActivity() + "\n");

		return buffer.toString();

	}

	public String toSalary() {

		String money = "";

		switch (Classconfig.getInstance().getCurrency()) {

		case "euro":

			if (Classconfig.getInstance().getnum_dec().equals("0.0")) {

				money = money + Lang.getInstance().getProperty("Salary") + ": " + Format_tools.F_1dec(getSalary()) + " � \n";

			}

			if (Classconfig.getInstance().getnum_dec().equals("0.00")) {

				money = money + Lang.getInstance().getProperty("Salary") + ": " + Format_tools.F_Euro(getSalary()) + " \n";

			}

			if (Classconfig.getInstance().getnum_dec().equals("0.000")) {

				money = money + Lang.getInstance().getProperty("Salary") + ": " + Format_tools.F_3dec(getSalary()) + " � \n";

			}

			break;

		case "dolar":

			float cald = 0.000f;

			cald = (float) (1.09922 * (getBenefits()));

			if (Classconfig.getInstance().getnum_dec().equals("0.0")) {

				money = money + Lang.getInstance().getProperty("Salary") + ": $" + Format_tools.F_1dec(cald) + "  \n";
			}

			if (Classconfig.getInstance().getnum_dec().equals("0.00")) {

				money = money + Lang.getInstance().getProperty("Salary") + ": " + Format_tools.F_Dollar(cald) + " \n";

			}

			if (Classconfig.getInstance().getnum_dec().equals("0.000")) {

				money = money + Lang.getInstance().getProperty("Salary") + ": $" + Format_tools.F_3dec(cald) + "  \n";

			}

			break;

		case "pound":

			float calp = 0.000f;

			calp = (float) 0.728500 * (getBenefits());

			if (Classconfig.getInstance().getnum_dec().equals("0.0")) {

				money = money + Lang.getInstance().getProperty("Salary") + ": �" + Format_tools.F_1dec(calp) + "   \n";
			}

			if (Classconfig.getInstance().getnum_dec().equals("0.00")) {

				money = money + Lang.getInstance().getProperty("Salary") + ": " + Format_tools.F_Libra(calp) + " \n";

			}

			if (Classconfig.getInstance().getnum_dec().equals("0.000")) {

				money = money + Lang.getInstance().getProperty("Salary") + ": �" + Format_tools.F_3dec(calp) + "   \n";
			}

			break;

		}

		return money;
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
			cad = cad + super.getName() + "\n";
			break;
		case 2:
			cad = cad + super.getLast_name() + "\n";
			break;
		case 3:
			cad = cad + super.getMobile() + "\n";
			break;
		case 4:
			cad = cad + super.getDate_birth().getDate() + "\n";
			break;
		case 5:
			cad = cad + super.getAge() + "\n";
			break;
		case 6:
			cad = cad + super.getEmail() + "\n";
			break;
		case 7:
			cad = cad + super.getUser() + "\n";
			break;
		case 8:
			cad = cad + super.getPassword() + "\n";
			break;
		case 9:
			cad = cad + super.getAvatar() + "\n";
			break;
		case 10:
			cad = cad + super.getStatus() + "\n";
			break;
		case 11:
			cad = cad + super.getBenefits() + "\n";
			break;

		case 12:
			cad = cad + this.getDate_cont().getDate() + "\n";
			break;
		case 13:
			cad = cad + this.getAntique() + "\n";
			break;
		case 14:
			cad = cad + Format_tools.F_Euro(getSalary()) + "\n";
			break;

		case 15:
			cad = cad + this.getActivity() + "\n";
			break;

		}
		return cad;

	}

}
