package in.cdac.design.prototype.configuration;

import java.util.concurrent.ConcurrentHashMap;

public class ImplConfigurationPrototypeRegistry implements ConfigurationPrototypeRegistry {
     ConcurrentHashMap<ConfigurationType, Configuration> mapOnType=new ConcurrentHashMap<>();
     
	@Override
	public void addPrototype(Configuration user) {
		   mapOnType.put(user.getType(), user);
		Math.pi
	}

	@Override
	public Configuration getPrototype(ConfigurationType type) {
		if(mapOnType.containsKey(type))
			return mapOnType.get(type);
		return null;
	}

	@Override
	public Configuration clone(ConfigurationType type) {
		if(mapOnType.containsKey(type))
			return mapOnType.get(type).cloneObject();
		else
		 return null;
	}

}
