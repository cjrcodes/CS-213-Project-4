package application;

/**
 * Extra, extra ingredient type to add to sandwich
 * @author Christian Rodriguez,  Yazhini Shanmugam
 *
 */
public class Extra {
	
	private String ingredientName;

	/**
	 * Default constructor for Extra
	 */
	public Extra() {
		this.ingredientName = "";
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Create Extra with ingredient name
	 * @param ingredientName Name of extra ingredient
	 */
	public Extra(String ingredientName) {
		this.ingredientName = ingredientName;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns extra name to string
	 * @return String ingredient name
	 */
	public String toString() {
		return ingredientName;
	}

}
