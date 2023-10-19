package lab2.moves.special;

import ru.ifmo.se.pokemon.*;

public class HydroPumpAttack extends SpecialMove {
    public HydroPumpAttack() {
        super(Type.WATER, 110, 80);
    }

    @Override
    protected String describe() {
        return "выпускает мощный струйный поток воды Hydro Pump!";
    }
}
