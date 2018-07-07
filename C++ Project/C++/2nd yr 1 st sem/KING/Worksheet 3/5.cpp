#include <iostream.h>
void main(){
	float mid,final,total;

	cout<<"Enter Mid:\t";
		cin>>mid;
	cout<<"Enter Final:\t";
		cin>>final;

	total=mid+final;

	if(total>100)
		cout<<"ERROR!";
	else if(total>90)
		cout<<"A";
	else if(total>80)
		cout<<"B";
	else if(total>70)
		cout<<"C";
	else if(total>60)
		cout<<"D";
	else if(total>50)
		cout<<"E";
	else
		cout<<"F";
}
