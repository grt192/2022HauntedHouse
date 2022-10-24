// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ExampleAutoCommand;
import frc.robot.subsystems.IntervalMech;
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

    // placeholder values
    private final int TEMP_DELAY = 2;
    private final int TEMP_PERIOD = 15;
    private final int TEMP_HOLD_DURATION = 5;

    // LOWER FLOOR
    private final IntervalSolenoid aidenMech = new IntervalSolenoid(new MotorControllerSolenoid(AIDEN_ID), 0, 3, 3, 1);
    private final IntervalSolenoid ryanMech = new IntervalSolenoid(new MotorControllerSolenoid(RYAN_ID), 2, 30, 30, 10);
    private final IntervalSolenoid matthewMech = new IntervalSolenoid(new MotorControllerSolenoid(MATTHEW_ID), 4, 10, 10, 3);

    // UPPER FLOOR
    
    // private final IntervalSolenoid shiraMech = new IntervalSolenoid(new MotorControllerSolenoid(SHIRA_ID), 6, 0, 0, 1);
    // private final IntervalSolenoid oliviaMech = new IntervalSolenoid(
        // new RepeaterSolenoids(new MotorControllerSolenoid(OLIVIA_ID), 3), 8, 20, 20, 10); // hold repeater solenoid for 10 sec; repeat again after 20 sec 

    private final IntervalSolenoid jacobMech = new IntervalSolenoid(new MotorControllerSolenoid(JACOB_ID), 1, 15, 15, 5);

    // STAIRS
    //private final IntervalSolenoid keplerMech = new IntervalSolenoid(new PCMSolenoid(KEPLER_ID), 3, 10, 10, 5);

    // PORCH
    private final IntervalSolenoid julianMech = new IntervalSolenoid(new PCMSolenoid(JULIAN_ID, true), 5, 12, 12, 5);

    private final ExampleAutoCommand autoCommand = new ExampleAutoCommand();

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();

        // initialize shuffleboard entries
        createShuffleboardToggle(aidenMech, "aiden");
        createShuffleboardToggle(ryanMech, "ryan");
        createShuffleboardToggle(matthewMech, "matthew");
        // createShuffleboardToggle(shiraMech, "shira");
        // createShuffleboardToggle(oliviaMech, "olivia");
        createShuffleboardToggle(jacobMech, "jacob");
        // createShuffleboardToggle(keplerMech, "kepler");
        createShuffleboardToggle(julianMech, "julian");
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

    public void createShuffleboardToggle(IntervalMech mech, String name) {
        ShuffleboardTab tab = Shuffleboard.getTab("mechs");
        tab.add(name, true).withWidget(BuiltInWidgets.kToggleSwitch).getEntry().addListener(mech::toggle, EntryListenerFlags.kUpdate);
    }

}
