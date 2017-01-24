package colorHelper;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import static colorHelper.ColorSpaceConversion.*;

/**
 * Created by robertfernandes on 1/20/2017.
 */
public class ComplimentaryAlgorithm implements MatchingAlgorithm {

	@Override
    public List<Integer> getMatchingColors(int color) {
        ArrayList<Integer> matchingColors = new ArrayList<>();
        
        Color c = new Color(color);
        // convert to hsl colorSpace
        double[] hslColor = RGBtoHSL(color);

         // rotate 180 across colorwheel
        hslColor[0] += 180.0/360.0;
        
        if (hslColor[0] > 1) {
        	hslColor[0] -= 1;
        } else if (hslColor[0] < 0) {
        	hslColor[0] += 1;
        }
        
        double[] temp = HSLtoRGB(hslColor);
        matchingColors.add(new Color((int)temp[0], (int)temp[1], (int)temp[2]).getRGB());
        
        return matchingColors;
    }

    @Override
    public boolean isMatch(int color1, int color2) {
        double[] c1 = RGBtoHSL(color1);
        double[] c2 = RGBtoHSL(color2);
        double hueDifference = Math.abs(c1[0]-c2[0]);

        double offset = 1/24.0;
        double complimentShift = 0.5;

        if(hueDifference < complimentShift + offset && hueDifference > complimentShift - offset) {

            return true;
        }
        return false;
    }
}

