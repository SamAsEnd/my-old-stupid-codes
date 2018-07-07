#include <iostream.h>
#include <conio.h>
void main()
{               //without another variable
	int n,m;
	cout<<"Enter z first number :   ";
	cin>>n;
	cout<<"Enter z second number:   ";
	cin>>m;
	
	cout<<"The first number before swaping:   "<<n<<endl;
	cout<<"The second number before swaping:   "<<m<<endl<<endl;
	
				  //    N        M
				  //  =====    =====
	n=n+m;     //   n+m       m
	m=n-m;     //   n+m       n
	n=n-m;     //    m        n
	
	cout<<"The first number after swaping:   "<<n<<endl;
	cout<<"The second number after swaping:   "<<m<<endl;
	
	}





