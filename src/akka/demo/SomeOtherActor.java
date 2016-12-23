/*
* SomeOtherActor.java
* Created on Dec 23, 2016, 8:57 PM
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

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

/**
 Description of class goes here

 @author Maneesh Sharma */
public class SomeOtherActor extends AbstractActor {
    // Props(new DemoActor(42)) would not be safe
    ActorRef demoActor = context().actorOf(DemoActor.props(42), "demo");
    // ...
} 
