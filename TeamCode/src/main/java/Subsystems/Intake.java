package Subsystems;

import dev.nextftc.core.commands.Command;

import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.ServoEx;
import dev.nextftc.hardware.positionable.SetPosition;

public class Intake implements Subsystem {

    public static final Intake INSTANCE = new Intake();
    private Intake(){

    }

    private ServoEx claw = new ServoEx("garra");

    public Command open = new SetPosition(claw, 1).requires(this);

    public Command close = new SetPosition(claw, 0.3).requires(this);


}
