#include<iostream.h>
#include<conio.h>
#include<stdlib.h>
void Welcome(){
	clrscr();
	cout<<" ==============================================================================\n";
	cout<<" ******************************************************************************\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\tWELCOME TO SAMI HEXA 2 Dec CALCULATOR\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<" ******************************************************************************\n";
	cout<<" ==============================================================================\n";
	cout<<"\n\t\t\t*******************************\n";
	}
int PoW(int a){
	int pow=1;
	if (a==0)
		return 1;
	if (a==1)
		return 16;
	do{
		pow=pow*16;
		a--;
		}
	while(a>0);
	return pow;
	}
void main(){
	A:
	char ipt[]={0,0,0,0,0,0,0,0};
	short opt[7];
	int li=0;
	char ch;
	int test=0;
	int stp=0,num=0;
	Welcome();
	cout<<"\n\tThis program can convert Hexa into decimal number";
	cout<<"\n\t===================================================";
	cout<<"\n\t       Enter a number (0-8 digit):     ";
	cin.getline(ipt,8);
	do{
	switch (ipt[li])
	{
	case '0':opt[li]=0;break;
	case '1':opt[li]=1;break;
	case '2':opt[li]=2;break;
	case '3':opt[li]=3;break;
	case '4':opt[li]=4;break;
	case '5':opt[li]=5;break;
	case '6':opt[li]=6;break;
	case '7':opt[li]=7;break;
	case '8':opt[li]=8;break;
	case '9':opt[li]=9;break;
	case 'A':case 'a':opt[li]=10;break;
	case 'B':case 'b':opt[li]=11;break;
	case 'C':case 'c':opt[li]=12;break;
	case 'D':case 'd':opt[li]=13;break;
	case 'E':case 'e':opt[li]=14;break;
	case 'F':case 'f':opt[li]=15;break;
	case '\0':stp=1;
	default:test++;
	}
	li++;
	}
	while (stp!=1);
		li-=2;
		int ccc;
		test--;
		if (test!=0){
		cout<<"\n\t "<<test<<"  Error! The Number you entered is not Hexa\t";
		getch();
		goto A;
		}
	do{
		num=num+(PoW(li)*opt[li]);
		li--;
		}
	while (li>=0);
	if (num<0)
	cout<<"\n\t       Unknown Error!"; 
	else{
	cout<<"\n\t       The number is     \"";
	cout<<num;
	}
	cout<<"\"\n\t===================================================";
	exit(1);
	}
        
