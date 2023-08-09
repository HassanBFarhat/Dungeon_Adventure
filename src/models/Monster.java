package models;

import java.util.Random;

public abstract class Monster extends DungeonCharacter {

    private static final String NEW_LINE = "\n";
    double myMonsterChanceToHeal;
    int myMinimumHealPoints;
    int myMaximumHealPoints;

    public Monster(String name, int healthPoints, int hitPoints, int attackSpeed, double chanceHit, int maxDamage, int minDamage) {
        super(name, healthPoints, hitPoints, minDamage, maxDamage, attackSpeed, chanceHit);
    }


    public String getMonsterBattleImgFilePath() {
        return "No Main file found";
    }



    @Override
    public int attack() {
        return super.attack();
    }

    public int heal() {
        final Random random = new Random();
        int randomHeal = 0;
        final int randomChanceToHeal = (int) (Math.random() * 100);
        if (randomChanceToHeal >= (1 - getMonsterChanceToHeal())) {
            randomHeal = random.nextInt(
                    getMaximumHealPoints() - getMinimumHealPoints() + 1)
                    + getMinimumHealPoints();
        }
        return randomHeal;
    }

    public void setMonsterChanceToHeal(final double chance) {
        myMonsterChanceToHeal = chance;
    }

    public double getMonsterChanceToHeal() {
        return myMonsterChanceToHeal;
    }

    public void setMinimumHealPoints(int minHealPoints) {
        myMinimumHealPoints = minHealPoints;
    }

    public int getMinimumHealPoints() {
        return myMinimumHealPoints;
    }

    public void setMaximumHealPoints(final int maxHealPoints) {
        myMaximumHealPoints = maxHealPoints;
    }

    public int getMaximumHealPoints() {
        return myMaximumHealPoints;
    }

    @Override
    public String toString() {
        return super.toString() + "Monster's Chance to Heal: " + myMonsterChanceToHeal + NEW_LINE
                + "Monster's Minimum Heal Points: " + myMinimumHealPoints + NEW_LINE
                + "Monster's Maximum Heal Points: " + myMaximumHealPoints + NEW_LINE;
    }
}