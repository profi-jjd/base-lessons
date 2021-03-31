package com.profi.jjd.lesson7;

public class Knight extends BattleUnit {
    private final int additionalAttack = Settings.ADDITIONAL_ATTACK;

    public Knight(int healthScore, int attackScore) {
        super(healthScore, attackScore);
    }


    @Override
    public void rest() {
        plusHealth(2);
    }

    @Override
    public void attack(Unit unit) {
        unit.minusHealth(getAttackScore());
    }
}
