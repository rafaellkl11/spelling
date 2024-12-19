import java.util.ArrayList;
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

    /**
     * Construtor para objetos da classe SpellChecker
     */
    public SpellChecker(DictReader dictReader)
    {   
        // inicializa variáveis de instância
        dictionary = dictReader.getDictionary();
        searching = false;
        
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
        
    }
    
}
