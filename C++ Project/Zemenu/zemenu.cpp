/*********************************************************       
		Headers  
**********************************************************/
#include <iostream.h>
#include <conio.h>
#include <fstream.h>
#include <string.h>
#include <stdlib.h>
/*********************************************************       
		structure  
**********************************************************/
struct course 
{
	char title[40];
	char code[10];
	unsigned int creditHour;
	char preqcourse[40][40];
	int numOfPre;
	course* nxt;     // Point to the next course
};
/*********************************************************       
		The start_ptr
**********************************************************/
course* start_ptr = NULL;
/*********************************************************       
		functions prototype  
**********************************************************/
void add();
void viewAll();
void searchByTitle();
void load();
void save();
void deleteByCode();
void searchByCode();
void updatecourse();
/*********************************************************       
		main function where the program start 
**********************************************************/
void main()
{
	cout<<"Loading file . . . ";
	load();
	char ch;		  // to accept choose
	while(1)          // Infinite loop
	{
		clrscr();
		cout<<"Enter   0    -    exit\n"
			<<"Enter   1    -    add\n"
			<<"Enter   2    -    view all\n"
			<<"Enter   3    -    search by name\n"
			<<"Enter   4    -    search by code\n"
			<<"Enter   5    -    delete by code\n"
			<<"Enter   6    -    update course\n"
			<<"Enter   7    -    sort\n";
		cin>>ch;
		cin.ignore();
		switch(ch)
		{
			case '0':
				save();
				_exit(0);
				break;
			case '1':
				add();
				break;
			case '2':
				viewAll();
				break;
			case '3':
				searchByTitle();
				break;
			case '4':
				searchByCode();
				break;
			case '5':
				deleteByCode();
				break;
			case '6':
				updatecourse();
				break;
			default:
				cout<<"Incorrect choose";
		}
		cout<<"\n\t press any key to continue . . . ";
		getch();
	}
}
/*********************************************************       
		add function to accept and add to the linked list 
**********************************************************/
void add()
{
	clrscr();
	course* temp = new course;
	cout<<"Enter course title:  ";
	cin.getline(temp->title,40);
	cout<<"Enter course code:  ";
	cin.getline(temp->code,10);
	cout<<"Enter course credit hour:  ";
	cin>>temp->creditHour;
	cin.ignore();
	cout<<"Enter number of prequest course:  ";
	cin>>temp->numOfPre;
	cin.ignore();
	for(int i=0;i<temp->numOfPre;i++)
	{
		cout<<"Enter prequest course "<<(i+1)<<":  ";
		cin.getline(temp->preqcourse[i],40);
	}
	/*********************************************************       
		Inserting start here
	**********************************************************/
	// if there is no course on the linked list
	if(start_ptr==NULL)  
	{
		temp->nxt=NULL;
		start_ptr=temp;
	}
	// if the new course come BEFORE the start_ptr on alphabet (addAtBig)
	else if(strcmp(temp->title,start_ptr->title)<0) {
		temp->nxt=start_ptr;
		start_ptr=temp;
	}
	else
	{
		course *temp2=start_ptr;
		course *temp3=temp2;
		while(temp2!=NULL) // until loop until the end
		{
			// cheak if the new course come BEFORE the current pointer on alphabet
			if(strcmp(temp->title,temp2->title)<0)
			{
				temp3->nxt=temp;
				temp->nxt=temp2;
				break;
			}
			temp3 = temp2;
			temp2 = temp2->nxt;
		}
		if(temp2==NULL) // if the new course come at last of the list (addAtEnd)
		{
			temp3->nxt = temp;
			temp->nxt = NULL;
		}
	}
}
/*********************************************************       
		View to display all the linked list 
**********************************************************/
void viewAll()
{
	clrscr();
	course* temp = start_ptr;
	if(temp==NULL)
		cout<<"\nList empty";
	else
	{
		cout<<"		title		code		credit hour\n";
		while(temp!=NULL) // loop until end
		{
			cout<<"		"<<temp->title<<"	"<<temp->code<<"	"<<temp->creditHour<<endl;
			temp = temp->nxt;
		}
	}
}
/*********************************************************       
searchByTitle function accept the title and display the prequest
**********************************************************/
void searchByTitle()
{
	char name[40];
	clrscr();
	cout<<"Enter the title of the course:  ";
	cin.getline(name,40);
	///////////////////////////////////////////
	course* temp = start_ptr;
	while(temp!=NULL)
	{
		if(strcmp(temp->title,name)==0)
		{
			cout<<"course title:   "<<temp->title<<"\ncourse code: "<<temp->code<<"\ncourse credit hour: "<<temp->creditHour<<endl;
			if(temp->numOfPre<0)
				cout<<"		No prequest"<<endl;
			for(int i=0;i<temp->numOfPre;i++)
			{
				cout<<"		prequest "<<(i+1)<<":  "<<temp->preqcourse[i]<<endl;
			}
			break;
		}
		temp = temp->nxt;
	}
	if(temp==NULL)
		cout<<"Not Found";
}
/*********************************************************       
	load function excute when the program start
	load a list on the file "zemenu.txt" to the linked list 
**********************************************************/
void load()
{
	ifstream zemenu("zemenu.txt"); // connect to the file
	if(zemenu.good())
	{
		while(!zemenu.eof())     // untile the end of file is true
		{
			course* temp = new course;
			zemenu.getline(temp->title,40,'|');
			zemenu.getline(temp->code,10,'|');
			zemenu>>temp->creditHour;
			zemenu.get();   // to ignore the '|'
			zemenu>>temp->numOfPre;
			zemenu.get();	// to ignore the '|'
			for(int i=0;i<temp->numOfPre;i++)
				zemenu.getline(temp->preqcourse[i],10,'|');
			zemenu.get();	// to ignore the '|'
			if(strlen(temp->title)==0) // if the course is empty
				break;
			/*********************************************************       
			Inserting start here
			**********************************************************/
			// if there is no course on the linked list
			if(start_ptr==NULL)  
			{
				temp->nxt=NULL;
				start_ptr=temp;
			}
			// if the new course come BEFORE the start_ptr on alphabet (addAtBig)
			else if(strcmp(temp->title,start_ptr->title)<0) {
				temp->nxt=start_ptr;
				start_ptr=temp;
			}
			else
			{
				course *temp2=start_ptr;
				course *temp3=temp2;
				while(temp2!=NULL) // until loop until the end
				{
					// cheak if the new course come BEFORE the current pointer on alphabet
					if(strcmp(temp->title,temp2->title)<0)
					{
						temp3->nxt=temp;
						temp->nxt=temp2;
						break;
					}
					temp3 = temp2;
					temp2 = temp2->nxt;  // walk
				}
				if(temp2==NULL) // if the new course come at last of the list (addAtEnd)
				{
					temp3->nxt = temp;
					temp->nxt = NULL;
				}
			}
		}
	}
	zemenu.close();
}
/*********************************************************       
	save function excute just before the program exit
	save a list on the file "zemenu.txt" from the linked list 
**********************************************************/
void save()
{
	ofstream zemenu("zemenu.txt");
	course* temp = start_ptr;
	while(temp!=NULL) // until the end
	{
		zemenu<<temp->title<<"|"<<temp->code<<"|"<<temp->creditHour<<"|"<<temp->numOfPre<<"|";
		for(int i=0;i<temp->numOfPre;i++)
			zemenu<<temp->preqcourse[i]<<"|";
		zemenu<<endl;
		temp=temp->nxt; // walk
	}
	zemenu.close();
}
/*********************************************************
	deleteByCode function accept and delete the node 
	by compering the course code on the linked list 
**********************************************************/
void deleteByCode()
{
	char name[10];
	clrscr();
	cout<<"Enter the code of the course:  ";
	cin.getline(name,10);
	///////////////////////////////////////////
	course* temp = start_ptr;
	course* temp2 = start_ptr;
	if(strcmp(start_ptr->code,name)==0)
	{
		start_ptr = start_ptr->nxt;
		delete temp;
		cout<<"Done";
	}
	else
	{
		while(temp!=NULL)
		{
			if(strcmp(temp->code,name)==0)
			{
				temp2->nxt = temp->nxt;
				delete temp;
				cout<<"Done";
				break;
			}
			temp2 = temp;
			temp = temp->nxt;  // walk
		}
		if(temp==NULL)
			cout<<"Not Found";
	}
}
/*********************************************************       
searchByCode function accept the code and display the prequest
**********************************************************/
void searchByCode()
{
	char name[10];
	clrscr();
	cout<<"Enter the code of the course:  ";
	cin.getline(name,10);
	///////////////////////////////////////////
	course* temp = start_ptr;
	while(temp!=NULL)
	{
		if(strcmp(temp->code,name)==0)
		{
			cout<<"course title:   "<<temp->title<<"\ncourse code: "<<temp->code<<"\ncourse credit hour: "<<temp->creditHour<<endl;
			for(int i=0;i<temp->numOfPre;i++)
			{
				cout<<"		prequest "<<(i+1)<<":  "<<temp->preqcourse[i]<<endl;
			}
			break;
		}
		temp = temp->nxt;  // walk
	}
	if(temp==NULL)
		cout<<"Not Found";
}
/*********************************************************       
updatecourse function accept the code and update course
**********************************************************/
void updatecourse()
{
	char name[10];
	clrscr();
	cout<<"Enter the code of the course:  ";
	cin.getline(name,10);
	///////////////////////////////////////////
	course* temp = start_ptr;
	while(temp!=NULL)
	{
		if(strcmp(temp->code,name)==0)
		{
			cout<<"course title:   "<<temp->title<<"\ncourse code: "<<temp->code<<"\ncourse credit hour: "<<temp->creditHour<<endl;
			for(int i=0;i<temp->numOfPre;i++)
			{
				cout<<"		prequest "<<(i+1)<<":  "<<temp->preqcourse[i]<<endl;
			}
			break;
		}
		temp = temp->nxt;  // walk
	}
	if(temp==NULL)
		cout<<"Not Found";
	else
	{
		cout<<"Enter course the new title:  ";
		cin.getline(temp->title,40);
		cout<<"Enter course the new code:  ";
		cin.getline(temp->code,10);
		cout<<"Enter course the new credit hour:  ";
		cin>>temp->creditHour;
		cin.ignore();
		cout<<"Enter number of prequest course:  ";
		cin>>temp->numOfPre;
		cin.ignore();
		for(int i=0;i<temp->numOfPre;i++)
		{
			cout<<"Enter prequest course "<<(i+1)<<":  ";
			cin.getline(temp->preqcourse[i],40);
		}
		cout<<"Done";
	}
}








