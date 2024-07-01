package in.cdac.singleton.connectionPool;

public interface ConnectionPool {
	
    
	
	  void initializePool();

	    DataBaseConnection getConnection();

	    void releaseConnection(DataBaseConnection connection);

	    int getAvailableConnectionsCount();

	    int getTotalConnectionsCount();

}
