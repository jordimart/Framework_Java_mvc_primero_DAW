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
 * @author Jorge Martines Frias
 * @version 1.0 start 19_11_2015
 * 
 * 
 *
 */
@XStreamAlias("User")
public abstract class User implements Comparable<User>, Serializable {

	/**
	 * 
	 */

	@XStreamAlias("dni")
	private String Dni;
	@XStreamAlias("name")
	private String Name;
	@XStreamAlias("last_name")
	private String Last_name;
	@XStreamAlias("Mobile")
	private String Mobile;
	@XStreamAlias("Date_birth")
	private ClassDate Date_birth;
	@XStreamAlias("Age")
	private int Age;
	@XStreamAlias("Email")
	private String Email;
	@XStreamAlias("User")
	private String User;
	@XStreamAlias("Password")
	private String Password;
	@XStreamAlias("Avatar")
	private Icon Avatar;
	@XStreamAlias("Status")
	private String Status;
	@XStreamAlias("Benefits")
	private float Benefits;

	/// CONSTRUCTORS//

	/** constructor one */
	/** constructor de datos, no devuelve nada, recoge todos los datos */
	public User(String Dni, String Name, String Last_name, String Mobile, ClassDate Date_birth, String Email, String User, String Password,
			Icon Avatar, String Status) {

		this.Dni = Dni;
		this.Name = Name;
		this.Last_name = Last_name;
		this.Mobile = Mobile;
		this.Date_birth = Date_birth;
		this.setAge(Date_birth.Diference_system_date());
		this.Email = Email;
		this.User = User;
		this.Password = Password;
		this.Avatar = Avatar;
		this.Status = Status;

	}// end of constructor

	// constructor two
	// constructor por defecto, no recoge nada
	public User() {

	}

	// constructor 3
	// constructor recoge un clave
	public User(String Dni) {

		this.Dni = Dni;

	}

	// constructor 4
	// constructor para un atributo pero el que le pidamos
	public User(int i, String s, int Age, float f, ClassDate c,Icon icono) {

		switch (i) {

		case 0:
			this.Dni = s;
			break;
		case 1:
			this.Name = s;
			break;
		case 2:
			this.Last_name = s;
			break;
		case 3:
			this.Mobile = s;
			break;
		case 4:
			this.Date_birth = c;
			break;
		case 5:
			this.Age = Age;
			break;
		case 6:
			this.Email = s;
			break;
		case 7:
			this.User = s;
			break;
		case 8:
			this.Password = s;
			break;
		case 9:
			this.Avatar = icono;
			break;
		case 10:
			this.Status = s;
			break;

		}

	}

	// Getters y Setters
	public String getDni() {
		return Dni;
	}

	public void setDni(String Dni) {
		this.Dni = Dni;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String Last_name) {
		this.Last_name = Last_name;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String Mobile) {
		this.Mobile = Mobile;
	}

	public ClassDate getDate_birth() {
		return Date_birth;
	}

	public void setDate_birth(ClassDate date_birth2) {
		this.Date_birth = date_birth2;
		this.setAge(Date_birth.Diference_system_date());
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int Age) {
		this.Age = Age;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String User) {
		this.User = User;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public Icon getAvatar() {
		return Avatar;
	}

	public void setAvatar(Icon Avatar) {
		this.Avatar = Avatar;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status2) {
		this.Status = status2;
	}

	public float getBenefits() {
		return Benefits;
	}

	public void setBenefits(float Benefits) {
		this.Benefits = Benefits;
	}

	/**
	 * Metodo que compara el dni de dos usuarios y los ordena.
	 */
	public int compareTo(User u) {
		if (this.getDni().compareTo(u.getDni()) > 0)
			return 1;
		if (this.getDni().compareTo(u.getDni()) < 0)
			return -1;
		return 0;
	}

	/**
	 * Metodo que retorna un boolean si dos objetos son iguales.
	 */
	public boolean equals(User o) {

		boolean b = false;

		b = getDni().equals(o.getDni());

		return b;
	}

	// To Strings
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("Dni: " + this.getDni() + "\n");
		buffer.append(Lang.getInstance().getProperty("Name") + ": " + this.getName() + "\n");
		buffer.append(Lang.getInstance().getProperty("Last_name") + ": " + this.getLast_name() + "\n");
		buffer.append(Lang.getInstance().getProperty("Mobile") + ": " + this.getMobile() + "\n");
		buffer.append(Lang.getInstance().getProperty("Date_birth") + ": " + this.getDate_birth().todate() + "\n");
		buffer.append(Lang.getInstance().getProperty("Age") + ": " + this.getAge() +  Lang.getInstance().getProperty("years")+ "\n");
		buffer.append("Email: " + this.getEmail() + "\n");
		buffer.append(Lang.getInstance().getProperty("User") + ": " + this.getUser() + "\n");
		buffer.append(Lang.getInstance().getProperty("Password") + ": " + this.getPassword() + "\n");
		buffer.append("Avatar: " + this.getAvatar().toString() + "\n");
		buffer.append("Status: " + this.getStatus() + "\n");
		buffer.append(this.toBenefits() + "\n");

		return buffer.toString();
	}

