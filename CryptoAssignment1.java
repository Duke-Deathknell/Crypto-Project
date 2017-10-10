package cryptoassignment1;

/**
 * Michael Alsbergas, 8207383
 * Gevindu 
 */
public class CryptoAssignment1 {
    
    static CryptoGUI Form = new CryptoGUI();
    
    public CryptoAssignment1(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Form.setVisible(true);
            }
        });
    }
    
    //Code for Shift Cipher
    public static void Shift(char[] input, int key){
         
        Form.txta_Output.insert("Shift \n", 0);
    }
    
    public static void Vigenere(char[] input, char[] key){
                
        Form.txta_Output.insert("Vigenere \n", 0);
    }
    
    public static void MonoAlpha(char[] input){
         
        Form.txta_Output.insert("Mono-Alpha \n", 0);
    }
    
    public static void Brute(char[] input){
         
        Form.txta_Output.insert("Brute Force \n", 0);
    }
    
    public static void main(String args[]) {
        CryptoAssignment1 c = new CryptoAssignment1();
    }
}
    
