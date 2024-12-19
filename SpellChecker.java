import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Escreva uma descrição da classe SpellChecker aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class SpellChecker
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int number;
    private ArrayList<String> dictionary;
    private boolean searching;
    private boolean palindrome;
    private boolean anagram;

    /**
     * Construtor para objetos da classe SpellChecker
     */
    public SpellChecker(DictReader dictReader)
    {   
        // inicializa variáveis de instância
        dictionary = dictReader.getDictionary();
        searching = false;      
        palindrome = false;
        anagram = false;
    }

    public int numberOfWord()
    {
        return dictionary.size();
    }
    
    public boolean isKnownWord(String word)
    {
        int index = 0;
        boolean searching = false;
        while (index < dictionary.size() && !searching){
            if (dictionary.get(index).equals(word)){
                searching = true;
                break;
            } 
            index++;
        }
        return searching;
    }
    
    public boolean allKnown(ArrayList<String> words)
    {
        int index = 0;
        int index2 = 0;
        searching = true;
        while (index < words.size()){
            index2 = 0;
            while (index2 < dictionary.size() && searching){
                if (dictionary.get(index2).equals(words.get(index))){
                    searching = true;
                }
                else {
                    searching = false;
                    break;
                }
                index2++;
                
                if (!searching){
                    break;
                }
            }
            index++;
        }
        return searching;
    }
    
    public ArrayList<String> wordsStartingWith(char prefix)
    {
        ArrayList<String> Lista = new ArrayList<>();
        int index = 0;
        while (index < dictionary.size()){
            if(dictionary.get(index).charAt(0) == prefix){
                Lista.add(dictionary.get(index));
            }
            index++;
        }
        return Lista;
    }
    
    public ArrayList<String> wordsContaining(String text)
    {
        ArrayList<String> Lista = new ArrayList<>();
        int index = 0;
        while (index < dictionary.size()){
            if(dictionary.get(index).toLowerCase().contains(text.toLowerCase())){
                Lista.add(dictionary.get(index));
            }
            index++;
        }
        
        return Lista;
    }
    
    public void insert(String newWord)
    {   
        int index = 0;
        searching = false;
        while (index < dictionary.size()){
            if(dictionary.get(index).equals(newWord)){
                searching = true;
                break;
            }
            index++;
        }
        
        if(!searching){
            dictionary.add(newWord);
        }
        
        Collections.sort(dictionary);
        
    }
    
    public boolean remove(String newWord)
    {
        int index = 0;
        searching = false;
        while (index < dictionary.size()){
            if(dictionary.get(index).equals(newWord)){
                searching = true;
                break;
            }
            index++;
        }
        
        if(searching){
            dictionary.remove(newWord);
        }
        
        Collections.sort(dictionary);
        
        return searching;
    }
    
    public void save()
    {
        DictReader dictReader = new DictReader("words.txt");
        dictReader.save(dictionary);
    }
    
    public boolean isPalindrome(String word)
    {
        boolean palindrome = false;
        int index = 0;
        searching = false;
        while (index < dictionary.size()){
            if (dictionary.get(index).equals(word)){
                searching = true;
                break;
            }
            index++;
        }
        
        if(searching){
            if(word.equals(new StringBuilder(word).reverse().toString())){
                palindrome = true;
            }
        }
        
        return palindrome;
    }
    
    public ArrayList<String> anagrams(String word)
    {
        int index = 0;
        anagram = false;
        ArrayList<String> anagrams = new ArrayList<>();
        while (index < dictionary.size()){
            char[] letrasWord = word.toCharArray();
            char[] letrasDictionary = dictionary.get(index).toCharArray();
            
            Arrays.sort(letrasWord);
            Arrays.sort(letrasDictionary);
            
            new String(letrasWord);
            new String(letrasDictionary);
            
            if(letrasDictionary.equals(letrasWord)){
                anagram = true;
            }

            if(anagram){
                anagrams.add(dictionary.get(index));
                anagram = false;
            }
        }
        return anagrams;
    }
    
    public ArrayList<String> difference(ArrayList<String> dictionary)
    {
        ArrayList<String> difference = new ArrayList<>();
        
        return difference;
    }
}
