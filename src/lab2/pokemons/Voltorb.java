package lab2.pokemons;

import lab2.moves.special.*;
import lab2.moves.status.*;
import ru.ifmo.se.pokemon.*;

public class Voltorb extends Pokemon {
    public Voltorb(String name, int level) {
        super(name, level);
        setStats(40, 30, 50, 55, 55, 100);
        setType(Type.ELECTRIC);
        setMove(
                new HydroPumpAttack(),
                new ThunderWaveAttack(),
                new LightScreenAttack()
        );
    }
}
