/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package caesarcipher;

import java.util.Scanner;

/**
 *
 * @author Adi Venkatesh
 */
public class CaesarCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type a to encrypt, Type b to decrypt, Type c to break");
        String initiate = keyboard.nextLine();

   switch (initiate) {
            case "a":
                {
                    System.out.println("Please enter a message that you would like to encrypt: ");
                    String message = keyboard.nextLine();
                    System.out.println("Please enter a key to encrypt: ");
                    int key = keyboard.nextInt();
                    String theEncrypted = encode(message, key);
                    System.out.println("This is the encrypted message: " + theEncrypted);
                    break;
                }
        // TODO code application logic here
            case "b":
                {
                    System.out.println("Please enter a message that you would like to decrypt");
                    String message = keyboard.nextLine();
                    System.out.println("Please enter a key to decrypt");
                    int key = keyboard.nextInt();
                    String theDecrypted = decode(message, key);
                    System.out.println("This is the decrypted message: " + theDecrypted);
                    break;
                }
            case "c":
                System.out.println("Please enter a message that you would like to break");
                while (true) {
                    
                    String theBreak = keyboard.nextLine();
                    String[] printOut = breakCode(theBreak);
                    for (int x = 0; x < printOut.length; x++) {
                        System.out.println(printOut[x]);
                    }
                    break;
                }   
             
            default:
            
            
        }

    }

    /**
     * @param message The message that the user enters when prompted for
     * something to encrypt (String)
     * @param key The integer value that the user requests that all the letters
     * in the input be shifted by (int)
     * @return encrypted - The message the user entered after being shifted by
     * the key parameter (String)
     */
    public static String encode(String message, int key) {
        String encrypted = "";
        for (int i = 0; i < message.length(); i++) {

            if ((message.charAt(i) >= 'a') && (message.charAt(i) <= 'z')) {
                if (message.charAt(i) + key > 'z') {

                    encrypted += (char) ((int) (message.charAt(i) + key - 97) % 26 + 97);

                } else {
                    encrypted += (char) (message.charAt(i) + key);

                }
            } else if ((message.charAt(i) >= 'A') && (message.charAt(i) <= 'Z')) {

                if (message.charAt(i) + key > 'Z') {
                    encrypted += (char) ((int) (message.charAt(i) + key - 65) % 26 + 65);

                } else {
                    encrypted += (char) (message.charAt(i) + key);
                }

            } else {
                encrypted += (char) ' ';
                continue;
            }

        }

        return encrypted;
    }

    /**
     * @param message The message that the user enters when prompted for
     * something to decrypt (String)
     * @param key The integer value that the user requests that all the letters
     * in the input be shifted by (int)
     * @return decrypted - The message the user entered after being shifted by
     * the key parameter (String)
     */
    public static String decode(String message, int key) {
        String decrypted = "";

        for (int i = 0; i < message.length(); i++) {
            if ((message.charAt(i) >= 'a') && (message.charAt(i) <= 'z')) {
                if (message.charAt(i) + key < 'z') {

                    decrypted += (char) ((int) (message.charAt(i) - key - 122) % 26 + 122);

                } else {
                    decrypted += (char) ((int) (message.charAt(i) - key));
                }

            } else if ((message.charAt(i) >= 'A') && (message.charAt(i) <= 'Z')) {
                if (message.charAt(i) + key < 'Z') {

                    decrypted += (char) ((int) (message.charAt(i) - key - 90) % 26 + 90);
                } else {

                    decrypted += (char) (message.charAt(i) - key);
                }

            } else {
                decrypted += (char) ' ';
                continue;
            }
        }

        return decrypted;
    }

    /**
     * @param message The message that the user enters when prompted for
     * something to break (String)
     * @return brokenMessage - Returns the array that includes all the keys that
     * were attempted in order to decipher the original message sent in proper
     * English, is later printed out using a for loop and left for user to
     * decipher
     */
    public static String[] breakCode(String message) {
        String keys[] = new String[26];
        String english[] = {"the", "be", "to", "of", "and", "a", "in", "that", "have", "i", "it", "for", "not", "on",
            "with", "he", "as", "you", "do", "at", "this", "but", "his", "by", "from", "they", "we", "say", "her", "she",
            "or", "an", "will", "my", "one", "all", "would", "there", "their", "what", "so", "up", "out", "if", "about",
            "who", "get", "which", "go", "me", "when", "make", "can", "like", "time", "no", "just", "know", "into", "some"};

        String[] broken = new String[26];
        int arrayLength = 0;
        for (int x = 0; x < 26; x++) {
            keys[x] = decode(message, x);
            String[] compare = keys[x].split(" ");
            for (int y = 0; y < compare.length; y++) {
                for (int l = 0; l < english.length; l++) {
                    if (compare[y].equalsIgnoreCase(english[l])) {
                        for (int z = 0; z < compare.length; z++) {
                            broken[x] += compare[z] + " ";
                        }

                    }
                }
            }
            if (broken[x] != null) {
                broken[x] = broken[x].substring(4, message.length() + 4);

            }
        }

        for (int x = 0; x < broken.length; x++) {
            if (broken[x] != null) {
                arrayLength++;
            }
        }

        String[] brokenMessage = new String[arrayLength];
        int x = 0;
        for (int y = 0; y < broken.length; y++) {
            if (broken[y] != null) {
                brokenMessage[x] = broken[y];
                x++;
            }
        }

        return brokenMessage;

    }

}
