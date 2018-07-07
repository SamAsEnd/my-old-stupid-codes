#include<iostream.h>
#include<conio.h>
void main(){
	a:
	long sum=0;
	unsigned int num,i=1;

	cout<<"This program calculates the sumation between 1 and any number!\n";
	cout<<"1 up to ";
	cin>>num;
	while((num<1)||(num>64000)){
		cout<<"ERROR Number must be between 1 and 65000\nTRY AGAIN:\t";
		cin>>num;
		}
	for(;i<=num;i++)
		sum+=i;
	cout<<sum<<endl;
	cout<<"Press any key to try again\n";
	getch();
	clrscr();
	goto a;
}