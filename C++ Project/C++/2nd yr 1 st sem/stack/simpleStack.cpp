#include <iostream>
using namespace std;

template< class T >
class Stack {

private:
   int MAX;
   int top;
   T* items;

public:
	Stack(int size){
		MAX = size;
		top = -1;
		items = new T[MAX];
	}

	~Stack(){ delete [] items; }

	void push(T c){
		if(full()){
			cout << "Stack Full!" << endl;
			exit(1);
		}

		items[++top] = c;
	}

	T pop(){
		if(empty()){
			cout << "Stack Empty!" << endl;
			exit(1);
		}

		return items[top--];
	}

	int empty(){ return top == -1; }

	int full(){ return top+1 == MAX; }
};

int main(){

	Stack<char> st(10);

        //the letters 'A' - 'J'
	for(int i = 65; i < 75; i++)
		st.push(i);

        //remove all the data
	for(int j = 0; j < 10; j++)
		cout << st.pop() << endl;

	return 0;
}