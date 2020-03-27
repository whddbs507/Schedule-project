package com.whddbs.sm;

import java.util.Map;
import com.whddbs.sm.context.ApplicationContextListener;

public class GreetingListener implements ApplicationContextListener {
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("[수업관리시스템]에 오신걸 환영합니다.");
  }
  public void contextDestroyed() {
    System.out.println("안녕히가세요 ^^");
  }
}
