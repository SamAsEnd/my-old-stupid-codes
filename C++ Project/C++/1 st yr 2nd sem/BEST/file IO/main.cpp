/*
  Name:            Samson Endale
  Copyright:       Protected
  Author:          Samson Endale
  Date:            08/06/10 12:10
  Description:     File IO
*/
#include <cstdlib>
#include <iostream>
#include <fstream>
#include <>
using namespace std;

int main()
{
    char c='N';
    cout<<"\"Y\" 4 out or \"N\"in";
    cin>>c;
    ofstream sami;
    if (c=='N'){
            sami.open("Sam_public.rc");
            for (int i=5000;i>-5000;i--){
                char ch=i;
                sami<<i<<"\t\t"<<ch<<"\n";
                }
            cout<<"GooD";
            system("PAUSE");
            return EXIT_SUCCESS;
    }
    else{
   			 ifstream R;
             R.open("Sam_public.rc");
             if(!R.is_open()){
             exit(EXIT_FAILURE);
             cout<<"Error";}char word[50];R>>word;
             while(R.good()){
                 cout<<word<<" ";
                 R>>word;
             }
             system("PAUSE");
            return EXIT_SUCCESS;
}}
