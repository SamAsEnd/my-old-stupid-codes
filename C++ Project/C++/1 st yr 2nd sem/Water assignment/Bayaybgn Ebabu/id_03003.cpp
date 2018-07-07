/*_____________________________________________
  |       Bayaybgn Ebabu                       |
  |        ID number 0300341                   |
  |     **********************                 |
  |____________________________________________|*/
#include<iostream.h>
#include<conio.h>                             //To use 'get();' and clrscr();
int main();                                   //Declaration of the main function
/******************************************************************************/
//________________________Start of function "fee()"_____________________________
void fee(){                                   //Our function
	 int c,yr,cs;                              //Declaration 'c' for choose
	 clrscr();                                 //'yr' for year
                                              //'cs' for cost sharing
	 cout<<"Please press 1 to see IOT students fee\n";
	 cout<<"Press 2 to see IOTex students fee\n";
	 cout<<"Press 3 to see Peda students fee\n";
	 cout<<"Press 4 to see Agricalture students fee\n";
	 cin>>c;
	 cout<<"How many years you stay at the campus\n";
	 cin>>yr;
	 while (yr<0)
	 {  cout<<"Year must be greater than 0\nEnter again:  ";
		 cin>>yr;
		 }
	 switch (c){                                  //Switch for int c
		case 1:
		  cs=yr*1000;
		  break;
		case 2:
		  cs=yr*980;
		  break;
		case 3:
		  cs=yr*950;
		  break;
		case 4:
		  cs=yr*1200;
		  break;
		default:                                  //If the user enter other number
		  cout<<"\nYou choice entered is INCORRECT!";
		  getch();                                //wait for char and ...
		  clrscr();                               //clear screen
		  cs=0;
		}
		cout<<"Your total cost sharing fee is "<<cs<<endl;//display cost sharing
}//___________________________End of function "fee()"___________________________
/******************************************************************************/
int main(){
		char ch;
		cout<<"Welcome\n";
		do{
		fee();
		cout<<"\nDO you want to see other student's fee?\n";
		cout<<"Press Y to continue\n";
		cout<<"Press N to Exit\n";
		cin>>ch;
		}
		while ((ch=='Y') || (ch=='y'));
		return 0;                                            //exit
}