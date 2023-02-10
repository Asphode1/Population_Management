package com.lele.cnpm.src.utils;

import java.util.prefs.Preferences;

public class Preference {
  public final static Preferences PREFERENCES = Preferences.userRoot();

  public static boolean checkInitial() {
    if (PREFERENCES.get("com.lele.db.servername", null) == null)
      return true;
    return false;
  }

  public static String getValue(String key) {
    return PREFERENCES.get(key, "");
  }

  public static void setValue(String key, String value) {
    PREFERENCES.put(key, value);
  }

}
