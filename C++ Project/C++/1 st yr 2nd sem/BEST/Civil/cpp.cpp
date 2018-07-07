#include <iostream.h>
#include <conio.h>
void main()
{
	int R;
	float t;
	char ch;
	A:
	clrscr();
	cout<<"Enter the roll number:   ";
	cin>>R;

	while(1)
	{
		clrscr();
		cout<<"Enter the constant:    ";
		cin>>t;

		cout<<"\nResult  =  \" "<<(t*R)<<" \" "<<endl;

		cout<<"\n    press \"C\" to Change roll number";
		cout<<"\n    press \"E\" to Exit";
		cout<<"\n    press any other key to calculate other . . . ";
		cin>>ch;
		if(ch=='C' || ch=='c')
			goto A;
		else if(ch=='E' || ch=='e')
			break;
		else
			continue;
	}
}