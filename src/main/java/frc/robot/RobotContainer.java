// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ExampleAutoCommand;
import frc.robot.subsystems.IntervalMotor;
import frc.robot.subsystems.IntervalSolenoid;
import frc.robot.subsystems.solenoids.DelaySolenoids;
import frc.robot.subsystems.solenoids.MotorControllerSolenoid;
import frc.robot.subsystems.solenoids.PCMSolenoid;
import frc.robot.subsystems.solenoids.ParallelSolenoids;
import frc.robot.subsystems.solenoids.RepeaterSolenoids;
import static frc.robot.Constants.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...

    // temporary placeholder values
    // also replace port #s
    private final int TEMP_DELAY = 2;
    private final int TEMP_PERIOD = 15;
    private final int TEMP_HOLD_DURATION = 5;

    // LOWER FLOOR
    private final IntervalSolenoid aidenMech = new IntervalSolenoid(new MotorControllerSolenoid(AIDEN_ID), TEMP_DELAY, TEMP_PERIOD, TEMP_PERIOD, TEMP_HOLD_DURATION);
    private final IntervalSolenoid ryanMech = new IntervalSolenoid(new MotorControllerSolenoid(RYAN_ID), TEMP_DELAY, 60, 60, 10);
    private final IntervalSolenoid matthewMech = new IntervalSolenoid(new MotorControllerSolenoid(MATTHEW_ID), TEMP_DELAY, 5, 5, 2);

    // UPPER FLOOR
    private final IntervalSolenoid shiraMech = new IntervalSolenoid(new MotorControllerSolenoid(SHIRA_ID), TEMP_DELAY, 0, 0, 1);
    private final IntervalSolenoid oliviaMech = new IntervalSolenoid(
        new RepeaterSolenoids(new MotorControllerSolenoid(OLIVIA_ID), 3), TEMP_DELAY, 20, 20, 10); // hold repeater solenoid for 10 sec; repeat again after 20 sec 
    private final IntervalSolenoid jacobMech = new IntervalSolenoid(new MotorControllerSolenoid(JACOB_ID), TEMP_DELAY, TEMP_PERIOD, TEMP_PERIOD, TEMP_HOLD_DURATION);

    // STAIRS
    private final IntervalSolenoid keplerMech = new IntervalSolenoid(new PCMSolenoid(KEPLER_ID), TEMP_DELAY, 10, 10, 5);

    // PORCH
    private final IntervalSolenoid julianMech = new IntervalSolenoid(new PCMSolenoid(JULIAN_ID), TEMP_DELAY, TEMP_PERIOD, TEMP_PERIOD, TEMP_HOLD_DURATION);

    /*
     * private final IntervalSolenoid tylerMech = new IntervalSolenoid(new
     * MotorControllerSolenoid(0), 2, 15, 25, 5);
     * 
     * private final IntervalSolenoid ethanMech = new IntervalSolenoid(new
     * MotorControllerSolenoid(1), 4, 6, 15, 5);
     * 
     * private final IntervalSolenoid roMech = new IntervalSolenoid(new
     * MotorControllerSolenoid(2), 6, 6, 15, 5);
     * 
     * private final IntervalSolenoid mattyMech = new IntervalSolenoid(
     * new DelaySolenoids(new MotorControllerSolenoid(12), new
     * MotorControllerSolenoid(13), 1), 8, 8, 15, 5);
     * 
     * private final IntervalSolenoid alexMech = new IntervalSolenoid(
     * new ParallelSolenoids(new MotorControllerSolenoid(14), new
     * MotorControllerSolenoid(15)), 10, 7, 15, 4);
     * 
     * private final IntervalSolenoid lucyMech = new IntervalSolenoid(new
     * MotorControllerSolenoid(3), 12, 7, 15, 10);
     * 
     * private final IntervalSolenoid aarushMech = new IntervalSolenoid(
     * new ParallelSolenoids(new PCMSolenoid(0, true), new RepeaterSolenoids(new
     * PCMSolenoid(1, true), 3)), 14, 15, 28, 12);
     */

    private final ExampleAutoCommand autoCommand = new ExampleAutoCommand();

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return autoCommand;
    }
}
