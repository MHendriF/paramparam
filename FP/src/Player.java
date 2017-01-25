public class Player {
    public static String _Player[][] = new String [20][20];
    public static String _Nmgrup;
    Player(){
        for(int i=0; i<_Player.length; i++){
            for(int j=0; j<_Player.length; j++){
                _Player[i][j] = "nol";
            }
        }
    }
    
    public void playerClear(){
        for(int i=0; i<_Player.length; i++){
            for(int j=0; j<_Player.length; j++){
                _Player[i][j] = "nol";
            }
        }
    }
}
