/***********************************************
***    Hiwot Girma                             +
***        ID number 0400868                   +
+++++++++++++++++++++++++++++++++++++++++++++++*/
#include<iostream.h>
#include<conio.h>
int main();
void cost(){
	 int choose,year,cost;clrscr();
	 cout<<"Please press 1 to see IOT students fee\n";
	 cout<<"Press 2 to see IOTex students fee\nPress 3 to see Peda students fee\n";
	 cout<<"Press 4 to see Agricalture students fee\n";cin>>choose;
	 cout<<"How many years you stay at the campus\n";cin>>year;
	 while (year<0)
	 {cout<<"Year must be greater than 0\nEnter again:  ";cin>>year;}
	 switch (choose){
		case 1:
		  cost=year*1000;break;
		case 2:
		  cost=year*980;break;
		case 3:
		  cost=year*950;break;
		case 4:
		  cost=year*1200;break;
		default:
		  cout<<"\nYou choice entered is INCORRECT!";
		  getch();
		  clrscr();cost=0;
		}
		cout<<"Your total cost sharing fee is "<<cost<<endl;
}
int main(){
		char ch;
		cout<<"Welcome\n";
		do{
		cost();
		cout<<"\nDO you want to see other student's fee?\n";
		cout<<"Press Y to continue\nPress N to Exit\n";
		cin>>ch;}
		while ((ch=='Y') || (ch=='y'));return 0;
}