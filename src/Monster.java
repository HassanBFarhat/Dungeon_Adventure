public abstract class Monster extends DungeonCharacter {

    double myMonsterChanceToHeal;
    int myMinimumHealPoints;
    int my MaximumHealPoints;

    public Monster(String name, int hitPoints, int attackSpeed, double chanceHit, int maxDamage, int minDamage) {
        super(name, hitPoints, attackSpeed, chanceHit, maxDamage, minDamage )
    }

    public int heal() {

    }

    public void setMonsterChanceToHeal() {

    }

    public double getMonsterChangeToHeal() {


    }

    public void setMinimumHealPoints() {

    }

    public int getMinimumHealPoints() {

    }

    public void setMaximumHealPoints() {

    }

    public int getMaximumHealPoints() {

    }

   @Override
    String toString() {

    }
}