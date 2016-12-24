/*
* GraduallyBuiltActor.java
* Created on Dec 23, 2016, 8:48 PM
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

/**
 Description of class goes here

 @author Maneesh Sharma */

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import akka.japi.pf.UnitPFBuilder;

public class GraduallyBuiltActor extends AbstractActor {
  private final LoggingAdapter log = Logging.getLogger(context().system(), this);

  public GraduallyBuiltActor() {
    UnitPFBuilder<Object> builder = ReceiveBuilder.create();
    builder.match(String.class, s -> {
      log.info("Received String message: {}", s);
    });
    // do some other stuff in between
    builder.matchAny(o -> log.info("received unknown message"));
    receive(builder.build());
  }
}
