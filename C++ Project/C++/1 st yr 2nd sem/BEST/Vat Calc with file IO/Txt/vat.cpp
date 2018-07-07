#include<fstream.h>
#include<conio.h>
void Welcome(){
	clrscr();
	cout<<" ==============================================================================\n";
	cout<<" ******************************************************************************\n";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\t\tWELCOME TO SAMI VAT CALCULATOR\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<"|**\t\t\t\t\t\t\t\t\t     **|";
	cout<<" ******************************************************************************\n";
	cout<<" ==============================================================================\n";
	cout<<"\n\t\t\t*******************************\n";
	}

int main(){
	A:
	float Price,vat,total;
	int Quan;
	int items=0;
	char Username[15];
	char TINnum[25];
	char Name[10];

	Welcome();
	cout<<"\t\t\tEnter your name : \t   ";
	cin.getline(Username,15);
	cout<<"\t\t\tEnter your TIN number :    ";
	cin.getline(TINnum,10);
	cout<<"\n\n";

	ofstream sami;
	sami.open("Vat.txt",ios::app);
	cout<<"\t\t\tHow many items?\t";
	while(items<1){  
		cin>>items;
		}
	sami<<"\n\n***************************************************************************\n";
	sami<<"\t\t\t\tCustemer:\t\t\t"<<Username<<endl;
	sami<<"\t\t\t\tTIN number:\t"<<TINnum<<endl;
	float T=0;
	for(int i=items;i!=0;i--){
	Welcome();
	cout<<"\t\tEnter the the name of the item?      (Items left="<<i<<")";
	cout<<"\n\t\t";
	cin.getline(Name,10);
	cin.getline(Name,10);
	cout<<"\t\tHow many?\t";
	cin>>Quan;
	cout<<"\t\tPrice?  ";
	cin>>Price;
	total=Price*Quan;
	vat=total+0.15*total;
	sami<<"\t\t\t"<<Name<<"\t\t"<<Price<<"\t\t"<<total<<"\t\t"<<vat<<endl;
	T=T+vat;
	}
	cout<<"\n\n\t\tTotal with vat:\t"<<T;
	sami<<"\n\n\t\tTotal with vat:\t"<<T;
	sami.close();
	cout<<"\n\t\t\tDone\n";
	sami<<"***************************************************************************\n";
	return 0;
}