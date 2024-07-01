package in.cdac.builderdesign.database;

public class DatabaseConfiguration {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

   private DatabaseConfiguration(DatabaseConfigurationBuilder builder)
   {
    
   }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public boolean isEnableCache() {
        return enableCache;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }
     public static DatabaseConfigurationBuilder getBuilder()
     {
        return new DatabaseConfigurationBuilder();
     }
     //inner class with builder
    public static class DatabaseConfigurationBuilder {

    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;

    private DatabaseConfigurationBuilder()
    {

    }

    public DatabaseConfigurationBuilder setDatabaseUrl(String url)
    {
          this.databaseUrl=url;
          return this;
    }
       public DatabaseConfigurationBuilder setUsername(String username)
    {
        this.username=username;
         return this;
    }
       public DatabaseConfigurationBuilder setPassword(String password)
    {
        this.password=password;
         return this;
    }
       public DatabaseConfigurationBuilder setMaxConnections(int maxCon)
    {
        this.maxConnections=maxCon;
         return this;
    }
       public DatabaseConfigurationBuilder setEnabledCache(boolean val)
    {
        this.enableCache=val;
         return this;
    }
       public DatabaseConfigurationBuilder setIsReadOnly(boolean val)
    {
        this.isReadOnly=val;
         return this;
    }
    public DatabaseConfiguration build()
    {
        return new DatabaseConfiguration(this);
    }

}
}
