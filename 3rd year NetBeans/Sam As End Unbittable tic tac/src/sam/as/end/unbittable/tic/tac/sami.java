package sam.as.end.unbittable.tic.tac;

public class sami {
    
    public int[] val;
    public boolean who;
    
    public sami(int[] x,boolean player)
    {
        for(int i=0;i<x.length&&i<val.length;i++)
        {
            val[i]=x[i];
        }
    }
    public int getBest()
    {
        if(!samiFull())
        {
            int[] x = new int[10];
            int top=0;
            for(int i=0;i<numberOfEmpty();i++)
            {
                sami temp;
                temp = new sami(val,!who);
                x[top++]= temp.getBest();
            }
            
            
        }
        else {
            return whoWon();
        }
    }

    public int whoWon() {
        final int[] x = {0, 1, 4, 7, 1, 2, 3, 1, 3};
        final int[] y = {0, 2, 5, 8, 4, 5, 6, 5, 5};
        final int[] z = {0, 3, 6, 9, 7, 8, 9, 9, 7};
        int winner = 0;
        for (int i = 1; i < 9; i++) {
            int a = x[i];
            int b = y[i];
            int c = z[i];
            if (val[a] == val[c] && val[a] == val[b] && val[c] == val[b]) {
                if (val[a] == 1) {
                    winner = 1;
                } else if (val[a] == -1) {
                    winner = -1;
                } else {
                    winner = 0;
                }
            }
        }
        return 0;
    }

    private boolean samiFull() {
        for(int i=1;i<=9;i++)
        {
            if(val[i]==0)
            {
                return false;
            }
        }
        return true;        
    }

    private int numberOfEmpty() {
        return 0;
    }
    
}
