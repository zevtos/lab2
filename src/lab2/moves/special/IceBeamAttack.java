package lab2.moves.special;

import lab2.MyPokemon;
import ru.ifmo.se.pokemon.*;

public class IceBeamAttack extends SpecialMove {

    public IceBeamAttack() {
        super(Type.ICE, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        super.applyOppEffects(p);
        Effect e = new Effect().condition(Status.FREEZE).chance(0.1);
        p.addEffect(e);
    }

    @Override
    protected String describe() {
        return "выпускает мощный ледяной луч Ice Beam!";
    }
}