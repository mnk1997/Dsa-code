package in.cdac.prototype.socialmediatester;

/*Create an interface named UserPrototypeRegistry 
that includes methods for adding
prototypes, retrieving prototypes by type, and cloning user objects.*/
public interface UserPrototypeRegistry {

    void addPrototype(User user);

    User getPrototype(UserType type);

    User clone(UserType type);
}
