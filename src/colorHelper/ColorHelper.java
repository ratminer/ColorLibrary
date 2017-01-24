package colorHelper;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static colorHelper.ColorSpaceConversion.*;

/**
 * Created by robertfernandes on 11/4/2016.
 */

public class ColorHelper {


	static HashMap<String, Integer> colorMap = ColorDatabase.colorMap;
	
    
	//takes in CIELab colors as inputs
    public static double getDeltaE(double[] color1, double[] color2) {
        return Math.sqrt(Math.pow(color2[0] - color1[0], 2) +
                Math.pow(color2[1] - color1[1], 2) +
                Math.pow(color2[2] - color1[2], 2));
    }
    
    public static int getClosestColor(int color) {
        int closestColor = 0;
        double currentDistance = Double.MAX_VALUE;

        for (int currentColor : colorMap.values()) {
            double tempDistance = getDeltaE(XYZtoCIELab(RGBtoXYZ(currentColor)), XYZtoCIELab(RGBtoXYZ(color)));
            if(tempDistance < currentDistance){
                currentDistance = tempDistance;
                closestColor = currentColor;
            }
        }

        return closestColor;
    }
}
