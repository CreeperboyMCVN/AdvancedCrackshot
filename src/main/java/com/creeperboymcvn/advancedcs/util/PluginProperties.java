package com.creeperboymcvn.advancedcs.util;

import com.creeperboymcvn.advancedcs.ACS;

public class PluginProperties {

    public static ACS inst = ACS.inst;

    public static boolean ADVANCED_SCOPE = inst.getConfig().getBoolean("advancedScope");
    public static boolean VISUAL_INDICATOR = inst.getConfig().getBoolean("visualIndicator.enable");
}
