#include <iostream.h>
void main(){
	int p,d=0;

	cout<<"Enter amount of purchases:\n";
		cin>>p;

	if(p>1000)
	{
		d=p/10;
		p-=d;
	}

	cout<<"Discounted price:   "<<p;

}