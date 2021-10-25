package info.sandroalmeida;

public class RobotReturnToOrigin {

    public static boolean judgeCircle(String moves) {

        int[] coordenate = {0,0};
        for(char move: moves.toCharArray()){
            if(move == 'U')
                coordenate[0]++;
            else if(move == 'D')
                coordenate[0]--;
            else if(move == 'R')
                coordenate[1]++;
            else if(move == 'L')
                coordenate[1]--;
        }
        return coordenate[0] == 0 && coordenate[1] == 0;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("LDRRLRUULD"));
    }

}
