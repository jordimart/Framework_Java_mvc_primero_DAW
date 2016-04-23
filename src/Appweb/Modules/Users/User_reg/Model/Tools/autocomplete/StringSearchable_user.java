package Appweb.Modules.Users.User_reg.Model.Tools.autocomplete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StringSearchable_user implements Searchable_user<String,String>{
	private List<String> terms = new ArrayList<String>();

	/**
	 * Constructs a new object based upon the parameter terms. 
	 * @param terms The inventory of terms to search.
	 */

	public StringSearchable_user(List<String> terms){
            this.terms.addAll(terms);
	}

	public Collection<String> search(String value) {
            List<String> founds = new ArrayList<String>();
            for ( String s : terms ){
		if ( s.indexOf(value) == 0 )
                    founds.add(s);
            }
            return founds;
	}
}
