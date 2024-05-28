package org.hw2.Core.DataRegistry;

import net.bytebuddy.utility.RandomString;

public class RandomGroupName {
    public static String generateRandomGroupName() {
        return RandomString.make(15);
    }
}
