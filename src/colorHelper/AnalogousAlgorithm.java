package colorHelper;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import static colorHelper.ColorSpaceConversion.*;
import static colorHelper.ColorHelper.*;

/**
 * Created by robertfernandes on 1/20/2017.
 */
public class AnalogousAlgorithm implements MatchingAlgorithm {
    
	@Override
    public List<Integer> getMatchingColors(int color) {
        ArrayList<Integer> analogousColors = new ArrayList<Integer>();
        
        double offset = 1 / 12.0;
        
        double[] leftAnalogous = RGBtoHSL(color);
        double[] rightAnalogous = RGBtoHSL(color);
        
        leftAnalogous[0] += offset;
        rightAnalogous[0] -= offset;
        
        if (leftAnalogous[0] > 1) leftAnalogous[0] -= 1.0;
        if (rightAnalogous[0] < 0) rightAnalogous[0] += 1.0;
        
        double[] temp = HSLtoRGB(leftAnalogous);
        Color c = new Color((int) temp[0], (int) temp[1], (int)temp[2]);
        
        analogousColors.add(c.getRGB());
        temp = HSLtoRGB(rightAnalogous);
        
        c = new Color((int) temp[0], (int) temp[1], (int)temp[2]);
        analogousColors.add(c.getRGB());
        
        return analogousColors;
    }

    @Override
    public boolean isMatch(int color1, int color2) {
    	double offset = 1 / 12.0;
    	double[] c1 = RGBtoHSL(color1);
    	double[] c2 = RGBtoHSL(color2);
    	
    	double hueDifference = Math.abs(c1[0] - c2[0]);
    	
    	return hueDifference <= offset;
    }
}
