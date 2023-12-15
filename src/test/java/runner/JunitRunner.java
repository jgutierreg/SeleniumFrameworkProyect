package runner;

import io.cucumber.core.cli.Main;

public class JunitRunner {
    public static void main(String[] args) {
        String[] cucumberArgs = {
                "--glue", "steps", // Paquete que contiene tus definiciones de pasos
                "src/test/resources/Features" // Ubicación de tus archivos .feature
        };

        byte exitstatus = Main.run(cucumberArgs, Thread.currentThread().getContextClassLoader());
        System.exit(exitstatus);
    }
}
