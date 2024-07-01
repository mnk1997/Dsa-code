package in.cdac.singleton.connectionPool;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPoolImpl implements ConnectionPool {
	  private  ConcurrentLinkedQueue<DataBaseConnection> connectionPool;
		private int maxConnections;
		private Semaphore semaphoreCon;
		private static Lock lock;
		private static volatile ConnectionPool con;
		
       
	   private ConnectionPoolImpl(int max) {
			this.maxConnections = max;
			semaphoreCon = new Semaphore(max);
			lock = new ReentrantLock();
			initializePool();
			
		}

	    
		public static ConnectionPool getInstance(int max) {
	        //in this what if reset is called just after the con is null check 
	        
			if (con == null) {
	            synchronized (ConnectionPoolImpl.class){

	                       if(con==null)
	                       {
	                                
	                    con = new ConnectionPoolImpl(max);
	                    
	                       }
	           
	            }
	            
	            
	        }
			
			PrintWriter pw;
			try {
				pw = new PrintWriter("");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.flush();
		
			pw.write(LocalDateTime.now()+" ");
	        return con;
		}
	  public static void resetInstance()
		    {
			  
	          synchronized(ConnectionPoolImpl.class)
	          {
	        	  con=null;
	          }
	            

	    
		    }
	    @Override
	    public void initializePool() {

	     lock.lock();
				
			
			if (connectionPool == null) {
	            //connectionPool=new ConcurrentLi(maxConnections);
				connectionPool = new ConcurrentLinkedQueue<DataBaseConnection>();
				for (int i = 0; i < maxConnections; i++) {
					connectionPool.offer(new DataBaseConnection());
				}
			} 
			lock.unlock();
	    
			
	    }

	    @Override
	    public DataBaseConnection getConnection() {
	         
					DataBaseConnection con = null;
					try {
						lock.lock();
						semaphoreCon.acquire();
						System.out.println("semaphore value  "+semaphoreCon.availablePermits()+" queue available "+connectionPool.size());
						con= connectionPool.poll();
						lock.unlock();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						semaphoreCon.release();
					}
					return con;
					
					
				

			
	    }

	    @Override
	    public void releaseConnection(DataBaseConnection connection) {
	        if(connection==null)
				return;
	       
				connectionPool.offer(connection);
				semaphoreCon.release();
			

	    }

	    @Override
	    public int getAvailableConnectionsCount() {
	    	
	        if(connectionPool!=null)
	            return connectionPool.size();

	        return 0;
	    }

	    @Override
	    public int getTotalConnectionsCount() {
	        return maxConnections;
	    }

}
