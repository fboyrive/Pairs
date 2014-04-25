package hku.view;

import hku.game.*;

import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.CompoundBorder;

import javax.swing.JPanel;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.Box;
import javax.swing.JLabel;


public class PanOptions extends PanBackground implements ActionListener{
	private static final long serialVersionUID = -4096127076126433656L;
	
    private WinMain main_frame;
    private Font font;
    private JLabel title;
    private InputStream is;
    private Color c = Color.WHITE;
    private int adv = 115;
    private int hgt = 20;
    private int sizeChar = 30;
    private String name_font;
    private JPanel panCenter;
   
    private JPanel panPlayer;
    private JPanel panNoCards;
    private JPanel panTypeCards;
    private JRadioButton onePlayer;
    private JRadioButton twoPlayer;
    
    private JRadioButton twos;
    private JRadioButton fours;
    private JRadioButton sixs;
    
    private JRadioButton latinLetters;
    private JRadioButton latinWords;
    private JRadioButton math1;
    private JRadioButton math2;
    
    
    public PanOptions(WinMain main_frame){
        
        super(main_frame, false);
        panCenter = this.getPanCenter();
        this.main_frame = main_frame;
        
        name_font = new String("EraserRegular.ttf");
        try{
            is = new FileInputStream(name_font);
            try{
                font = Font.createFont(Font.TRUETYPE_FONT, is);
                font = font.deriveFont(Font.BOLD, sizeChar);
                //font.setBackground(new Color(0,0,0,0));
            }catch(Exception ie){
                ie.printStackTrace();
                System.err.println(name_font + " not loaded.  Using TimesRoman font.");
                font = new Font("TimesRoman",Font.BOLD,sizeChar);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        initPanOptions();
    }
    
    private void initPanOptions(){
        panCenter.setLayout(new BorderLayout(10,10));
        
        panCenter.setBackground(new Color(0,0,0,0));
         title = new JLabel("Options"); 
         Border margin = BorderFactory.createEmptyBorder(30, 200, 20, 0);
         title.setBorder(margin);
         title.setFont(font);
         title.setForeground(Color.WHITE);
         panCenter.add(title, BorderLayout.NORTH);
         font = font.deriveFont(Font.BOLD, 12);
         addPanNoPlayer();
         addPanNoCards();
         addPanTypeCards();
    }
    
    private void addPanNoPlayer(){
        panPlayer = new JPanel();
        panPlayer.setLayout(new BoxLayout(panPlayer, BoxLayout.Y_AXIS));
        panPlayer.setPreferredSize(new Dimension(200,80));
        
        Border margin = BorderFactory.createEmptyBorder(0, 35, 40, 0);
        Border border1 = BorderFactory.createLineBorder(Color.WHITE, 2);
        Border border = new CompoundBorder(margin, border1);
        TitledBorder borderPlayer = BorderFactory.createTitledBorder(border,"No. of Player", TitledBorder.LEFT,TitledBorder.TOP, font, Color.WHITE );
        borderPlayer.setTitleFont(font);
        borderPlayer.setTitleColor(Color.WHITE);
        panPlayer.setBackground(new Color(0,0,0,0));
        panPlayer.setBorder(borderPlayer);
        
        
        onePlayer = new JRadioButton("Single Player");
        onePlayer.setForeground(Color.WHITE);
        onePlayer.setBackground(new Color(0,0,0,0));
        onePlayer.setActionCommand("Single Player");
        onePlayer.setFont(font);
        twoPlayer = new JRadioButton("Two Players");
        twoPlayer.setForeground(Color.WHITE);
        twoPlayer.setBackground(new Color(0,0,0,0));
        twoPlayer.setFont(font);
        
        if(Constants.twoPlayer)
            twoPlayer.setSelected(true);
        else
            onePlayer.setSelected(true);
        
        //we group the buttons because we want only one of them to be checked at a time
        ButtonGroup group = new ButtonGroup();
        group.add(onePlayer);
        group.add(twoPlayer);
        
        ActionListener actionListener;
        
        actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //if(e.getSource() ==onePlayer){
                        if(onePlayer.isSelected()){
                        Constants.twoPlayer = false;
                        
                    }
                    else
                        Constants.twoPlayer = true;
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
        panNoCards = new JPanel();
        panNoCards.setLayout(new BoxLayout(panNoCards, BoxLayout.Y_AXIS));
        Border margin = BorderFactory.createEmptyBorder(0, 0, 40, 0);
        Border border1 = BorderFactory.createLineBorder(Color.WHITE, 2);
        Border border = new CompoundBorder(margin, border1);
        panNoCards.setPreferredSize(new Dimension(70,80));

        TitledBorder borderPlayer = BorderFactory.createTitledBorder(border,"No. of Cards", TitledBorder.LEFT,TitledBorder.TOP, font, Color.WHITE );
        borderPlayer.setTitleFont(font);
        borderPlayer.setTitleColor(Color.WHITE);
        panNoCards.setBackground(new Color(0,0,0,0));
        panNoCards.setBorder(borderPlayer);
        
        
        twos = new JRadioButton("2x2");
        twos.setForeground(Color.WHITE);
        twos.setBackground(new Color(0,0,0,0));
        twos.setFont(font);
        fours = new JRadioButton("4x4");
        fours.setForeground(Color.WHITE);
        fours.setBackground(new Color(0,0,0,0));
        fours.setFont(font);
        sixs = new JRadioButton("6x6");
        sixs.setForeground(Color.WHITE);
        sixs.setBackground(new Color(0,0,0,0));
        sixs.setFont(font);
        
        if(Constants.cardsPerRow == 2)
            twos.setSelected(true);
        else if(Constants.cardsPerRow == 4)
            fours.setSelected(true);
        else
            sixs.setSelected(true);
        
        //we group the buttons because we want only one of them to be checked at a time
        ButtonGroup group = new ButtonGroup();
        group.add(twos);
        group.add(fours);
        group.add(sixs);
        
        ActionListener actionListener;
        
        actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == twos){
                        Constants.cardsPerRow = 2;
                        Constants.cardsPerColumn = 2;
                        Constants.cardImageSize = 300;
                        Constants.cardSize = 340;
                        Constants.cardsFontSize = 50;
                    }
                    else if(e.getSource() == fours){
                        Constants.cardsPerRow = 4;
                        Constants.cardsPerColumn = 4;
                        Constants.cardImageSize = 158;
                        Constants.cardSize = 175;
                        Constants.cardsFontSize = 30;
                    }
                    else{
                        Constants.cardsPerRow = 6;
                        Constants.cardsPerColumn = 6;
                        Constants.cardImageSize = 100;
                        Constants.cardSize = 115;
                        Constants.cardsFontSize = 20;
                    }
                    }
            };
        
