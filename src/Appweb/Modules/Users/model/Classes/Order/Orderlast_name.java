package Appweb.Modules.Users.model.Classes.Order;

import java.util.Comparator;

import Appweb.Modules.Users.model.Classes.User;

public class Orderlast_name implements Comparator<User> {

	public int compare(User u1, User u2) {
		if (u1.getLast_name().compareTo(u2.getLast_name()) > 0)
			return 1;
		if (u1.getLast_name().compareTo(u2.getLast_name()) < 0)
			return -1;
		return 0;

	}

}
