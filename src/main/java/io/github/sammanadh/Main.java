package io.github.sammanadh;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) exitGracefullyWithMessage("USAGE: samgit [command]");

        String command = args[0];
        String[] restArgs = Arrays.copyOfRange(args, 1, args.length);

        switch (command) {
            case "init":
                if (restArgs.length < 1) {
                    exitGracefullyWithMessage("USAGE: samgit init [path]");
                }
                String path = restArgs[0];
                init(path);
                break;
            default:
                System.err.println("Invalid Command");
        }
    }

    private static void init(String path) {
        String[] fileNames = new String[]{"HEAD", "config", "description"};
        String[] dirNames = new String[]{"hooks", "info", "objects", "refs"};

        try {
            String gitFolder = path + "/.git/";
            // first generate the .git folder
            Files.createDirectory(Path.of(gitFolder));

            for (String fileName : fileNames) {
                Files.createFile(Path.of(gitFolder + fileName));
            }
            for (String dirName : dirNames) {
                Files.createDirectory(Path.of(gitFolder + dirName));
            }
        } catch (IOException ioex) {
            System.err.println("[Error while initializing repo] " + ioex.getMessage());
        }
    }

    private static void exitGracefullyWithMessage(String msg) {
        System.err.println(msg);
        System.exit(1);
    }
}