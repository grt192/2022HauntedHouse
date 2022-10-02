// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ExampleMech;

/** An example command that uses an example subsystem. */
public class ExampleAutoCommand extends SequentialCommandGroup {
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ExampleAutoCommand() {
    // addCommands(new ExampleAutoCommand(examplemech),
    //     // do something quirky here
    //     new ExampleAutoCommand(examplemech) // follow another path
    // // maybe do something else quirky
    // );
  }
}
