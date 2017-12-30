package org.ms.thinkInJava.generics;

/**
 * Created by Ryan on 2017/10/23.
 */
public class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {
    SuperSleuth(POWER power){
        super(power);
    }

    void  see(){
        power.seeThroughWalls();
    }
}
