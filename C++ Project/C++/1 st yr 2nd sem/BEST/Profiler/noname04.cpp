#include<iostream.h>
#include<conio.h>
int a[100];
int searchz(int &Value2b_searched, int &SizeOfArray);
void Welcome();
void main()
	{
		loop:
		clrscr();
		Welcome();
		int n=0;
		cout<<"\t\tHow many No's you wanna store:\t";
		cin>>n;
		int temp=n;
		do
		{
			clrscr();
			Welcome();
			cout<<"\t\tEnter the number you wanna store:\t\t"<<temp<<" number left"<<endl<"\t\t  ";
			cin>>a[temp];
			temp--;
			}
		while(temp>0);
		clrscr();
		Welcome();
		cout<<"\n\t\tDone Entering\nYou entered ";
		for(int t=0;t<n;t++)
		{
			cout<<a[t]<<" , ";
			}
		cout<<"\b\b";
		cout<<"\nEnter z number u wanna search:\t";
		cin>>temp;
		if (searchz(temp,n)==1)
		{
			cout<<"\n\t\tFound";
			}
		else if (searchz(temp,n)==0)
		{
			cout<<"\n\t\tNOT FOUND!!!";
			}
		else
		{
			cout<<"\n\t\tERROR";
			}
		getch();
		goto loop;
		}
int searchz(int &Value2b_searched, int &SizeOfArray)
	{
		for(int i=0;i<=SizeOfArray;i++)
		{
			if(a[i]==Value2b_searched)
			{
				return 1;
				}
			}
		return 0;
		}
void Welcome(){
	clrscr();
	cout<<" ==============================================================================\n";
	cout<<" ******************************************************************************\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\tWELCOME TO ARRAY  SEARCH EXAMPLE!!\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<" ******************************************************************************\n";
	cout<<" ==============================================================================\n";
	cout<<"\n\t\t\t*******************************\n";
	}
