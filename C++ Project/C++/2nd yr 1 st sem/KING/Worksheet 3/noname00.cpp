#include <iostream.h>
void main(){
	float a,b,c,x1,x2;

	cout<<"Enter A:\t";
		cin>>a;
	cout<<"Enter B:\t";
		cin>>b;
	cout<<"Enter C:\t";
		cin>>c;

	float x=((b*b)-(4*a*c));

	if(x==0){
		x1 = - b/(2*a);
		cout<<"X = "<<x1;
		}
	else if (x<0)
		cout<<"Maths Error";
	else if (x>0){
		x1=(-(b*b)+x)/(2*a);
		x2=(-(b*b)-x)/(2*a);
		cout<<"X1 = "<<x1;
		cout<<"X2 = "<<x2;
		}
	}

