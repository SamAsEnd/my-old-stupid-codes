#include<iostream.h>
#include<conio.h>
#include<string.h>
#include<fstream.h>
struct student_info
{
		int id_no;
		char name[50];
		float grade[10];
		float Gpa;
		student_info *next;
};
student_info *start = 0;
void add_info()
{
	clrscr();
	student_info *temp = new student_info;
	cout<<"please enter your name \n";
	cin>> temp->name,50;
	cin.ignore();
	 cout<<"please enter your ID number \n";
	 cin>> temp->id_no;
		cin.ignore();
	 for (int j=1; j<=10;j++)
{
	 cout<<"enter grade number  "  <<   (j)  <<   "---> ";
	 cin>>temp->grade[j];
	 temp->Gpa= temp->Gpa + temp->grade[j];
	  cin.ignore();
}
	 temp->Gpa= temp->Gpa/10;
	 if (start==0)
{
	 temp->next=0;
	 start=temp;
}
	 else if (start->id_no > temp->id_no)
{
	 temp->next=start;
	 start=temp;
}
	 else
{
	 student_info *temp2=start;
	 student_info *temp3=temp2;
	 while (temp2!= NULL)
{
	 if (temp2->id_no > temp->id_no)
{
	 temp3->next=temp;
	 temp->next=temp2;
	 break ;
}
  temp3=temp2;
  temp2=temp2->next;
}
  if(temp2==0)
{
  temp3->next=temp;
  temp->next=0;
}
	 }
	 }

  void DELETE ()
{
		 clrscr();
		 int tempo;
		 cout<<"ENTER THE ID NUMBER YOU WANT TO DELEAT \n";
		 cin>>tempo;
		 student_info *temp = start;
		 student_info *temp2= temp;
	if(start->id_no==tempo)
{
		 start=start->next;
		 delete temp;
}
		 else
		 {
		 while(temp!=0)
		 {
			if (temp->id_no==tempo)
			{
			 temp2->next=temp->next;
			 delete temp;
			 break;
			 }
			 temp2= temp;
			 temp=temp->next;
			 cout<<"your data has benn Successfully deleted  \n";
			 }
			 }
			 }

	  void SEARCH()
{

		clrscr();
		int tempo;
			 cout<<"ENTER THE ID NUMBER YOU WANT TO SEARCH \n";
			 cin>>tempo;
			 cin.ignore();
		if(start->id_no==tempo)
		cout<<"*****************************************";
		cout<<start->id_no<<"  "<<start->name<<endl;
		cout<<"grade";
		for(int i=1; i<=10; i++)
		{
		cout<<start->grade[i];
		}
		 }

		void show_info()
		{

			clrscr();
		for (student_info *temp = start; temp!=0;temp=temp->next)

{
			cout<<"\n************************************\n";
		cout<<temp->id_no<<"  "<<temp->name<<endl;
		cout<<"Grade ";
		for(int i=1;i<10;i++)
		{
			cout<<temp->grade[i]<<"   ";
		}
		cout<<"    Gpa: "<<temp->Gpa;
	}
	}


	void UPDATE_INFO()
{
	 clrscr();
	 int tempo;
	 cout<<"ENTER THE ID NUMBER YOU WANT TO UPDATE \n";
	 cin>>tempo;
	 cin.ignore();
	 if(start->id_no==tempo)
{
	 cout <<"enter the updates name\n";
	 cin>> start->name,50;
	 start->Gpa=0;
	 for(int i=1; i<=10; i++)
{

	  cout<<"enter grade number  "  <<   (i)  <<   "---> ";
	 cin>>start->grade[i];
	 start->Gpa= start->Gpa + start->grade[i];
	  cin.ignore();
}


	 start->Gpa= start->Gpa /5;
	 }
	 else
{
	 student_info *temp=start;
	 while(temp!=0)
	 {
	 if(temp->id_no==tempo)
	 {
	 cout<<"please enter your name \n";
	 cin>>temp-> name,50;
	 temp->Gpa= NULL;
		 for(int i=1; i<=10; i++)
{

	  cout<<"enter grade number  "  <<   (i)  <<   "---> ";
	  cin>>temp->grade[i];
	 temp->Gpa= temp->Gpa+temp->grade[i];
	  cin.ignore();
		}
		 temp->Gpa= temp->Gpa/5;
		 break;
		 }
		 temp=temp->next;
		 }

		  cout<<"your data has benn Successfully UBDATED  \n";
		  }
}
		void SAVE ()
		{
		ofstream out("info.txt");
		for(student_info *temp = start;temp!=0; temp->next)
{
			out<<temp->id_no<<"   " <<temp->name <<"~";
			for(int i=1; i<=10; i++)
			{
				out<<temp->grade[i]  <<"  ";
				}
}
			out.close();
}
			 getch();



void main()
{
	int tempo;
	while(1)
	{
	
	  cout<<"\n      PREES NUM 1 TO ADD STUDENT INFO\n"
			<<"      PREES NUM 2 TO DELEATE STUDENT INFO\n"
			<<"      PREES NUM 3 TO SEARCH STUDENT INFO\n"
			<<"      PREES NUM 4 TO VIEW INFO ABOUT STUDENT\n"
			<<"      PREES NUM 5 TO UPDATE INFO ABOUT STUDENT\n"
			<<"      PREES NUM 6 TO SAVE STUDENT INFO\n"
			<<"            ----->           ";
		cin>>tempo;
		if(tempo==1)
		{
			add_info();
			 
				 }
		else if (tempo==2)

			 DELETE();


		else if (tempo==3)

			 SEARCH();


		else if (tempo==4)

			 show_info();

		else if (tempo==5)

			 UPDATE_INFO ();

		else if (tempo==6)
			  SAVE();
		else
		cout<<"you entered an availabel button\n";
		clrscr();
}

	 }
