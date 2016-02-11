package Appweb.Modules.Users.model.Classes.Order;

import java.util.Comparator;

import Appweb.Modules.Users.model.Classes.User;

public class Orderdate_birth implements Comparator<User> {

	public int compare(User u1, User u2) {
		if (u1.getAge() > (u2.getAge()))
			return 1;
		if (u1.getAge() < (u2.getAge()))
			return -1;
		return 0;

	}

}
