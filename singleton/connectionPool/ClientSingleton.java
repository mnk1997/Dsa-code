package in.cdac.singleton.connectionPool;

public class ClientSingleton {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ConnectionPool connection=ConnectionPoolImpl.getInstance(5);
		connection.initializePool();
		System.out.println("Total "+connection.getTotalConnectionsCount());
		
		Thread t1=new Thread(()->{
			
		DataBaseConnection db1= connection.getConnection();
		DataBaseConnection db2=connection.getConnection();
		System.out.println("available count after 2 connection withdrawn"+connection.getAvailableConnectionsCount());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 connection.releaseConnection(db2);
		 System.out.println("available count form t1 "+connection.getAvailableConnectionsCount());
		 
		 connection.releaseConnection(db1);
		 System.out.println("available count form t1 "+connection.getAvailableConnectionsCount());
		 
		});
		t1.start();
//System.out.println("conneciton available from main thread "+connection.getAvailableConnectionsCount());
		Thread t2=new Thread(()->{
			DataBaseConnection[] db=new DataBaseConnection[5];
			for(int i=0;i<5;i++)
				
			{
				db[i]=connection.getConnection();
			}
			System.out.println("after acquiring and befor sleeping  thread availabe "+connection.getAvailableConnectionsCount());
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<5;i++)
			{
				System.out.println("conneciton released by therad 2");
				connection.releaseConnection(db[i]);
			}
			
		});
		//t2.start();
		System.out.println("conneciton available from main thread after t2 "+connection.getAvailableConnectionsCount());
		Thread t3=new Thread(()->{
			//DataBaseConnection db3=connection.getConnection();
			//System.out.println("now got conenction inside thread 3");
			DataBaseConnection[] db=new DataBaseConnection[10];
		     for(int i=0;i<10;i++)
		     {
		    	 db[i]=connection.getConnection();
                    System.out.println("gained the connection "+i);
		     }
		    
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("releasing al the conneciton");
			for(int i=0;i<10;i++)
			{
				connection.releaseConnection(db[i]);
			}
			
		});
		//t3.start();

		Thread t4=new Thread(()->{
			ConnectionPoolImpl.resetInstance();
			System.out.println("connection availabe from thread4"+connection.getAvailableConnectionsCount());
			System.out.println("toal connection from  thread 4"+connection.getTotalConnectionsCount());
		});
	//	t4.start();
 
		
		
		t1.join();
		//t2.join();
		//t3.join();
		
		
	}

}
