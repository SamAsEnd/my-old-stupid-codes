#include <iostream>
using namespace std;

template<class T>
class node{

private:
	T Data;
	node<T>* Link;

public:
	//constructor
	node(){Link = 0;}
	node(T d) { Data = d; Link = 0; }

	//accessors
	T& data(){ return Data; }
	node<T>*& link(){ return Link; }

};

int main(){

	node<char> a('a'), b('b'), c('c');

        //give the address to the link:
	a.link() = &b;
	b.link() = &c;

        //print each element:
	cout << a.data() << endl;
	cout << b.data() << endl;
	cout << c.data() << endl;

        //the list looks like this:
        //a --> b --> c

return 0;
}
