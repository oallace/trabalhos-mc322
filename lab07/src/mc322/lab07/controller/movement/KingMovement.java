package mc322.lab07.controller.movement;

import java.util.ArrayList;

public class KingMovement extends Movement{

    public ArrayList<int[]> getValidMoves(){

        ArrayList<int[]> moves = new ArrayList<>();

        moves.addAll(untilBlockedPath(1, 0, true, 1));
        moves.addAll(untilBlockedPath(-1, 0, true, 1));
        moves.addAll(untilBlockedPath(0, 1, true, 1));
        moves.addAll(untilBlockedPath(0, -1, true, 1));
        moves.addAll(untilBlockedPath(1, 1, true, 1));
        moves.addAll(untilBlockedPath(-1, 1, true, 1));
        moves.addAll(untilBlockedPath(1, -1, true, 1));
        moves.addAll(untilBlockedPath(-1, -1, true, 1));

        return moves;
    }
}
