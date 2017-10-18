package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable {
    private static int hitCount;
    boolean isDebugOn = false;

    public BodyPart attack() {
        if (isDebugOn) System.out.print("Enter attack() : ");
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            if (isDebugOn) System.out.print("hitCount = " + hitCount + " : ");
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            if (isDebugOn) System.out.print("hitCount = " + hitCount + " : ");
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            if (isDebugOn) System.out.print("hitCount = " + hitCount + " : ");
//            hitCount = 0;
            attackedBodyPart = BodyPart.LEG;
        } else {
            attackedBodyPart = BodyPart.CHEST;
            hitCount = 0;
        }
        if (isDebugOn) System.out.println("Exit attack()");
        return attackedBodyPart;
    }

    public BodyPart defense() {
        if (isDebugOn) System.out.print("Enter defense() : ");
        BodyPart defencedBodyPart = null;
        hitCount = hitCount + 2;

        if (hitCount == 1) {
            if (isDebugOn) System.out.print("hitCount = " + hitCount + " : ");
            defencedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            if (isDebugOn) System.out.print("hitCount = " + hitCount + " : ");
            defencedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            if (isDebugOn) System.out.print("hitCount = " + hitCount + " : ");
//            hitCount = 0;
            defencedBodyPart = BodyPart.ARM;
        } else {
            defencedBodyPart = BodyPart.CHEST;
            hitCount = 0;
        }
        if (isDebugOn) System.out.println("Exit defense");
        return defencedBodyPart;
    }
}
