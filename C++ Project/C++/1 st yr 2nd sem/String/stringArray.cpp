#include <iostream>
#include <string>
using namespace std;

int main(){

string name = "Sam As End";

//loop to print out the string
for(int i = 0; i < name.length(); i++){
	cout << name[i];
}
cout << endl;

//loop to print out the string funny:
for(int i = 0; i < name.length(); i++){
	if(i % 2 == 0){
		cout << name[5];
	}else{
		cout << name[i];
	}
}
cout << endl;

return 0;
}
