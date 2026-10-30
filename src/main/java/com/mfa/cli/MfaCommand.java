package com.mfa.cli;

import com.mfa.application.AssessmentEngine;
import java.io.PrintWriter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

@Command(
    name = "mfa",
    mixinStandardHelpOptions = true,
    version = "0.0.1",
    description = "AI-powered application modernization platform.")
public class MfaCommand implements Runnable {

  @Spec private CommandSpec spec;

  @Override
  public void run() {
    this.spec.commandLine().usage(this.spec.commandLine().getOut());
    this.spec.commandLine().getOut().flush();
  }

  public static CommandLine createCommandLine(
      final AssessmentEngine assessmentEngine,
      final PrintWriter outputWriter,
      final PrintWriter errorWriter) {
    final CommandLine commandLine = createCommandLine(assessmentEngine);
    commandLine.setOut(outputWriter);
    commandLine.setErr(errorWriter);
    return commandLine;
  }

  public static CommandLine createCommandLine(final AssessmentEngine assessmentEngine) {
    final CommandLine commandLine = new CommandLine(new MfaCommand());
    commandLine.addSubcommand("analyze", new AnalyzeCommand(assessmentEngine));
    return commandLine;
  }

  public static void main(final String[] args) {
    final int exitCode = createCommandLine(new AssessmentEngine()).execute(args);
    if (exitCode != 0) {
      System.exit(exitCode);
    }
  }
}
