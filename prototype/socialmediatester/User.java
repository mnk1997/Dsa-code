package in.cdac.prototype.socialmediatester;

/*Implement the user object: Implement the 
User class with attributes like userId, username, email, 
displayName, and age. Ensure that the User 
class implements the ObjectClonable interface by providing
a proper clone method that creates a deep copy of the user object.*/
public class User implements ClonableObject<User> {
	
	 private long userId;

	    private String username;
	    private String email;
	    private String displayName;
	    private int age;
	    private UserType type;
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	//this noArgs constructor will help in creating the first template or 
	//if someone wants to create complex object from scratch
	public User()
	{
		
	}
	//this copy constr should only be used via clone method hence private
	  //validation becomes possible before constr is created
	private User(User u)
	{
		this.age=u.age;
		this.displayName=u.displayName;
		this.email=u.email;
		this.userId=u.userId;
		this.username=u.username;
		this.type=u.type;
		
	}
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public User cloneObject() {
		return new User(this);
		
	}
	
	

}
