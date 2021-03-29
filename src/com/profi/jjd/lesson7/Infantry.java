package com.profi.jjd.lesson7;

public class Infantry extends BattleUnit{
    private int additionalHealth = 7;

    public Infantry(int healthScore, int attackScore) {
        super(healthScore, attackScore);
    }

    @Override
    public void rest() {
        plusHealth(1);
    }

    @Override
    public void attack(Unit unit) {
        unit.minusHealth(getAttackScore());
        if (!unit.isAlive()) plusHealth(additionalHealth);
    }
}
