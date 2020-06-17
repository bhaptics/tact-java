package com.bhaptics.haptic.models.tact;

import java.util.Map;

public class Layout {
    private String type;
    private Map<String, LayoutObject[]> layouts;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, LayoutObject[]> getLayouts() {
        return layouts;
    }

    public void setLayouts(Map<String, LayoutObject[]> layouts) {
        this.layouts = layouts;
    }
}
