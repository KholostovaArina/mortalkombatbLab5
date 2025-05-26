package fighter.fighters;

import fighter.Enemy;


public abstract class Fighter extends Enemy {

    public Fighter() {
        super();
        this.damage = 50;
        this.maxHp = 85;
        this.type = "Боец";
        this.numberType = this.getBehaviorType(this.type);
        calculateInfo(this.level);
    }

    private void calculateInfo(int level) {
        switch (level) {
            case 0 ->  {
                this.damage = 50;
                this.maxHp = 85;
            }
            case 1 ->  {
                this.damage = 65;
                this.maxHp = 110;
            }
            case 2 ->  {
                this.damage = 80;
                this.maxHp = 135;
            }
            case 3 ->  {
                this.damage = 95;
                this.maxHp = 160;
            }
            case 4 ->  {
                this.damage = 110;
                this.maxHp = 185;
            }
            case 5 ->  {
                this.damage = 125;
                this.maxHp = 210;
            }
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
