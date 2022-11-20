class Enemy extends Character {
    public int damage;
    public int hp;
    public int maxHp;
    
   

    public Enemy(String name, int maxHp, int damage){
        super(name, maxHp);
        this.damage = damage;
        this.hp = maxHp;
        this.maxHp = maxHp;

       
    }

    public void enemyAttack(Player player){
        player.hp -= this.damage;
        System.out.println(this.name + " did " + Integer.toString(this.damage) + " damage");

    }

    public void editEnemy(String name, int maxHp, int damage){
        this.name = name;
        this.maxHp = maxHp;
        this.damage = damage;
    }
}

