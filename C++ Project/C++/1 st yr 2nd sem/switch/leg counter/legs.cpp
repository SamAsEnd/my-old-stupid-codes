/*

This is an easy switch statement!

	  Samson Endale
	  CSED
	  C++
*/
#include<iostream.h>
#include<conio.h>
void main(){
sami:
int x;   //variable declaretion

clrscr();
cout<<"How many legs do you have?\n";    //promot the user
cin>>x;                                  //setting value


	  switch (x)                               //tell "switch" the variable to compute
	  {                                        //block
			 case 1:                             //means if x==1, end with ":"
			 cout<<"You are a pirate!\n";
			 break;                              //to stop the switch if x==1
			 case 2:
			 cout<<"You are HUMAN BEING!\n";
			 break;
			 case 3:
			 cout<<"You have a BIG d**k\n";
			 break;
			 case 4:
			 cout<<"You are an animal! Stay away from the PC\n";
			 break;
			 case 6:
			 cout<<"You are an ant!\n";
			 break;
			 case 8:
			 cout<<"You are a spider!\n";
			 break;
			 default:                             //the code to run if non are true
			 cout<<"You are an alien!\n";
	  }
	  cout<<"Press Enter to continue"<<endl;
	  getch();
	  goto sami;
	        }

