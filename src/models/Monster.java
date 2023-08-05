package models;

public abstract class Monster extends DungeonCharacter {

    private static final String NEW_LINE = "\n";
    double myMonsterChanceToHeal;
    int myMinimumHealPoints;
    int myMaximumHealPoints;

    public Monster(String name, int healthPoints, int hitPoints, int attackSpeed, double chanceHit, int maxDamage, int minDamage) {
        super(name, healthPoints, hitPoints, minDamage, maxDamage, attackSpeed, chanceHit);
    }

    @Override
    public int attack() {
        return super.attack();
    }

    public int heal() {
        if (Math.random() < myMonsterChanceToHeal) {
            int healAmount;

            healAmount = (int) (Math.random() * (myMaximumHealPoints - myMinimumHealPoints + 1))
                    + myMinimumHealPoints;
            setCharacterHealthPoints(getCharacterHealthPoints() + healAmount);
            return healAmount;
        }
        return 0;
    }

    public void setMonsterChanceToHeal(final double chance) {
        myMonsterChanceToHeal = chance;
    }

    public double getMonsterChangeToHeal() {
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