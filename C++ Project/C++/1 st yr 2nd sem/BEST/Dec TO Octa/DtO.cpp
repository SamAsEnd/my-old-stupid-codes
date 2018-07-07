#include<iostream.h>
#include<conio.h>
#include<stdlib.h>
void Welcome(){
	clrscr();
	cout<<" ==============================================================================\n";
	cout<<" ******************************************************************************\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\tWELCOME TO SAMI Dec 2 Octa CALCULATOR\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<" ******************************************************************************\n";
	cout<<" ==============================================================================\n";
	cout<<"\n\t\t\t*******************************\n";
	}
int main(){
A:
clrscr();
unsigned long i=113481575;
float range=4294967295;
float I;
Welcome();
	cout<<"\n\tThis program can convert Decimal into octa number";
	cout<<"\n\t===================================================";
	cout<<"\n\t       Enter a number (0-4294967295):     ";
	cin>>i;
	if (i==113481575){
	cout<<"\n\t       Bug detected! You Entered a character. Please restart!";
	i=0;
	getch();
	exit(1);
	goto A;
	}
	I=i;
while (!(I<=0)&&(range<=I)){
	cout<<"\t       You entered a number out of range";
	cout<<"\n\t       Try again:        :";
	cin>>i;
	I=i;
}
int r[33];
int c=0;
do{
c++;
r[c]=i%8;
i=i/8;
}
while (!(i==0));
cout<<"\t       The number you entered is \n\n\t\t\t"<<c<<" digit";
cout<<"\n\t                \"";
while(c>0){
cout<<r[c];
c--;
}
cout<<"\"";
cout<<"\n\t===================================================";
cout<<"\n  \t      Do you want to try again?";
cout<<"\n  \t            Press Y for YES (Continue)";
cout<<"\n  \t            Press N for NO  (Exit)";
char ch;
cin>>ch;
if ((ch=='N')||(ch=='n'))
return 0;
else
goto A;
}