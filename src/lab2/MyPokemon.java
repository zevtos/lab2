package lab2;

import lab2.pokemons.*;
import ru.ifmo.se.pokemon.*;
import lab2.moves.special.*;
import lab2.moves.status.*;

import java.util.*;

public class MyPokemon extends Pokemon {

    private static int HoppipID = 0, ElectrodeID = 0, ShroomishID = 0, PurrloinID = 0, BreloomID = 0, VoltorbID = 0;


    private MyPokemon(String name,
                     int level,
                     int hp,
                     int attack,
                     int defense,
                     int specialAttack,
                     int specialDefense,
                     int speed, Move[] attacks) {
        super(name, level);
        Objects.requireNonNull(name, "The name cannot be null");
        setStats(hp, attack, defense, specialAttack, specialDefense, speed);
        for (Move x : attacks) {
            addMove(x);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Battle battle = new Battle();

        // создание HashMap из существующих атак и существующих покемонов
        HashMap<String, Move> attacks = add_existing_attacks();
        HashMap<String, Pokemon> pokemons = add_existing_pokemons();

        System.out.println("MyPokemon program");
        int launchMethod = number_request(scanner, pokemons);
        int number_Ally, number_Foe;
        if (launchMethod == 2 || launchMethod == 3) {
            int[] teamSizes = initializeTeams(scanner);
            number_Ally = teamSizes[0];
            number_Foe = teamSizes[1];
            addPokemonsToTeams(scanner, battle, launchMethod, number_Foe, number_Ally, pokemons, attacks);
        } else {
            number_Ally = 3;
            number_Foe = 3;
            if (launchMethod == 1) {
                addPokemonsToTeams(scanner, battle, launchMethod, number_Foe, number_Ally, pokemons, attacks);
            } else {
                runTest(pokemons, battle);
            }
        }
        // Запускаем бой
        battle.go();
    }

    // тестовый запуск битвы(3x3 из уже существующих)
    private static void runTest(HashMap<String, Pokemon> pokemons, Battle battle) {
        System.out.println("Тестовый запуск:");
        int i = 0, lengt_Ally = pokemons.values().size() / 2;
        for (Pokemon value : pokemons.values()) {
            if (i < lengt_Ally) {
                battle.addAlly(value);
            } else {
                battle.addFoe(value);
            }
            i++;
        }
    }

    // добавление покемонов в команды в зависимости от способа запуска(launchMethod)
    private static void addPokemonsToTeams(Scanner scanner, Battle battle, int launchMethod, int number_Foe, int number_Ally, HashMap<String, Pokemon> pokemons, HashMap<String, Move> attacks) {
        if (launchMethod == 1) {
            System.out.println("Ручное создание покемонов и добавление к ним существующих атак");
        }
        int number_create_Ally = 0, number_create_Foe = 0;
        if (launchMethod == 3 || launchMethod == 1) {
            System.out.println("Введите количество покемонов которые будут созданы вручную для команды Ally");
            number_create_Ally = integer_request(scanner, 0, number_Ally);
            System.out.println("Введите количество покемонов которые будут созданы вручную для команды Foe");
            number_create_Foe = integer_request(scanner, 0, number_Foe);
            System.out.println("Создание покемонов в команду Ally");
            for (Pokemon x : create_pokemons(scanner, number_create_Ally, attacks)) {
                battle.addAlly(x);
            }
            System.out.println("Создание покемонов в команду Foe");
            for (Pokemon x : create_pokemons(scanner, number_create_Foe, attacks)) {
                battle.addFoe(x);
            }
        }
        if (launchMethod != 1) {
            displayAvailablePokemons(pokemons);
            for (Pokemon x : pokemons_request(scanner, number_Ally - number_create_Ally, pokemons, "Ally")) {
                battle.addAlly(x);
            }
            for (Pokemon x : pokemons_request(scanner, number_Foe - number_create_Foe, pokemons, "Foe")) {
                battle.addFoe(x);
            }
        }
    }

    // инициализация команд
    private static int[] initializeTeams(Scanner scanner) {
        int[] teamSizes = new int[2];

        System.out.println("Введите количество покемонов в команде Ally:");
        teamSizes[0] = integer_request(scanner, 1, 3);

        System.out.println("Введите количество покемонов в команде Foe:");
        teamSizes[1] = integer_request(scanner, 1, 3);

        return teamSizes;
    }

    // запрос способа запуска программы
    private static int number_request(Scanner scanner, HashMap<String, Pokemon> pokemons) {
        do {
            displayAvailablePokemons(pokemons);
            System.out.println("Введите способ запуска программы из предложенных");
            System.out.println("0 - тестовый запуск");
            System.out.println("1 - ручной ввод покемонов и ручное добавление атак");
            System.out.println("2 - выбор покемонов из уже существующих");
            System.out.println("3 - выбор покемонов + создание");
            if (scanner.hasNextInt()) {
                int ret = scanner.nextInt();
                scanner.nextLine();
                return ret;
            } else {
                System.out.println("Вы ввели не число. Пожалуйста, попробуйте снова.");
                scanner.nextLine(); // Сбрасываем буфер ввода
            }
        } while (true);
    }

    // создание HashMap состоящего из названий и объектов(атак)
    private static HashMap<String, Move> add_existing_attacks() {
        HashMap<String, Move> attacks = new HashMap<>();
        attacks.put("Blizzard", new BlizzardAttack());
        attacks.put("Eruption", new EruptionAttack());
        attacks.put("HydroPump", new HydroPumpAttack());
        attacks.put("IceBeam", new IceBeamAttack());
        attacks.put("PsyBeam", new PsybeamAttack());
        attacks.put("Thunderbolt", new ThunderboltAttack());
        attacks.put("ThunderShock", new ThunderShockAttack());
        attacks.put("LightScreen", new LightScreenAttack());
        attacks.put("ThunderWave", new ThunderWaveAttack());
        attacks.put("Trick", new TrickAttack());
        return attacks;
    }

    // создание HashMap состоящего из названий и объектов(покемонов)
    private static HashMap<String, Pokemon> add_existing_pokemons() {
        HashMap<String, Pokemon> pokemons = new HashMap<>();
        pokemons.put("Hoppip", new Hoppip("Чужой", 1));
        pokemons.put("Electrode", new Electrode("Хищник", 1));
        pokemons.put("Shroomish", new Shroomish("Грибок", 1));
        pokemons.put("Purrloin", new Purrloin("Скрыватель", 1));
        pokemons.put("Breloom", new Breloom("Брелум", 1));
        pokemons.put("Voltorb", new Voltorb("Вольт", 1));
        return pokemons;
    }

    // создание одного покемона на основе имени и уровня, с указанием его ID
    private static Pokemon createPokemon(String name, int level) {
        switch (name) {
            case "Hoppip":
                HoppipID++;
                return new Hoppip(name + HoppipID, level);
            case "Electrode":
                ElectrodeID++;
                return new Electrode(name + ElectrodeID, level);
            case "Shroomish":
                ShroomishID++;
                return new Shroomish(name + ShroomishID, level);
            case "Purrloin":
                PurrloinID++;
                return new Purrloin(name + PurrloinID, level);
            case "Breloom":
                BreloomID++;
                return new Breloom(name + BreloomID, level);
            case "Voltorb":
                VoltorbID++;
                return new Voltorb(name + VoltorbID, level);
            default:
                throw new IllegalArgumentException("Неизвестное имя покемона: " + name);
        }
    }

    // создание number покемонов и добвление им атак
    private static MyPokemon[] create_pokemons(Scanner scanner, int number, HashMap<String, Move> attacks) {
        MyPokemon[] pokemonArray = new MyPokemon[number];
        for (int i = 0; i < number; i++) {
            System.out.print("Введите через пробел название, уровень и характеристики: HP, attack, defense, special attack, special defense, speed: ");
            String input = scanner.nextLine();
            String[] inputParts = input.split(" ");
            if (inputParts.length != 8) {
                System.out.println("Неправильный формат ввода. Пожалуйста, введите все характеристики.");
                i--; // Чтобы повторно запросить характеристики для текущего индекса массива
                continue;
            }
            System.out.println("Укажите количество атак:");
            int number_attacks = integer_request(scanner, 1, 4);
            System.out.println("Укажите атаки покемона из доступных:");
            Move[] add_attacks = add_attacks(scanner, number_attacks, attacks);
            try {
                String name = inputParts[0];
                int level = Integer.parseInt(inputParts[1]);
                int hp = Integer.parseInt(inputParts[2]);
                int attack = Integer.parseInt(inputParts[3]);
                int defense = Integer.parseInt(inputParts[4]);
                int specialAttack = Integer.parseInt(inputParts[5]);
                int specialDefense = Integer.parseInt(inputParts[6]);
                int speed = Integer.parseInt(inputParts[7]);

                MyPokemon pokemon = new MyPokemon(name, level, hp, attack, defense, specialAttack, specialDefense, speed, add_attacks);
                pokemonArray[i] = pokemon; // Добавляем созданный покемон в массив
            } catch (NumberFormatException e) {
                System.out.println("Неправильный формат чисел. Пожалуйста, введите числовые значения.");
                i--; // Чтобы повторно запросить характеристики для текущего индекса массива
            }
        }
        return pokemonArray;
    }

    // создание массива атак(пользователь выбирает number атак)
    private static Move[] add_attacks(Scanner scanner, int number, HashMap<String, Move> attacks) {
        Move[] to_return = new Move[number];
        int count = 0;
        while (count < number) {
            System.out.println("Blizzard, Eruption, HeroPump, IceBeam, Psybeam, Thunderbolt, ThunderShock, LightScreen, ThunderWave, Trick");
            System.out.println("Введите атаку из предложенных выше");
            boolean flag = true;
            String input;
            do {
                input = scanner.nextLine();
                switch (input) {
                    case "Blizzard":
                    case "Eruption":
                    case "HydroPump":
                    case "IceBeam":
                    case "Psybeam":
                    case "Thunderbolt":
                    case "ThunderShock":
                    case "LightScreen":
                    case "ThunderWave":
                    case "Trick":
                        flag = false;
                        break;
                    default:
                        System.out.println("Неправильный формат или такая атака не создана. Доступные атаки:");
                        System.out.println("Blizzard, Eruption, HydroPump, IceBeam, Psybeam, Thunderbolt, ThunderShock, LightScreen, ThunderWave, Trick");
                }
            } while (flag);
            to_return[count] = attacks.get(input);

            count++;
        }
        return to_return;
    }

    // запрос пользователя на выбор number существующих покемонов в команду team
    private static Pokemon[] pokemons_request(Scanner scanner, int number, HashMap<String, Pokemon> pokemons, String team) {
        int count = 0;
        Pokemon[] to_return = new Pokemon[number];
        while (count < number) {
            System.out.println("Введите, соблюдая регистр, название покемона из предложенных ранее для добавления в команду " + team + " или help(для отображения существующих покемонов):");
            String input;
            do {
                input = scanner.next();
                if (pokemons.containsKey(input)) {
                    break;
                } else {
                    System.out.println("Неправильный формат ввода или такой покемон не был создан, доступные покемоны:");
                    displayAvailablePokemons(pokemons);
                }
            } while (true);
            to_return[count] = createPokemon(input, 1);
            count++;
        }
        return to_return;
    }

    // запрос пользователя на ввод числа в диапазоне от minValue до maxValue
    private static int integer_request(Scanner scanner, int minValue, int maxValue) {
        int number;
        do {
            System.out.print("Введите число от " + minValue + " до " + maxValue + ": ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine();
                if (number >= minValue && number <= maxValue) {
                    break;
                } else {
                    System.out.println("Число должно быть в диапазоне от " + minValue + " до " + maxValue);
                }
            } else {
                System.out.println("Вы ввели не число. Пожалуйста, попробуйте снова.");
                scanner.nextLine();
            }

        } while (true);

        return number;
    }

    // Выводит на экран доступных для добавления покемонов
    private static void displayAvailablePokemons(HashMap<String, Pokemon> pokemons) {
        System.out.println("Доступные покемоны для выбора:");
        Set<String> keys = pokemons.keySet();
        System.out.println(String.join(", ", keys));
    }
}