package fr.istic.vv;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class StringUtils {

    private Map<Character,Character> characterMap;

    public StringUtils() {
        this.characterMap= new HashMap<Character,Character>();
    }

    private boolean isOpeningSymbol(char c){
        return this.characterMap.containsKey(c);
    }

    private boolean isClosingSymbol(char c){
        return this.characterMap.containsValue(c);
    }

    private boolean isCorrespondingSymbol(char open,char close){
        return (characterMap.containsKey(open) &&characterMap.get(open).equals(close) );
    }

    public boolean isBalanced(String str){
        LinkedList<Character> queue = new LinkedList<Character>();
        for (Character c : str.toCharArray()){
            if(isOpeningSymbol(c)){
                queue.addLast(c);
            }else if(isClosingSymbol(c) && !queue.isEmpty() && isCorrespondingSymbol(queue.getLast(),c)){
                queue.removeLast();
            }
        }
        return queue.isEmpty();
    }

}