        twos.addActionListener(actionListener);
        fours.addActionListener(actionListener);
        sixs.addActionListener(actionListener);
        
        panNoCards.add(Box.createRigidArea(new Dimension(20,20)));
        panNoCards.add(twos);
        panNoCards.add(fours);
        panNoCards.add(sixs);
        
        panCenter.add(panNoCards, BorderLayout.CENTER);
    }

    private void addPanTypeCards(){
        panTypeCards = new JPanel();
        panTypeCards.setLayout(new BoxLayout(panTypeCards, BoxLayout.Y_AXIS));
        panTypeCards.setPreferredSize(new Dimension(200,80));
        Border margin = BorderFactory.createEmptyBorder(0, 0, 40, 35);
        Border border1 = BorderFactory.createLineBorder(Color.WHITE, 2);
        Border border = new CompoundBorder(margin, border1);
        TitledBorder borderPlayer = BorderFactory.createTitledBorder(border,"Type Of cards", TitledBorder.LEFT,TitledBorder.TOP, font, Color.WHITE );
        borderPlayer.setTitleFont(font);
        borderPlayer.setTitleColor(Color.WHITE);
        panTypeCards.setBackground(new Color(0,0,0,0));
        panTypeCards.setBorder(borderPlayer);
        
        
        latinLetters = new JRadioButton("Latin Letters");
        latinLetters.setForeground(Color.WHITE);
        latinLetters.setBackground(new Color(0,0,0,0));
        latinLetters.setFont(font);
        latinWords = new JRadioButton("Latin Words");
        latinWords.setForeground(Color.WHITE);
        latinWords.setBackground(new Color(0,0,0,0));
        latinWords.setFont(font);
        math1 = new JRadioButton("Math level 1");
        math1.setForeground(Color.WHITE);
        math1.setBackground(new Color(0,0,0,0));
        math1.setFont(font);
        math2 = new JRadioButton("Math level 2");
        math2.setForeground(Color.WHITE);
        math2.setBackground(new Color(0,0,0,0));
        math2.setFont(font);
        
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
        
        //we group the buttons because we want only one of them to be checked at a time
        ButtonGroup group = new ButtonGroup();
        group.add(latinLetters);
        group.add(latinWords);
        group.add(math1);
        group.add(math2);
        
        ActionListener actionListener;
        
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
