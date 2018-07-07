#include<iostream.h>
void main()
{
	const int Size=5;
	int ii, R[Size];
	ii=0;
	while (ii<Size){
	cout<<"Enter a number:  ";
	cin>>R[ii];
	ii++;
	}
	cout<<"Done\n\tThe list before sorting!!!!!\n";
	for(ii=0;ii<Size;ii++){
		cout<<R[ii]<<" , ";
		}
	cout<<"\b\b";
	///////////////////////////////////
	int t[Size],v,min,min1=0,x=0;
	for(v=0;v<Size;v++)
	{
		t[v]=R[v];
	}
	v=0;
	for(int i=0;i<Size;i++){
		for(int j=(i+1);j<Size;j++){
		min=R[i];
		if(x==1){
		min=min1;
		x=0;}
		if(min>R[j]){
		min=R[j];}
		else if(min<R[j]){
		break;}
		else{
		min1=R[j];}
		if (min1==min){
		x=1;}
		t[i]=min;
		}
		cout<<"\n"<<min<<"\t"<<R[i]<<"\t"<<t[i]<<"\n";
		}
	cout<<"\n\t";
	for(v=0;v<Size;v++)
	{
		R[v]=t[v];
	}
	
	//////////////////////////////////
	for(i=0;i<Size;i++){
		cout<<R[i]<<" , ";
		}
	cout<<"\b\b";
}







