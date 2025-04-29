public class Potion extends Item {
    private int healAmount;

    public Potion(String name, String type, int healAmount) {
        super(name, type);
        this.healAmount = healAmount;
    }

    public Potion(Potion potion){
        super(potion.getName(), potion.getType());
        this.healAmount = potion.getHealAmount();
    }

    public int getHealAmount() {
        return healAmount;
    }

}
