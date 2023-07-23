public abstract class Monster extends DungeonCharacter {

    private static final String NEW_LINE = "\n";
    double myMonsterChanceToHeal;
    int myMinimumHealPoints;
    int myMaximumHealPoints;

    public Monster(String name, int healthPoints, int hitPoints, int attackSpeed, double chanceHit, int maxDamage, int minDamage) {
        super(name, healthPoints, hitPoints, maxDamage, minDamage, attackSpeed, chanceHit);
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
        myMinimumHealPoints = maxHealPoints;
    }

    public int getMaximumHealPoints() {
        return myMaximumHealPoints;
    }

    @Override
    public String toString() {
        return super.toString() + "Monster's Chance to Heal: " + myMonsterChanceToHeal + NEW_LINE +
                "Monster's Minimum Heal Points: " + myMinimumHealPoints + NEW_LINE +
                "Monster's Maximum Heal Points: " + myMaximumHealPoints + NEW_LINE;
    }
}

class Ogre extends Monster {
    public Ogre(String name) {
        super(name, 200, 200, 2, 0.6, 60, 30);
        setMonsterChanceToHeal(0.1);
        setMinimumHealPoints(30);
        setMaximumHealPoints(60);
    }
}

class Gremlin extends Monster {
    public Gremlin(String name) {
        super(name, 70, 70, 5, 0.8, 30, 15);
        setMonsterChanceToHeal(0.4);
        setMinimumHealPoints(20);
        setMaximumHealPoints(40);
    }
}

class Skeleton extends Monster {
    public Skeleton(String name) {
        super(name, 100, 100, 3, 0.8, 50, 30);
        setMonsterChanceToHeal(0.3);
        setMinimumHealPoints(30);
        setMaximumHealPoints(50);
    }
}