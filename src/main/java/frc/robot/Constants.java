// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.util.PIDConstants;
import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.util.LinearInterpolation;
import frc.robot.util.PolynomialRegression;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int driverControllerPort = 0;
    public static final int operatorControllerPort = 1;

    public static final int intakeNoteButton = 13;

    public static final int shootButton = 12;

    public static final int armToPickup = 5;
    public static final int armToSubwoofer = 6;
    public static final int armToPodium = 7;
    public static final int armToAmp = 8;
    public static final int armAutoShoot = 14;

    public static final int armManualUp = 10;
    public static final int armManualDown = 9;

    public static final int armPreciseManualAdjustment = 16;

    public static final int climberButton = 1;
    public static final int leftClimberButton = 3;
    public static final int rightClimberButton = 4;

    public static final int manualShootButton = 12;
    public static final int manualFeedButton = 11;
    public static final int manualOuttakeButton = 15;

    public static final int ledWarningButton = 2;
  }

  public static final class FieldConstants {
    public static final double fieldLength = 16.541;
    public static final double fieldWidth = 8.211;

    public static final AprilTagFieldLayout aprilTagLayout =
        AprilTagFields.k2024Crescendo.loadAprilTagLayoutField();

    public static final Pose2d speakerBlueAlliance =
        new Pose2d(0.0, 5.5, Rotation2d.fromDegrees(0.0));
    public static final Pose2d speakerRedAlliance =
        new Pose2d(16.54, 5.5, Rotation2d.fromDegrees(180.0));

    public static Pose2d driverStationBlueAlliance = new Pose2d();
    public static Pose2d driverStationRedAlliance = new Pose2d();

    public static Transform3d blueOriginFromCenter =
        new Transform3d(fieldLength / 2, fieldWidth / 2, 0.0, new Rotation3d());
  }

  public static final class StationCoordinateConstants {
    public static final class CenterChainPoses {
      public static final Pose2d bottomRightChainRedStage =
          new Pose2d(new Translation2d(12.41, 2.87), Rotation2d.fromDegrees(-59.30));
      public static final Pose2d topRightChainRedStage =
          new Pose2d(new Translation2d(12.39, 5.32), Rotation2d.fromDegrees(60));
      public static final Pose2d leftChainRedStage =
          new Pose2d(new Translation2d(10.23, 4.06), Rotation2d.fromDegrees(-180));
      public static final Pose2d rightChainBlueStage =
          new Pose2d(new Translation2d(6.32, 3.99), Rotation2d.fromDegrees(-2.01));
      public static final Pose2d topLeftChainBlueStage =
          new Pose2d(new Translation2d(4.14, 5.29), Rotation2d.fromDegrees(120));
      public static final Pose2d bottomLeftChainBlueStage =
          new Pose2d(new Translation2d(4.06, 2.89), Rotation2d.fromDegrees(-123.52));

      public static final List<Pose2d> redSidePoses =
          List.of(bottomRightChainRedStage, topRightChainRedStage, leftChainRedStage);

      public static final List<Pose2d> blueSidePoses =
          List.of(rightChainBlueStage, topLeftChainBlueStage, bottomLeftChainBlueStage);
    }

    public static final class LeftChainPoses {
      public static final Pose2d bottomRightChainRedStage =
          new Pose2d(new Translation2d(11.89, 2.59), Rotation2d.fromDegrees(-59.30));
      public static final Pose2d topRightChainRedStage =
          new Pose2d(new Translation2d(13.07, 5), Rotation2d.fromDegrees(60));
      public static final Pose2d leftChainRedStage =
          new Pose2d(new Translation2d(10.27, 4.69), Rotation2d.fromDegrees(-180));
      public static final Pose2d rightChainBlueStage =
          new Pose2d(new Translation2d(6.31, 3.57), Rotation2d.fromDegrees(-2.01));
      public static final Pose2d topLeftChainBlueStage =
          new Pose2d(new Translation2d(4.72, 5.70), Rotation2d.fromDegrees(120));
      public static final Pose2d bottomLeftChainBlueStage =
          new Pose2d(new Translation2d(3.61, 3.16), Rotation2d.fromDegrees(-123.52));

      public static final List<Pose2d> redSidePoses =
          List.of(bottomRightChainRedStage, topRightChainRedStage, leftChainRedStage);

      public static final List<Pose2d> blueSidePoses =
          List.of(rightChainBlueStage, topLeftChainBlueStage, bottomLeftChainBlueStage);
    }

    public static final class RightChainPoses {
      public static final Pose2d bottomRightChainRedStage =
          new Pose2d(new Translation2d(12.94, 3.18), Rotation2d.fromDegrees(-59.30));
      public static final Pose2d topRightChainRedStage =
          new Pose2d(new Translation2d(11.98, 5.6), Rotation2d.fromDegrees(60));
      public static final Pose2d leftChainRedStage =
          new Pose2d(new Translation2d(10.27, 3.41), Rotation2d.fromDegrees(-180));
      public static final Pose2d rightChainBlueStage =
          new Pose2d(new Translation2d(6.31, 4.63), Rotation2d.fromDegrees(-2.01));
      public static final Pose2d topLeftChainBlueStage =
          new Pose2d(new Translation2d(3.60, 5.05), Rotation2d.fromDegrees(120));
      public static final Pose2d bottomLeftChainBlueStage =
          new Pose2d(new Translation2d(4.69, 2.60), Rotation2d.fromDegrees(-123.52));

      public static final List<Pose2d> redSidePoses =
          List.of(bottomRightChainRedStage, topRightChainRedStage, leftChainRedStage);

      public static final List<Pose2d> blueSidePoses =
          List.of(rightChainBlueStage, topLeftChainBlueStage, bottomLeftChainBlueStage);
    }
  }

  public static final class VisionConstants {
    public static final String limelightName = "limelight";
    public static final String arducamName = "Arducam_OV9281";

    public static final Transform3d arducamTransform =
        new Transform3d(
            Units.inchesToMeters(-6.5),
            Units.inchesToMeters(-13.25),
            Units.inchesToMeters(8.50),
            new Rotation3d(0.0, Units.degreesToRadians(-30.0), Units.degreesToRadians(180.0)));

    public static final Transform3d limelightTransform =
        new Transform3d(
            Units.inchesToMeters(5.53),
            0.0,
            Units.inchesToMeters(10.35),
            new Rotation3d(0.0, Units.degreesToRadians(-35.0), 0.0));

    public static final class ArducamConstants {
      public static final double[] distances =
          new double[] {
            0.50, 1.00, 1.50, 2.00, 4.95, 5.5,
          };
      public static final double[] xyStandardDeviations =
          new double[] {
            0.019, // 0.50
            0.025, // 1.00
            0.150, // 1.50
            0.200, // 2.00
            0.037, // 4.95
            1.15, // 5.5 might be a stddev of 0.85-ish
          };
      public static final double[] thetaStandardDeviations =
          new double[] {
            0.115, // 0.50
            0.149, // 1.00
            0.190, // 1.50
            0.250, // 2.00
            0.353, // 4.95
            1.85, // 5.5
          };

      public static PolynomialRegression xyPolynomialRegression =
          new PolynomialRegression(distances, xyStandardDeviations, 3);

      public static PolynomialRegression thetaPolynomialRegression =
          new PolynomialRegression(distances, thetaStandardDeviations, 3);
    }

    public static final class LimelightConstants {
      public static final double[] distances =
          new double[] {
            0.50, 1.00, 1.50, 2.00,
          };
      public static final double[] xyStandardDeviations =
          new double[] {
            0.014, // 0.50
            0.020, // 1.00
            0.150, // 1.50
            0.200, // 2.00
          };
      public static final double[] thetaStandardDeviations =
          new double[] {
            0.115, // 0.50
            0.149, // 1.00
            0.190, // 1.50
            0.250 // 2.00
          };

      public static PolynomialRegression xyPolynomialRegression =
          new PolynomialRegression(distances, xyStandardDeviations, 3);

      public static PolynomialRegression thetaPolynomialRegression =
          new PolynomialRegression(distances, thetaStandardDeviations, 3);
    }
  }

  public static final class ArmConstants {
    public static final int mainMotorID = 9;
    public static final int followerID = 10;

    public static final boolean mainMotorInverted = true;
    public static final boolean absoluteEncoderInverted = true;

    public static final Rotation2d absoluteOffset = Rotation2d.fromDegrees(265.89294);

    public static final double armKg = 0.13175;
    public static final double armKs = 0.12958;
    public static final double armKv = 7.6843;
    public static final double armKa = 0.000001358;

    public static final double armKp = 2.55;
    public static final double armKi = 0.0;
    public static final double armKd = 0.0;

    public static final double holdKp = 1.50;
    public static final double holdKi = 0.0;
    public static final double holdKd = 0.0;

    public static final int currentLimit = 50;

    public static final double armGearRatio =
        (12.0 / 60.0) * (18.0 / 68.0) * (18.0 / 72.0) * (12.0 / 64.0);
    public static final double armPositionConversionFactor = 2 * Math.PI * armGearRatio;
    public static final double armVelocityConversionFactor = armPositionConversionFactor / 60.0;

    // Assuming 90% gearbox efficiency
    public static final double maxVelocity =
        Units.rotationsToRadians(5800 * armGearRatio) * 0.90 / 60;
    public static final double maxAcceleration = Units.degreesToRadians(480.0);

    public static final double manualSpeed = 0.60;
    public static final double preciseManualSpeed = 0.20;
    public static final double angleTolerance = Units.degreesToRadians(0.15);
    public static final double autonomousAngleTolerance = Units.degreesToRadians(0.35);
    public static final double autoShootAngleTolerance = Units.degreesToRadians(0.65);
    public static final double replanningError = Units.degreesToRadians(20.0);
    public static final double debounceTime = 0.50;
    public static final double movementDebounceTime = 0.353;
    public static final double autoMovementDebounceTime = 0.40;
    public static final double holdDebounceTime = 1.5;

    public static final TrapezoidProfile.Constraints profileConstraints =
        new TrapezoidProfile.Constraints(maxVelocity, maxAcceleration);

    public static final Rotation2d pickupAngle = Rotation2d.fromDegrees(-2.4);
    public static final Rotation2d ampAngle = Rotation2d.fromDegrees(95.0);
    public static final Rotation2d subwooferAngle = Rotation2d.fromDegrees(9);
    public static final Rotation2d podiumAngle = Rotation2d.fromDegrees(22.03);

    public static final Rotation2d autoAmpPodiumAngle = Rotation2d.fromDegrees(34.785046585654335);
    public static final Rotation2d autoSourcePodiumAngle = Rotation2d.fromDegrees(36.3);
    public static final Rotation2d autoCloseShootAngle = Rotation2d.fromDegrees(22.5);
    public static final Rotation2d autoWingShotAngle = Rotation2d.fromDegrees(27.75);
    public static final Rotation2d autoAmpWingAngle = Rotation2d.fromDegrees(30.0);
    public static final Rotation2d behindWing1Angle = Rotation2d.fromDegrees(30.0);
    public static final Rotation2d behindWing2Angle = Rotation2d.fromDegrees(30.0);
    
    public static final double ampSpeedAngle = Units.degreesToRadians(85.0);

    public static final double reverseMovementLimitAngle = Units.degreesToRadians(-3.5);
    public static final double forwardMovementLimitAngle = Units.degreesToRadians(97.5);

    public static final double armPivotZ = Units.inchesToMeters(10.3);
    public static final double armPivotX = Units.inchesToMeters(-7.5);
    public static final double armLength = Units.inchesToMeters(21.75);
    public static final double armPivotToShooter = Units.inchesToMeters(14.0);
    public static final double armMass = Units.lbsToKilograms(30.0);
  }

  public static class IntakeConstants {
    public static final int intakeMotorID = 13;

    public static final double intakeSpeed = 0.90;
    public static final int intakeCurrentLimit = 40; // Amps
    public static final int shutoffCurrentLimit = 55;

    public static final int beamBreakID = 9;
  }

  public static class ShooterConstants {
    public static final int bottomShooterID = 11;
    public static final int topShooterID = 12;

    public static final double shooterVelocity = 4000.0;
    public static final double ampVelocity = 750.0;

    public static final double shooterKs = 0.33307;
    public static final double shooterKv = 0.0020945;
    public static final double shooterKa = 0.00072307;

    public static final double shooterKp = 0.0015;

    public static final double velocityTolerance = 100.0; // 100.0

    public static final double voltageCompensation = 12.0;

    public static final int shooterCurrentLimit = 40;

    public static final double gearing = 1 / 0.75;
    public static final double circumference = Math.PI * Units.inchesToMeters(3.8);
  }

  public static final class AutoShootConstants {
    // (distance, angle)
    public static final Point2D[] autoShootArmAngles =
        new Point2D.Double[] {
          new Point2D.Double(1.12, Units.degreesToRadians(9.0)),
          new Point2D.Double(2.29, Units.degreesToRadians(27.03)),
          new Point2D.Double(2.91, Units.degreesToRadians(30.9)),
          new Point2D.Double(3.26, Units.degreesToRadians(34.0)),
          // new Point2D.Double(Units.inchesToMeters(38.0), Units.degreesToRadians(8.5)),
          // new Point2D.Double(1.83, Units.degreesToRadians(13.0)),
          // new Point2D.Double(2.03, Units.degreesToRadians(16.14)),
          // new Point2D.Double(2.42, Units.degreesToRadians(22.8)),
          // new Point2D.Double(2.45, Units.degreesToRadians(23.5)),
          // new Point2D.Double(2.65, Units.degreesToRadians(23.1)),
          // new Point2D.Double(2.94, Units.degreesToRadians(27.3)),
          // new Point2D.Double(3.02, Units.degreesToRadians(27.4)),
          // new Point2D.Double(3.06, Units.degreesToRadians(28.1)),
          // new Point2D.Double(3.09, Units.degreesToRadians(29.5)),
          // new Point2D.Double(3.7, Units.degreesToRadians(31.2)),
        };

    public static final LinearInterpolation autoShootAngleInterpolation =
        new LinearInterpolation(autoShootArmAngles);

    // (distance, rpm)
    public static final Point2D[] autoShootRPM =
        new Point2D.Double[] {
          new Point2D.Double(2.91 - 0.000001, 3500), new Point2D.Double(2.91, 4000.0),
        };

    public static final LinearInterpolation autoShootRPMInterpolation =
        new LinearInterpolation(autoShootRPM);

    // (distance, time)
    public static final Point2D[] autoShootTimes =
        new Point2D.Double[] {
          new Point2D.Double(Units.feetToMeters(8.0), 0.24),
          new Point2D.Double(Units.feetToMeters(10.0), 0.29),
        };

    public static final LinearInterpolation autoShootTimeInterpolation =
        new LinearInterpolation(autoShootTimes);
  }

  public static final class ClimberConstants {
    public static final int leftMotorID = 14;
    public static final int rightMotorID = 15;

    public static final int climberCurrentLimit = 60;

    public static final double climberMotorSpeed = 0.50;
  }

  public static final class LEDConstants {
    public static final int ledPort = 0;
    public static final int bufferLength = 100;

    public static final Color transparent = new Color(0, 0, 0);
    public static final Color rslColor = new Color(255, 25, 0);
  }

  public static final class SwerveConstants {
    public static final double TRACK_WIDTH = Units.inchesToMeters(24.0);
    public static final double WHEEL_BASE = Units.inchesToMeters(24.0);

    public static final Translation2d frontLeft =
        new Translation2d(WHEEL_BASE / 2, TRACK_WIDTH / 2);
    public static final Translation2d frontRight =
        new Translation2d(WHEEL_BASE / 2, -TRACK_WIDTH / 2);
    public static final Translation2d backLeft =
        new Translation2d(-WHEEL_BASE / 2, TRACK_WIDTH / 2);
    public static final Translation2d backRight =
        new Translation2d(-WHEEL_BASE / 2, -TRACK_WIDTH / 2);

    public static final Translation2d[] wheelLocations = {
      frontLeft, frontRight, backLeft, backRight
    };

    public static final double driveBaseRadius = frontLeft.getNorm();

    public static final double maxTranslationalSpeed = Units.feetToMeters(12.5);
    public static final double maxAngularSpeed = Units.degreesToRadians(180);
    public static final double slowMotionMaxTranslationalSpeed = Units.feetToMeters(3.53);
    public static final double turboMaxTranslationalSpeed = Units.feetToMeters(14.5);

    public static final double maxTranslationalAcceleration = Units.feetToMeters(18.0);
    public static final double maxAngularAcceleration = Units.feetToMeters(270.0);

    public static final double wheelCircumference = Units.inchesToMeters(3.977) * Math.PI;
    public static final double driveGearRatio = 1 / 6.12;
    public static final double turnGearRatio = 1 / (150.0 / 7.0);

    public static final double drivePositionConversion = wheelCircumference * driveGearRatio;
    public static final double driveVelocityConversion = drivePositionConversion / 60;

    public static final double turnPositionConversion = 2 * Math.PI * turnGearRatio;

    public static final boolean driveMotorInverted = false;
    public static final boolean turnMotorInverted = true;
    public static final boolean canCoderInverted = false;

    public static final boolean useCosineCompensation = true;

    public static final double skewOpenLoopFudgeFactor = 0.100;
    public static final double skewClosedLoopFudgeFactor = 0.060;

    public static final double driveP = 0.08;

    public static final double driveKs = 0.27332;
    public static final double driveKv = 2.4366;
    public static final double driveKa = 0.0 * 0.22997;

    public static final double turnP = 0.85;
    public static final double turnD = 0;

    public static final double headingP = 0.55;
    public static final double headingD = 0;

    public static final double turnToAngleMaxVelocity = Units.degreesToRadians(270.0);

    public static final double openLoopRamp = 0.15;
    public static final double closedLoopRamp = 0.04;

    public static final double voltageCompensation = 12.0;

    public static final int driveCurrentLimit = 35;
    public static final int turnCurrentLimit = 25;

    public static final double maxDriveTemperature = 50.0;
    public static final double maxTurnTemperature = 50.0;

    public static final double maxModuleSpeed = Units.feetToMeters(14.5);

    public static final int odometryUpdateFrequency = 100; // 100 Hz

    public static final boolean zeroWithIntakeForward = true;
  }

  public static final class AutoConstants {
    public static final PIDConstants translationConstants = new PIDConstants(5.0, 0.0, 0.0);
    public static final PIDConstants rotationConstants = new PIDConstants(5.0, 0.0, 0.0);

    public static final double pathfindingMaxVelocity = Units.feetToMeters(13.0);
    public static final double pathfindingMaxAcceleration = Units.feetToMeters(20.0);
    public static final double pathfindingMaxAngularVelocity = Units.degreesToRadians(180.0);
    public static final double pathfindingMaxAngularAcceleration = Units.degreesToRadians(180.0);
  }

  public static class FrontLeftModule {
    public static final int driveID = 3;
    public static final int turnID = 7;
    public static final int encoderID = 11;
    public static final Rotation2d angleOffset = Rotation2d.fromDegrees(87.1875);
  }

  public static class FrontRightModule {
    public static final int driveID = 1;
    public static final int turnID = 5;
    public static final int encoderID = 9;
    public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-127.17773437499999);
  }

  public static class BackLeftModule {
    public static final int driveID = 2;
    public static final int turnID = 6;
    public static final int encoderID = 10;
    public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-53.349609375);
  }

  public static final class BackRightModule {
    public static final int driveID = 4;
    public static final int turnID = 8;
    public static final int encoderID = 12;
    public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-76.9921875);
  }
}
