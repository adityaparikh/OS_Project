import java.util.Scanner;
public class Bankers
{
	public int Check(int MaximumRequest[][],int AllocatedResource[][],int AvailableResource[]) throws InterruptedException
	{
		int row=MaximumRequest.length;
		int col=MaximumRequest[0].length;
		int flag=1;
		int safe=0;
		int [][]RequiredResource=new int[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				RequiredResource[i][j]=MaximumRequest[i][j]-AllocatedResource[i][j];
			}
		}
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(AvailableResource[j]<RequiredResource[i][j])
				{
					flag=0;
					break;
				}
			}
			if(flag==1)
			{
				System.out.println("Process" + (i+1) + "is running");
				safe=1;
				for(int j=0;j<col;j++)
				{
					AvailableResource[j]=AvailableResource[j]+MaximumRequest[i][j];
				}
				for(int j=0;j<col;j++)
				{
					System.out.println(AvailableResource[j]);
				}
				
			}
			else
			{
				return 1;
			}
		}
		return 0;
	}
	
	public static void main(String args[]) throws InterruptedException
	{
		Bankers obj=new Bankers();
		Scanner user=new Scanner(System.in);
		System.out.println("Enter size of Available resource:");
		int AvalSize;
		AvalSize=user.nextInt();
		System.out.println(AvalSize);
		System.out.println("Enter Available resource:");
		int []AvailableResource=new int[AvalSize];
		for(int i=0;i<AvalSize;i++)
		{
			AvailableResource[i]=user.nextInt();
		}
		
		System.out.println("Enter size of Maximum resource allocated:");
		int MaxSize;
		MaxSize=user.nextInt();
		System.out.println("Enter Maximum resource allocated:");
		int [][]MaximumResource=new int[MaxSize][MaxSize];
		for(int i=0;i<MaxSize;i++)
		{
			for(int j=0;j<MaxSize;j++)
			{
				MaximumResource[i][j]=user.nextInt();
			}
		}
		
		System.out.println("Enter size of Current Allocated resource:");
		int CurrSize;
		CurrSize=user.nextInt();
		System.out.println("Enter Current Allocated resource:");
		int [][]CurrentResource=new int[CurrSize][CurrSize];
		for(int i=0;i<CurrSize;i++)
		{
			for(int j=0;j<CurrSize;j++)
			{
				CurrentResource[i][j]=user.nextInt();
			}
		}
		
	int deadlockCheck= obj.Check(MaximumResource,CurrentResource,AvailableResource);
	if(deadlockCheck==1)
	{
		System.out.println("Deadlock Detected");
	}
	else
	System.out.println("Safe state");
	}
}
