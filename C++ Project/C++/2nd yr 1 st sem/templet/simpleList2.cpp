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

template <class T>
void print (node<T>* p){

     //as long as the list is not empty:
     while(p){
	cout << p -> data();
	p = p -> link();
     }

};

int main(){

	node<char> a('a'), b('b'), c('c');

        //give the address to the link:
	a.link() = &b;
	b.link() = &c;

        //start at beginning:
        print(&a);

        //the list looks like this:
        //a --> b --> c

return 0;
}
