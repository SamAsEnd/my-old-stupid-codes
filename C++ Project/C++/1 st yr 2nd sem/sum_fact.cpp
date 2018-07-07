#include<iostream.h>
void main(){
	 sami:
	 int x;
	 long fact=1,sum=0;
	 cout<<"Enter the number:  ";
	 cin>>x;
	 for(int i=1;i<=x;i++){
			fact*=i;
			sum+=fact;
	 }
	 cout<<"Sum:   "<<sum;
	 goto sami;
}