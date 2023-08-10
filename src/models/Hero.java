package models;

import java.io.Serial;
import java.io.Serializable;

public abstract class Hero extends DungeonCharacter implements Serializable {


    protected static final String NEW_LINE = "\n";
    @Serial
    private static final long serialVersionUID = 4675854409591872348L;

    private double myChanceToBlock;

    private String myHeroSpecialSkill;


    // Constructor

    public Hero(String name, int healthPoints, int hitPoints, int attackSpeed, double chanceHit,
                int maxDamage, int minDamage) {
        super(name, healthPoints, hitPoints, minDamage, maxDamage, attackSpeed, chanceHit);
    }


    // method

    public int specialAttack() {
        return 0;
    }

    public int standardAttack() {
        return super.attack();
    }

    public double getChanceToBlock() {
        return myChanceToBlock;
    }

    public void setChanceToBlock(double chanceToBlock) {
        this.myChanceToBlock = chanceToBlock;
    }

    protected String getHeroSpecialSkill() {
        return myHeroSpecialSkill;
    }

    // TODO: CAN BE REMOVED BC OF ABSTRACT specialAttack() method being overriden by heros
    protected void setHeroSpecialSkill(String heroSpecialSkill) {
        this.myHeroSpecialSkill = heroSpecialSkill;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Hero's Chance to Block: " + getChanceToBlock()+ NEW_LINE);
        sb.append("Hero's Special Skill: " + myHeroSpecialSkill + NEW_LINE);
        return sb.toString();
    }
}




