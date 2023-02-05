public class Participant
{
    private String name;
        private int num_of_steps;
        private Vehicle red_car;

        public Participant(String name, int num_of_steps, Vehicle red_car){
            this.name = name;
            this.num_of_steps =0 ;
            this.red_car=red_car;
        }

        public int getNum_of_steps()
        {
            return this.num_of_steps;
        }

    public void move_any_car(){
        this.num_of_steps++;
    }

    public String getName() {
       return this.name;
    }

    public Vehicle Get_Red_Car() {
       return this.red_car;
    }

}

