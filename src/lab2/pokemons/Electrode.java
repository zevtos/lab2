package lab2.pokemons;

import lab2.moves.special.*;
import lab2.moves.status.*;
import ru.ifmo.se.pokemon.*;

public class Electrode extends Pokemon {
    public Electrode(String name, int level) {
        super(name, level);
        setStats(60, 50, 70, 80, 80, 150);
        setType(Type.ELECTRIC);
        setMove(
                new HydroPumpAttack(),
                new ThunderWaveAttack(),
                new LightScreenAttack()
        );
    }
}
