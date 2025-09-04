package Subsystems;


import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.subsystems.Subsystem;

import dev.nextftc.hardware.controllable.RunToPosition;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.core.commands.Command;



public class Extend implements Subsystem {

    public static final Extend INSTANCE = new Extend();
    private Extend(){}

    private MotorEx extend = new MotorEx("extend");

    private ControlSystem controlSystem = ControlSystem.builder()
            .posPid(0, 0, 0)
            .elevatorFF(0)
            .build();

    public Command toLow() = new RunToPosition(controlSystem,0).requires(this);

    @Override
    public void periodic() {
        extend.setPower(controlSystem.calculate(extend.getState()));
    }

}