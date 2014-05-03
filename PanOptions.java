/*
 * The University of Hong Kong
 * Project Course ELEC 1503/2543 
 * 
 **** Pairs ****
 * Authors:
 * 	- Florian Boyrivent
 *  - Ian Cook
 *  - Lucie Thomas
 * 
 * Version 1.0 (04/05/2014)
 * All rights reserved
 */

package hku.view;

import hku.game.*;

import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.FileInputStream;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.CompoundBorder;

import javax.swing.JPanel;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Box;
import javax.swing.JLabel;


public class PanOptions extends PanBackground implements ActionListener{
// Option menu of the main panel, handeling different options and choice from the user
	
	private static final long serialVersionUID = -4096127076126433656L;
	
    private Font font;
    private JLabel title;
    private InputStream is;
    private final int sizeChar = 30;
    private String name_font;
    private JPanel panCenter;
   
    private JPanel panPlayer;
    private JPanel panNoCards;
    private JPanel panTypeCards;
    private JRadioButton onePlayer;
    private JRadioButton twoPlayer;
    
    private JRadioButton twos;
    private JRadioButton fours;
    private JRadioButton five;
    
    private JRadioButton latinLetters;
    private JRadioButton latinWords;
    private JRadioButton math1;
    private JRadioButton math2;
    
    private Border margin = BorderFactory.createEmptyBorder(0, 35, 40, 0);
    private Border border1 = BorderFactory.createLineBorder(Color.WHITE, 2);
    private Border border = new CompoundBorder(margin, border1);
    private TitledBorder borderPlayer = BorderFactory.createTitledBorder(border,"No. of Player", TitledBorder.LEFT,TitledBorder.TOP, font, Color.WHITE );
        
    private ButtonGroup group;
    
    private ActionListener actionListener;
    
    public PanOptions(WinMain main_frame){
        
        super(main_frame, false);
        panCenter = this.getPanCenter();
        // loading the font
        name_font = new String("EraserRegular.ttf");
        try{
            is = new FileInputStream(name_font);
            try{
                font = Font.createFont(Font.TRUETYPE_FONT, is);
                font = font.deriveFont(Font.BOLD, sizeChar);
            }catch(Exception ie){
            	JOptionPane.showMessageDialog(null, "Some fonts cannot be load, using 'Arial' instead","Inane warning",JOptionPane.WARNING_MESSAGE);
                font = new Font("Arial",Font.BOLD,sizeChar);
            }
        }catch(IOException e){
        	JOptionPane.showMessageDialog(null, "Some fonts cannot be load, using 'Arial' instead","Inane warning",JOptionPane.WARNING_MESSAGE);
            font = new Font("Arial",Font.BOLD,sizeChar);
        }
        initPanOptions();
    }
    
