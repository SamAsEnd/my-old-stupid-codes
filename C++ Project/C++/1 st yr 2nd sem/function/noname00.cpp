  #include<iostream.h>
  #include<math.h>
  void sum (int a,int b)
  {
		int c=a+b;
		cout<<"The sum is: "<<c<<endl;
  }
  void power (int a,int b)
  {
		int d=pow(a,b);
		cout<<"The power function is: "<<d;
  }
  void main ()
  {
		int a, b;
		cout<<"Enter the first number: \n";
		cin>>a;
		cout<<"Enter the second number: \n";
		cin>>b;
		sum(a,b);
		power(a,b);
  }
