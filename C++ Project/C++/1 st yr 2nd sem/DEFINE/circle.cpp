#include <iostream.h>
#define PI 3.14158/*
	  How to write
	  Format : #define identifier value"

	  In fact the only thing that the compiler preprocessor
	  does when it encounters #define directives is to literally
	  replace any occurrence of their identifier
	  (in the previous example, these were PI)
	  by the code to
	  which they have been defined (3.14159).

	  The #define directive is not a C++ statement but a directive
	  for the preprocessor; therefore it assumes the entire
	  line as the directive and does not require a semicolon (;) at its end.
	  If you append a semicolon character (;) at the end,
	  it will also be appended in all occurrences within the body of the
	  program that the preprocessor replaces.

	  */
int main ()
{
double r;
double circle;
double area;
cout<<"Enter the radius?\n";
cin>>r;
circle = 2 * PI * r;
area = PI * r * r;
cout<< "The circu.. is: "<< circle<<endl;
cout<< "The Area is: " << area;
return 0;
}
