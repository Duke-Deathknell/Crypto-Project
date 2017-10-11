package cryptoassignment1;

/**
 * Michael Alsbergas, 8207383
 * Fundamentals of cryptography assignment 1
 * 
 * Encryption functions for 3 ciphers and a brute force attack function
 */

public class CryptoAssignment1 {
    
    //Have GUI and alphabet array as globals for 
    //encryption functions
    static CryptoGUI Form = new CryptoGUI();
    static char[] alpha;
    
    public CryptoAssignment1(){
        //initialize the alphabet array
        String temp = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alpha = temp.toCharArray();
        
        //create the GUI in a new thread
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form.setVisible(true);
            }
        });
    }
    
    //Shift cipher encryption with user key
    public static void Shift(char[] input, int key){
        String output = "";
        
        for (int i=0; i < input.length; i++){
            for (int j=0; j < alpha.length; j++){
                if (input[i] == alpha[j]){
                    output += alpha[(j+key)%26];//mod
                    break;
                }
            }
        }
         
        Form.txta_Output.insert(output, 0);
    }
    
    //Vigenere cipher encryption with user key
    public static void Vigenere(char[] input, char[] key){
        int[] numKey = new int[key.length];
        int temp;
        String output = "";
        
        //Convert word key into shift numbers
        for (int i=0; i < key.length; i++){
            for (int j=0; j < alpha.length; j++){
                if (key[i] == alpha[j]){
                    numKey[i] = j; 
                    break;
                }
            }
        }
        
        //Now shift with number key
        for (int i=0; i < input.length; i++){
            for (int j=0; j < alpha.length; j++){
                if (input[i] == alpha[j]){
                    temp = numKey[i%numKey.length];//shift based on position in text
                    output += alpha[(j+temp)%26];//mod
                    break;
                }
            }
        }
                
        Form.txta_Output.insert(output, 0);
    }
    
    //Mono-alphabetic cipher using a set key. 
    public static void MonoAlpha(char[] input){
        char[] key = "michaelsbrgdfhjknopqtuvwxyz".toCharArray();
        String output = "";
        
        //Shift with key for output
        for (int i=0; i < input.length; i++){
            for (int j=0; j < alpha.length; j++){
                if (input[i] == alpha[j]){
                    output += key[j];
                    break;
                }
            }
        }
                
        Form.txta_Output.insert(output, 0);
    }
    
    //Brute force attack on a shift ciphertext.
    public static void Brute(char[] input){
        String output = "";
        
        //reverse shift with all keys
        for (int key=0; key < 26; key++){
            for (int i=0; i < input.length; i++){
                for (int j=0; j < alpha.length; j++){
                    if (input[i] == alpha[j]){
                        output += alpha[(26+j-key)%26];//mod
                        break;
                    }
                }
            }
            output += "\n"; //for better reading
        }
        
        Form.txta_Output.insert(output, 0);
    }
    
    public static void main(String args[]) {
        CryptoAssignment1 c = new CryptoAssignment1();
    }
}
    
