package io.github.sammanadh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if(args.length <= 1) {
            System.err.println("USAGE: samgit [command]");
        }

        String command = args[0];
        String[] restArgs = Arrays.copyOfRange(args, 1, args.length);

        switch (command) {
            case "init":
                String path = restArgs[0];
                init(path);
                break;
            default:
                System.err.println("Invalid Command");
        }
    }

    public static void init(String path) {
        System.out.println("CREATED!!!!");
    }
}