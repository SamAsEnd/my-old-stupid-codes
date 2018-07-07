#include<iostream.h>
#include<math.h>
void main(){
	float s1, s2, s3, s, A;
	cout<<"Enter the first side:\t";
	cin>>s1;
	cout<<"Enter the second side:\t";
	cin>>s2;
	cout<<"Enter the third side:\t";
	cin>>s3;
	
	s=((0.5)*s1)+((0.5)*s2)+((0.5)*s3);
	
	A=sqrt(s*(s-s1)*(s-s2)*(s-s3));
	
	cout<<"Area = "<<A;
	}