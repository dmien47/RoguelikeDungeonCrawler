public class Potion extends Item {
    private int healAmount;

    public Potion(String name, String type, int healAmount) {
        super(name, type);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

}
