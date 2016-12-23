/*
* DemoActor.java
* Created on Dec 23, 2016, 8:53 PM
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
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;

/**
 Description of class goes here

 @author Maneesh Sharma */
public class DemoActor extends AbstractActor {
    /**
     * Create Props for an actor of this type.
     * @param magicNumber The magic number to be passed to this actor’s constructor.
     * @return a Props for creating this actor, which can then be further configured
     *         (e.g. calling `.withDispatcher()` on it)
     */
    static Props props(Integer magicNumber) {
        // You need to specify the actual type of the returned actor
        // since Java 8 lambdas have some runtime type information erased
        return Props.create(DemoActor.class, () -> new DemoActor(magicNumber));
    }

    private final Integer magicNumber;

    DemoActor(Integer magicNumber) {
        this.magicNumber = magicNumber;
        receive(ReceiveBuilder.
                match(Integer.class, i -> {
                    sender().tell(i + magicNumber, self());
                }).build()
        );
    }
}



