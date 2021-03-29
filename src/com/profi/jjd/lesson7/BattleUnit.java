package com.profi.jjd.lesson7;

abstract public class BattleUnit
        extends Unit implements AttackAble{
    private int attackScore;

    public BattleUnit(int healthScore, int attackScore){
        super(healthScore); // вызов конструктора родителя
        this.attackScore = attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    }
}
