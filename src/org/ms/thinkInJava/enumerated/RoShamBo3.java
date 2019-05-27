package org.ms.thinkInJava.enumerated;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/28 23:21
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {

    PAPER {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:  //To placate the compiler
                case PAPER: return Outcome.DRAW;
                case SCISSORS: return Outcome.LOSE;
                case ROCK: return Outcome.WIN;
            }
        }
    },
    SCISSORS {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER: return Outcome.WIN;
                case SCISSORS: return Outcome.DRAW;
                case ROCK: return Outcome.LOSE;
            }
        }
    },
    ROCK {
        @Override
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER: return Outcome.LOSE;
                case SCISSORS: return Outcome.WIN;
                case ROCK: return Outcome.DRAW;
            }
        }
    };

    public abstract Outcome compete(RoShamBo3 it);

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }

}
