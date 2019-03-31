/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktaktoe;

/**
 *
 * @author aqibj
 */
public class tictaktoemodel {
    private int [][]main_arr ;
    int row , col;

    public tictaktoemodel() {
        main_arr = new int [3][3];
        row = 3;
        col = 3;
        Initialise_Board(main_arr, row, col);
        
    }

    public int[][] getMain_arr() {
        return main_arr;
    }
    
    
    
    void Initialise_Board(int [][]arr , int row , int col)
    {
        if (arr != null)
        {
            for ( int i = 0 ; i < row ; i++)
            {
                for ( int j = 0 ; j < col ; j++)
                {
                    arr[i][j] = -1;
                }
            }
        }
    }
    boolean check_winner ( int row , int col , int symbol)
    {

        int count = 0;

        if(symbol == 0)
        {
            //0 to right
            for ( int i = 0 ; i < 3 ; i++)
            {
                for ( int j = 0 ; j < 3 ; j++)
                {
                    if (main_arr[i][j] == 0)
                    {
                        count ++;
                    }

                }
                if (count == 3 )
                    return true;
                else
                    count=0;
            }
            for ( int i = 0 ; i < 3 ; i++)
            {
                for ( int j = 0 ; j < 3 ; j++)
                {
                    if (main_arr[j][i] == 0)
                    {
                        count ++;
                    }

                }
                if (count == 3 )
                    return true;
                else
                    count=0;
            }

            //check diagonal
            for ( int i =  0, j = 0 ; i < 3 && j < 3 ; i++, j++)
            {
                if (main_arr[i][j] == 0)
                {
                    count ++;
                }
            }
            if (count == 3 )
                return true;
            else
                count=0;

            for ( int i = 3-1 , j = 3-1 ;  i >=0 & j >= 0 ; i-- , j-- )
            {
                if (main_arr[i][j] == 0)
                {
                    count ++;
                }
            }
            if (count == 3 )
                return true;
            else
                count=0;


        }
        else if(symbol == 1)
        {
            for ( int i = 0 ; i < 3 ; i++)
            {
                for ( int j = 0 ; j < 3 ; j++)
                {
                    if (main_arr[i][j] == 1)
                    {
                        count ++;
                    }

                }
                if (count == 3 )
                    return true;
                else
                    count=0;
            }
            for ( int i = 0 ; i < 3 ; i++)
            {
                for ( int j = 0 ; j < 3 ; j++)
                {
                    if (main_arr[j][i] == 1)
                    {
                        count ++;
                    }

                }
                if (count == 3 )
                    return true;
                else
                    count=0;
            }

            //check diagonal
            for ( int i =  0, j = 0 ; i < 3 && j < 3 ; i++, j++)
            {
                if (main_arr[i][j] == 1)
                {
                    count ++;
                }
            }
            if (count == 3 )
                return true;
            else
                count=0;

            for ( int i = 3-1 , j = 3-1 ;  i >=0 & j >= 0 ; i-- , j-- )
            {
                if (main_arr[i][j] == 1)
                {
                    count ++;
                }
            }
            if (count == 3 )
                return true;
            else
                count=0;

        }
        return false;
    }
    
    boolean check_draw( )
    {
        
        for (int i = 0 ; i < row ; i++)
        {
            for ( int j = 0 ; j < col ; j++ )
            {
                if(main_arr[i][j] == -1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    void input_from_player( int row , int col ,int num , int num2, int symbol)
    {
        if(num< row && num2 < col)
        {
            if(main_arr[num][num2] == -1)
            {
                if(symbol == 0)
                {
                
                    main_arr[num][num2] = 0;
                }
                else if( symbol == 1)
                {
                    main_arr[num][num2] = 1;
                }
            }
            
        }    
    }
    void input_from_p2(int [][]arr , int row , int col ,int num , int num2)
    {
       

        

        if(num< row && num2 < col)
        {
            if(arr[num][num2] == -1)
            {
                arr[num][num2] = 1;
            }
        }
        
    }

    
}
