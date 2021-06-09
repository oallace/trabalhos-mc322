package mc322.lab07.controller.state;

import mc322.lab07.controller.StateMachineController;

public class TurnEndState extends State{

    public void enter(){
        System.out.println("TurnEndState:");
        
        StateMachineController.instance.changeTo(new TurnBeginState());
    }
}
