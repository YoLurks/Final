public class Player {
    
    private int x;
    private int y;
    private int speed;
    private String engineType;
    private int dTime;
    private boolean TireType;
    private int gear;

    public Player(int x, int y, String engineType, int dTime, boolean TireType){
        this.x = x;
        this.y = y;
        this.speed = 0;
        this.engineType = engineType;
        this.dTime = dTime;
        this.TireType = TireType;
        this.gear = 1; // it is always on gear one lil bro no neutral here
    }

    public void checkEngine(){
        //initializes the engines
        if (this.engineType == "V6 Engine" && this.speed <= 250){
            addSpeed(1);
        }

        if (this.engineType == "V8 Engine" && this.speed <= 270){
            addSpeed(2);
        }
        
        if (this.engineType == "V10 Engine" && this.speed <=290){
            addSpeed(3);
        }
        if (this.engineType == "LeEngine" && this.speed <=400000){
            addSpeed(4);
        }
    }

    public void addSpeed(int engineTypeAmp){
        if (this.gear == 1 && this.speed < 50){
            this.speed += 1 * engineTypeAmp;
        } else if (this.gear == 2 && this.speed < 90) {
            this.speed += 1 * engineTypeAmp;
        } else if (this.gear == 3 && this.speed < 130) {
            this.speed += 1 * engineTypeAmp;
        }  else if (this.gear == 4 && this.speed < 170) {
            this.speed += 1 * engineTypeAmp;
        }  else if (this.gear == 5 && this.speed < 200) {
            this.speed += 1 * engineTypeAmp;
        }  else if (this.gear == 6 && this.speed < 290) {
            this.speed += 1 * engineTypeAmp;
        }
    }

    public void addBreakPressure(){

        if(this.speed != 0){
            int counter = 1;
            if (counter == 10){
                counter = 1;
            } else {
                this.speed-=1 * counter;
            }
        }

    }

    // gearbox is sequential 
    public void shiftUp(){
        if (this.speed >= 30 && this.gear == 1){
            this.gear = 2;
        } else if (this.speed >= 80 && this.gear == 2){
            this.gear = 3;
        } else if (this.speed >= 120 && this.gear == 3){
            this.gear = 4; 
        } else if (this.speed >= 180 && this.gear == 4){
            this.gear = 5;
        }  else if (this.speed >= 210 && this.gear == 5){
           this.gear = 6;
        }
    }

    public void shiftDown(){
        if (this.speed <= 210 && this.gear == 6){
            this.gear = 5;
        } else if (this.speed <= 180 && this.gear == 5){
            this.gear = 4;
        } else if (this.speed <= 120 && this.gear == 4){
            this.gear = 3; 
        } else if (this.speed <= 80 && this.gear == 3){
            this.gear = 2;
        }  else if (this.speed <= 30 && this.gear == 2){
           this.gear = 1;
        }
    }

    public int getGear(){
        return this.gear;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getSpeed(){
        return this.speed;
    }

    public int getDeltaTime(){
        return this.dTime;
    }

    public boolean getTireType(){
        return this.TireType;
    }
}
