package colorHelper;

import java.util.*;

/**
 * Created by robertfernandes on 1/20/2017.
 */

public class Matcher {

	MatchingAlgorithm matcher = new TriadAlgorithm();
	
    enum MatchType {
        Complimentary, Analogous, Triad
    }

    public MatchingAlgorithm selectStrategy() {
        return null;
    }

    public MatchingAlgorithm selectRandomStrategy() {
        int pick = new Random().nextInt(MatchType.values().length);
        return createMatchingAlgorithm(MatchType.values()[pick]);
    }

    public MatchingAlgorithm createMatchingAlgorithm(MatchType matchType) {
        switch(matchType) {
            case Complimentary:
                return new ComplimentaryAlgorithm();
            case Analogous:
                return new AnalogousAlgorithm();
            case Triad:
                return new TriadAlgorithm();
            default:
                return null;
        }
    }
    
    public boolean isMatch(int color1, int color2) {
    	return matcher.isMatch(color1, color2);
    }

    public List<Integer> getMatchingColors(int color) {
    	return matcher.getMatchingColors(color);
    }

}
