package application;

import java.util.ArrayList;

public class Encrypt {

	public static String encrypt(String password1)
	{
	String original = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//Stores alphabet
	String modified = "";//Declare and store variable that will store password and the alphabet
	String password = "";//Stores password
	String messageToEncrypt = "";//Stores message user wants to encrypt
	String messageEncrypt = "";//stores the encrypted message(non-case sensitive)
	String finalMessageEncrypt = "";//stores the encrypted message(case sensitive)
	
	char letterCheck = '/';
	int indexCheck = 0, keynumber = 0,keyNumberDiff = 0;
	
		password = "Encypt This Message";
		keynumber = 12;
		messageToEncrypt = password1;
		
		password = password.toUpperCase();//Converts to uppercase for easier manipulation
		modified += password + original;//Connects password with alphabet
		
		String originalMessageToEncrypt = messageToEncrypt;//Stores message in variable for reference before altering the String
		String messageToEncrypt_UpperCase = messageToEncrypt.toUpperCase();//converts message to upper-case
		
		char[] password_With_Original = modified.toCharArray();//converts string to character array
		ArrayList<Character> originalModified = new ArrayList<Character>();//Declare and initialize an array list
		
		for (char check : password_With_Original)//Enhanced loop that checks through each character in the array and if it not present in the array list add the character
		{
			if (Character.isLetter(check) && !(originalModified.contains(check)))
			{
				originalModified.add(check);
			}
		}
		
		modified = originalModified.toString();//Convert the array list to a string
		modified  = modified.replace(" ", "");//Removes unwanted properties from the string
		modified  = modified.replace(",", "");//Removes unwanted properties from the string
		modified  = modified.replace("[", "");//Removes unwanted properties from the string
		modified  = modified.replace("]", "");//Removes unwanted properties from the string
		
		for (int index = 0;  index < messageToEncrypt_UpperCase.length(); index++)//For loop responsible for encrypting the message
		{
			if (!(Character.isLetter(messageToEncrypt_UpperCase.charAt(index))))//If character in message isn't a "character" add a space
			{
				messageEncrypt += " ";
			}
			else if(Character.isLetter(messageToEncrypt_UpperCase.charAt(index)))//If character is a letter shift message by keynumber on modified string
			{
				letterCheck = messageToEncrypt_UpperCase.charAt(index);
				indexCheck = original.indexOf(letterCheck);
				if ((indexCheck + keynumber) > 25)//If the shift exceeds end of string index
				{
					keyNumberDiff = (keynumber + indexCheck) % 25;
					messageEncrypt += "" + modified.charAt(keyNumberDiff - 1);
				}
				else
				{
					messageEncrypt += "" + modified.charAt(indexCheck + keynumber);
				}
			}
		}
		for (int index = 0; index < originalMessageToEncrypt.length(); index++)//Converts the encrypted message (All uppper-case) to its respective case from original message
		{
			if (Character.isDigit(originalMessageToEncrypt.charAt(index)))
			{
				finalMessageEncrypt += "" + originalMessageToEncrypt.charAt(index);
			}
		    else if (Character.isUpperCase(originalMessageToEncrypt.charAt(index)))
			{
				finalMessageEncrypt += "" + Character.toUpperCase(messageEncrypt.charAt(index));
			}
			
			else if (!(Character.isLetter(originalMessageToEncrypt.charAt(index))))
			{
				finalMessageEncrypt += " ";
			}
			else if(Character.isLowerCase(originalMessageToEncrypt.charAt(index)))
			{
				finalMessageEncrypt += "" + Character.toLowerCase(messageEncrypt.charAt(index));
			}
			
		}
		return finalMessageEncrypt;
	}
		
	

}
