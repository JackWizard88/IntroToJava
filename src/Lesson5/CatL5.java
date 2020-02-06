package Lesson5;

public class CatL5 extends AnimalL5 {
    private boolean satiaty;
    private String name;
    private int runLimit;
    private double jumpLimit;
    private int appetitus;

    public CatL5(String _name, int _runLimit, double _jumpLimit, int _appetitus ) {
        this.name = _name;
        this.runLimit = _runLimit;
        this.jumpLimit = _jumpLimit;
        this.satiaty = false;
        this.appetitus = _appetitus;
    }

    public int getAppetitus() {
        return appetitus;
    }

    public String getName() {
        return this.name;
    }

    public void catEat(Bowl bowl) {
        try {
            if (this.appetitus > bowl.getFilling() && this.appetitus > bowl.getVolume() ) {
                throw new MyException("Котик не может поесть из миски, его аппетит ("+ this.getAppetitus() +") больше чем в миске еды (" + bowl.getFilling() + "). \n" +
                        "И даже если миску наполнить, он всёравно черезчур прожорлив... купите ему миску побольше");
            } else if (this.appetitus > bowl.getFilling() && this.appetitus <= bowl.getVolume()) {
                System.out.println("В миске не хватает еды? надо досыпать!");
                bowl.setFilling(bowl.getVolume());
                this.catEat(bowl);
            } else {
                System.out.println("Котик покушал");
                this.satiaty = true;
                bowl.setFilling(bowl.getFilling() - this.appetitus);
            }

        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Имя: " + this.name + "\nКушает за раз: " + this.appetitus + " единиц еды" + "\nТекущая сытость: " + (this.satiaty ? " сыт" : " голоден") +
                "\n--------------------конец-данных----------------------------------- ";
    }

}
