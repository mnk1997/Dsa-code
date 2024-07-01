package in.cdac.prototype.socialmediatester;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*lass that adheres to the UserPrototypeRegistry interface. 
In this class, manage a collection of user
prototypes and provide methods to add prototypes, 
retrieve prototypes by type, and clone user objects based on their type.*/
public class UserRegistryImpl implements UserPrototypeRegistry {
	
	private ConcurrentHashMap<UserType, User> registry;
	
	public UserRegistryImpl()
	{
		registry=new ConcurrentHashMap<>();
		
	}



	

	@Override
	public User clone(UserType key) {
	      
		return registry.get(key).cloneObject();
	}

	@Override
	public void addPrototype(User user) {
		registry.put(user.getType(), user);
		
	}

	@Override
	public User getPrototype(UserType type) {
		return registry.get(type);
	}

}
