package colorHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static colorHelper.ColorHelper.*;

import static colorHelper.ColorSpaceConversion.*;
/**
 * Created by robertfernandes on 1/20/2017.
 */
public class TriadAlgorithm implements MatchingAlgorithm {

    @Override
    public List<Integer> getMatchingColors(int color) {
        ArrayList<Integer> matchingColors = new ArrayList<>();
        
        MatchingAlgorithm matcher = new ComplimentaryAlgorithm();
        
        int compliment = matcher.getMatchingColors(color).get(0);
        
        matcher = new AnalogousAlgorithm();
        
        return matcher.getMatchingColors(compliment);
    }

    @Override
    public boolean isMatch(int color1, int color2) {
    	ComplimentaryAlgorithm comp = new ComplimentaryAlgorithm();
    	AnalogousAlgorithm alg = new AnalogousAlgorithm();
    	
    	int compliment = comp.getMatchingColors(color1).get(0);
    	
    	return alg.isMatch(compliment, color2);
    	
    }
}
