import java.util.Locale;

public class VigenereCipher {
    String key;
    String alphabet;

    public VigenereCipher(String key) {
        this.key=key.toLowerCase(Locale.ROOT);
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
    public String encode(String message){
        String [] messageArray = message.split("");
        String encodedMessage = "";
        String fullKey = generateKey(message);
        for(int i =0; i<message.length(); i++){
            if(alphabet.contains(messageArray[i])){
                int x = (message.charAt(i)-97 + fullKey.charAt(i)-97) %26+97; // add up index;
                encodedMessage+=(char)(x);
            }
            else{
                encodedMessage+=message.charAt(i);
            }
        }
        return encodedMessage;
    }

    public String decode(String message){
        String decodedMessage = "";
        String fullKey = generateKey(message);
        for(int i =0; i<message.length(); i++){
            if(alphabet.contains(String.valueOf(message.charAt(i)))){
                int x = ((message.charAt(i)-97) - (fullKey.charAt(i)-97))%26 ;
                if (x<0)
                    x+=26;
                x += 97;
                decodedMessage+=(char)(x);
            }
            else{
                decodedMessage+=message.charAt(i);
            }

        }
        return decodedMessage;
    }

    private String generateKey(String message){
        String fullKey = "";
        int keySize = key.length();
        int keyLength = 0;
        for(int i=0; keyLength<message.length();i++){
            if(i==keySize){
                i -= (keySize);
                fullKey += key.charAt(i);
            }
            else{
                fullKey += key.charAt(i);
            }
            keyLength++;
        }
        return fullKey;
    }
    public String getKey() {
        return key;
    }

    public String getAlphabet() {
        return alphabet;
    }
}
