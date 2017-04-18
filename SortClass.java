//David Radke
//GUI for sort
//November 1, 2016

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class SortClass extends JFrame implements ActionListener
{
   //declare everything
   JPanel myPanel;
   JButton calculate; 
   JTextField myText;
   JTextField myText1;
   JTextField myText2;
   JTextField myText3;
   JTextField myText4;
   JTextArea textArea;
   JScrollPane scrollPane;
   JLabel myLabel;
   JLabel myLabel2;
   JLabel myLabel3;
   JLabel myLabel4;
   JLabel myLabel5;
   JLabel myLabel6;
   JLabel myLabel7;
   
   
   int counter = 0;
   int counter2 = 0;
   int counter3 = 0;
   int counter4 = 0;
   public static int counter5 = 0;
   
   
   public SortClass()
   {
      setSize(600,500);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      myPanel = new JPanel(); 
      
      calculate = new JButton("Pick a File"); //creates a button
      calculate.addActionListener(this); 
      calculate.setBounds(50,250,130,40);
      
      myText = new JTextField("Selection: ",160); //creates a textfield
      myText.addActionListener(this); 
      myText.setBounds(50,50,200,20);
      
      myLabel2 = new JLabel("Selection Worst Case: N(N-1)/2"); //creates a label
      myLabel2.setBounds(250,50,450,20);
      
      myText1 = new JTextField("Bubble: ",160); //creates a textfield
      myText1.addActionListener(this); 
      myText1.setBounds(50,80,200,20);
      
      myLabel3 = new JLabel("Bubble Worst Case: N(N-1)/2"); //creates a label
      myLabel3.setBounds(250,80,450,20);
      
      myText2 = new JTextField("Insertion: ",160); //creates a textfield
      myText2.addActionListener(this); 
      myText2.setBounds(50,110,200,20);
      
      myLabel4 = new JLabel("Insertion Worst Case: N(N-1)/2"); //creates a label
      myLabel4.setBounds(250,110,450,20);
      
      myText3 = new JTextField("Quicksort: ",160); //creates a textfield
      myText3.addActionListener(this); 
      myText3.setBounds(50,140,200,20);
      
      myLabel5 = new JLabel("Quicksort Worst Case: N(N-1)/2"); //creates a label
      myLabel5.setBounds(250,140,450,20);
      
      myText4 = new JTextField("Merge: ",160); //creates a textfield
      myText4.addActionListener(this); 
      myText4.setBounds(50,170,200,20);
      
      myLabel6 = new JLabel("MergeSort Worst Case: (logN)N - (N-1)"); //creates a label
      myLabel6.setBounds(250,170,450,20);
      
      myLabel7 = new JLabel("For Worst Case: file of 10, N = 10...etc"); //creates a label
      myLabel7.setBounds(250,200,500,20);
      
      myLabel = new JLabel("See the Number of Comparisons:"); //creates a label
      myLabel.setBounds(55,27,450,20);
      
      myPanel.setLayout(null); 
      myPanel.add(myLabel); //adds everything to the panel
      myPanel.add(myLabel2);
      myPanel.add(myLabel3);
      myPanel.add(myLabel4);
      myPanel.add(myLabel5);
      myPanel.add(myLabel6);
      myPanel.add(myLabel7);
      myPanel.add(myText);
      myPanel.add(calculate); 
      myPanel.add(myText1);
      myPanel.add(myText2);
      myPanel.add(myText3);
      myPanel.add(myText4);
      
      add(myPanel);      //adds panel
      setVisible(true);
   }
   
   public void actionPerformed(ActionEvent evt)
   {
      if(evt.getSource() == calculate) //if add button is pressed
      {
         try
         {
         JFileChooser myChooser = new JFileChooser(); //initializes JFileChooser
         int input = myChooser.showOpenDialog(null);
         
         Scanner myScanner = new Scanner(myChooser.getSelectedFile());
         
         ArrayList<Integer> list1 = new ArrayList<Integer>(); //initializes ArrayList
         
         while(myScanner.hasNextLine())
         {
            int value = Integer.valueOf(myScanner.nextLine());//scans file and adds value to ArrayList
            list1.add(value);
         }
         
         int[] list = new int[list1.size()];//initializes new array
         
         for(int i = 0; i < list1.size(); i++)//fills a new int array with a set size
            list[i] = list1.get(i);
      
         
         int x = SelectionSort(list);
         int y = BubbleSort(list);
         int z = InsertionSort(list);
         int low = 0;
         int high = list.length - 1;
         
         int[] listCopy1 = new int[list.length]; //copies array
            System.arraycopy(list, 0, listCopy1, 0, list.length);
         int a = Quicksort(listCopy1, low, high);
         
         int[] listCopy2 = new int[list.length];
            System.arraycopy(list, 0, listCopy2, 0, list.length);
         int b = MergeSort(listCopy2);
         
         myText.setText("Selection: " + x);//prints out counters
         myText1.setText("Bubble: " + y);
         myText2.setText("Insertion: " + z);
         myText3.setText("Quicksort: " + a);
         myText4.setText("Mergesort: " + b);
         }
         catch(FileNotFoundException myError)
         {
            myText.setText("Error");
         }
         
         
      }
      else    //if enter is pressed
      { 
         try
         {
         JFileChooser myChooser = new JFileChooser(); //initializes JFileChooser
         int input = myChooser.showOpenDialog(null);
         
         Scanner myScanner = new Scanner(myChooser.getSelectedFile());
         
         ArrayList<Integer> list1 = new ArrayList<Integer>(); //initializes ArrayList
         
         while(myScanner.hasNextLine())
         {
            int value = Integer.valueOf(myScanner.nextLine());//scans file and adds value to ArrayList
            list1.add(value);
         }
         
         int[] list = new int[list1.size()];//initializes new array
         
         for(int i = 0; i < list1.size(); i++)//fills a new int array with a set size
            list[i] = list1.get(i);
         
         int x = SelectionSort(list);
         int y = BubbleSort(list);
         int z = InsertionSort(list);
         int low = 0;
         int high = list.length - 1;
         
         int[] listCopy1 = new int[list.length]; //copies array
            System.arraycopy(list, 0, listCopy1, 0, list.length);
         
         int a = Quicksort(listCopy1, low, high);
         
         int[] listCopy2 = new int[list.length];
            System.arraycopy(list, 0, listCopy2, 0, list.length);
         int b = MergeSort(listCopy2);
         
         myText.setText("Selection: " + x);//prints out counters
         myText1.setText("Bubble: " + y);
         myText2.setText("Insertion: " + z);
         myText3.setText("Quicksort: " + a);
         myText4.setText("Mergesort: " + b);
         }
         catch(FileNotFoundException myError)
         {
            myText.setText("Error");
         }         
      }
   }
   
public int SelectionSort (int[] list)
{   
    int[] listCopy = new int[list.length];
    System.arraycopy(list, 0, listCopy, 0, list.length); //copies original array
    int min = 0;   
    for(int i = 0; i < listCopy.length; i++)   //locate smallest element between positions 1 and i.
          {
               min = i;
               for(int j = i + 1; j < listCopy.length; j++) 
               {
                  counter++; //counter increments
                  if (listCopy[j] < listCopy[min])
                     min = j;
               }
               if(min != i) 
               {
                  final int temp = listCopy[i];
                  listCopy[i] = listCopy[min];
                  listCopy[min] = temp;
               }
        }
        return counter;
}//closing for selection sort
    
public int BubbleSort(int[] list) //change. need a while loop
{
    int[] listCopy = new int[list.length];
    System.arraycopy(list, 0, listCopy, 0, list.length);//copies original array
    
    int n = listCopy.length;
    int temp = 0;

    for(int i = 0; i < listCopy.length; i++) 
    {
        for(int j = 1; j < listCopy.length - i; j++) 
        {
            counter2++;
            if(listCopy[j - 1] > listCopy[j]) 
            {
                temp = listCopy[j - 1];
                listCopy[j - 1] = listCopy[j];
                listCopy[j] = temp;
            }
        }
    }
    return counter2;
}    //closes bubble method

public int InsertionSort(int[] list)
{
   int[] listCopy = new int[list.length];
   System.arraycopy(list, 0, listCopy, 0, list.length);//copies original array

   for(int i = 1; i < listCopy.length; i++)
   {
      int next = listCopy[i];
      int j = i;
      //might hit while loop and not go in, maybe counter inside the argument?//////////////////
      while(j > 0 && listCopy[j - 1] > next)
      {
         counter3++;
         listCopy[j] = listCopy[j - 1];
         j--;
      }
      listCopy[j] = next;
   }
   return counter3;
}//closes insertionSort

public int Quicksort(int[] list, int low, int high)
{
   int temp = 0;
   
   if(list.length == 0)
      return 0;
   if(low > high)
      return 0;
      
   int mid = low + (high - low) / 2;//initializes middle
   int pivot = list[mid];//initializes pivot
   int i = low;
   int j = high;
   
   while(i <= j)
   {
      while(list[j] > pivot)
      {
         j--;
         counter4++;
      }
      while(list[i] < pivot)
      {
         i++;
         counter4++;
      }
      if(i <= j)
      {
         temp = list[i];//swaps
         list[i] = list[j];
         list[j] = temp;
         i++;
         j--;
      }
   }
   if(low < j)
   {
      Quicksort(list, low, j);//recursively calls Quicksort
   }
   if(high > i)
   {
      Quicksort(list, i, high);//recursively calls Quicksort
   }
   return counter4;
} //closing bracket for quicksort

public static int MergeSort(int[] list)
{
   if(list.length <= 1)
      return 0;
      
   int[] first = new int[list.length/2];//new array
   int[] second = new int[list.length - first.length];//new array
   
   counter5++;
   System.arraycopy(list, 0, first, 0, first.length);//copies array
   System.arraycopy(list, first.length, second, 0, second.length);//copies array
   
   MergeSort(first);//recursively calls MergeSort
   MergeSort(second);
   merge(first, second, list);//calls merge
   
   return counter5;
   
}  //Closes mergeSort

public static int merge(int[] first, int[] second, int[] newList)  
{
   int i = 0;//initializes variables
   int j = 0;
   int k = 0;
   
   while(i < first.length && j < second.length)
   {
      if(first[i] < second[j])//comparison
      {
         newList[k] = first[i]; 
         i++;
         counter5++;
      }
      else //comparison
      {
         newList[k] = second[j];
         j++;
         counter5++;
      }
      k++;
   }
   System.arraycopy(first, i, newList, k, first.length - i); //copies array
   System.arraycopy(second, j, newList, k, second.length- j);//copies array
   
   return 0;
}//closes merge    
}