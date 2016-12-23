/*
* DemoMessagesActor.java
* Created on Dec 23, 2016, 9:09 PM
*
* Copyright 2008-2016 LiveAction, Incorporated. All Rights Reserved.
* 3945 Freedom Circle, Suite 360, Santa Clara, California 95054-1267, U.S.A.
*
* This software is the confidential and proprietary information
* of LiveAction ("Confidential Information").
* You shall not disclose such Confidential Information and shall use
* it only in accordance with the terms of the license agreement
* you entered into with LiveAction.
*/

package akka.demo;

import akka.actor.AbstractLoggingActor;
import akka.japi.pf.ReceiveBuilder;

/**
 * Description of class goes here
 * 
 * @author Maneesh Sharma
 */
public class DemoMessagesActor extends AbstractLoggingActor {

  static public class Greeting {
    private final String from;

    public Greeting(String from) {
      this.from = from;
    }

    public String getGreeter() {
      return from;
    }
  }

  DemoMessagesActor() {
    receive(ReceiveBuilder.match(Greeting.class, g -> {
      log().info("I was greeted by {}", g.getGreeter());
    }).build());
  };
}
