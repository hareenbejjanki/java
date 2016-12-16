package com.bhirava.ovilearning.ui.util;

import java.awt.Color;
import java.awt.Font;
import java.net.URI;
import java.util.Properties;

import com.bhirava.ovilearning.constants.FontStyle;
import com.bhirava.ovilearning.constants.UIConstants;

public class PropertyUtil {

    public static Integer getInteger(Properties properties, String key) {
        return getInteger(properties, key, null);
    }

    public static Integer getInteger(Properties properties, String key, Integer defaultValue) {
        try {
            return Integer.parseInt(properties.getProperty(key));
        } catch (Exception exception) {
            return defaultValue;
        }
    }

    public static Color getColor(Properties properties, String key) {
        return getColor(properties, key, null);
    }

    public static Color getColor(Properties properties, String key, Color defaultValue) {
        try {
            String color = properties.getProperty(key);
            if (color.charAt(0) == '#') {
                color = color.substring(1);
            }

            if (color.length() != 6 && color.length() != 3) {
                return defaultValue;
            }

            String[] colors = color.split("");
            if (color.length() == 3) {
                colors[0] += colors[0];
                colors[1] += colors[1];
                colors[2] += colors[2];
            } else {
                colors[0] = colors[0] + colors[1];
                colors[1] = colors[2] + colors[3];
                colors[2] = colors[4] + colors[5];
            }

            String opacity = properties.getProperty(key + UIConstants.Styles.OPACITY_POSTFIX);
            if (opacity != null && (opacity.length() == 1 || opacity.length() == 2)) {
                if (opacity.length() == 1) {
                    opacity += opacity;
                }

                return new Color(Integer.parseInt(colors[0], 16), Integer.parseInt(colors[1], 16), Integer.parseInt(colors[2], 16), Integer.parseInt(opacity,
                        16));
            } else {
                return new Color(Integer.parseInt(colors[0], 16), Integer.parseInt(colors[1], 16), Integer.parseInt(colors[2], 16));
            }
        } catch (Exception exception) {
            return defaultValue;
        }
    }

    public static String getPath(Properties properties, String key) {
        return getPath(properties, key, "");
    }

    public static String getPath(Properties properties, String key, String prefix) {
        String pathPrefix = System.getenv("OVILEARNING_HOME");
        String path = properties.getProperty(key);
        System.out.println(path);
        if (path == null) {
        	System.out.println(prefix + pathPrefix);
            return prefix + pathPrefix;
        } else {
        	System.out.println(prefix + pathPrefix + path);
            return prefix + pathPrefix + path;
        }
    }

    public static Font getFont(Properties properties, String key) {
        String fontFamily = properties.getProperty(key + UIConstants.Styles.FAMILY_POSTFIX);
        if (fontFamily == null || fontFamily.isEmpty()) {
            fontFamily = UIConstants.Styles.DEFAULT_FONT_FAMILY;
        }

        String fontSizeAsString = properties.getProperty(key + UIConstants.Styles.SIZE_POSTFIX);
        int fontSize;
        try {
            fontSize = Integer.parseInt(fontSizeAsString);
        } catch (Exception exception) {
            fontSize = UIConstants.Styles.DEFAULT_FONT_SIZE;
        }

        String fontStyleAsString = properties.getProperty(key + UIConstants.Styles.STYLE_POSTFIX);
        int fontStyle;
        try {
            if (fontStyleAsString.equalsIgnoreCase(FontStyle.BOLD.name())) {
                fontStyle = Font.BOLD;
            } else if (fontStyleAsString.equalsIgnoreCase(FontStyle.ITALIC.name())) {
                fontStyle = Font.ITALIC;
            } else {
                fontStyle = Font.PLAIN;
            }
        } catch (Exception exception) {
            fontStyle = UIConstants.Styles.DEFAULT_FONT_STYLE;
        }

        return new Font(fontFamily, fontStyle, fontSize);
    }

}
