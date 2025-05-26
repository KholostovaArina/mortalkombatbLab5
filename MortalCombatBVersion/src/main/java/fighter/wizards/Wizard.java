package fighter.wizards;

import fighter.Enemy;
public abstract class Wizard extends Enemy {

    public Wizard() {
        super();
        this.damage = 35;
        this.currentHp = 75;
        this.maxHp = 75;
        this.type = "Маг";
        this.numberType = this.getBehaviorType(this.type);
        calculateInfo(this.level);
    }

    private void calculateInfo(int level) {
        switch (level) {
            case 0 ->  {this.damage = 35; this.maxHp = 75; }
            case 1 ->  {this.damage = 50; this.maxHp = 100; }
            case 2 ->  {this.damage = 65; this.maxHp = 125; }
            case 3 ->  {this.damage = 80; this.maxHp = 150; }
            case 4 ->  {this.damage = 95; this.maxHp = 175; }
            case 5 ->  {this.damage = 110; this.maxHp = 200; }
            default -> throw new IllegalArgumentException("Некорректный уровень: " + level);
        }
        this.currentHp = this.maxHp;
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
        calculateInfo(level);
    }


}
