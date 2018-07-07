#include <iostream.h>
#include <conio.h>
void main()
{
					//using third variable
	int n,m,Temp;
	cout<<"Enter z first number :   ";
	cin>>n;
	cout<<"Enter z second number:   ";
	cin>>m;
	
	cout<<"The first number before swaping:   "<<n<<endl;
	cout<<"The second number before swaping:   "<<m<<endl<<endl;
	
				//  N        M       Temp
				//=====    =====    =======
	Temp=n; 	//  n        m        n
	n=m;    	//  m        m		  n
	m=Temp;     //  m        n		  n
	
	cout<<"The first number after swaping:   "<<n<<endl;
	cout<<"The second number after swaping:   "<<m<<endl;
	
	}


