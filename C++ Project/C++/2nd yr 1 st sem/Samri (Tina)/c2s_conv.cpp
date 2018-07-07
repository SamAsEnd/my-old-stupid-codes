#include <iostream.h>
#include <conio.h>
void main()
{
	char ch;
	int n;
	cout<<"Enter z character:   ";
	loop:
	cin>>ch;
	n=ch;
	if(n>=65&&n<=90)n+=32;
	else if(n>=97&&n<=122)n-=32;
	else{
		cout<<"Enter a valid character(A-Z or a-z):\n\t";
		goto loop;
	}
	ch=n;
	cout<<"Your char wid opposite case is:  \""<<ch<<"\"";
}
