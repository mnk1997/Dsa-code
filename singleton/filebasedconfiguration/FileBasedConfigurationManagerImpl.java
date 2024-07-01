package in.cdac.singleton.filebasedconfiguration;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {
	private static FileBasedConfigurationManager fileConfig;
	
	private FileBasedConfigurationManagerImpl()
	{
		super();
		fileConfig=new FileBasedConfigurationManagerImpl();
		
	}
	
	
	
	@Override
	public String getConfiguration(String key) {
		// TODO Auto-generated method stub
		  String value=  properties.getProperty(key);
		  if(value==null)
			  return null;
		  return value;
		  
	}

	@Override
	public <T> T getConfiguration(String key, Class<T> type) {
		   
		   String value= properties.getProperty(key);
		   if(value==null)
			   return null;
		   return convert(value,type);
			
	}

	@Override
	public void setConfiguration(String key, String value) {
		// TODO Auto-generated method stub
		  synchronized(properties)
		  {
			  properties.put(key, value);
		  }
		  
	}

	@Override
	public <T> void setConfiguration(String key, T value) {
		
		synchronized(properties)
		{
			properties.put(key, value);
		}
		   
	}

	@Override
	public void removeConfiguration(String key) {
		
		synchronized(properties)
		{
			if(properties.containsKey(key))
				properties.remove(key);
			
		}
		
	}

	@Override
	public void clear() {
		synchronized(properties)
		{
			 properties.clear();
		}
		
	}

	public synchronized  static  FileBasedConfigurationManager getInstance() {
		
		   if(fileConfig==null)
		   {
			   fileConfig=new FileBasedConfigurationManagerImpl();
		   }
		   
			   return fileConfig;
			   
		   
		
	}

	public static synchronized void resetInstance() {
		
		
		fileConfig=null;

	}
}