	public String toBenefits() {

		String money = "";

		switch (Classconfig.getInstance().getCurrency()) {

		case "euro":

			if (Classconfig.getInstance().getnum_dec().equals("0.0") ) {

				money = money + Lang.getInstance().getProperty("Benefits") + ": " + Format_tools.F_1dec(getBenefits()) + " E \n";

			}

			if (Classconfig.getInstance().getnum_dec().equals("0.00")) {

				money = money + Lang.getInstance().getProperty("Benefits") + ": " + Format_tools.F_Euro(getBenefits()) + " \n";

			}

			if (Classconfig.getInstance().getnum_dec().equals("0.000")) {

				money = money + Lang.getInstance().getProperty("Benefits") + ": " + Format_tools.F_3dec(getBenefits()) + " E \n";

			}

			break;

		case "dolar":

			float cald = 0.000f;

			cald = (float) (1.09922 * (getBenefits()));

			if (Classconfig.getInstance().getnum_dec().equals("0.0")) {

				money = money + Lang.getInstance().getProperty("Benefits") + ": $" + Format_tools.F_1dec(cald) + "  \n";
			}

			if (Classconfig.getInstance().getnum_dec().equals("0.00")) {

				money = money + Lang.getInstance().getProperty("Benefits") + ": " + Format_tools.F_Dollar(cald) + " \n";

			}

			if (Classconfig.getInstance().getnum_dec().equals("0.000")) {

				money = money + Lang.getInstance().getProperty("Benefits") + ": $" + Format_tools.F_3dec(cald) + "  \n";

			}

			break;

		case "pound":

			float calp = 0.000f;

			calp = (float) 0.728500 * (getBenefits());

			if (Classconfig.getInstance().getnum_dec().equals("0.0")) {

				money = money + Lang.getInstance().getProperty("Benefits") + ": pound " + Format_tools.F_1dec(calp) + "   \n";
			}

			if (Classconfig.getInstance().getnum_dec().equals("0.00")) {

				money = money + Lang.getInstance().getProperty("Benefits") + ": " + Format_tools.F_Libra(calp) + " \n";

			}

			if (Classconfig.getInstance().getnum_dec().equals("0.000")) {

				money = money + Lang.getInstance().getProperty("Benefits") + ": pound " + Format_tools.F_3dec(calp) + "   \n";
			}

			break;

		}

		return money;
	}

	// imprime solo el elemento clave
	public String toString(String Dni) {

		String cad = "";

		cad = "Dni: " + this.getDni();

		return cad;
	}

	// debe imprimir la peticon del cliente
	public String toString(int i) {
		
		String cad = "";

		switch (i) {

		case 0:
			cad = "Dni: ";
			cad = cad + "Dni: " + this.getDni() + "\n";
			break;
		case 1:
			cad = cad + "Name: " + this.getName() + "\n";
			break;
		case 2:
			cad = cad + "Last name: " + this.getLast_name() + "\n";
			break;
		case 3:
			cad = cad + "Mobile: " + this.getMobile() + "\n";
			break;
		case 4:
			cad = cad + "Date birth: " + this.getDate_birth().getDate() + "\n";
			break;
		case 5:
			cad = cad + "Age: " + this.getAge() + "\n";
			break;
		case 6:
			cad = cad + "Email: " + this.getEmail() + "\n";
			break;
		case 7:
			cad = cad + "User: " + this.getUser() + "\n";
			break;
		case 8:
			cad = cad + "Pasword: " + this.getPassword() + "\n";
			break;
		case 9:
			cad = cad + "Avatar: " + this.getAvatar() + "\n";
			break;
		case 10:
			cad = cad + "Status: " + this.getStatus() + "\n";
			break;
		case 11:
			cad = cad + this.toBenefits() + "\n";
			break;
		}
		return cad;

	}

	// metodo abstracto que calcula benefits
	public abstract float Cal_benefits();

}
