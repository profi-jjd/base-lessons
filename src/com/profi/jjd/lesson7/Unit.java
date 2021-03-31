package com.profi.jjd.lesson7;

abstract public class Unit implements RestAble{
    protected int healthScore;
    protected final int maxHealthScore;

    public Unit(int healthScore) {
        this.healthScore = healthScore;
        maxHealthScore = healthScore;
    }

    public boolean isAlive(){
        return healthScore > 0;
    }
    // увеличивает значение healthScore на count,
    // но не больше maxHealthScore
    public void plusHealth(int count) {
        if (!isAlive()) return;
        /*healthScore = healthScore + count >= maxHealthScore ?
                maxHealthScore : healthScore + count;*/
        healthScore = Math.min(healthScore + count, maxHealthScore);
    }

    // уменьшает значение healthScore на count
    public void minusHealth(int count) {
        if (!isAlive()) return;
        healthScore -= count;
    }


}
