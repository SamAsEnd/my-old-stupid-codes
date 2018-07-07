#include <iostream>
#include <string>
using namespace std;

struct Person{

	string name;
	int age;
	char gender;

};

int main(){

	Person p;

	p.name = "Christopher";
	p.age = 34;
	p.gender = 'M';

	cout << "Name: " << p.name << endl;
	cout << "Age: " << p.age << endl;
	cout << "Gender: " << p.gender << endl;

	return 0;
}