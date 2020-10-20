package application;

public class User {

	private String first, last, email, password;
	
	public User()
	{}
	public User(String f, String l, String email, String password1)
	{
		first = f;
		last = l;
		this.email = email;
		this.password = password1;	
	}
	
	/*Takes all properties and formats it in a string
	 * 
	 * @return String
	 */
	public String toFile()
	{
		return first + "," + last + "," + email + "," + password;
	}
	/*Gets the users first name
	 * 
	 * @return String
	 */
	public String getFirstName()
	{
		return first;
	}
	/*Gets users Last name
	 * 
	 * @return String
	 */
	public String getLastName()
	{
		return last;
	}
	/*Gets user's email
	 * 
	 * @return String
	 * 
	 */
	public String getEmail()
	{
		return email;
	}
	public String getPassword()
	{
		return password;
	}
}
