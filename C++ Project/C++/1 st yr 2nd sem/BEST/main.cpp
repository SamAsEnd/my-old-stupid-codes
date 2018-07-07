#include <cstdlib>
#include <iostream>

using namespace std;
int fun(int &a,int l);
int main()
{
	int x[10],temp=0;
	while(temp<10){
        cout<<"Enter the "<<(temp+1);
        if(temp==0) cout<<"st ";
        else if (temp==1) cout<<"nd ";
        else if (temp==2) cout<<"rd ";
        else cout<<"th ";
        cout<<"number:\n\t";
        cin>>x[temp];
        temp++;
	}
	
/////////////////////////////////////////////////////////////
	
	cout<<"\n\tBefore rearrenging \n";
	for(temp=0;temp<10;temp++){
		cout<<x[temp]<<" ";
	}cout<<endl;
	
////////////////////////////////////////////////////////////

	int z;

	for(int i=0;i<10;i++)
	{
        for(int k=i;k<10;k++)
        {
			if(x[i]>x[k]){
			    z=x[k];
			    x[k]=x[i];
			    x[i]=z;
			}
        }
	}
	
////////////////////////////////////////////////////////////

	cout<<"\n\tAfter rearrenging \n";
	for(temp=0;temp<10;temp++){
		cout<<x[temp]<<" ";
	}cout<<"\n";
	system("pause");
	return 0;
}/////////////////////////////////////////////////////////////














