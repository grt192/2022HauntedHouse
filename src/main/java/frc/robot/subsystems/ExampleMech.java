// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class ExampleMech extends SubsystemBase {


  //solenoids, timer, and checkpoints/total time
  private Solenoid zarmleft;
  private Solenoid zarmright;
  private Timer time;

  private double totaltime;
  private double checkpoint1;

  public ExampleMech() {
    CommandScheduler.getInstance().registerSubsystem(this);
    zarmleft = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    zarmright = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
    time = new Timer();

    //cycle total time in seconds
    double totaltime = 4;

    //checkpoints in seconds
    double checkpoint1 = 0.3;

    //TODO if you want aspect of randomness, 
    //just use checkpoint1*(Math.random()*10) to scale, + or -
    //and make sure its under totaltime

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    //time interval that full 'cycle' will run in is totaltime.
    //within total time checkpoint1,2,3, then set mech to specified position

    //mech starts at a specified position
     zarmleft.set(true);
     //300 ms = 0.3 s
    if (time.hasElapsed(checkpoint1)) {
      zarmright.set(true);
    }
   
     if (time.hasElapsed(totaltime)) {
       time.reset();
     }


  }

  @Override
  public void simulationPeriodic() {
    periodic();
  }

}