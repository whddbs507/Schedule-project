package com.whddbs.sm.context;

import java.util.Map;

public interface ApplicationContextListener {
  public abstract void contextInitialized(Map<String, Object> context);
  public abstract void contextDestroyed();
}
