#include <stdlib.h>
#include <iostream>
#include <string>
using namespace std;

struct Student
{
	string name;
	int age;
};

int main()
{
	Student Sami[3];
	for(int Index=0;Index<4;Index++)
	{
		cout<<"Enter student name\n";
		cin>>Sami[Index].name;
		cout<<"Enter student age\n";
		cin>>Sami[Index].age;
		cout<<"_________________\n";
	}
	cout<<"\n User NO\tName\tAge";
	cout<<"\n ____ __\t____\t___\n ";
	for(int Index1=0;Index1<4;Index1++)
	{
		cout<<Index1+1<<"     \t"<<Sami[Index1].name<<"\t"<<Sami[Index1].age<<"\n ";

	}
	
	system("PAUSE");
	return 0;
}
