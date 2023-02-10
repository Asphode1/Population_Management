package com.lele.cnpm.src.utils;

import java.util.prefs.Preferences;

public class Preference {
  private final static Preferences prefs = Preferences.userRoot();

  public static boolean checkInitial() {
    if (prefs.get("com.lele.db.servername", null) == null)
      return true;
    return false;
  }

  public static String getValue(String key) {
    return prefs.get(key, "");
  }

  public static void setValue(String key, String value) {
    prefs.put(key, value);
  }

}
