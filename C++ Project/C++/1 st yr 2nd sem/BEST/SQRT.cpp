	#include <iostream>
	#include <math.h>
	#include <cstdlib>
	int main()
	{
		double x,r,i=0.1;
		int a=0;
		A:
		cin>>x;
		a=0;
		i=0.1;
		if(x-(i*i)>(x-(1000000*a*a*i*i)))
			i*=(a*1000);
		else if(x-(i*i)>(x-(250000*a*a*i*i)))
			i*=(a*500);
		else if(x-(i*i)>(x-(1000*a*a*i*i)))
			i*=(a*100);
		else if(x-(i*i)>(x-(100*a*a*i*i)))
			i*=(a*10);

		while((x-(a*a*i*i))>0){
				if(x-(i*i)>(x-(a*a*i*i)))
					i*=a;
					a++;
				}
		for(;i*i<=x;i+=0.000001){
				r=i;
			}
			cout<<"THE my SQRT IS "<<r<<endl;
			cout<<"THE math SQRT IS "<<sqrt(x)<<endl;
		goto A;
		system("PAUSE");
		return 0;
	}
