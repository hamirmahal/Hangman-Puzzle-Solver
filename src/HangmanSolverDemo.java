// Hamir Mahal
// Started 9/20/2016
// Finished around January 2017

import java.util.Scanner;	// Needed for the Scanner class
import java.io.*;
import java.util.ArrayList;	// Needed for ArrayList class

/**
	This program demonstrates the HangmanSolver class.
*/

public class HangmanSolverDemo {
	
	public static void main(String[] args) throws IOException
	{
		int numberOfLetters;	// The number of letters in the current Hangman challenge
		
		// Create an object of the HangmanSolver class.
		HangmanSolver genius = new HangmanSolver();
		
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
		
		// Sort the dictionary so HangmanSolver can narrow down words based on length.
		genius.sortDictionary();
		
		// Use the listPotentialSolutions method to display possible solutions to the puzzle.
		listPotentialSolutions(numberOfLetters);
	}
	
	/**
	 * The listPotentialSolutions method accepts a parameter corresponding to the number of letters in the Hangman
	 * challenge and lists the potential solutions to the challenge based on a process of elimination.
	 */
	
	public static void listPotentialSolutions (int numberOfLetters) throws IOException {
		
		File file;					// Needed to for file input
		Scanner inputFile;			// Used to read input from the input file
		char[] invalidCharacters;	// An array to hold invalid characters from the current Hangman challenge
		char[] validArrangement;	// Array used to hold the valid configuration of letters for the puzzle
		
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);
		
		// Create an ArrayList object to hold potential solutions to the Hangman puzzle.
		ArrayList<String> potentialSolutions = new ArrayList<String>();
		
		// Make sure the file exists.
		file = new File("dictionary" + numberOfLetters + ".txt");
		if (!file.exists())
		{
			System.out.println("Eclipse was unable to find \"dictionary2.txt\". "
					+ "Please try moving the file to a location where Eclipse can find it.");
			System.exit(0);
		}
		
		// Open the file for reading.
		inputFile = new Scanner(file);
		
		System.out.println("What letter or letters does the puzzle not contain?");
		String input = keyboard.nextLine();
		invalidCharacters = new char[input.length()];
		
		for (int i = 0; i < input.length(); i++)
		{
			invalidCharacters[i] = input.charAt(i);
		}
		
		// Take valid letters from the user and filter out potential solutions so that only those with the valid letters
		// in exactly the right places will appear in the potentialSolutions ArrayList
		
		System.out.println("Which letters does the puzzle contain, and where are they placed?");
		input = keyboard.nextLine();
		validArrangement = new char[numberOfLetters];
		
		for (int i = 0; i < numberOfLetters; i++)
			if (Character.isLetter(input.charAt(i)))
				validArrangement[i] = input.charAt(i);
		
		// Reads lines from the file until there are no more lines remaining
		while(inputFile.hasNext())
		{
			String nextWord = inputFile.nextLine();
			int invalidLetterCount = 0;
			
			for (int i = 0; i < numberOfLetters; i++)
			{
				for (int innerIndex = 0; innerIndex < invalidCharacters.length; innerIndex++)
					if (nextWord.charAt(i) == invalidCharacters[innerIndex])
						invalidLetterCount++;
				
				if (Character.isLetter(validArrangement[i]) && nextWord.charAt(i) != validArrangement[i])
						invalidLetterCount++;
			}
			
			// If there are no invalid letters
			if (invalidLetterCount == 0)
				potentialSolutions.add(nextWord);
		}
		
		// Read out the possible solutions.
		System.out.println("The potential solutions to the puzzle are: ");
		for (String potentialSolution : potentialSolutions)
			System.out.println(potentialSolution);
		
		// Close the file.
		inputFile.close();
	}
}