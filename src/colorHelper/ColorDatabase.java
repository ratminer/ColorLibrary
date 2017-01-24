package colorHelper;

import java.util.*;

import static colorHelper.ColorSpaceConversion.*;

public class ColorDatabase {

	static List<String> colorNames = new ArrayList<>();
	static List<Integer> colorValues = new ArrayList<>();
	
	public static HashMap<String, Integer> colorMap = new HashMap<>();
	
    //takes in CIELab colors as inputs
    public static double getDeltaE(double[] color1, double[] color2) {
        return Math.sqrt(Math.pow(color2[0] - color1[0], 2) +
                Math.pow(color2[1] - color1[1], 2) +
                Math.pow(color2[2] - color1[2], 2));
    }

    //Returns the name of the colour detected
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

    public static int getColor(String colorName) {
        return colorMap.get(colorName);
    }

    public static String getColorName(int color) {

        String colorName = "";

        for (String s : colorMap.keySet()) {
            if (colorMap.get(s) == color) {
                return s;
            }
        }

        return colorName;
    }
	
	static {
		colorNames.add("AliceBlue");
        colorNames.add("AntiqueWhite");
        colorNames.add("Aqua");
        colorNames.add("Aquamarine");
        colorNames.add("Azure");
        colorNames.add("Beige");
        colorNames.add("Bisque");
        colorNames.add("Black");
        colorNames.add("BlanchedAlmond");
        colorNames.add("Blue");
        colorNames.add("Blueviolet");
        colorNames.add("Brown");
        colorNames.add("Burlywood");
        colorNames.add("CadetBlue");
        colorNames.add("Chartreuse");
        colorNames.add("Chocolate");
        colorNames.add("Coral");
        colorNames.add("CornflowerBlue");
        colorNames.add("Cornsilk");
        colorNames.add("Crimson");
        colorNames.add("Cyan");
        colorNames.add("DarkBlue");
        colorNames.add("DarkCyan");
        colorNames.add("DarkGoldenrod");
        colorNames.add("DarkGray");
        colorNames.add("DarkGreen");
        colorNames.add("DarkKhaki");
        colorNames.add("DarkMagenta");
        colorNames.add("DarkOlivegreen");
        colorNames.add("DarkOrange");
        colorNames.add("DarkOrchid");
        colorNames.add("DarkRed");
        colorNames.add("DarkSalmon");
        colorNames.add("DarkSeagreen");
        colorNames.add("DarkSlateBlue");
        colorNames.add("DarkSlateGray");
        colorNames.add("DarkTurquoise");
        colorNames.add("DarkViolet");
        colorNames.add("DeepPink");
        colorNames.add("DeepSkyBlue");
        colorNames.add("DimGray");
        colorNames.add("DodgerBlue");
        colorNames.add("Firebrick");
        colorNames.add("FloralWhite");
        colorNames.add("ForestGreen");
        colorNames.add("Fuchsia");
        colorNames.add("Gainsboro");
        colorNames.add("GhostWhite");
        colorNames.add("Gold");
        colorNames.add("Goldenrod");
        colorNames.add("Gray");
        colorNames.add("Green");
        colorNames.add("GreenYellow");
        colorNames.add("Honeydew");
        colorNames.add("HotPink");
        colorNames.add("IndianRed");
        colorNames.add("Indigo");
        colorNames.add("Ivory");
        colorNames.add("Khaki");
        colorNames.add("Lavender");
        colorNames.add("LavenderBlush");
        colorNames.add("LawnGreen");
        colorNames.add("LemonChiffon");
        colorNames.add("LightBlue");
        colorNames.add("LightCoral");
        colorNames.add("LightCyan");
        colorNames.add("LightGoldenrodYellow");
        colorNames.add("LightGreen");
        colorNames.add("LightGrey");
        colorNames.add("LightPink");
        colorNames.add("LightSalmon");
        colorNames.add("LightSeaGreen");
        colorNames.add("LightSkyBlue");
        colorNames.add("LightSlateGray");
        colorNames.add("LightSteelBlue");
        colorNames.add("LightYellow");
        colorNames.add("Lime");
        colorNames.add("LimeGreen");
        colorNames.add("Linen");
        colorNames.add("Magenta");
        colorNames.add("Maroon");
        colorNames.add("MediumAquamarine");
        colorNames.add("MediumBlue");
        colorNames.add("MediumOrchid");
        colorNames.add("MediumPurple");
        colorNames.add("MediumSeaGreen");
        colorNames.add("MediumSlateBlue");
        colorNames.add("MediumSpringGreen");
        colorNames.add("MediumTurquoise");
        colorNames.add("MediumVioletRed");
        colorNames.add("MidnightBlue");
        colorNames.add("MintCream");
        colorNames.add("MistyRose");
        colorNames.add("Moccasin");
        colorNames.add("NavajoWhite");
        colorNames.add("Navy");
        colorNames.add("OldLace");
        colorNames.add("OliveDrab");
        colorNames.add("Orange");
        colorNames.add("OrangeRed");
        colorNames.add("Orchid");
        colorNames.add("PaleGoldenrod");
        colorNames.add("PaleGreen");
        colorNames.add("PaleTurquoise");
        colorNames.add("PaleVioletRed");
        colorNames.add("PapayaWhip");
        colorNames.add("PeachPuff");
        colorNames.add("Peru");
        colorNames.add("Pink");
        colorNames.add("Plum");
        colorNames.add("PowderBlue");
        colorNames.add("Purple");
        colorNames.add("Red");
        colorNames.add("RosyBrown");
        colorNames.add("RoyalBlue");
        colorNames.add("SaddleBrown");
        colorNames.add("Salmon");
        colorNames.add("SandyBrown");
        colorNames.add("Seagreen");
        colorNames.add("SeaShell");
        colorNames.add("Sienna");
        colorNames.add("Silver");
        colorNames.add("SkyBlue");
        colorNames.add("SlateBlue");
        colorNames.add("Snow");
        colorNames.add("SpringGreen");
        colorNames.add("SteelBlue");
        colorNames.add("Tan");
        colorNames.add("Thistle");
        colorNames.add("Teal");
        colorNames.add("Tomato");
        colorNames.add("Turquoise");
        colorNames.add("Violet");
        colorNames.add("Wheat");
        colorNames.add("White");
        colorNames.add("Whitesmoke");
        colorNames.add("Yellow");
        colorNames.add("YellowGreen");
        
        colorValues.add(0xF0F8FF);
        colorValues.add(0xFAEBD7);
        colorValues.add(0x00FFFF);
        colorValues.add(0x7FFFD4);
        colorValues.add(0xF0FFFF);
        colorValues.add(0xF5F5DC);
        colorValues.add(0xFFE4C4);
        colorValues.add(0x000000);
        colorValues.add(0xFFEBCD);
        colorValues.add(0x0000FF);
        colorValues.add(0x8A2BE2);
        colorValues.add(0xA52A2A);
        colorValues.add(0xDEB887);
        colorValues.add(0x5F9EA0);
        colorValues.add(0x7FFF00);
        colorValues.add(0xD2691E);
        colorValues.add(0xFF7F50);
        colorValues.add(0x6495ED);
        colorValues.add(0xFFF8DC);
        colorValues.add(0xDC143C);
        colorValues.add(0x00FFFF);
        colorValues.add(0x00008B);
        colorValues.add(0x008B8B);
        colorValues.add(0xB8860B);
        colorValues.add(0xA9A9A9);
        colorValues.add(0x006400);
        colorValues.add(0xBDB76B);
        colorValues.add(0x8B008B);
        colorValues.add(0x556B2F);
        colorValues.add(0xFF8C00);
        colorValues.add(0x9932CC);
        colorValues.add(0x8B0000);
        colorValues.add(0xE9967A);
        colorValues.add(0x8DBC8F);
        colorValues.add(0x483D8B);
        colorValues.add(0x2F4F4F);
        colorValues.add(0x00DED1);
        colorValues.add(0x9400D3);
        colorValues.add(0xFF1493);
        colorValues.add(0x00BFFF);
        colorValues.add(0x696969);
        colorValues.add(0x1E90FF);
        colorValues.add(0xB22222);
        colorValues.add(0xFFFAF0);
        colorValues.add(0x228B22);
        colorValues.add(0xFF00FF);
        colorValues.add(0xDCDCDC);
        colorValues.add(0xF8F8FF);
        colorValues.add(0xFFD700);
        colorValues.add(0xDAA520);
        colorValues.add(0x808080);
        colorValues.add(0x008000);
        colorValues.add(0xADFF2F);
        colorValues.add(0xF0FFF0);
        colorValues.add(0xFF69B4);
        colorValues.add(0xCD5C5C);
        colorValues.add(0x4B0082);
        colorValues.add(0xFFFFF0);
        colorValues.add(0xF0E68C);
        colorValues.add(0xE6E6FA);
        colorValues.add(0xFFF0F5);
        colorValues.add(0x7CFC00);
        colorValues.add(0xFFFACD);
        colorValues.add(0xADD8E6);
        colorValues.add(0xF08080);
        colorValues.add(0xE0FFFF);
        colorValues.add(0xFAFAD2);
        colorValues.add(0x90EE90);
        colorValues.add(0xD3D3D3);
        colorValues.add(0xFFB6C1);
        colorValues.add(0xFFA07A);
        colorValues.add(0x20B2AA);
        colorValues.add(0x87CEFA);
        colorValues.add(0x778899);
        colorValues.add(0xB0C4DE);
        colorValues.add(0xFFFFE0);
        colorValues.add(0x00FF00);
        colorValues.add(0x32CD32);
        colorValues.add(0xFAF0E6);
        colorValues.add(0xFF00FF);
        colorValues.add(0x800000);
        colorValues.add(0x66CDAA);
        colorValues.add(0x0000CD);
        colorValues.add(0xBA55D3);
        colorValues.add(0x9370DB);
        colorValues.add(0x3CB371);
        colorValues.add(0x7B68EE);
        colorValues.add(0x00FA9A);
        colorValues.add(0x48D1CC);
        colorValues.add(0xC71585);
        colorValues.add(0x191970);
        colorValues.add(0xF5FFFA);
        colorValues.add(0xFFE4E1);
        colorValues.add(0xFFE4B5);
        colorValues.add(0xFFDEAD);
        colorValues.add(0x000080);
        colorValues.add(0xFDF5E6);
        colorValues.add(0x6B8E23);
        colorValues.add(0xFFA500);
        colorValues.add(0xFF4500);
        colorValues.add(0xDA70D6);
        colorValues.add(0xEEE8AA);
        colorValues.add(0x98FB98);
        colorValues.add(0xAFEEEE);
        colorValues.add(0xDB7093);
        colorValues.add(0xFFEFD5);
        colorValues.add(0xFFDAB9);
        colorValues.add(0xCD853F);
        colorValues.add(0xFFC8CB);
        colorValues.add(0xDDA0DD);
        colorValues.add(0xB0E0E6);
        colorValues.add(0x800080);
        colorValues.add(0xFF0000);
        colorValues.add(0xBC8F8F);
        colorValues.add(0x4169E1);
        colorValues.add(0x8B4513);
        colorValues.add(0xFA8072);
        colorValues.add(0xF4A460);
        colorValues.add(0x2E8B57);
        colorValues.add(0xFFF5EE);
        colorValues.add(0xA0522D);
        colorValues.add(0xC0C0C0);
        colorValues.add(0x87CEEB);
        colorValues.add(0x6A5ACD);
        colorValues.add(0xFFFAFA);
        colorValues.add(0x00FF7F);
        colorValues.add(0x4682B4);
        colorValues.add(0xD2B48C);
        colorValues.add(0xD8BFD8);
        colorValues.add(0x008080);
        colorValues.add(0xFF6347);
        colorValues.add(0x40E0D0);
        colorValues.add(0xEE82EE);
        colorValues.add(0xF5DEB3);
        colorValues.add(0xFFFFFF);
        colorValues.add(0xF5F5F5);
        colorValues.add(0xFFFF00);
        colorValues.add(0x9ACD32);
        
        int index = 0;
        for (String name : colorNames) {
        	colorMap.put(name, colorValues.get(index));
        	index++;
        }        
	}
}
