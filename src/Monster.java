public abstract class Monster extends DungeonCharacter {

    public Monster(String name, int hitPoints, int attackSpeed, double chanceHit, int maxDamage, int minDamage) {
        super(name, hitPoints, attackSpeed, chanceHit, maxDamage, minDamage )
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