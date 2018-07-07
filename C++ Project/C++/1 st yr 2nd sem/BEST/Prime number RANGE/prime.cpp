#include<iostream.h>
#include<conio.h>
void Welcome(){
	clrscr();
	cout<<" ==============================================================================\n";
	cout<<" ******************************************************************************\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\tWELCOME TO Prime Range  CALCULATOR\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<" ******************************************************************************\n";
	cout<<" ==============================================================================\n";
	cout<<"\n\t\t\t*******************************\n";
	}
void main(){
	loop:
	clrscr;
	Welcome();
	int x=0,s,f;
	cout<<"This program shows the prime number given in the range of any given number\n";
	cout<<"Enter the starting number\n";
	cin>>s;
	cout<<s<<"  Up to   ";
	cin>>f;
	s++;
	for (int j=s;j<f;j++){
		for(int i=2;i<j;i++){
			if (j%i==0)
				x=1;
		}
		if(x==0)
			cout<<j<<"   ";
		else
			x=0;
	}
	cout<<"\nPress any key to try again\n";
	getch();
	clrscr();
	goto loop;
}
