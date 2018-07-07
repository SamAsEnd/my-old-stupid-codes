#include<iostream.h>
#include<conio.h>
#include<stdlib.h>
void Welcome(){
	clrscr();
	cout<<" ==============================================================================\n";
	cout<<" ******************************************************************************\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\tWELCOME TO Digit counter   \t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<" ******************************************************************************\n";
	cout<<" ==============================================================================\n";
	cout<<"\n\t\t\t*******************************\n";
	}
void main()
{
	loop:
	clrscr;
	Welcome();
	int i,num,c=1,sum=0;
	cout<<"\tEnter the number?: ";
	cin>>num;
	i=num;
	while (i>9)
	{
		sum=sum+(i%10);
		i/=10;
		c++;
	}
	cout<<"\n\n\tNumber of Digits are: "<<c;
	cout<<"\n\tSum of Digits is: "<<(sum+i);
	cout<<"\"\n\t===================================================";
	cout<<"\n  \t      Do you want to try again?";
	cout<<"\n  \t            Press Y for YES (Continue)";
	cout<<"\n  \t            Press N for NO  (Exit)";
	char ch;
	cin>>ch;
	if ((ch=='N')||(ch=='n'))
	exit(1);
	else
	goto loop;
}
