/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktaktoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author aqibj
 */
public class tiktakcontroller {
    private tictaktoemodel model;
    private tictak_gui gui;
    private int player_turn;
    String p1s , p2s; 
    int calculate ;
    boolean changed= false;
 
    public tiktakcontroller(tictaktoemodel m , tictak_gui g)
    {
        this.model = m;
        this.gui = g;
        gui.setVisible(true);
        player_turn = 1;
        p1s = "X";
        p2s = "0";
        calculate = 0;
        
    }
    
    public void initview()
    {
      
        gui.getjFrame1().setVisible(true);
        gui.getjPanel1().setVisible(false);
        gui.getjPanel2().setVisible(false);
        gui.getjButton10().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String p1=gui.getjTextField1().getText();
                String p2=gui.getjTextField2().getText();
                if(p1.length()!= 0 && p2.length() != 0 )
                {
                    gui.getjLabel3().setText(p1);
                    gui.getjLabel4().setText(p2);
                    gui.getjPanel1().setVisible(true);
                    gui.getjPanel2().setVisible(true);
                    gui.getjFrame1().setVisible(false);
                }
                else 
                    gui.getjLabel7().setText("Please enter both name");
                
             
            }
        });
        this.reset_game();
        
    }
    
     public void change_board()
    {
        int row = calculate/3;
        int col = calculate%3;
        int symbol = 0;
        boolean result;
        if(player_turn == 0)
        {
            symbol =0;
        }
        else
        {
            symbol = 1;
        }
        model.input_from_player(3, 3, row, col, symbol);
        result = model.check_winner(row, col, symbol);
        System.out.println(result);
        if(result == false)
        {
            System.out.println(result);
            result = model.check_draw();
            if (result == true)
            {
                JOptionPane.showMessageDialog(gui, "game draw");
            }
            
            
        }
        else if( result == true)
        {
            System.out.println(result);
            JOptionPane.showMessageDialog(gui, "Player" + Integer.toString(player_turn+ 1)+ " wins");
            this.reset_game_hard();
        }
        
        
        
    }
     
    public void reset_game()
    {
        JButton btn = gui.getReset_button();
        btn.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent ae ) {
                    ArrayList<JButton> btn_arr = new ArrayList<JButton>();
                    btn_arr.add(gui.getjButton1());
                    btn_arr.add(gui.getjButton2());
                    btn_arr.add(gui.getjButton3());
                    btn_arr.add(gui.getjButton4());
                    btn_arr.add(gui.getjButton5());
                    btn_arr.add(gui.getjButton6());
                    btn_arr.add(gui.getjButton7());
                    btn_arr.add(gui.getjButton8());
                    btn_arr.add(gui.getjButton9());
                    for ( int i = 0 ; i < btn_arr.size();i++)
                    {
                        btn_arr.get(i).setText("");
                    }
                    model.Initialise_Board(model.getMain_arr(), 3, 3);
        
                }
        });
    }
      public void reset_game_hard()
    {
        JButton btn = gui.getReset_button();
        
        ArrayList<JButton> btn_arr = new ArrayList<JButton>();
        btn_arr.add(gui.getjButton1());
        btn_arr.add(gui.getjButton2());
        btn_arr.add(gui.getjButton3());
        btn_arr.add(gui.getjButton4());
        btn_arr.add(gui.getjButton5());
        btn_arr.add(gui.getjButton6());
        btn_arr.add(gui.getjButton7());
        btn_arr.add(gui.getjButton8());
        btn_arr.add(gui.getjButton9());
        for ( int i = 0 ; i < btn_arr.size();i++)
        {
            btn_arr.get(i).setText("");
        }
        model.Initialise_Board(model.getMain_arr(), 3, 3);
        
                
    
    }
     
    public void play()
    {
        ArrayList<JButton> btn_arr = new ArrayList<JButton>();
        btn_arr.add(gui.getjButton1());
        btn_arr.add(gui.getjButton2());
        btn_arr.add(gui.getjButton3());
        btn_arr.add(gui.getjButton4());
        btn_arr.add(gui.getjButton5());
        btn_arr.add(gui.getjButton6());
        btn_arr.add(gui.getjButton7());
        btn_arr.add(gui.getjButton8());
        btn_arr.add(gui.getjButton9());
        
        for (int  i = 0 ; i < btn_arr.size() ;i++)
        {
            btn_arr.get(i).addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent ae ) {
                    
                    for ( int i = 0 ; i < btn_arr.size() ;i++)
                    {
                        if(btn_arr.get(i) == ae.getSource())
                        {
                            
                            if(btn_arr.get(i).getText().isEmpty())
                            {
                                if(player_turn == 0)
                                {
                                    btn_arr.get(i).setText(p1s);
                                }
                                else if(player_turn == 1)
                                {
                                    btn_arr.get(i).setText(p2s);
                                }
                                player_turn++;
                                player_turn = player_turn %2;
                                gui.getjLabel8().setText("player " + Integer.toString(player_turn+1)+ " turn");
                                changed = true;
                                calculate = i;
                            }
                        }
                    }
                    
                }
            });
        }
        
        
        
        while (true)
        {
            if (changed == true)
            {
                System.out.println("Board was changed");
                this.change_board();
                changed= false;
            }
        }
        
        
    }
    
   
    
}
