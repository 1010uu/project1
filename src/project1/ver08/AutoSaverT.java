package project1.ver08;

public class AutoSaverT extends Thread 
{

	@Override
	public void run()
	{
		while(true)
		{
			System.out.println("주소록이 텍스트로 자동저장됐습니다.");
			try
			{
				sleep(5000);
			} 
			catch (InterruptedException e)
			{
				break;
			}
		}
	}

}
