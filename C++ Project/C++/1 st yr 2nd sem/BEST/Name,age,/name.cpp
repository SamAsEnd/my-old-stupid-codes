#include <iostream.h>
#include <string.h>
int main () {
	char Name[20];
	char FName[20];
	char Age[3];
	cout<<"What's your name?\n";
	cin>>Name;
	cout<<"What's your father name?\n";
	cin>>FName;
	cout<<"How old are you?\n";
	cin>>Age;
	cout<<"\n\n**\t\tYour name is             \t\""<<Name<<"\"\n";
	cout<<"**\t\tYour Father name is          \t\""<<FName<<"\"\n";
	cout<<"**\t\tYour age is                      "<<Age<<endl;
	return 0;
	}
