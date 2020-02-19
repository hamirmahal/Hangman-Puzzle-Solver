		/**
		// char repeat;				// Used to decide if the user wants to enter additional characters or not
		// char invalidLetter;		// A letter that is not a solution to the puzzle
		
		// By process of elimination, find the solution to the puzzle.
		System.out.println("What letter does the puzzle not contain?");
		
		String input = keyboard.nextLine();
		invalidLetter = input.charAt(0);
		
		// Reads lines from the file until there are no more lines remaining
		while(inputFile.hasNext())
		{
			String nextWord = inputFile.nextLine();
			int validLetterCount = 0;
			
			for (int i = 0; i < numberOfLetters; i++)
			{
				if (nextWord.charAt(i) != invalidLetter)
					validLetterCount++;
				// If all the letters are valid
				if (validLetterCount == numberOfLetters)
					potentialSolutions.add(nextWord);
			}
		}
		
		// Does the user want to enter another letter?
		System.out.println("Would you like to enter another letter that the puzzle does not contain?");
		input = keyboard.nextLine();	// Read the next line.
		repeat = input.charAt(0);
		
		while (repeat == 'Y' || repeat == 'y')
		{	
			System.out.println("What other letter does the puzzle not contain?");
			input = keyboard.nextLine();
			
			invalidLetter = input.charAt(0);
			
			// First, remove any words from the potential solutions list that contain the invalid letter.
			for (int outerIndex = 0; outerIndex < potentialSolutions.size(); outerIndex++)
			{	
				String currentWord = potentialSolutions.get(outerIndex);
				int invalidLetterCount = 0;
				
				for (int i = 0; i < numberOfLetters; i++)
					if (currentWord.charAt(i) == invalidLetter)
						invalidLetterCount++;
				
				if (invalidLetterCount >= 1)
				{
					potentialSolutions.remove(outerIndex);
					outerIndex--;
				}
			}
			
			// Then, add only words that do not contain the invalid letter to the potential solutions list.
			while(inputFile.hasNext())
			{
				String nextWord = inputFile.nextLine();
				int validLetterCount = 0;
				
				for (int i = 0; i < numberOfLetters; i++)
				{
					if (nextWord.charAt(i) != invalidLetter)
						validLetterCount++;
					// If all the letters are valid
					if (validLetterCount == numberOfLetters)
						potentialSolutions.add(nextWord);	
				}
			}
			
			// Does the user want to enter another letter?
			System.out.println("Would you like to enter another letter that the puzzle does not contain?");
			input = keyboard.nextLine();	// Read the next line.
			repeat = input.charAt(0);
		}
		*/


		// Get the number of words in the Hangman challenge to narrow down the search of solutions to only those words of
		// the proper length.
		/**
		switch (numberOfLetters)
		{
			case 1:
				// There is only one possible solution to the puzzle, and it is the letter "A".
				System.out.println("The solution is the word \"a\".");
				break;
			case 2:
				// Make sure the file exists.
				file = new File("dictionary" + String.valueOf(numberOfLetters) + ".txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary2.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				
				// Consume the remaining newline character.
				keyboard.nextLine();
				
				String input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
					int validLetterCount = 0;
					
					for (int i = 0; i < numberOfLetters; i++)
					{
						if (nextWord.charAt(i) != invalidLetter)
							validLetterCount++;
						// If all the letters are valid
						if (validLetterCount == numberOfLetters)
							potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int outerIndex = 0; outerIndex < potentialSolutions.size(); outerIndex++)
					{	
						String currentWord = potentialSolutions.get(outerIndex);
						int invalidLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
							if (currentWord.charAt(i) == invalidLetter)
								invalidLetterCount++;
						
						if (invalidLetterCount >= 1)
						{
							potentialSolutions.remove(outerIndex);
							outerIndex--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
						int validLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
						{
							if (nextWord.charAt(i) != invalidLetter)
								validLetterCount++;
							// If all the letters are valid
							if (validLetterCount == numberOfLetters)
								potentialSolutions.add(nextWord);	
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 3:
				// Make sure the file exists.
				file = new File("dictionary" + String.valueOf(numberOfLetters) + ".txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary2.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				
				// Consume the remaining newline character.
				keyboard.nextLine();
				
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
					int validLetterCount = 0;
					
					for (int i = 0; i < numberOfLetters; i++)
					{
						if (nextWord.charAt(i) != invalidLetter)
							validLetterCount++;
						// If all the letters are valid
						if (validLetterCount == numberOfLetters)
							potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int outerIndex = 0; outerIndex < potentialSolutions.size(); outerIndex++)
					{	
						String currentWord = potentialSolutions.get(outerIndex);
						int invalidLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
							if (currentWord.charAt(i) == invalidLetter)
								invalidLetterCount++;
						
						if (invalidLetterCount >= 1)
						{
							potentialSolutions.remove(outerIndex);
							outerIndex--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
						int validLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
						{
							if (nextWord.charAt(i) != invalidLetter)
								validLetterCount++;
							// If all the letters are valid
							if (validLetterCount == numberOfLetters)
								potentialSolutions.add(nextWord);	
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 4:
				// Make sure the file exists.
				file = new File("dictionary" + String.valueOf(numberOfLetters) + ".txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary2.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				
				// Consume the remaining newline character.
				keyboard.nextLine();
				
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
					int validLetterCount = 0;
					
					for (int i = 0; i < numberOfLetters; i++)
					{
						if (nextWord.charAt(i) != invalidLetter)
							validLetterCount++;
						// If all the letters are valid
						if (validLetterCount == numberOfLetters)
							potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int outerIndex = 0; outerIndex < potentialSolutions.size(); outerIndex++)
					{	
						String currentWord = potentialSolutions.get(outerIndex);
						int invalidLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
							if (currentWord.charAt(i) == invalidLetter)
								invalidLetterCount++;
						
						if (invalidLetterCount >= 1)
						{
							potentialSolutions.remove(outerIndex);
							outerIndex--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
						int validLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
						{
							if (nextWord.charAt(i) != invalidLetter)
								validLetterCount++;
							// If all the letters are valid
							if (validLetterCount == numberOfLetters)
								potentialSolutions.add(nextWord);	
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 5:
				// Make sure the file exists.
				file = new File("dictionary" + String.valueOf(numberOfLetters) + ".txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary2.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				
				// Consume the remaining newline character.
				keyboard.nextLine();
				
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
					int validLetterCount = 0;
					
					for (int i = 0; i < numberOfLetters; i++)
					{
						if (nextWord.charAt(i) != invalidLetter)
							validLetterCount++;
						// If all the letters are valid
						if (validLetterCount == numberOfLetters)
							potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int outerIndex = 0; outerIndex < potentialSolutions.size(); outerIndex++)
					{	
						String currentWord = potentialSolutions.get(outerIndex);
						int invalidLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
							if (currentWord.charAt(i) == invalidLetter)
								invalidLetterCount++;
						
						if (invalidLetterCount >= 1)
						{
							potentialSolutions.remove(outerIndex);
							outerIndex--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
						int validLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
						{
							if (nextWord.charAt(i) != invalidLetter)
								validLetterCount++;
							// If all the letters are valid
							if (validLetterCount == numberOfLetters)
								potentialSolutions.add(nextWord);	
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 6:
				// Make sure the file exists.
				file = new File("dictionary" + String.valueOf(numberOfLetters) + ".txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary2.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				
				// Consume the remaining newline character.
				keyboard.nextLine();
				
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
					int validLetterCount = 0;
					
					for (int i = 0; i < numberOfLetters; i++)
					{
						if (nextWord.charAt(i) != invalidLetter)
							validLetterCount++;
						// If all the letters are valid
						if (validLetterCount == numberOfLetters)
							potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int outerIndex = 0; outerIndex < potentialSolutions.size(); outerIndex++)
					{	
						String currentWord = potentialSolutions.get(outerIndex);
						int invalidLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
							if (currentWord.charAt(i) == invalidLetter)
								invalidLetterCount++;
						
						if (invalidLetterCount >= 1)
						{
							potentialSolutions.remove(outerIndex);
							outerIndex--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
						int validLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
						{
							if (nextWord.charAt(i) != invalidLetter)
								validLetterCount++;
							// If all the letters are valid
							if (validLetterCount == numberOfLetters)
								potentialSolutions.add(nextWord);	
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 7:
				// Make sure the file exists.
				file = new File("dictionary" + String.valueOf(numberOfLetters) + ".txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary2.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				
				// Consume the remaining newline character.
				keyboard.nextLine();
				
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
					int validLetterCount = 0;
					
					for (int i = 0; i < numberOfLetters; i++)
					{
						if (nextWord.charAt(i) != invalidLetter)
							validLetterCount++;
						// If all the letters are valid
						if (validLetterCount == numberOfLetters)
							potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int outerIndex = 0; outerIndex < potentialSolutions.size(); outerIndex++)
					{	
						String currentWord = potentialSolutions.get(outerIndex);
						int invalidLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
							if (currentWord.charAt(i) == invalidLetter)
								invalidLetterCount++;
						
						if (invalidLetterCount >= 1)
						{
							potentialSolutions.remove(outerIndex);
							outerIndex--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
						int validLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
						{
							if (nextWord.charAt(i) != invalidLetter)
								validLetterCount++;
							// If all the letters are valid
							if (validLetterCount == numberOfLetters)
								potentialSolutions.add(nextWord);	
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 8:
				// Make sure the file exists.
				file = new File("dictionary" + String.valueOf(numberOfLetters) + ".txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary2.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				
				// Consume the remaining newline character.
				keyboard.nextLine();
				
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
					int validLetterCount = 0;
					
					for (int i = 0; i < numberOfLetters; i++)
					{
						if (nextWord.charAt(i) != invalidLetter)
							validLetterCount++;
						// If all the letters are valid
						if (validLetterCount == numberOfLetters)
							potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int outerIndex = 0; outerIndex < potentialSolutions.size(); outerIndex++)
					{	
						String currentWord = potentialSolutions.get(outerIndex);
						int invalidLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
							if (currentWord.charAt(i) == invalidLetter)
								invalidLetterCount++;
						
						if (invalidLetterCount >= 1)
						{
							potentialSolutions.remove(outerIndex);
							outerIndex--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
						int validLetterCount = 0;
						
						for (int i = 0; i < numberOfLetters; i++)
						{
							if (nextWord.charAt(i) != invalidLetter)
								validLetterCount++;
							// If all the letters are valid
							if (validLetterCount == numberOfLetters)
								potentialSolutions.add(nextWord);	
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 9:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 10:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 11:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 12:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 13:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 14:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 15:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 16:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 17:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 18:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 19:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 20:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 21:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			case 22:
				// Make sure the file exists.
				file = new File("dictionary4.txt");
				if (!file.exists())
				{
					System.out.println("Eclipse was unable to find \"dictionary4.txt\". "
							+ "Please try moving the file to a location where Eclipse can find it.");
					System.exit(0);
				}
				
				// Open the file for reading.
				inputFile = new Scanner(file);
				
				// By process of elimination, find the solution to the puzzle.
				System.out.println("What letter does the puzzle not contain?");
				input = keyboard.nextLine();
				invalidLetter = input.charAt(0);
				
				// Reads lines from the file until there are no more lines remaining
				while(inputFile.hasNext())
				{
					String nextWord = inputFile.nextLine();
						
					// Read the next word if it only uses letters that are not invalid.
					if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
							&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
					{
						potentialSolutions.add(nextWord);
					}
				}
				
				// Does the user want to enter another letter?
				System.out.println("Would you like to enter another letter that the puzzle does not contain?");
				input = keyboard.nextLine();	// Read the next line.
				repeat = input.charAt(0);
				
				while (repeat == 'Y' || repeat == 'y')
				{	
					System.out.println("What other letter does the puzzle not contain?");
					input = keyboard.nextLine();
					invalidLetter = input.charAt(0);
					
					// First, remove any words from the potential solutions list that contain the invalid letter.
					for (int i = 0; i < potentialSolutions.size(); i++)
					{
						String currentWord = potentialSolutions.get(i);
						
						if(currentWord.charAt(0) == invalidLetter || currentWord.charAt(1) == invalidLetter 
								|| currentWord.charAt(2) == invalidLetter || currentWord.charAt(3) == invalidLetter)
						{
							potentialSolutions.remove(i);
							
							// Need to decrement the index to account for the ArrayList class's automatic resizing.
							i--;
						}
					}
					
					// Then, add only words that do not contain the invalid letter to the potential solutions list.
					while(inputFile.hasNext())
					{
						String nextWord = inputFile.nextLine();
							
						// Add the next word to the potential solutions if it only uses letters that are not invalid.
						if(nextWord.charAt(0) != invalidLetter && nextWord.charAt(1) != invalidLetter 
								&& nextWord.charAt(2) != invalidLetter && nextWord.charAt(3) != invalidLetter)
						{
							potentialSolutions.add(nextWord);
						}
					}
					
					// Does the user want to enter another letter?
					System.out.println("Would you like to enter another letter that the puzzle does not contain?");
					input = keyboard.nextLine();	// Read the next line.
					repeat = input.charAt(0);
				}
				
				// Read out the possible solutions.
				System.out.println("The potential solutions to the puzzle are: ");
				for (String potentialSolution : potentialSolutions)
					System.out.println(potentialSolution);
				
				// Close the file.
				inputFile.close();
				break;
			default:
				System.out.println("The program didn't anticipate words over 22 characters in length. "
						+ "Modify the source code to continue.");
		}

public @interface PreviousCode {

}
*/
