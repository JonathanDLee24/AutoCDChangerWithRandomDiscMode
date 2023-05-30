/*
Program request: Michael Licciardello Help to learn arrays DB post

You have decided to get real crazy with arrays, the random class in Java, and also 
testing yourself with String equality. You want to create a large array with each element 
filled by one of the elements in another array (randomly selected from the baseline array) 
and, at the end, provide both a count of each element and the overall percentage of each 
element compared to the total array length.
Broken down:
Create a baseline String array of 5 elements. One example would be 
{apple, banana, peach, pear, orange}. Yours could be {green, blue, yellow, brown, 
fire engine red}. Either way, five different String elements. This is the list from which every 
element in the large array will be filled.
Create a separate large String array of 500 and let it auto-initialize everything to null values.
Fill each element of the large array with a randomly selected element from the baseline array. Use a 
For loop and the random class along with the index statement to do this. 
Once the large array is filled, traverse it again to count how many time each baseline element 
is in there. Can be accomplished with another for loop and a handful of if statements. You'll 
likely need to initialize separate element variables to keep count. Increment the count variables 
with each element checked.
Using the final counts for each baseline element, show the total count for each and the overall 
percentage of the large array was filled. For example: if the large array had 80 orange entries,
you would display 80 as the total count for oranges and then show 16.0% as the percentage (80 / 500) * 100.  
"80 oranges in the array = 16.0% of the total entries"

Solution Author: Jonathan Lee
Professor: Gita Faroughi
Class: Sierra College CSCI12
Date: May 1 2021

*/
import java.util.*;
public class AutoCDChangerWithRandomDiscMode
{
   public static void main (String args[])
   {
      Random rand = new Random(); // my random is called rand
      
      String[][] changer = {
         /*CD1*/{"Summer Lane (feat. Mick Smiley) Owenstone Mick Smiley","This Is the Life (Amy Macdonald)", "Sweet Potato (Cracker)", "Surfer Girl (Home Grown)", "Kind and Generous (Natalie Merchant)"},
         /*CD2*/{"Blues Traveler Run-Arround","Blues Traveler Stand","Blues Traveler Look Arround","Blues Traveler Fallible","Blues Traveler The Mountains Win Again","Blues Traveler Freedom","Blues Traveler Crash Burn","Blues Traveler Price to pay","Blues Traveler Hook","Blues Traveler The Good, The Bad, And The Ugly","Blues Traveler Just Wait","Blues Traveler Brother John"},
         /*CD3*/{"10,000 Maniacs, Noah's Dove","10,000 Maniacs, These Are Days","10,000 Maniacs,Eden","10,000 Maniacs Few and Far Between","10,000 Maniacs, Stockton Gala Days","10,000 Maniacs, Gold Rush Brides","10,000 Maniacs, Jezebel","How You've Grown","10,000 Maniacs, Candy Everybody Wants","10,000 Maniacs, Tolerance","10,000 Maniacs, Circle Dream","10,000 Maniacs, If You Intend","10,000 Maniacs, I'm Not The Man"},  
         /*CD4*/{"Running With The Devil", "Eruption", "You Really Got Me", "Ain't Talkin' 'Bout Love", "I'm The One", "Jamie's Crying'", "Atomic Punk", "Feel Your Love Tonight", "Little Dreamer", "Ice Cream Man", "On Fire"},
         };
         
      /*Array auto CD changer is the song list. Change it to any length or amount of songs and this will still 
      work.*/ 
   
      String[] autochanger = new String [500]; //This makes me a empty array of size 500
      
      int totalrows = changer.length;// total rows
      int totalsongs = 0; // total songs 
   
      for (int i = 0; i<changer.length; i++)
      {
         for (int j = 0; j<changer[i].length; j++)
         {
            totalsongs++; // finds total songs this would be very slow on a CD changer as it would have to read everything each time
         }
      }
      
      String [] songlist = new String [totalsongs]; // new string with all songs for true random generations
      int k = 0;// k is counter for all songs for new array locator
      for (int i = 0; i<changer.length; i++) // loop for new array for random generations
      {
         for (int j = 0; j<changer[i].length; j++)
         {
            songlist[k] = changer[i][j]; // finds total songs this would be very slow on a CD changer as it would have to read everything each time
            k++;
         }
      }
      
      
      for (int i = 0; i<autochanger.length; i++) // This loop iterates over the size of the new array 500 that we set
      {
         autochanger[i] = songlist[rand.nextInt(songlist.length)]; // Each time that i is used it sets a random entery from changer this happens 500 times
      }
      
      System.out.println("\t\t\tThe Jukebox's auto que ran "+autochanger.length+ " times\n");
      System.out.println("\t\t\tThe Jukebox is currently holding "+totalsongs+" songs\n");
      
      for (int i = 0; i<changer.length; i++) // This loop iterates over the length of the changer array that has the song names 
      {
         for(int j = 0; j<changer[i].length; j++)
         {
            String s = changer[i][j]; // Sets up the string to the string at i as it moves i=0 then i=1. . .
            int pos = find(s, autochanger); // Passes string and the array autochanger to find method for a count
            double len = autochanger.length; // Must be set to a double for finding the percent
            double avg = (pos/len)*100; // Equation for finding the average
            System.out.println(changer[i][j]+" was randomly played "+pos+" times, \nthis is "+ avg +"% of the total "+autochanger.length+" plays overall"); // prints out each time
            System.out.println(); // prints new line each loop
         }
      }
   }
   
   /* 
   This method takes a string and the array random generated 
   autochanger array and iterates over it to find how many 
   occurances of the string is there
   */
   public static int find (String s, String[] autochanger)
   {
      int counter = 0; // Variable for the return value
      
      for(int i = 0; i<autochanger.length; i++) // This iterates over the random generated array that is 500 
      {
         if (autochanger[i] == s) // If the array item is equal to the string we found a match
         {
            counter++; // Count how many times the string is seen
         }
      }
      return counter; // Returns how many times this string is in the array
   }
}
