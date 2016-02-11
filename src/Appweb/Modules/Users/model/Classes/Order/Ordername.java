package Appweb.Modules.Users.model.Classes.Order;

import java.util.Comparator;

import Appweb.Modules.Users.model.Classes.User;

public class Ordername implements Comparator<User> {

	public int compare(User u1, User u2) {
		if (u1.getName().compareTo(u2.getName()) > 0)
			return 1;
		if (u1.getName().compareTo(u2.getName()) < 0)
			return -1;
		return 0;

	}
}
