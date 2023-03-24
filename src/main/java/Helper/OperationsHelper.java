package Helper;

import java.util.UUID;

public class OperationsHelper {

    public static String generateUid() {
        return UUID.randomUUID().toString();
    }
}