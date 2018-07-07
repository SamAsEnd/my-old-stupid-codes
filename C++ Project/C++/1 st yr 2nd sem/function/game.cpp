#include <iostream.h>
#include <stdlib.h>    // rand  ()
#include <time.h>      // time  ()
#include <conio.h>

void Start ();
void GetResults ();

int  i, j, life, maxrand, cheat=0, numOfWin=0;
char c;

void main ()
{
	  Start();
}

void Start ()
{
	  i = 0;
	  j = 0;
     life = 0;
	  maxrand = 6;
	  clrscr();
	  cout << "\tYou WON "<<numOfWin<<" times \n\n";
	  cout << "\tSelect difficulty mode:\n";      // the user has to select a difficutly level
	  cout << "\t  1 : Easy (0-15)\n";
	  cout << "\t  2 : Medium (0-30)\n";
	  cout << "\t  3 : Difficult (0-50)\n";
	  cout << "\t    or type another key to quit\n\t    -> ";
	  c = 30;
	  A:
	  cin >> c;                                 // read the user's choice
	  cout << "\n";

	  switch (c)
	  {
		  case '1' : maxrand = 15;               // the random number will be between 0 and maxrand
        break;
		  case '2' : maxrand = 30;
        break;
		  case '3' : maxrand = 50;
		  break;
		  case 's' : cheat=1; goto A;      // Cheat mode
		  break;
		  default :
		  clrscr();
		  cout << "\n    You WON "<<numOfWin<<" times \n      Good bye  ";
		  exit(1);
     }

	  life = 5;                                  // number of lifes of the player
																//srand( (unsigned)time( NULL ) ); // init Rand() function
	  j = unsigned (rand() * time(0)) % maxrand;                      // j get a random value between 0 and maxrand

	  /*
	  if (cheat==1)
	  {
			cout<<"\nThe number is "<<j<<endl;
			getch();
	  }
	  */
	  clrscr();
	  GetResults();

}


void GetResults ()
{
     if (life <= 0)
		  // if player has no more life then he lose
	  {
		  cout << "\t\tYou lose!\n\tPress any key to play again . . . ";
		  getch();
        Start();
	  }

	  cout << "\n\n\t\tType a number (0 - "<<maxrand<<"):     ";
     cin >> i;          // read user's number

	  if ((i>maxrand) || (i<0)) // if the user number isn't correct, restart
     {
		  cout << "\n\t\tError : Number not between 0 and \n" << maxrand;
        GetResults();
     }

     if (i == j)
	  {
		  cout << "\n\t\tYOU WIN !\n\t\tPress any key to play again . . . ";   // the user found the secret number
		  numOfWin++;
		  getch();
		  Start();
     }

     else if (i>j)
	  {
		  cout << "\t\tToo BIG\n";
		  if(cheat!=1)life--;    // -1 to the user's "life"
		  cout << "\t\tNumber of remaining life:\t" << life << "\n\n";
        GetResults();
	  }

     else if (i<j)
     {
		  cout << "\t\tToo SMALL\n";
		  life--;
		  cout << "\t\tNumber of remaining life:\t" << life << "\n\n";
        GetResults();
     }
}

