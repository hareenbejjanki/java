package com.bhirava.ovilearning.ui.util;

import java.util.Properties;

public class PropertyValues {

    private Properties positionProperties;
    private Properties stylesProperties;
    private Properties textAndPathsProperties;
    private Properties otherProperties;
    private Properties generalProperties;

    public Properties getPositionProperties() {
        return positionProperties;
    }

    public void setPositionProperties(Properties positionProperties) {
        this.positionProperties = positionProperties;
    }

    public Properties getStylesProperties() {
        return stylesProperties;
    }

    public void setStylesProperties(Properties stylesProperties) {
        this.stylesProperties = stylesProperties;
    }

    public Properties getTextAndPathsProperties() {
        return textAndPathsProperties;
    }

    public void setTextAndPathsProperties(Properties textAndPathsProperties) {
        this.textAndPathsProperties = textAndPathsProperties;
    }

    public Properties getOtherProperties() {
        return otherProperties;
    }

    public void setOtherProperties(Properties otherProperties) {
        this.otherProperties = otherProperties;
    }

    public Properties getGeneralProperties() {
        return generalProperties;
    }

    public void setGeneralProperties(Properties generalProperties) {
        this.generalProperties = generalProperties;
    }

    public PropertyValues(Properties positionProperties, Properties stylesProperties, Properties textAndPathsProperties, Properties otherProperties,
            Properties generalProperties) {
        this.positionProperties = positionProperties;
        this.stylesProperties = stylesProperties;
        this.textAndPathsProperties = textAndPathsProperties;
        this.otherProperties = otherProperties;
        this.generalProperties = generalProperties;
    }

}
