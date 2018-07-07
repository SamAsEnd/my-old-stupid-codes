#include <stdlib.h>
#include <iostream>
#include <conio.h>
#include <string>
using namespace std;
void Welcome(){
	cout<<" ==============================================================================\n";
	cout<<" ******************************************************************************\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\tWELCOME TO SAMI Bi 2 Dec CALCULATOR\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|\n";
	cout<<" ******************************************************************************\n";
	cout<<" ==============================================================================\n";
	cout<<"\n\t\t\t*******************************\n";
	}
int PoW(int a){
	int pow=1;
	if (a==0)
		return 1;
	if (a==1)
		return 2;
	do{
		pow=pow*2;
		a--;
		}
	while(a>0);
	return pow;
	}
int main()
{
	long i=113481575;
	int c=0;
	int r[18];
	int num=0;
	float range=111111111;
	float I;
	Welcome();
	cout<<"\n\tThis program can convert Binary into decimal number";
	cout<<"\n\t===================================================";
	cout<<"\n\t       Enter a number (0-8 bit):     ";
	cin>>i;
	if (i==113481575){
	cout<<"\n\t       Bug detected! You Entered a character. Please restart!";
	i=0;
	getch();
	exit(1);
	}
	I=i;
while (!(I<=0)&&(range<=I)){
	cout<<"\t       You entered a number out of range";
	cout<<"\n\t       Try again:        :";
	cin>>i;
	I=i;
}
	do{
		r[c]=i%10;
		i=i/10;
		c++;
		}
	while(!(i==0));
		c--;
		int T=c;
		int Test=0;
	while(T>=0){
		if ((1<r[T])&&(r[T]>0))
		Test++;
		T--;
		}
		//Test--;
		if (Test==0)
		Test=0;
		else{
		cout<<"\n\t "<<Test<<"  Error! The Number you entered is not binary\t";
		getch();
		}
	do{
		num=num+(PoW(c)*r[c]);
		c--;
		}
	while(c>=0);
	cout<<"\n\t       The number is     \"";
	cout<<num;
	cout<<"\"\n\t===================================================\n";
	system("pause");
	return 0;
}
