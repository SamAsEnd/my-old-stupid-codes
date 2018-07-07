#include<iostream.h>
void main(){
	float D,G, KpL, LpK;
	cout<<"Enter \"Distance in Kelo Meters\":\t";
	cin>>D;
	cout<<"Enter \"Gas in Litres\":\t";
	cin>>G;
	
	KpL=D/G;
	LpK=G/(D/100);
	
	cout<<"Distance\tLitres used\tKm/L\t\tL/100Km"<<endl;
	cout<<"========\t===========\t====\t\t======="<<endl;
	cout<<D<<"  \t\t"<<G<<"\t\t"<<KpL<<"   \t"<<LpK;
	}