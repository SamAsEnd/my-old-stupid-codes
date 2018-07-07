#include<iostream.h>
#include<conio.h>
void main ()
{
	int year,month,day,Sam_day,DAY;
	Sam_loop:
	clrscr();
	cout<<"Enter the date:  \n";
	cout<<"\t\tday:  ";  do{cin>>day;  }while(day<=0  ||day  >30  );
	cout<<"\t\tmonth:  ";  do{cin>>month;}while(month<=0||month>12  );
	cout<<"\t\tyear:  ";  do{cin>>year; }while(year<=0 ||year >3000);
	Sam_day=(year*365.25)+(month*30)+day;
	DAY=int(Sam_day)%7;
	cout<<"The day was  ";
	switch (DAY)
	{
		case 0:
		cout<<"Sunday";
		break;
		case 1:
		cout<<"Monday";
		break;
		case 2:
		cout<<"Tusday";
		break;
		case 3:
		cout<<"Wesday";
		break;
		case 4:
		cout<<"Therday";
		break;
		case 5:
		cout<<"Friday";
		break;
		case 6:
		cout<<"Saturnday";
		break;
		default:
		cout<<"Error";
	}
	cout<<"!!!\n Press any key to use again . . . ";
	getch();
	goto Sam_loop;
}