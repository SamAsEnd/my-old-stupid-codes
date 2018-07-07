#include<iostream.h>
#include<conio.h>
void main(){
	class student{
		public:
			char Fname[20];
			char Lname[20];
			char ID[10];
			int Age;
			float Height;
			float Weight;
			int Dorm;
		};
		student sami;
		cout<<"Enter First name:\t";
		cin.getline(sami.Fname,20);
		cout<<"Enter Last name:\t";
		cin.getline(sami.Lname,20);
		cout<<"Enter ID:\t";
		cin.getline(sami.ID,10);
		cout<<"Enter Age:\t";
		cin>>sami.Age;
		while((sami.Age<0)||(sami.Age>100))
		{
			cout<<"\tIncorrect answer! Try again:   ";
			cin>>sami.Age;
			}
		cout<<"Enter Height:\t";
		cin>>sami.Height;
		while((sami.Height<0)||(sami.Height>3.0))
		{
			cout<<"\tIncorrect answer! Try again:   ";
			cin>>sami.Height;
			}
		cout<<"Enter Weight:\t";
		cin>>sami.Weight;
		while((sami.Weight<0)||(sami.Weight>500))
		{
			cout<<"\tIncorrect answer! Try again:   ";
			cin>>sami.Weight;
			}
		cout<<"Enter Dorm number:\t";
		cin>>sami.Dorm;
		while((sami.Dorm<0)||(sami.Dorm>500))
		{
			cout<<"\tIncorrect answer! Try again:   ";
			cin>>sami.Dorm;
			}
		clrscr();
		cout<<"\t\t \""<<sami.Fname<<" Profile\"\n\tName:  "<<sami.Fname<<" "<<sami.Lname<<"\n\tID:  ";
		cout<<sami.ID<<"\n\tAge:  "<<sami.Age<<"\n\tHeight:  "<<sami.Height<<"\n\tWeight: "<<sami.Weight<<"\n\tDorm: "<<sami.Dorm;
		}
