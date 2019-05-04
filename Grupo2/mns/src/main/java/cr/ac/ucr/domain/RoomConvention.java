package cr.ac.ucr.domain;

public abstract class RoomConvention
{

	public void process(Message message) 
	{
		
		insertMessage(message);
		
		Thread thread = new Thread() {

			public void run()
			{
				serialize(message);
			}
		};
		thread.start();
		
		updateMetrics(message);
		
		try 
		{
			thread.join();
		} 
		catch (InterruptedException e)
		{
			throw new RuntimeException(e);
		}
	}

	protected abstract void updateMetrics(Message message);

	protected abstract void serialize(Message message);

	protected abstract void insertMessage(Message message);
	
}