    private void initPanOptions(){
    // Initialisation of the option menu
        group = new ButtonGroup();
        panCenter.setLayout(new BorderLayout(10,10));
        panCenter.setBackground(new Color(0,0,0,0));
         title = new JLabel("OPTIONS");
         title.setBorder(Constants.marginTitle);
         title.setFont(font);
         title.setForeground(Color.WHITE);
         panCenter.add(title, BorderLayout.NORTH);
         font = font.deriveFont(Font.BOLD, 12);
         
         // adding 3 zones with radio buttons
         addPanNoPlayer();
         addPanNoCards();
         addPanTypeCards();
    }
    
    
    private void addPanNoPlayer(){
    	// this function adds on the left of the panCenter a set of radio buttons to choose the number of player
        // settings of the panel that contains the radio button that sets the number of players
        panPlayer = new JPanel();
        panPlayer.setLayout(new BoxLayout(panPlayer, BoxLayout.Y_AXIS));
        panPlayer.setPreferredSize(new Dimension(200,80));
        
        // the margin is used to place the new panel
        margin = BorderFactory.createEmptyBorder(0, 35, 40, 0);
        border = new CompoundBorder(margin, border1);
        borderPlayer = BorderFactory.createTitledBorder(border,"No. of Player", TitledBorder.LEFT,TitledBorder.TOP, font, Color.WHITE );
        borderPlayer.setTitleFont(font);
        borderPlayer.setTitleColor(Color.WHITE);
        panPlayer.setBackground(new Color(0,0,0,0));
        panPlayer.setBorder(borderPlayer);
        
        // The following lines are used to implement every radio buttons and define their settings
        onePlayer = new JRadioButton("SiNgle Player");
        onePlayer.setForeground(Color.WHITE);
        onePlayer.setBackground(Color.BLACK);
        onePlayer.setOpaque(false);
        onePlayer.setFocusPainted(false);
        onePlayer.setMnemonic(KeyEvent.VK_B);
        onePlayer.setActionCommand("Single Player");
        onePlayer.setFont(font);
        twoPlayer = new JRadioButton("Two Players");
        twoPlayer.setForeground(Color.WHITE);
        twoPlayer.setFocusPainted(false);
        twoPlayer.setBackground(Color.BLACK);
        twoPlayer.setOpaque(false);
        twoPlayer.setFont(font);
        
        if(Constants.twoPlayer)
            twoPlayer.setSelected(true);
        else
            onePlayer.setSelected(true);
        
        // we group the buttons because we want only one of them to be checked at a time
        group = new ButtonGroup();
        group.add(onePlayer);
        group.add(twoPlayer);
        
        
        actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Constants.twoPlayer = !onePlayer.isSelected();
                    }
            };
        
        panPlayer.add(Box.createRigidArea(new Dimension(20,20)));
        panPlayer.add(onePlayer);
        panPlayer.add(twoPlayer);
        
        onePlayer.addActionListener(actionListener);
        twoPlayer.addActionListener(actionListener);
        
        panCenter.add(panPlayer, BorderLayout.WEST);
    }
    
    private void addPanNoCards(){
        // this function adds on the middle of the panCenter a set of radio buttons to choose the number of card we want to play with
        // settings of the panel that holds the radio buttons
        panNoCards = new JPanel();
        panNoCards.setLayout(new BoxLayout(panNoCards, BoxLayout.Y_AXIS));
        margin = BorderFactory.createEmptyBorder(0, 0, 40, 0);
        border = new CompoundBorder(margin, border1);
        panNoCards.setPreferredSize(new Dimension(70,80));

        // settings of the margin that holds the radio buttons
        borderPlayer = BorderFactory.createTitledBorder(border,"No. of Cards", TitledBorder.LEFT,TitledBorder.TOP, font, Color.WHITE );
        borderPlayer.setTitleFont(font);
        borderPlayer.setTitleColor(Color.WHITE);
        panNoCards.setBackground(new Color(0,0,0,0));
        panNoCards.setBorder(borderPlayer);
        
        // settings of the radio buttons
        twos = new JRadioButton("2x2");
        twos.setForeground(Color.WHITE);
        twos.setBackground(Color.BLACK);
        twos.setOpaque(false);
        twos.setFocusPainted(false);
        twos.setFont(font);
        fours = new JRadioButton("4x4");
        fours.setForeground(Color.WHITE);
        fours.setFocusPainted(false);
        fours.setBackground(Color.BLACK);
        fours.setOpaque(false);
        fours.setFont(font);
        five = new JRadioButton("5x4");
        five.setFocusPainted(false);
        five.setForeground(Color.WHITE);
        five.setBackground(Color.BLACK);
        five.setOpaque(false);
        five.setFont(font);
        
        // defining where the initial button selected should be (according to what has been previously chosen
        if(Constants.cardsPerColumn == 2)
            twos.setSelected(true);
        else if(Constants.cardsPerColumn == 4)
            fours.setSelected(true);
        else
            five.setSelected(true);
        
        // we group the buttons because we want only one of them to be checked at a time
        group = new ButtonGroup();
        group.add(twos);
        group.add(fours);
        group.add(five);
        
        actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // the settings are different for each kind of matrix sizes
                    if(e.getSource() == twos){
                        Constants.cardsPerRow = 2;
                        Constants.cardsPerColumn = 2;
                        Constants.cardImageSize = 290;
                        Constants.cardSize = 325;
                        Constants.cardsFontSize = 48;
                    }
                    else if(e.getSource() == fours){
                        Constants.cardsPerRow = 4;
                        Constants.cardsPerColumn = 4;
                        Constants.cardImageSize = 141;
                        Constants.cardSize = 161;
                        Constants.cardsFontSize = 28;
                    }
                    else{
                        Constants.cardsPerRow = 4;
                        Constants.cardsPerColumn = 5;
                        Constants.cardImageSize = 115;
                        Constants.cardSize = 130;
                        Constants.cardsFontSize = 23;
                    }
                    }
            };
        
        // adding action listener to every radio button
        twos.addActionListener(actionListener);
        fours.addActionListener(actionListener);
        five.addActionListener(actionListener);
        
        // adding the button to the centre panel
        panNoCards.add(Box.createRigidArea(new Dimension(20,20)));
        panNoCards.add(twos);
        panNoCards.add(fours);
        panNoCards.add(five);
        
        // adding the center panel to the option panel
        panCenter.add(panNoCards, BorderLayout.CENTER);
    }

    private void addPanTypeCards(){
        // this function adds on the right of the panCenter a set of radio buttons to choose what type of cards the user wants to play with
        // settings of the centre panel
        panTypeCards = new JPanel();
        panTypeCards.setLayout(new BoxLayout(panTypeCards, BoxLayout.Y_AXIS));
        panTypeCards.setPreferredSize(new Dimension(200,80));
        margin = BorderFactory.createEmptyBorder(0, 0, 40, 35);
        border = new CompoundBorder(margin, border1);
        borderPlayer = BorderFactory.createTitledBorder(border,"Type Of cards", TitledBorder.LEFT,TitledBorder.TOP, font, Color.WHITE );
        borderPlayer.setTitleFont(font);
        borderPlayer.setTitleColor(Color.WHITE);
        panTypeCards.setBackground(new Color(0,0,0,0));
        panTypeCards.setBorder(borderPlayer);
        
        // settings of the radio buttons
        latinLetters = new JRadioButton("LATIN LETTERS");
        latinLetters.setForeground(Color.WHITE);
        latinLetters.setFocusPainted(false);
        latinLetters.setBackground(Color.BLACK);
        latinLetters.setOpaque(false);
        latinLetters.setFont(font);
        latinWords = new JRadioButton("LATIN WORDS");
        latinWords.setForeground(Color.WHITE);
        latinWords.setFocusPainted(false);
        latinWords.setBackground(Color.BLACK);
        latinWords.setOpaque(false);
        latinWords.setFont(font);
        math1 = new JRadioButton("Math level 1");
        math1.setForeground(Color.WHITE);
        math1.setBackground(Color.BLACK);
        math1.setOpaque(false);
        math1.setFocusPainted(false);
        math1.setFont(font);
        math2 = new JRadioButton("Math level 2");
        math2.setForeground(Color.WHITE);
        math2.setBackground(Color.BLACK);
        math2.setOpaque(false);
        math2.setFocusPainted(false);
        math2.setFont(font);
        
        // determining what type of cards has been previously selected
        switch (Constants.typeOfCardsOption){
            case 1: 
                latinLetters.setSelected(true);
                break;
            case 2: 
                latinWords.setSelected(true);
                break;
            case 3: 
                math1.setSelected(true);
                break;
            case 4: 
                math2.setSelected(true);
                break;
            default:
                break;
        }
        
        // we group the buttons because we want only one of them to be checked at a time
        group = new ButtonGroup();
        group.add(latinLetters);
        group.add(latinWords);
        group.add(math1);
        group.add(math2);
        
        actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == latinLetters){
                        Constants.typeOfCardsOption = 1;
                    }
                    else if(e.getSource() == latinWords)
                        Constants.typeOfCardsOption = 2;
                    else if(e.getSource() == math1)
                        Constants.typeOfCardsOption = 3;
                    else
                        Constants.typeOfCardsOption = 4;
                    }
            };
        
        latinLetters.addActionListener(actionListener);
        latinWords.addActionListener(actionListener);
        math1.addActionListener(actionListener);
        math2.addActionListener(actionListener);
        
        panTypeCards.add(Box.createRigidArea(new Dimension(20,20)));
        panTypeCards.add(latinLetters);
        panTypeCards.add(latinWords);
        panTypeCards.add(math1);
        panTypeCards.add(math2);
        
        panCenter.add(panTypeCards, BorderLayout.EAST);
    }
}
