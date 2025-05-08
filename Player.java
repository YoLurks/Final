public class Player {

    private double x, y;
    private String kingdom;
    private String engineType;
    private String brakes;
    private String wheels;
    private boolean randomWeather;
    private int speed;

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
            calcSpeed(20, playerUpdate(20));
        }
        else if(engineType == "Overload Core"){
            calcSpeed(30, playerUpdate(20));
        } else if(engineType == "Matcha Core"){
            calcSpeed(50, playerUpdate(20));
        }
    }
    
    public void calcSpeed(double a, int t){
        speed += a * t /1000;
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

    public void moveX(){
        x += speed;
    }

    public void setX(double n){
        x = n;
    }

    public int playerUpdate(int time){
        return time;
    }
}