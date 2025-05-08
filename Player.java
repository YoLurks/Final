public class Player {

    private double x, y;
    private String kingdom;
    private String engineType;
    private String brakes;
    private String wheels;
    private boolean randomWeather;

    private Player(double x, double y, String kingdom, String engineType, String brakes, String wheels){
        this.x = x;
        this.y = y;
        this.kingdom = kingdom;
        this.engineType = engineType;
        this.brakes = brakes;
        this.wheels = wheels;
    }

    public void speedMultiplier(String engineType){
        if (engineType == "Shortcake Core"){
            int acc = 1;
            for(int i = 0; i < 50; i++){
                if( i == 49 ){
                    i = 0;
                }
                acc += 1;
                moveX( x * acc);
            }
        }
        else if(engineType == "Overload Core"){
            int acc = 3;
            for(int i = 0; i < 70; i++){
                if( i == 69 ){
                    i = 0;
                }
                acc += 2;
                moveX( x * acc);
            }
        } else if(engineType == "Matcha Core"){
            int acc = 5;
            for(int i = 0; i < 120; i++){
                if( i == 69 ){
                    i = 0;
                }
                acc += 2;
                moveX( x * acc);
            }
        }
    }

    public void brakesMultiplier(String brakes){
        if (engineType == "Candy Brakes"){

        }
        else if(engineType == "Stripe Brakes"){

        } else if(engineType == "Magic Brakes"){

        }
    }

    public void tireCheck(String wheels){
        if (wheels == "Slicks" && randomWeather == true){

        } else {

        }
        if (wheels == "Wets" && randomWeather == false){

        } else {

        }
    }

    public void moveX(double n){
        x +=  n;
    }

    public void setX(double n){
        x = n;
    }
}