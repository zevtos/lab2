package lab2.moves.status;

import ru.ifmo.se.pokemon.*;

public class ThunderWaveAttack extends StatusMove {

    public ThunderWaveAttack() {
        super(Type.ELECTRIC, 90, 0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().condition(Status.PARALYZE));
        p.addEffect(new Effect().chance(0.75).stat(Stat.ACCURACY, 0));
        p.addEffect(new Effect().stat(Stat.SPEED, (int) p.getStat(Stat.SPEED) / 2));
    }

    @Override
    protected String describe() {
        return "отправляет врагам морскую волну Thunder Wave!";
    }
}