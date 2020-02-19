// Hamir Mahal
// Started 9/19/2016

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;	// Needed for the Scanner class
import java.io.*;

/**
	This program helps the user solve any Hangman puzzle.
*/

public class HangmanSolver {
	
	/**
	 * The sortDictionary method takes an alphabetized text file and sorts the String entries in that text file 
	 * alphabetically into new text files based on their length.
	 */
	
	public void sortDictionary () throws IOException {
		
		// Make sure the file exists.
		File file = new File("dictionary.txt");
		if (!file.exists())
		{
			System.out.println("Eclipse was unable to find \"dictionary.txt\". "
					+ "Please try moving the file to a location where Eclipse can find it.");
			System.exit(0);
		}
		
		// Open the file for reading.
		Scanner inputFile = new Scanner(file);
		
		// Open the files for output.
		PrintWriter outputFile1 =  new PrintWriter("dictionary1.txt");
		PrintWriter outputFile2 =  new PrintWriter("dictionary2.txt");
		PrintWriter outputFile3 =  new PrintWriter("dictionary3.txt");
		PrintWriter outputFile4 =  new PrintWriter("dictionary4.txt");
		PrintWriter outputFile5 =  new PrintWriter("dictionary5.txt");
		PrintWriter outputFile6 =  new PrintWriter("dictionary6.txt");
		PrintWriter outputFile7 =  new PrintWriter("dictionary7.txt");
		PrintWriter outputFile8 =  new PrintWriter("dictionary8.txt");
		PrintWriter outputFile9 =  new PrintWriter("dictionary9.txt");
		PrintWriter outputFile10 =  new PrintWriter("dictionary10.txt");
		PrintWriter outputFile11 =  new PrintWriter("dictionary11.txt");
		PrintWriter outputFile12 =  new PrintWriter("dictionary12.txt");
		PrintWriter outputFile13 =  new PrintWriter("dictionary13.txt");
		PrintWriter outputFile14 =  new PrintWriter("dictionary14.txt");
		PrintWriter outputFile15 =  new PrintWriter("dictionary15.txt");
		PrintWriter outputFile16 =  new PrintWriter("dictionary16.txt");
		PrintWriter outputFile17 =  new PrintWriter("dictionary17.txt");
		PrintWriter outputFile18 =  new PrintWriter("dictionary18.txt");
		PrintWriter outputFile19 =  new PrintWriter("dictionary19.txt");
		PrintWriter outputFile20 =  new PrintWriter("dictionary20.txt");
		PrintWriter outputFile21 =  new PrintWriter("dictionary21.txt");
		PrintWriter outputFile22 =  new PrintWriter("dictionary22.txt");
		
		// Reads line from the file until there are no more lines remaining
		while(inputFile.hasNext())
		{
			// Read the next word.
			String word = inputFile.nextLine();
			
			// Write the word into a new text file depending on the number of letters it has
			// Uses a switch statement!
			switch (word.length())
			{
				case 1:
					// Write the word to the output file that contains only 1-letter words
					outputFile1.println(word);
					break;
				case 2:
					// Write the word to the output file that contains only 2-letter words
					outputFile2.println(word);
					break;
				case 3:
					// Write the word to the output file that contains only 3-letter words
					outputFile3.println(word);
					break;
				case 4:
					// Write the word to the output file that contains only 4-letter words
					outputFile4.println(word);
					break;
				case 5:
					// Write the word to the output file that contains only 5-letter words
					outputFile5.println(word);
					break;
				case 6:
					// Write the word to the output file that contains only 6-letter words
					outputFile6.println(word);
					break;
				case 7:
					// Write the word to the output file that contains only 7-letter words
					outputFile7.println(word);
					break;
				case 8:
					// Write the word to the output file that contains only 8-letter words
					outputFile8.println(word);
					break;
				case 9:
					// Write the word to the output file that contains only 9-letter words
					outputFile9.println(word);
					break;
				case 10:
					// Write the word to the output file that contains only 10-letter words
					outputFile10.println(word);
					break;
				case 11:
					// Write the word to the output file that contains only 11-letter words
					outputFile11.println(word);
					break;
				case 12:
					// Write the word to the output file that contains only 12-letter words
					outputFile12.println(word);
					break;
				case 13:
					// Write the word to the output file that contains only 13-letter words
					outputFile13.println(word);
					break;
				case 14:
					// Write the word to the output file that contains only 14-letter words
					outputFile14.println(word);
					break;
				case 15:
					// Write the word to the output file that contains only 15-letter words
					outputFile15.println(word);
					break;
				case 16:
					// Write the word to the output file that contains only 16-letter words
					outputFile16.println(word);
					break;
				case 17:
					// Write the word to the output file that contains only 17-letter words
					outputFile17.println(word);
					break;
				case 18:
					// Write the word to the output file that contains only 18-letter words
					outputFile18.println(word);
					break;
				case 19:
					// Write the word to the output file that contains only 19-letter words
					outputFile19.println(word);
					break;
				case 20:
					// Write the word to the output file that contains only 20-letter words
					outputFile20.println(word);
					break;
				case 21:
					// Write the word to the output file that contains only 21-letter words
					outputFile21.println(word);
					break;
				case 22:
					// Write the word to the output file that contains only 22-letter words
					outputFile22.println(word);
					break;
				default:
					System.out.println("The program didn't anticipate words over 22 characters in length. "
							+ "Modify the source code to continue.");
			}	
		}
	
		// Close the files.
		inputFile.close();
		outputFile1.close();
		outputFile2.close();
		outputFile3.close();
		outputFile4.close();
		outputFile5.close();
		outputFile6.close();
		outputFile7.close();
		outputFile8.close();
		outputFile9.close();
		outputFile10.close();
		outputFile11.close();
		outputFile12.close();
		outputFile13.close();
		outputFile14.close();
		outputFile15.close();
		outputFile16.close();
		outputFile17.close();
		outputFile18.close();
		outputFile19.close();
		outputFile20.close();
		outputFile21.close();
		outputFile22.close();
	}
	
	/**
	 * The getNumberOfLetters method takes an integer from the user corresponding to the number of letters
	 * the user needs to solve the Hangman challenge.
	 */
	
	public int getNumberOfLetters()
	{
		int numberOfLetters;
		
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);
		
		// Get the number of letters in the current Hangman puzzle from the user
		System.out.println("How many letters does the Hangman puzzle have? ");
		numberOfLetters = keyboard.nextInt();
		
		// Verify that the number of letters in the challenge is valid
		while (numberOfLetters < 1 || numberOfLetters > 45)
		{
			// Consume the remaining newline character.
			keyboard.nextLine();
			System.out.println("Please verify that the length of the puzzle is correct, "
					+ "and then re-type the length here. ");
			numberOfLetters = keyboard.nextInt();
		}
		
		return numberOfLetters;
	}
}